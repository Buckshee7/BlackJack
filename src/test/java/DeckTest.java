import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DeckTest {

    private Deck deck;

    @Before
    public void before(){
        this.deck = new Deck();
    }

    @Test
    public void hasNoCardsToStart(){
        assertEquals(0, deck.getCards().size());
    }

    @Test
    public void canPopulateDeck(){
        this.deck.populateDeck();
        assertEquals(52, deck.getCards().size());
    }

    @Test
    public void canShuffleDeck(){
        Deck unshuffledDeck = new Deck();
        unshuffledDeck.populateDeck();
        this.deck.populateDeck();
        this.deck.shuffleDeck();
        // change condition to check different number of cards are different.
            // higher number has greater chance of failing though
        for(int i = 0; i < 1; i++){
            Card shuffledCard = this.deck.getCardFromIndex(i);
            Card unshuffledCard = unshuffledDeck.getCardFromIndex(i);
            assertTrue(shuffledCard.getSuitValue() != unshuffledCard.getSuitValue() || shuffledCard.getSuitValue() != unshuffledCard.getSuitValue());
        }
    }

    @Test
    public void canDealCard(){
        this.deck.populateDeck();
        this.deck.shuffleDeck();
        Card returnedCard = this.deck.dealCard();
        ArrayList cards = this.deck.getCards();
        assertFalse(cards.contains(returnedCard));
        assertEquals(51, cards.size());
    }

}
