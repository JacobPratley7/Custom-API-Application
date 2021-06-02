package View;

import Model.ApplicationFacade;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ApplicationWindow {

    private Stage window;
    private ApplicationFacade appFacade;
    private ApplicationFacade model;
    private Scene homePage, leaguesPage, seriesPage, sentDataPage;


    public ApplicationWindow(Stage window, ApplicationFacade appFacade) {
        this.window = window;
        this.appFacade = appFacade;
    }

    /**
     * Initializes all Scene objects used by the main application.
     * Creates all buttons/inputFields/text objects, assigns them to the appropriate Scene.
     */
    public void initialize() {

        Text leagueDataText = new Text();
        Text seriesDataText = new Text();
        Text sentDataText = new Text();

        TextField leagueIDSlug = new TextField();
        leagueIDSlug.setMaxWidth(200);

        //home page
        Label homePageLabel = new Label("Welcome!!!");
        Label getLeaguesLabel = new Label("Get Information on Leagues");
        getLeaguesLabel.setFont(Font.font("Modena", FontWeight.BOLD, Font.getDefault().getSize()));
        homePageLabel.setFont(new Font("Modena", 30));
        Button getLeagueData = new Button("Get League Data");
        getLeagueData.setOnAction(e -> {window.setScene(leaguesPage);
            try {
                leagueDataText.setText(appFacade.getLeagueData());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        Label getSeriesLabel = new Label("Get Information on Series for a particular League");
        getSeriesLabel.setFont(Font.font("Modena", FontWeight.BOLD, Font.getDefault().getSize()));
        Button getSeriesData = new Button("Get Series Data");
        getSeriesData.setOnAction(e -> {window.setScene(seriesPage);
            try {
                seriesDataText.setText(appFacade.getSeriesData(leagueIDSlug.getText()));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        VBox homePageLayout = new VBox(10);
        homePageLayout.getChildren().addAll(homePageLabel, getLeaguesLabel, getLeagueData,
                getSeriesLabel, leagueIDSlug, getSeriesData);

        homePage = new Scene(homePageLayout, 800, 640);


        //leaguesPage
        VBox leaguePageLayout = new VBox(10);
        Button sendLeagueData = new Button("Send");
        Label leagues = new Label("Leagues:");
        leagues.setFont(Font.font("Modena", FontWeight.BOLD, Font.getDefault().getSize()));
        sendLeagueData.setOnAction(e -> {window.setScene(sentDataPage);
            sentDataText.setText("sent!");});
        Button returnButton = new Button("Home");
        returnButton.setOnAction(e -> {window.setScene(homePage);});


        leaguePageLayout.getChildren().addAll(leagues,
                leagueDataText, returnButton);

        ScrollPane leagueScrollPane = new ScrollPane();
        leagueScrollPane.setContent(leaguePageLayout);

        leaguesPage = new Scene(leagueScrollPane, 800, 640);

        //seriesPage
        VBox seriesPageLayout = new VBox(10);
        Label sendSeriesDataLabel = new Label("Send this data?");
        sendSeriesDataLabel.setFont(Font.font("Modena", FontWeight.BOLD, Font.getDefault().getSize()));
        Button sendSeriesData = new Button("Send");
        Label series = new Label("Series:");
        series.setFont(Font.font("Modena", FontWeight.BOLD, Font.getDefault().getSize()));

        sendSeriesData.setOnAction(e -> {window.setScene(sentDataPage);
            try {
                sentDataText.setText(appFacade.sendReport());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        Button returnButtonTwo = new Button("Home");
        returnButtonTwo.setOnAction(e -> {window.setScene(homePage);});


        seriesPageLayout.getChildren().addAll(sendSeriesDataLabel, sendSeriesData, series
                ,seriesDataText, returnButtonTwo);

        ScrollPane seriesScrollPane = new ScrollPane();
        seriesScrollPane.setContent(seriesPageLayout);

        seriesPage = new Scene(seriesScrollPane, 800, 640);

        //sentDataPage
        VBox sentDataLayout = new VBox(10);
        Button returnButtonThree = new Button("Home");
        returnButtonThree.setOnAction(e -> {window.setScene(homePage);});

        sentDataLayout.getChildren().addAll(sentDataText, returnButtonThree);

        sentDataPage = new Scene(sentDataLayout, 800, 640);

        window.setScene(homePage);
    }


}