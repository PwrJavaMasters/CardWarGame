package com.pwrjavamasters.cardwargame.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player {
    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Card> cards = new ArrayList<>();

    public Player(List<Card> hand) {
        this.cards = hand;
    }

    public Player() {

    }
}