import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;

public class Runner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to BlackJack");
        System.out.println("How many players would like to play?");

        String input = scanner.next();
        int numberOfPlayers = parseInt(input);

        // add players
        ArrayList<Player> players = new ArrayList();
        for(int i=1; i<=numberOfPlayers; i++){
            System.out.println(String.format("Player %d, enter you name: ", i));
            String playerName = scanner.next();
            Player newPlayer = new Player(playerName);
            players.add(newPlayer);
        }
        //add dealer
        players.add(new Player("Dealer"));

        Deck deck = new Deck();
        deck.populateDeck();
        deck.shuffleDeck();

        Game game = new Game(players, deck);
        game.dealFromDeck();

        //reporting and decision-making
        for(Player player : game.getPlayers()){
            //report player hand situation
            System.out.println(String.format("%s's turn", player.getName()));
            game.delayGameXMs(1200);
            System.out.println(String.format("%s's cards:", player.getName()));
            for (Card card : player.getHand()) {
                System.out.println(card.getCardValueAndSuit());
                game.delayGameXMs(1000);
            }
            System.out.println(String.format("Hand Total Value: %s", player.getHandTotal()));
            game.delayGameXMs(1000);
            if (player.getName() != "Dealer"){
                boolean endTurn = false;
                while (endTurn == false) {

                    //get player decision
                    if (player.getHandTotal() >= 21){
                        endTurn = true;
                    } else {
                        boolean validResponse = false;
                        String decision = "";
                        while (validResponse == false) {
                            //ensure response valid
                            decision.toLowerCase();
                            if (decision.equalsIgnoreCase("twist") || decision.equalsIgnoreCase("stand")) {
                                validResponse = true;
                            } else {
                                System.out.println("Twist or Stand?");
                                decision = scanner.next();
                            }
                        }
                        //action decision
                        if (decision.equalsIgnoreCase("stand")) {
                            endTurn = true;
                            System.out.println("--------------------");
                        } else {
                            System.out.println(game.twist(player));
                            System.out.println(String.format("Hand Total Value: %s", player.getHandTotal()));
                            game.delayGameXMs(1000);
                            game.reportIfBust21OrBlackjack(player);
                        }
                    }
                }
            } else {
                // if player is dealer twist if handTotal < 16
                boolean endTurn = false;
                game.delayGameXMs(2000);
                while (endTurn == false) {
                    if (player.getHandTotal() < 16) {
                        System.out.println("Dealer Twists");
                        game.delayGameXMs(1500);
                        System.out.println(game.twist(player));
                        System.out.println(String.format("Hand Total Value: %d", player.getHandTotal()));
                        game.delayGameXMs(1500);
                        game.reportIfBust21OrBlackjack(player);
                    } else {
                        System.out.println("Dealer Sticks");
                        game.delayGameXMs(1500);
                        endTurn = true;
                    }
                }
                System.out.println("***R*E*S*U*L*T*S***");
            }

        }

        game.reportGameOutcome();
    }

}
