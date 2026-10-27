package comp296.caravan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;

//Class to test the database connection.
public class DB_test extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }
    @SuppressWarnings("exports")
    public void start(Stage primaryStage) {
        String url = "jdbc:sqlite:caravan.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            int cardMasterID=((int)(Math.random()*54)+1);
            String sql = "SELECT * FROM cardMaster WHERE PK_card="+cardMasterID;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            String cardLink = rs.getString("image");
            String cardName = rs.getString("name");
            URL imageUrl = getClass().getResource("/images/" + cardLink);

            Image image = new Image(imageUrl.toString());
            ImageView imageView = new ImageView(image);

            Pane root = new Pane();
            root.getChildren().add(imageView);
            Scene scene = new Scene(root, 500, 726);
            primaryStage.setScene(scene);
            primaryStage.setTitle("DB Test: "+cardName);
            primaryStage.show();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}