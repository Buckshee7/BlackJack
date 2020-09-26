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
            } else if (getTotalValueForPlayerHand(player) > getTotalValueForPlayerHand(winnerList.get(0))){
                winnerList.clear();
                winnerList.add(player);
            } else if (getTotalValueForPlayerHand(player) == getTotalValueForPlayerHand(winnerList.get(0))){
                winnerList.add(player);
            }
        }
        return winnerList;
    }

    private int getTotalValueForPlayerHand(Player player){
        int total = 0;
        for(Card card : player.getHand()){
            total += card.getCardValue();
        }
        return total;
    }

    public String getWinner(){
        ArrayList<Player> winnerList = this.decideWinner();
        int handValue = getTotalValueForPlayerHand(winnerList.get(0));
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
}
