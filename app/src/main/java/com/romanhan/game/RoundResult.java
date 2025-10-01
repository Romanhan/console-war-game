package com.romanhan.game;

import java.util.List;

import com.romanhan.Player;
import com.romanhan.cards.Card;

public class RoundResult {
    private Player winner;
    private List<Card> cardsWon;
    private boolean isTie;

    public RoundResult(Player winner, List<Card> cardsWon) {
        this.winner = winner;
        this.cardsWon = cardsWon;
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

}
