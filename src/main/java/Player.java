import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
    }

    public ArrayList<Card> getCard() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public void setCard(Card card) {
        this.hand.add(card);
    }
    
    public void clearHand(){
        this.hand.clear();
    }
}