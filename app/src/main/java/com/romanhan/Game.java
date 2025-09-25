package com.romanhan;

import com.romanhan.cards.Card;
import com.romanhan.cards.Rank;
import com.romanhan.cards.Suit;

import java.util.*;

public class Game {
    private Player player1;
    private Player player2;

    public Game(Scanner scanner) {
        LinkedList<Card> deck = createDeck();
        Collections.shuffle(deck);
        List<LinkedList<Card>> decks = splitDeck(deck);
        String[] names = getPlayerNames(scanner);
        createPlayers(decks, names);
    }

    private void createPlayers(List<LinkedList<Card>> decks, String[] names) {
        player1 = new Player(names[0], decks.getFirst());
        player2 = new Player(names[1], decks.getLast());
    }

    private String[] getPlayerNames(Scanner scanner) {
        System.out.println("Enter player 1 name");
        String name1 = scanner.nextLine();
        System.out.println("Enter player 2 name");
        String name2 = scanner.nextLine();
        scanner.close();
        return new String[] { name1, name2 };
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    private List<LinkedList<Card>> splitDeck(LinkedList<Card> deck) {
        LinkedList<Card> deck1 = new LinkedList<>(deck.subList(0, deck.size() / 2));
        LinkedList<Card> deck2 = new LinkedList<>(deck.subList(deck.size() / 2, deck.size()));
        return Arrays.asList(deck1, deck2);
    }

    LinkedList<Card> createDeck() {
        LinkedList<Card> deck = new LinkedList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, suit));
            }
        }
        return deck;
    }
}
