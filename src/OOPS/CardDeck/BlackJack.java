package OOPS.CardDeck;

public class BlackJack extends Card {

    public BlackJack(int value, Suit suit) {
        super(value, suit);
    }

    @Override
    public int getValue() {
        int val = super.getValue();
        if (val > 10)
            return 10;
        else if (val == 1)
            return 11;
        else return val;
    }
}
