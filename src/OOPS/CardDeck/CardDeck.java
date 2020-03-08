package OOPS.CardDeck;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
    List<Card> deck = new ArrayList<>();

    public CardDeck() {
        for (int i = 1; i <= 13; i++) {
            for (Suit suit : Suit.values()) {
                deck.add(new Card(i, suit));
            }
        }
    }
}
