package OOPS.CardDeck;

public class Card {


    int value;
    Suit suit;

    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }


    public int getValue() {
        return value;
    }

}
