package com.pwrjavamasters.cardwargame.model;

import java.util.LinkedList;

public class Deck {

    private LinkedList<Card> deck = new LinkedList<>();

    public Deck(LinkedList<Card> deck) {
        this.deck = deck;
    }

    public LinkedList<Card> getDeck() {
        return deck;
    }

    public void setDeck(LinkedList<Card> deck) {
        this.deck = deck;
    }



}