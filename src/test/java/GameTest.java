import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Player player1;
    private Player dealer;
    private Deck deck;
    private Game game;
    private Card cardAce;
    private Card cardFive;
    private Card cardSix;

    @Before
    public void before(){
        this.player1 = new Player("Ally");
        this.dealer = new Player("Dealer");
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(dealer);
        this.deck = new Deck();
        deck.populateDeck();
        deck.shuffleDeck();
        this.game = new Game(players, deck);
        this.cardAce = new Card(CardValue.ACE,CardSuit.SPADES);
        this.cardFive = new Card(CardValue.FIVE,CardSuit.SPADES);
        this.cardSix = new Card(CardValue.SIX,CardSuit.SPADES);
    }

    @Test
    public void canDealFromDeck(){
        this.game.dealFromDeck();
        assertEquals(2, this.player1.getHand().size());
        assertEquals(2, this.dealer.getHand().size());
    }

    @Test
    public void canTwist(){
        this.game.twist(player1);
        assertEquals(1, this.player1.getHand().size());
    }

    @Test
    public void canGetOutcomeWinFromBlackJackVs21NoAce(){
        Player dealer =  this.game.getPlayers().get(1);
        dealer.addCard(cardSix);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        Player player =  this.game.getPlayers().get(0);
        player.addCard(cardAce);
        player.addCard(cardFive);
        player.addCard(cardFive);
        player.addCard(cardFive);
        player.addCard(cardFive);
        assertEquals("Ally has beaten the Dealer!", this.game.vsDealerOutcome(player));
    }

    @Test
    public void canGetOutcomeWinFrom21NoAceVs16WithAce(){
        Player dealer =  this.game.getPlayers().get(1);
        dealer.addCard(cardSix);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        Player player =  this.game.getPlayers().get(0);
        player.addCard(cardSix);
        player.addCard(cardFive);
        player.addCard(cardFive);
        player.addCard(cardFive);
        assertEquals("Ally has beaten the Dealer!", this.game.vsDealerOutcome(player));
    }

    @Test
    public void canGetOutcomeWinFrom15vs10(){
        Player dealer =  this.game.getPlayers().get(1);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        Player player =  this.game.getPlayers().get(0);
        player.addCard(cardFive);
        player.addCard(cardFive);
        player.addCard(cardFive);
        assertEquals("Ally has beaten the Dealer!", this.game.vsDealerOutcome(player));
    }

    @Test
    public void canGetOutcomeLossFromNoAceVsBlackJack(){
        Player dealer =  this.game.getPlayers().get(1);
        dealer.addCard(cardAce);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        Player player =  this.game.getPlayers().get(0);
        player.addCard(cardSix);
        player.addCard(cardFive);
        player.addCard(cardFive);
        player.addCard(cardFive);
        assertEquals("Ally lost to the Dealer :(", this.game.vsDealerOutcome(player));
    }

    @Test
    public void canGetOutcomeLossFromBustVs15(){
        Player dealer =  this.game.getPlayers().get(1);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        Player player =  this.game.getPlayers().get(0);
        player.addCard(cardFive);
        player.addCard(cardFive);
        player.addCard(cardFive);
        player.addCard(cardFive);
        player.addCard(cardFive);
        assertEquals("Ally lost to the Dealer :(", this.game.vsDealerOutcome(player));
    }

    @Test
    public void canGetOutcomeLossFrom16WithAceVs21NoAce(){
        Player dealer =  this.game.getPlayers().get(1);
        dealer.addCard(cardSix);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        Player player =  this.game.getPlayers().get(0);
        player.addCard(cardSix);
        player.addCard(cardFive);
        player.addCard(cardFive);
        assertEquals("Ally lost to the Dealer :(", this.game.vsDealerOutcome(player));
    }

    @Test
    public void canGetOutcomeLossFrom10vs15(){
        Player dealer =  this.game.getPlayers().get(1);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        Player player =  this.game.getPlayers().get(0);
        player.addCard(cardFive);
        player.addCard(cardFive);
        assertEquals("Ally lost to the Dealer :(", this.game.vsDealerOutcome(player));
    }

    @Test
    public void canGetOutcomeDrawFromBlackJackVsBlackJack(){
        Player dealer =  this.game.getPlayers().get(1);
        dealer.addCard(cardAce);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        Player player =  this.game.getPlayers().get(0);
        player.addCard(cardAce);
        player.addCard(cardFive);
        player.addCard(cardFive);
        player.addCard(cardFive);
        player.addCard(cardFive);
        assertEquals("It's a draw", this.game.vsDealerOutcome(player));
    }

    @Test
    public void canGetOutcomeDrawFromBustVsBust(){
        Player dealer =  this.game.getPlayers().get(1);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        Player player =  this.game.getPlayers().get(0);
        player.addCard(cardFive);
        player.addCard(cardFive);
        player.addCard(cardFive);
        player.addCard(cardFive);
        player.addCard(cardFive);
        assertEquals("It's a draw", this.game.vsDealerOutcome(player));
    }

    @Test
    public void canGetOutcomeDrawFrom21NoAceVs21NoAce(){
        Player dealer =  this.game.getPlayers().get(1);
        dealer.addCard(cardSix);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        Player player =  this.game.getPlayers().get(0);
        player.addCard(cardSix);
        player.addCard(cardFive);
        player.addCard(cardFive);
        player.addCard(cardFive);
        assertEquals("It's a draw", this.game.vsDealerOutcome(player));
    }

    @Test
    public void canGetOutcomeDrawFrom15vs15(){
        Player dealer =  this.game.getPlayers().get(1);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        dealer.addCard(cardFive);
        Player player =  this.game.getPlayers().get(0);
        player.addCard(cardFive);
        player.addCard(cardFive);
        player.addCard(cardFive);
        assertEquals("It's a draw", this.game.vsDealerOutcome(player));
    }

}
