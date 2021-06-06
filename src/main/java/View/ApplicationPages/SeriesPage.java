package View.ApplicationPages;

import Controller.ApplicationController;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SeriesPage {

    /**
     * Constructs SeriesPage object.
     * Also responsible for constructing the seriesPage scene that will be
     * used by the ApplicationWindow.
     *
     * @param window Primary stage used by the ApplicationWindow.
     * @param otherScenes The other scenes used by the ApplicationWindow.
     * @param textBoxes The other text boxes used by the ApplicationWindow.
     * @param controller The ApplicationController used by the application.
     */
    public SeriesPage(Stage window, HashMap<String, Scene> otherScenes, HashMap<String, Text> textBoxes, ApplicationController controller) throws IOException {
        Scene seriesPage;

        VBox seriesPageLayout = new VBox(10);
        Label sendSeriesDataLabel = new Label("Send this data?");
        sendSeriesDataLabel.setFont(Font.font("Modena", FontWeight.BOLD, Font.getDefault().getSize()));
        Button sendSeriesData = new Button("Send");
        Label series = new Label("Series:");
        series.setFont(Font.font("Modena", FontWeight.BOLD, Font.getDefault().getSize()));

        sendSeriesData.setOnAction(e -> {
            window.setScene(otherScenes.get("sent"));
            textBoxes.get("sent").setText("");
            List<String> retrievedData = new ArrayList<>();
            Task<String> sendReportTask = new Task<String>() {
                @Override
                protected String call() throws Exception {
                    return controller.sendReport();
                }
            };
            sendReportTask.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED,
                    new EventHandler<WorkerStateEvent>() {
                        @Override
                        public void handle(WorkerStateEvent event) {
                            retrievedData.clear();
                            retrievedData.add((String) event.getSource().getValue());
                            textBoxes.get("sent").setText(retrievedData.get(0));
                        }
                    });
            Thread sendReportThread = new Thread(sendReportTask);
            sendReportThread.start();
        });


        Button returnButtonTwo = new Button("Home");
        returnButtonTwo.setOnAction(e -> {window.setScene(otherScenes.get("home"));});


        seriesPageLayout.getChildren().addAll(sendSeriesDataLabel, sendSeriesData, series
                ,textBoxes.get("series"), returnButtonTwo);

        ScrollPane seriesScrollPane = new ScrollPane();
        seriesScrollPane.setContent(seriesPageLayout);

        seriesPage = new Scene(seriesScrollPane, 800, 640);
        otherScenes.put("series", seriesPage);
    }

}
