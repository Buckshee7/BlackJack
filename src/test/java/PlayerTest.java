import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player;
    private Card card;

    @Before
    public void before(){
        this.player = new Player("Ally");
        this.card = new Card(CardValue.ACE, CardSuit.SPADES);
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
        this.player.addCard(this.card);
        assertEquals(1, this.player.getHand().size());
    }

    @Test
    public void canClearHand(){
        this.player.addCard(this.card);
        this.player.clearHand();
        assertEquals(0, this.player.getHand().size());
    }


}
