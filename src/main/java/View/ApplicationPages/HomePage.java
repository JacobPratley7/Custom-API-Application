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

public class HomePage {

    /**
     * Constructs HomePage object.
     * Also responsible for constructing the homePage scene that will be
     * used by the ApplicationWindow
     *
     * @param window Primary stage used by the ApplicationWindow
     * @param otherScenes the other scenes used by the ApplicationWindow
     * @param textBoxes the other text boxes used by the ApplicationWindow
     * @param controller the ApplicationController used by the application
     * @return new HomePage instance
     */
    public HomePage(Stage window, HashMap<String, Scene> otherScenes, HashMap<String, Text> textBoxes, ApplicationController controller) {
        TextField leagueIDSlug = new TextField();
        leagueIDSlug.setMaxWidth(200);

        Scene homePage;
        Label homePageLabel = new Label("Welcome!!!");
        Label getLeaguesLabel = new Label("Get Information on Leagues");
        getLeaguesLabel.setFont(Font.font("Modena", FontWeight.BOLD, Font.getDefault().getSize()));
        homePageLabel.setFont(new Font("Modena", 30));
        Button getLeagueData = new Button("Get League Data");
        getLeagueData.setOnAction(e -> {window.setScene(otherScenes.get("inputMode"));});

        Label getSeriesLabel = new Label("Get Information on Series for a particular League");
        getSeriesLabel.setFont(Font.font("Modena", FontWeight.BOLD, Font.getDefault().getSize()));
        Button getSeriesData = new Button("Get Series Data");
        getSeriesData.setOnAction(e -> {window.setScene(otherScenes.get("series"));
            try {
                textBoxes.get("series").setText(controller.getSeriesData(leagueIDSlug.getText()));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        VBox homePageLayout = new VBox(10);
        homePageLayout.getChildren().addAll(homePageLabel, getLeaguesLabel, getLeagueData,
                getSeriesLabel, leagueIDSlug, getSeriesData);

        homePage = new Scene(homePageLayout, 800, 640);
        otherScenes.put("home", homePage);
    }

}
