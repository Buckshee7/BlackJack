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

    private ArrayList<Player> decideWinner(){
        ArrayList<Player> winnerList = new ArrayList<>();
        for(Player player : players){
            if (winnerList.size() == 0) {
                winnerList.add(player);
            } else if (player.getCard().getCardValue() > winnerList.get(0).getCard().getCardValue()){
                winnerList.clear();
                winnerList.add(player);
            } else if (player.getCard().getCardValue() == winnerList.get(0).getCard().getCardValue()){
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
        if(winnerList.size() == 1){
            String name = winnerList.get(0).getName();
            String suit = winnerList.get(0).getCard().getSuitValue();
            int value = winnerList.get(0).getCard().getCardValue();
            return String.format("%s wins! They drew a %d of %s", name, value, suit);
        } else {
            String playerNames = "";
            for(Player player : winnerList){
                playerNames += String.format(" %s and", player.getName());
            }
            playerNames = playerNames.substring(0, playerNames.length()-4);
            int value = winnerList.get(0).getCard().getCardValue();
            return String.format("It's a draw! %s drew a %d", playerNames, value);
        }
    }
}
