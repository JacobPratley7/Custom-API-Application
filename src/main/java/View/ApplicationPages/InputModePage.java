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

public class InputModePage {

    /**
     * Constructs InputModePage object.
     * Also responsible for constructing the inputModePage scene that will be
     * used by the ApplicationWindow
     *
     * @param window Primary stage used by the ApplicationWindow
     * @param otherScenes the other scenes used by the ApplicationWindow
     * @param textBoxes the other text boxes used by the ApplicationWindow
     * @param controller the ApplicationController used by the application
     * @return new InputModePage instance
     */
    public InputModePage(Stage window, HashMap<String, Scene> otherScenes, HashMap<String, Text> textBoxes, ApplicationController controller) {
        Scene inputModePage;

        VBox inputModeLayout = new VBox(10);
        Label inputModeLabel = new Label("Would you like live or cached data?");
        inputModeLabel.setFont(Font.font("Modena", FontWeight.BOLD, Font.getDefault().getSize()));
        Button cachedData = new Button("Get cached data");
        Button liveData = new Button("Get live data");
        cachedData.setOnAction(e -> {window.setScene(otherScenes.get("league"));
            try {
                textBoxes.get("league").setText(controller.getLeagueData(true));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        liveData.setOnAction(e -> {window.setScene(otherScenes.get("league"));
            try {
                textBoxes.get("league").setText(controller.getLeagueData(false));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        inputModeLayout.getChildren().addAll(inputModeLabel, liveData, cachedData);
        inputModePage = new Scene(inputModeLayout, 800, 640);
        otherScenes.put("inputMode", inputModePage);
    }

}
