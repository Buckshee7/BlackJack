import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public void clearHand(){
        this.hand.clear();
    }

    public int getHandTotal(){
        int total = 0;
        int aces = 0;
        for(Card card : this.hand){
            total += card.getCardValue();
            if (card.getCardName() == CardValue.ACE){
                aces+=1;
            }
        }
        while (total > 21 && aces > 0){
            total -= 10;
            aces -= 1;
        }
        return total;
    }

    public boolean isBlackJack(){
        int total = this.getHandTotal();
        boolean hasAce = false;
        for(Card card : this.hand){
            if (card.getCardName() == CardValue.ACE){
                hasAce = true;
            }
        }
        return (total == 21 && hasAce);
    }

    public boolean isBust(){
        int total = this.getHandTotal();
        return total > 21 ? true : false;
    }
}
