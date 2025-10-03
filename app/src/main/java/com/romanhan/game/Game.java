package com.romanhan.game;

import com.romanhan.Player;
import com.romanhan.cards.Card;
import com.romanhan.cards.Rank;
import com.romanhan.cards.Suit;

import java.util.*;

public class Game {
    private Player player1;
    private Player player2;
    private GameLogic gameLogic = new GameLogic();

    public Game(Scanner scanner) {
        LinkedList<Card> deck = createDeck();
        Collections.shuffle(deck);
        List<LinkedList<Card>> decks = splitDeck(deck);
        String[] names = getPlayerNames(scanner);
        createPlayers(decks, names);
        System.out.println("Players created: " + player1.getName() + " and " + player2.getName());
    }

    public void game() {
        System.out.println("War game started");
        while (player1.hasCards() && player2.hasCards()) {
            playRound();
            System.out.printf("%s has %d cards, %s has %d cards%n", player1.getName(), player1.size(),
                    player2.getName(), player2.size());
            System.out.println("-------------------------");
        }
        if (player1.hasCards()) {
            System.out.printf("%s wins the game!%n", player1.getName());
        } else {
            System.out.printf("%s wins the game!%n", player2.getName());
        }
    }

    private void playRound() {
        RoundResult result = gameLogic.compareCards(player1, player2);
        if (result.isTie()) {
            System.out.println("It's a tie! War!");
            startWar(result, player1, player2);
        } else {
            result.getWinner().addWonCards(result.getCardsWon());
        }
    }

    private void startWar(RoundResult previousResult, Player player1, Player player2) {
        if (player1.size() < 4) {
            System.out.printf("%s does not have enough cards for war and loses.%n", player1.getName());
            RoundResult gameOverResult = new RoundResult(player2, previousResult.getCardsWon());
            gameOverResult.setGameOver(true);
            player2.addWonCards(gameOverResult.getCardsWon());
            return;
        } else if (player2.size() < 4) {
            System.out.printf("%s does not have enough cards for war and loses.%n", player2.getName());
            RoundResult gameOverResult = new RoundResult(player1, previousResult.getCardsWon());
            gameOverResult.setGameOver(true);
            player1.addWonCards(gameOverResult.getCardsWon());
            return;
        }

        RoundResult warResult = gameLogic.war(previousResult, player1, player2);
        if (warResult.isTie()) {
            System.out.println("War resulted in a tie! Another war!");
            startWar(warResult, player1, player2);
        } else {
            warResult.getWinner().addWonCards(warResult.getCardsWon());
        }
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
