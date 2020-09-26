import java.util.ArrayList;
import java.util.Scanner;

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
        for(int i=0; i<numberOfPlayers; i++){
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

        //reporting and decision-making
        for(Player player : game.getPlayers()){
            //report player hand situation
            System.out.println(String.format("%s's turn", player.getName()));
            System.out.println(String.format("%s's cards:", player.getName()));
            for (Card card : player.getHand()) {
                System.out.println(card.getCardValueAndSuit());
            }
            System.out.println(String.format("Hand Total Value: %s", player.getHandTotal()));
            if (player.getName() != "Dealer"){
                boolean endTurn = false;
                while (endTurn == false) {
                    if (player.getHandTotal() > 21){
                        System.out.println(String.format("%s is bust!", player.getName()));
                    } else if (player.getHandTotal() == 100){
                        System.out.println("BlackJack!");
                    }
                    //get player decision
                    if (player.getHandTotal() >= 21){
                        endTurn = true;
                    } else {
                        boolean validResponse = false;
                        String decision = "";
                        while (validResponse == false) {
                            if (decision.toLowerCase() != "twist" && decision.toLowerCase() != "stand") {
                                System.out.println("Twist or Stand?");
                                decision = scanner.next();
                            } else {
                                validResponse = true;
                            }
                        }
                        if (decision.toLowerCase() == "stand"){
                            endTurn = true;
                        } else {
                            System.out.println(game.twist(player));
                            System.out.println(String.format("Hand Total Value: %s", player.getHandTotal()));
                        }
                    }
                }
            } else {
                // if player is dealer twist if handTotal < 16
                boolean endTurn = false;
                while (endTurn == false) {
                    if (player.getHandTotal() < 16) {
                        System.out.println(game.twist(player));
                        System.out.println(String.format("Hand Total Value: %s", player.getHandTotal()));
                    } else {
                        endTurn = true;
                    }
                }
            }
        }

//        game.reportGameOutcome();
    }

}
