import Model.ApplicationFacade;
import Model.InputAPI.InputFetcher;
import Model.InputAPI.InputFetcherDummy;
import Model.InputAPI.InputFetcherImpl;
import Model.OutputAPI.ReportSender;
import Model.OutputAPI.ReportSenderDummy;
import Model.OutputAPI.ReportSenderImpl;
import View.ApplicationWindow;
import javafx.stage.Stage;

import java.util.List;

public class ApplicationManager {

    private ApplicationFacade appFacade;

    public ApplicationManager(String inputMode, String outputMode) {
        InputFetcher inFetcher;
        ReportSender repSender;
        if(inputMode.equals("online")) {
            inFetcher = new InputFetcherImpl();
        } else {
            inFetcher = new InputFetcherDummy();
        }

        if(outputMode == "online") {
            repSender = new ReportSenderImpl();
        } else {
            repSender = new ReportSenderDummy();
        }

        this.appFacade = new ApplicationFacade(inFetcher, repSender);
    }


    public ApplicationFacade getAppFacade() {
        return appFacade;
    }


}
