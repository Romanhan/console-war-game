package com.romanhan.cards;

public enum Suit {
    DIAMOND('♦'),
    CLUBS('♣'),
    HEART('♥'),
    SPADE('♠');

    private final char name;

    Suit(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }
}
