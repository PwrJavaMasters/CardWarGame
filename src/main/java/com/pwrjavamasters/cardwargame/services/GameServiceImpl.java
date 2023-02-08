package com.pwrjavamasters.cardwargame.services;

import com.pwrjavamasters.cardwargame.model.Card;
import com.pwrjavamasters.cardwargame.model.Player;
import com.pwrjavamasters.cardwargame.model.enums.Suit;
import com.pwrjavamasters.cardwargame.repositories.CardRepository;
import com.pwrjavamasters.cardwargame.repositories.GameRepository;
import com.pwrjavamasters.cardwargame.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class GameServiceImpl implements GameService{

    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;
    private final CardRepository cardRepository;

    public GameServiceImpl(GameRepository gameRepository, PlayerRepository playerRepository, CardRepository cardRepository) {
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
        this.cardRepository = cardRepository;
    }

    Player player1 = new Player();
    Player player2 = new Player();

    @Override
    public void startNewGame() {

        ArrayList<Card> deck = new ArrayList<Card>();
        Card currentCard;

        for (int i = 2; i <= 14; i++){
            for (Suit suit : Suit.values()) {
                currentCard = new Card(suit, i);
                deck.add(currentCard);
                cardRepository.save(currentCard);
            }
        }

        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));

        player1.setCards(deck.subList(0,26));
        player2.setCards(deck.subList(26,52));

        playerRepository.save(player1);
        playerRepository.save(player2);

    }

    @Override
    public boolean makeMove() {

        Card cardToRemoveP1;
        Card cardToRemoveP2;
        boolean isWinner = false;
        boolean isFinished = false;
        ArrayList<Card> stake = new ArrayList<>();
        List<Card> p1Cards = player1.getCards();
        List<Card> p2Cards = player2.getCards();

        while (!isFinished){
            if(player1.getCards().get(0).getRank() > p2Cards.get(0).getRank()){
                cardToRemoveP1 = p1Cards.remove(0);
                cardToRemoveP2 = p2Cards.remove(0);

                p1Cards.add(cardToRemoveP2);
                p1Cards.add(cardToRemoveP1);
                p1Cards.addAll(stake);

                isFinished = true;

                System.out.println("player 1 wins the round");

            } else if (p1Cards.get(0).getRank() < p2Cards.get(0).getRank()) {
                cardToRemoveP1 = p1Cards.remove(0);
                cardToRemoveP2 = p2Cards.remove(0);

                player2.getCards().add(cardToRemoveP1);
                player2.getCards().add(cardToRemoveP2);
                player2.getCards().addAll(stake);

                isFinished = true;

                System.out.println("player 2 wins the round");

            } else {

                stake.add(p1Cards.remove(0));
                stake.add(p2Cards.remove(0));

                isFinished = false;

                System.out.println("draw - next round");
            }
        }

        player1.setCards(p1Cards);
        player2.setCards(p2Cards);

        playerRepository.save(player1);
        playerRepository.save(player2);

        if (player2.getCards().size() == 52 || player1.getCards().size() == 52) isWinner = true;

        if (player1.getCards().size() == 52) System.out.println("Player nr 1 wins");
        else if (player2.getCards().size() == 52) System.out.println("Player nr 2 wins");
        else System.out.println("No winner");

        return isWinner;
    }
}