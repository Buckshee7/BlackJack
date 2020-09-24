public class Player {

    private String name;
    private Card card;

    public Player(String name) {
        this.name = name;
    }

    public Card getCard() {
        return card;
    }

    public String getName() {
        return name;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
