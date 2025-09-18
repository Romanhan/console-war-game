package com.romanhan;

import com.romanhan.cards.Card;
import com.romanhan.cards.Rank;
import com.romanhan.cards.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player;

    @BeforeEach
    void beforeEach() {
        player = new Player("Tester", new LinkedList<>(Arrays.asList(new Card(Rank.ACE, Suit.DIAMOND), new Card(Rank.EIGHT, Suit.CLUBS))));
    }

    @Test
    void should_return_player_name() {
        assertEquals("Tester", player.getName());
    }

    @Test
    void should_draw_card_and_erase_it_from_deck() {
        assertEquals("[A♦]", player.drawCard().toString());
        assertEquals(1, player.size());
    }

    @Test
    void should_return_card_size() {
        assertEquals(2, player.size());
    }

    @Test
    void should_increase_cars_size() {
        player.addWonCards(Arrays.asList(new Card(Rank.NINE, Suit.HEART), new Card(Rank.FOUR, Suit.SPADE)));

        assertEquals(4, player.size());
    }

    @Test
    void should_return_has_player_cards() {
        assertTrue(player.hasCards());
        player.drawCard();
        player.drawCard();
        assertFalse(player.hasCards());
    }

}