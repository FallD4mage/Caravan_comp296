package comp296.caravan;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Card implements Comparable<Card> {
    private int masterPK;
    private String name;
    private int value;
    private int suit;
    private String image;
    private Card attachment;

    public Card(String name, int value, int suit){
        this.name = name;
        this.value = value;
        this.suit = suit;
    }
    public int getMasterPK() {
        return masterPK;
    }
    public String getName() {
        return name;
    }
    public int getValue() {
        return value;
    }
    public int getSuit() {
        return suit;
    }
    public String getImage() {
        return image;
    }
    public Card getAttachment() {
        return attachment;
    }
    public int compareTo(Card other) {
        if(this.value < other.value) {
            return -1;
        }else if(this.value > other.value) {
            return 1;
        }else{
            if(this.suit < other.suit) {
                return -1;
            }else if(this.suit > other.suit) {
                return 1;
            }else{
                return 0;
            }
        }
    }
    public void write() {
        String url = "jdbc:sqlite:caravan.db";
        try (Connection conn = DriverManager.getConnection(url)) {

            String sql = "INSERT INTO cardReal (FK_cardMaster) VALUES ("+this.masterPK+")";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}