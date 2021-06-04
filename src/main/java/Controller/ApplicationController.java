package Controller;

import Model.ApplicationFacade;
import Model.Database.DataBaseManager;
import Model.InputAPI.InputFetcher;
import Model.InputAPI.InputFetcherDummy;
import Model.InputAPI.InputFetcherImpl;
import Model.OutputAPI.ReportSender;
import Model.OutputAPI.ReportSenderDummy;
import Model.OutputAPI.ReportSenderImpl;
import View.ApplicationWindow;
import javafx.stage.Stage;
import java.io.IOException;

public class ApplicationController {

    private ApplicationFacade appFacade;
    private ApplicationWindow appWindow;

    /**
     * Constructs ApplicationManager object.
     * Also responsible for constructing the ApplicationFacade object that will be
     * used by the rest of the application
     *
     * @param inputMode String representing the desired input API functionality
     * @param outputMode String representing the desired output API functionality
     * @return new ApplicationManager instance
     */
    public ApplicationController(String inputMode, String outputMode) {
        InputFetcher inFetcher = null;
        ReportSender repSender = null;
        if(inputMode.equals("online")) {
            inFetcher = new InputFetcherImpl();
        } else if(inputMode.equals("offline")){
            inFetcher = new InputFetcherDummy();
        } else {
            System.out.println("Please provide a valid input mode");
            System.exit(0);
        }

        if(outputMode.equals("online")) {
            repSender = new ReportSenderImpl();
        } else if(outputMode.equals("offline")){
            repSender = new ReportSenderDummy();
        } else {
            System.out.println("Please provide a valid output mode");
            System.exit(0);
        }

        this.appFacade = new ApplicationFacade(inFetcher, repSender, new DataBaseManager());
    }



    /** Calls the stored ApplicationFacade, returns league data */
    public String getLeagueData(boolean cachedDataWanted) throws IOException {
        return this.appFacade.getLeagueData(cachedDataWanted);
    }

    /** Calls the stored ApplicationFacade, returns series data */
    public String getSeriesData(String idOrSlug) throws IOException {
        return this.appFacade.getSeriesData(idOrSlug);
    }

    /** Calls the stored ApplicationFacade, returns the report */
    public String sendReport() throws IOException {
        return this.appFacade.sendReport();
    }

    /** Returns the stored ApplicationWindow */
    public ApplicationWindow getAppWindow() {
        return this.appWindow;
    }

    /** Sets and creates a new ApplicationWindow */
    public void setAppWindow(Stage primaryStage) {
        this.appWindow = new ApplicationWindow(primaryStage, this);
    }
}
