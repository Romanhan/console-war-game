package com.romanhan;

import com.romanhan.cards.Card;

import java.util.Collection;
import java.util.LinkedList;

public class Player {
    private String name;
    private LinkedList<Card> cards;

    public Player(String name, LinkedList<Card> cards) {
        this.name = name;
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public LinkedList<Card> getCards() {
        return cards;
    }

    public boolean hasCards() {
        return !cards.isEmpty();
    }

    public Card drawCard() {
        return cards.removeFirst();
    }

    public void addWonCards(Collection<Card> cards) {
        this.cards.addAll(cards);
    }

    public int size() {
        return cards.size();
    }

}
