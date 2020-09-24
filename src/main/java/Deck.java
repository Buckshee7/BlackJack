import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public void populateDeck(){
        for(CardSuit suit : CardSuit.values()){
            for (CardValue value : CardValue.values()){
                this.cards.add(new Card(value, suit));
            }
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(this.cards);
    }

    public Card getCardFromIndex(int index){
        return this.cards.get(index);
    }

    public Card dealCard(){
        return this.cards.remove(0);
    }

}
