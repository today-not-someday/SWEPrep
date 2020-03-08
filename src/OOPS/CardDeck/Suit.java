package OOPS.CardDeck;

public enum Suit {
    spade(0),
    diamond(1),
    heart(2),
    club(4);

    public int value;

    private Suit(int value) {
        this.value = value;
    }
}
