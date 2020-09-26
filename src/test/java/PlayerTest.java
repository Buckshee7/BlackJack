import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player;
    private Card cardAce;
    private Card cardFive;

    @Before
    public void before(){
        this.player = new Player("Ally");
        this.cardAce = new Card(CardValue.ACE, CardSuit.SPADES);
        this.cardFive = new Card(CardValue.FIVE, CardSuit.CLUBS);
    }

    @Test
    public void hasName(){
        assertEquals("Ally", this.player.getName());
    }

    @Test
    public void startsWithEmptyHand(){
        System.out.println(this.player.getHand().size());
        assertEquals(0, this.player.getHand().size());
    }

    @Test
    public void canAddCardToHand(){
        this.player.addCard(this.cardAce);
        assertEquals(1, this.player.getHand().size());
    }

    @Test
    public void canClearHand(){
        this.player.addCard(this.cardAce);
        this.player.clearHand();
        assertEquals(0, this.player.getHand().size());
    }

    @Test
    public void canGetHandTotalWhenNoAces(){
        this.player.addCard(cardFive);
        this.player.addCard(cardFive);
        this.player.addCard(cardFive);
        assertEquals(15, this.player.getHandTotal());
    }

    @Test
    public void canGetHandTotalWithAceAsValue11(){
        this.player.addCard(cardFive);
        this.player.addCard(cardAce);
        assertEquals(16, this.player.getHandTotal());
    }

    @Test
    public void canGetHandTotalWithAceAsValue1(){
        this.player.addCard(cardFive);
        this.player.addCard(cardFive);
        this.player.addCard(cardFive);
        this.player.addCard(cardAce);
        assertEquals(16, this.player.getHandTotal());
    }

    @Test
    public void canGetHandTotalWithMultipleAcesWithBothValues11And1(){
        this.player.addCard(cardAce);
        this.player.addCard(cardAce);
        this.player.addCard(cardAce);
        assertEquals(13, this.player.getHandTotal());
    }


}
