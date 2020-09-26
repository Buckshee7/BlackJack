import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private Deck deck;

    public Game(ArrayList<Player> players, Deck deck) {
        this.deck = deck;
        this.players = players;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Deck getDeck() {
        return deck;
    }

    public void dealFromDeck(){
        for(Player player : players){
            player.addCard(deck.dealCard());
            player.addCard(deck.dealCard());
        }
    }

    public String twist(Player player){
        player.addCard(deck.dealCard());
        int index = player.getHand().size() - 1;
        Card card = player.getHand().get(index);
        return card.getCardValueAndSuit();
    }

    private ArrayList<Player> decideWinner(){
        ArrayList<Player> winnerList = new ArrayList<>();
        for(Player player : players){
            if (winnerList.size() == 0) {
                winnerList.add(player);
            } else if (player.getHandTotal() > winnerList.get(0).getHandTotal()){
                winnerList.clear();
                winnerList.add(player);
            } else if (player.getHandTotal() == winnerList.get(0).getHandTotal()){
                winnerList.add(player);
            }
        }
        return winnerList;
    }

    public String getWinner(){
        ArrayList<Player> winnerList = this.decideWinner();
        int handValue = winnerList.get(0).getHandTotal();
        if(winnerList.size() == 1){
            String name = winnerList.get(0).getName();
            return String.format("%s wins! Their hand total was %d", name, handValue);
        } else {
            String playerNames = "";
            for(Player player : winnerList){
                playerNames += String.format(" %s and", player.getName());
            }
            playerNames = playerNames.substring(0, playerNames.length()-4);
            return String.format("It's a draw! %s's hand totals were %d", playerNames, handValue);
        }
    }

    public void delayGameXMs(int time){
        try
        { Thread.sleep(time); }
        catch(InterruptedException ex)
        { Thread.currentThread().interrupt(); }
    }

    public void reportIfBust21OrBlackjack(Player player){
        if (player.getHandTotal() > 21){
            System.out.println(String.format("%s is bust!", player.getName()));
            System.out.println("--------------------");
        } else if (player.isBlackJack()){
            System.out.println(String.format("%s got BlackJack!", player.getName()));
            System.out.println("--------------------");
        } else if (player.getHandTotal() == 21){
            System.out.println(String.format("%s got 21!", player.getName()));
            System.out.println("--------------------");
        }
    }
}
