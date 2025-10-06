# Console war card game

A Java implementation of the classic War card game for two players, built with Gradle and Java 21.
About the Game
War is a simple card game typically played by two players using a standard 52-card deck. The objective is to win all the cards by having higher-ranked cards than your opponent.

## Game Rules

The deck is shuffled and split evenly between two players (26 cards each)
Each round, both players draw the top card from their deck
The player with the higher-ranked card wins both cards and adds them to the bottom of their deck
If both cards have the same rank, a "War" occurs:

Each player places 3 cards face down
Both players draw one more card face up
The higher card wins all cards in play
If there's another tie, the war continues

The game ends when one player runs out of cards

## Card Rankings
Cards are ranked from lowest to highest:

2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace

## Technologies Used

* Java 21: Programming language
* Gradle 9.0.0: Build automation tool
* JUnit Jupiter 5.12.1: Testing framework
* Google Guava: Utility library# Example Output


```
Enter player 1 name
Alice
Enter player 2 name
Bob
Players created: Alice and Bob
War game started
Alice plays [7♦], Bob plays [K♣]
Bob wins the round
Alice has 25 cards, Bob has 27 cards
-------------------------
Alice plays [A♠], Bob plays [A♥]
It's a tie! War!
Alice place [][][], Bob place [][][]
Alice plays [Q♦], Bob plays [8♣]
Alice wins the round
Alice has 32 cards, Bob has 20 cards
-------------------------
...
Alice wins the game!
```