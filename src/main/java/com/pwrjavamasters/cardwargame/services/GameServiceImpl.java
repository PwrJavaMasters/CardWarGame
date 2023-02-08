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

        Player player1 = new Player(deck.subList(0,26));
        Player player2 = new Player(deck.subList(26,52));

        playerRepository.save(player1);
        playerRepository.save(player2);

    }

    @Override
    public void makeMove() {

    }
}