package com.romanhan.game;

import java.util.LinkedList;
import java.util.List;

import com.romanhan.Player;
import com.romanhan.cards.Card;

public class GameLogic {

    RoundResult compareCards(Player player1, Player player2) {
        String player1Name = player1.getName();
        String player2Name = player2.getName();
        Card card1 = player1.drawCard();
        Card card2 = player2.drawCard();

        System.out.printf("%s plays %s, %s plays %s%n", player1Name, card1, player2Name,
                card2);

        if (card1.getRank() > card2.getRank()) {
            System.out.printf("%s wins the round%n", player1Name);
            return new RoundResult(player1, List.of(card1, card2));
        } else if (card2.getRank() > card1.getRank()) {
            System.out.printf("%s wins the round%n", player2Name);
            return new RoundResult(player2, List.of(card1, card2));
        } else {
            RoundResult result = new RoundResult(null, List.of(card1, card2));
            result.setTie(true);
            return result;
        }
    }

    RoundResult war(RoundResult previousResult, Player player1, Player player2) {
        List<Card> warCards = new LinkedList<>();
        warCards.addAll(previousResult.getCardsWon());

        for (int i = 0; i < 3; i++) {
            if (player1.hasCards()) {
                warCards.add(player1.drawCard());
            }
            if (player2.hasCards()) {
                warCards.add(player2.drawCard());
            }
        }
        RoundResult warResult = compareCards(player1, player2);
        warResult.addCardsWon(warCards);
        return warResult;
    }
}