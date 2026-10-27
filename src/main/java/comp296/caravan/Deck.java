package comp296.caravan;
import comp296.caravan.DataStructure.LinkedListSorted;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Deck {
    private LinkedListSorted<Card> cardsMaster;
    private LinkedListSorted<Card> cardsReal;
    private boolean isPlayerDeck;

    public Deck(boolean isPlayerDeck) {
        cardsMaster = new LinkedListSorted<Card>();
        cardsReal = new LinkedListSorted<Card>();
        this.isPlayerDeck = isPlayerDeck;
    }
    public LinkedListSorted<Card> getCardsMaster() {
        return cardsMaster;
    }
    public LinkedListSorted<Card> getCardsReal() {
        return cardsReal;
    }
    public boolean isPlayerDeck() {
        return isPlayerDeck;
    }
    public void write() {
        String url = "jdbc:sqlite:caravan.db";
        try (Connection conn = DriverManager.getConnection(url)){

            cardsMaster.resetHead();
            for(int nav=0; nav<cardsMaster.size(); nav++) {
                Card card = cardsMaster.getNext();

                String sql = "SELECT seq FROM sqlite_sequence WHERE name='deck'";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                int deckPK = rs.getInt("seq")+1;

                sql = "INSERT INTO cardReal (FK_cardMaster, FK_deck) VALUES ("+card.getMasterPK()+", "+deckPK+")";
                stmt.executeUpdate(sql);
            }
            
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}