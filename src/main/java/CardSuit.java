public enum CardSuit {

    CLUBS("Clubs"),
    SPADES("Spades"),
    DIAMONDS("Diamonds"),
    HEARTS("Hearts");

    private final String suit;

    CardSuit(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }
}
