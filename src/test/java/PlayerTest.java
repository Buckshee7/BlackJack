import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player;

    @Before
    public void before(){
        this.player = new Player("Ally");
    }

    @Test
    public void hasName(){
        assertEquals("Ally", this.player.getName());
    }

    @Test
    public void startsWithNoCard(){
        assertEquals(null, this.player.getCard());
    }



}
