package com.romanhan.cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void shouldReturnCard() {
        // Given and When
        Card card = new Card(Rank.FIVE, Suit.CLUBS);

        // Then
        assertEquals("[5♣]", card.toString());
    }

    @Test
    void shouldReturnRank() {
        // Given and When
        Card cardTwo = new Card(Rank.TWO, Suit.CLUBS);

        // Then
        assertEquals(2, cardTwo.getRank());
    }
}