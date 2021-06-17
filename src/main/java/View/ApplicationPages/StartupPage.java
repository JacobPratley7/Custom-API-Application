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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StartupPage {

    /**
     * Constructs HomePage object.
     * Also responsible for constructing the homePage scene that will be
     * used by the ApplicationWindow.
     *
     * @param window Primary stage used by the ApplicationWindow.
     * @param otherScenes The other scenes used by the ApplicationWindow.
     * @param textBoxes The other text boxes used by the ApplicationWindow.
     * @param controller The ApplicationController used by the application.
     */
    public StartupPage(Stage window, HashMap<String, Scene> otherScenes, HashMap<String, Text> textBoxes, ApplicationController controller) {
        TextField yearField = new TextField();
        yearField.setMaxWidth(200);

        Scene startPage;
        Label startPageLabel = new Label("Please enter a year between 1900 and 2021");
        startPageLabel.setFont(Font.font("Modena", FontWeight.BOLD, Font.getDefault().getSize()));
        Button enterYear = new Button("Submit Year");
        enterYear.setOnAction(e -> {

            List<String> retrievedData = new ArrayList<>();
            Task<String> setYearTask = new Task<String>() {
                @Override
                protected String call() throws Exception {
                    return controller.setYear(yearField.getText());
                }
            };
            setYearTask.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED,
                    new EventHandler<WorkerStateEvent>() {
                        @Override
                        public void handle(WorkerStateEvent event) {
                            retrievedData.clear();
                            retrievedData.add((String) event.getSource().getValue());
                            if(retrievedData.get(0).equals("Success")) {
                                window.setScene(otherScenes.get("home"));
                            } else {
                                startPageLabel.setText(retrievedData.get(0));
                            }
                        }
                    });
            Thread setYearThread = new Thread(setYearTask);
            setYearThread.start();
        });



        VBox startPageLayout = new VBox(10);
        startPageLayout.getChildren().addAll(startPageLabel, yearField, enterYear);

        startPage = new Scene(startPageLayout, 800, 640);
        otherScenes.put("start", startPage);
    }

}
