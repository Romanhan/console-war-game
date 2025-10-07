package com.romanhan.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.romanhan.Player;
import com.romanhan.cards.Card;
import com.romanhan.cards.Rank;
import com.romanhan.cards.Suit;

public class RoundResultTest {
    static Player player1;
    static LinkedList<Card> player1Cards;
    static LinkedList<Card> wonCards;

    @BeforeAll
    static void setUp() {
        player1Cards = new LinkedList<>(
                Arrays.asList(
                        new Card(Rank.ACE, Suit.HEART),
                        new Card(Rank.KING, Suit.SPADE)));
        player1 = new Player("Player1", player1Cards);
        wonCards = new LinkedList<>(
                Arrays.asList(
                        new Card(Rank.TWO, Suit.DIAMOND),
                        new Card(Rank.THREE, Suit.CLUBS)));
    }

    @Test
    void shouldAddWonCards() {
        RoundResult roundResult = new RoundResult(player1, wonCards);
        List<Card> additionalCards = List.of(new Card(Rank.FOUR, Suit.HEART));
        roundResult.addCardsWon(additionalCards);

        List<Card> expectedCards = new LinkedList<>(wonCards);
        expectedCards.addAll(additionalCards);

        assertEquals(expectedCards, roundResult.getCardsWon());
    }

    @Test
    void shouldReturnWonCards() {
        RoundResult roundResult = new RoundResult(player1, wonCards);

        assertEquals(roundResult.getCardsWon(), wonCards);
    }

    @Test
    void shouldReturnWinner() {
        RoundResult roundResult = new RoundResult(player1, wonCards);

        assertEquals(roundResult.getWinner(), player1);
    }

    @Test
    void shouldReturnIsGameOver() {
        RoundResult roundResult = new RoundResult(player1, wonCards);
        roundResult.setGameOver(true);

        assertTrue(roundResult.isGameOver());
    }

    @Test
    void shouldReturnIsTie() {
        RoundResult roundResult = new RoundResult(player1, wonCards);
        roundResult.setTie(true);

        assertTrue(roundResult.isTie());
    }
}
