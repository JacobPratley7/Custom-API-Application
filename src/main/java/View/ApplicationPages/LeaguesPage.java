package View.ApplicationPages;

import Controller.ApplicationController;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.HashMap;

public class LeaguesPage {

    private Scene scene;

    public LeaguesPage(Stage window, HashMap<String, Scene> otherScenes, HashMap<String, Text> textBoxes, ApplicationController controller) throws IOException {
        Scene leaguesPage;

        VBox leaguePageLayout = new VBox(10);
        Label leagues = new Label("Leagues:");
        leagues.setFont(Font.font("Modena", FontWeight.BOLD, Font.getDefault().getSize()));
        Button returnButton = new Button("Home");
        returnButton.setOnAction(e -> {window.setScene(otherScenes.get("home"));});


        leaguePageLayout.getChildren().addAll(leagues,
                textBoxes.get("league"), returnButton);

        ScrollPane leagueScrollPane = new ScrollPane();
        leagueScrollPane.setContent(leaguePageLayout);

        leaguesPage = new Scene(leagueScrollPane, 800, 640);
        otherScenes.put("league", leaguesPage);
        this.scene = leaguesPage;
    }

}
