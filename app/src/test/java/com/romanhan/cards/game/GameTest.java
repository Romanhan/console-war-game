package com.romanhan.cards.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

import com.romanhan.cards.Card;
import com.romanhan.game.Game;

public class GameTest {
    @Test
    void should_Create_Players() {
        // Given
        Scanner scanner = new Scanner("Alice\nBob\n");
        // When
        Game game = new Game(scanner);
        // Then
        assertEquals("Alice", game.getPlayer1().getName());
        assertEquals("Bob", game.getPlayer2().getName());
    }

    @Test
    void should_Create_Two_Decks() {
        // Given
        Scanner scanner = new Scanner("Alice\nBob\n");
        // When
        Game game2 = new Game(scanner);
        // Then
        assertEquals(26, game2.getPlayer1().size());
        assertEquals(26, game2.getPlayer2().size());
    }

    @Test
    void should_not_have_duplicate_cards() {
        // Given
        Scanner scanner = new Scanner("Alice\nBob\n");
        // When
        Game game = new Game(scanner);
        LinkedList<Card> deck = new LinkedList<>();
        deck.addAll(game.getPlayer1().getCards());
        deck.addAll(game.getPlayer2().getCards());
        // Then
        LinkedList<Card> uniqueCards = new LinkedList<>(deck.stream().distinct().toList());
        assertEquals(52, uniqueCards.size());
    }

    @Test
    void should_Play_One_Round() {
        // Given
        Scanner scanner = new Scanner("Alice\nBob\n");
        // When
        Game game = new Game(scanner);
        game.game();
        // Then
        int totalCards = game.getPlayer1().size() + game.getPlayer2().size();
        assertEquals(52, totalCards);
    }
}
