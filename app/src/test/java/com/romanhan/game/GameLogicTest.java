package com.romanhan.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.romanhan.Player;
import com.romanhan.cards.Card;
import com.romanhan.cards.Rank;
import com.romanhan.cards.Suit;

public class GameLogicTest {
    Player player1;
    Player player2;
    LinkedList<Card> player1Cards;
    LinkedList<Card> player2Cards;

    @BeforeEach
    void setUp() {
        player1Cards = new LinkedList<>();
        player1Cards.add(new Card(Rank.ACE, Suit.HEART));
        player2Cards = new LinkedList<>();
        player2Cards.add(new Card(Rank.KING, Suit.SPADE));

        player1 = new Player("Player1", player1Cards);
        player2 = new Player("Player2", player2Cards);
    }

    @Test
    void shouldReturnBiggerCardWon() {
        // Given
        GameLogic gameLogic = new GameLogic();
        // When
        RoundResult result = gameLogic.compareCards(player1, player2);
        // Then
        assertEquals(result.getWinner(), player1);
        assertEquals(result.getCardsWon().size(), 2);

        assertTrue(result.getCardsWon().contains(new Card(Rank.ACE, Suit.HEART)));
        assertTrue(result.getCardsWon().contains(new Card(Rank.KING, Suit.SPADE)));
    }

    @Test
    void shouldReturnSecondPlayerWon() {
        // Given
        player1Cards.clear();
        player1Cards.add(new Card(Rank.TWO, Suit.HEART));
        player1 = new Player("Player1", player1Cards);
        GameLogic gameLogic = new GameLogic();
        // When
        RoundResult result = gameLogic.compareCards(player1, player2);
        // Then
        assertEquals(result.getWinner(), player2);
        assertEquals(result.getCardsWon().size(), 2);
    }

    @Test
    void shouldReturnTie() {
        // Given
        player2Cards.clear();
        player2Cards.add(new Card(Rank.ACE, Suit.CLUBS));
        player2 = new Player("Player2", player2Cards);
        GameLogic gameLogic = new GameLogic();
        // When
        RoundResult result = gameLogic.compareCards(player1, player2);
        // Then
        assertEquals(result.getWinner(), null);
        assertTrue(result.isTie());
        assertEquals(result.getCardsWon().size(), 2);
    }

    @Test
    void shouldStartWar() {
        // Given
        player1Cards.clear();
        player1Cards.add(new Card(Rank.TWO, Suit.HEART));
        player2Cards.clear();
        player2Cards.add(new Card(Rank.TWO, Suit.SPADE));
        player1 = new Player("Player1", player1Cards);
        player2 = new Player("Player2", player2Cards);
        GameLogic gameLogic = new GameLogic();
        // When
        RoundResult result = gameLogic.compareCards(player1, player2);
        // Then
        assertEquals(result.getWinner(), null);
        assertTrue(result.isTie());
        assertEquals(result.getCardsWon().size(), 2);
    }

    @Test
    void shouldReturnWarWinner() {
        // Given
        player1Cards.clear();
        player1Cards.addAll(List.of(new Card(Rank.TWO, Suit.HEART),
                new Card(Rank.THREE, Suit.HEART),
                new Card(Rank.FOUR, Suit.HEART),
                new Card(Rank.FIVE, Suit.HEART),
                new Card(Rank.NINE, Suit.HEART)));
        player1 = new Player("Player1", player1Cards);

        player2Cards.clear();
        player2Cards.addAll(List.of(new Card(Rank.TWO, Suit.SPADE),
                new Card(Rank.SIX, Suit.SPADE),
                new Card(Rank.SEVEN, Suit.SPADE),
                new Card(Rank.EIGHT, Suit.SPADE),
                new Card(Rank.KING, Suit.SPADE)));
        player2 = new Player("Player2", player2Cards);
        GameLogic gameLogic = new GameLogic();
        // When
        RoundResult initialResult = gameLogic.compareCards(player1, player2);
        RoundResult warResult = gameLogic.war(initialResult, player1, player2);
        // Then
        assertEquals(warResult.getWinner(), player2);
        assertEquals(warResult.getCardsWon().size(), 10);
    }

    @Test
    void shouldReturnWarTie() {
        // Given
        player1Cards.clear();
        player1Cards.addAll(List.of(new Card(Rank.TWO, Suit.HEART),
                new Card(Rank.THREE, Suit.HEART),
                new Card(Rank.FOUR, Suit.HEART),
                new Card(Rank.FIVE, Suit.HEART),
                new Card(Rank.NINE, Suit.HEART)));
        player1 = new Player("Player1", player1Cards);
        player2Cards.clear();
        player2Cards.addAll(List.of(new Card(Rank.TWO, Suit.SPADE),
                new Card(Rank.SIX, Suit.SPADE),
                new Card(Rank.SEVEN, Suit.SPADE),
                new Card(Rank.EIGHT, Suit.SPADE),
                new Card(Rank.NINE, Suit.SPADE)));
        player2 = new Player("Player2", player2Cards);
        GameLogic gameLogic = new GameLogic();
        // When
        RoundResult initialResult = gameLogic.compareCards(player1, player2);
        RoundResult warResult = gameLogic.war(initialResult, player1, player2);
        // Then
        assertEquals(warResult.getWinner(), null);
        assertTrue(warResult.isTie());
        assertEquals(warResult.getCardsWon().size(), 10);
    }
}
