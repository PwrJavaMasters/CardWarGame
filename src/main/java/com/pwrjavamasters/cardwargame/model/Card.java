package com.pwrjavamasters.cardwargame.model;

import com.pwrjavamasters.cardwargame.model.enums.Suit;

import javax.persistence.*;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private Suit suit;
    private int rank;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Card(Suit suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Card() {

    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

}