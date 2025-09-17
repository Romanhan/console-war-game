package com.romanhan.cards;

public class Card {

    private Rank rank;
    private Suit suit;

    public Card (Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank.getValue();
    }

    @Override
    public String toString() {
        return String.format("[%s%c]", rank.getName(), suit.getName());
    }
}
