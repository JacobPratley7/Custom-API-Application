package View.ApplicationPages;

import Controller.ApplicationController;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.HashMap;

public class SendPage {

    private Scene scene;

    public SendPage(Stage window, HashMap<String, Scene> otherScenes, HashMap<String, Text> textBoxes, ApplicationController controller) throws IOException {
        Scene sentDataPage;

        VBox sentDataLayout = new VBox(10);
        Button returnButtonThree = new Button("Home");
        returnButtonThree.setOnAction(e -> {window.setScene(otherScenes.get("home"));});

        sentDataLayout.getChildren().addAll(textBoxes.get("sent"), returnButtonThree);

        sentDataPage = new Scene(sentDataLayout, 800, 640);
        otherScenes.put("sent", sentDataPage);
        this.scene = sentDataPage;
    }
}
