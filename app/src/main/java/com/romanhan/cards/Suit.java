package com.romanhan.cards;

public enum Suit {
    DIAMOND('♦'),
    CLUBS('♣'),
    HEART('♥'),
    SPADE('♠');

    private final char value;

    Suit(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
