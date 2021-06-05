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

public class SeriesPage {

    private Scene scene;

    public SeriesPage(Stage window, HashMap<String, Scene> otherScenes, HashMap<String, Text> textBoxes, ApplicationController controller) throws IOException {
        Scene seriesPage;

        VBox seriesPageLayout = new VBox(10);
        Label sendSeriesDataLabel = new Label("Send this data?");
        sendSeriesDataLabel.setFont(Font.font("Modena", FontWeight.BOLD, Font.getDefault().getSize()));
        Button sendSeriesData = new Button("Send");
        Label series = new Label("Series:");
        series.setFont(Font.font("Modena", FontWeight.BOLD, Font.getDefault().getSize()));

        sendSeriesData.setOnAction(e -> {window.setScene(otherScenes.get("sent"));
            try {
                textBoxes.get("sent").setText(controller.sendReport());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        Button returnButtonTwo = new Button("Home");
        returnButtonTwo.setOnAction(e -> {window.setScene(otherScenes.get("home"));});


        seriesPageLayout.getChildren().addAll(sendSeriesDataLabel, sendSeriesData, series
                ,textBoxes.get("series"), returnButtonTwo);

        ScrollPane seriesScrollPane = new ScrollPane();
        seriesScrollPane.setContent(seriesPageLayout);

        seriesPage = new Scene(seriesScrollPane, 800, 640);
        otherScenes.put("series", seriesPage);
        this.scene = seriesPage;
    }

}
