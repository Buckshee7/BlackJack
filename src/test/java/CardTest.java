import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    private Card card;

    @Before
    public void before(){
        this.card = new Card(CardValue.KING, CardSuit.SPADES);
    }

    @Test
    public void hasValue(){
        assertEquals(13, this.card.getCardValue());
    }

    @Test
    public void hasSuit(){
        assertEquals("Spades", this.card.getSuitValue());
    }

    @Test void canGetValueAsCardSuit(){
        assertEquals(CardValue.KING, this.card.getCardName() );
    }

}
