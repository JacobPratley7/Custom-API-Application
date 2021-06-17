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

public class InputModePage {

    /**
     * Constructs InputModePage object.
     * Also responsible for constructing the inputModePage scene that will be
     * used by the ApplicationWindow.
     *
     * @param window Primary stage used by the ApplicationWindow.
     * @param otherScenes The other scenes used by the ApplicationWindow.
     * @param textBoxes The other text boxes used by the ApplicationWindow.
     * @param controller The ApplicationController used by the application.
     */
    public InputModePage(Stage window, HashMap<String, Scene> otherScenes, HashMap<String, Text> textBoxes, ApplicationController controller) {
        Scene inputModePage;

        VBox inputModeLayout = new VBox(10);
        Label inputModeLabel = new Label("Would you like live or cached data?");
        inputModeLabel.setFont(Font.font("Modena", FontWeight.BOLD, Font.getDefault().getSize()));
        Button cachedData = new Button("Get cached data");
        Button liveData = new Button("Get live data");

        cachedData.setOnAction(e -> {
            window.setScene(otherScenes.get("league"));
            textBoxes.get("league").setText("");
            List<String> retrievedData = new ArrayList<>();
            Task<String> getLeaguesTask = new Task<String>() {
                @Override
                protected String call() throws Exception {
                    return controller.getLeagueData(true);
                }
            };
            getLeaguesTask.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED,
                    new EventHandler<WorkerStateEvent>() {
                        @Override
                        public void handle(WorkerStateEvent event) {
                            retrievedData.clear();
                            retrievedData.add((String) event.getSource().getValue());
                            textBoxes.get("league").setText(retrievedData.get(0));
                        }
                    });
            Thread getLeaguesThread = new Thread(getLeaguesTask);
            getLeaguesThread.start();
        });


        liveData.setOnAction(e -> {
            window.setScene(otherScenes.get("league"));
            textBoxes.get("league").setText("");
            List<String> retrievedData = new ArrayList<>();
            Task<String> getLeaguesTask = new Task<String>() {
                @Override
                protected String call() throws Exception {
                    return controller.getLeagueData(false);
                }
            };
            getLeaguesTask.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED,
                    new EventHandler<WorkerStateEvent>() {
                        @Override
                        public void handle(WorkerStateEvent event) {
                            retrievedData.clear();
                            retrievedData.add((String) event.getSource().getValue());
                            textBoxes.get("league").setText(retrievedData.get(0));
                        }
                    });
            Thread getLeaguesThread = new Thread(getLeaguesTask);
            getLeaguesThread.start();
        });

        inputModeLayout.getChildren().addAll(inputModeLabel, liveData, cachedData);
        inputModePage = new Scene(inputModeLayout, 800, 640);
        otherScenes.put("inputMode", inputModePage);
    }

}
