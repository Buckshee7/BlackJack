public class Card {

    private CardValue cardValue;
    private CardSuit cardSuit;

    public Card(CardValue cardValue, CardSuit cardSuit) {
        this.cardValue = cardValue;
        this.cardSuit = cardSuit;
    }

    public  int getCardValue() {
        return this.cardValue.getValue();
    }

    public CardValue getCardName(){
        return this.cardValue;
    }

    public String getSuitValue() {
        return this.cardSuit.getSuit();
    }

    public String getCardValueAndSuit(){
        return String.format("%s of %s", this.getCardName(), this.cardSuit);
    }

}
