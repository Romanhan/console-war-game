package com.romanhan.game;

import java.util.LinkedList;
import java.util.List;

import com.romanhan.Player;
import com.romanhan.cards.Card;

public class RoundResult {
    private Player winner;
    private List<Card> cardsWon;
    private boolean isTie;
    private boolean isGameOver;

    public RoundResult(Player winner, List<Card> cardsWon) {
        this.winner = winner;
        this.cardsWon = new LinkedList<>(cardsWon);
    }

    Player getWinner() {
        return winner;
    }

    List<Card> getCardsWon() {
        return cardsWon;
    }

    public boolean isTie() {
        return isTie;
    }

    public void setTie(boolean isTie) {
        this.isTie = isTie;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }

    public void addCardsWon(List<Card> additionalCards) {
        this.cardsWon.addAll(additionalCards);
    }
}
