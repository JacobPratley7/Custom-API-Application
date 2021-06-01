import Model.ApplicationFacade;
import Model.InputAPI.InputFetcher;
import Model.InputAPI.InputFetcherDummy;
import Model.InputAPI.InputFetcherImpl;
import Model.OutputAPI.ReportSender;
import Model.OutputAPI.ReportSenderDummy;
import Model.OutputAPI.ReportSenderImpl;

public class ApplicationManager {

    private ApplicationFacade appFacade;

    /**
     * Constructs ApplicationManager object.
     * Also responsible for constructing the ApplicationFacade object that will be
     * used by the rest of the application
     *
     * @param inputMode String representing the desired input API functionality
     * @param outputMode String representing the desired output API functionality
     * @return new ApplicationManager instance
     */
    public ApplicationManager(String inputMode, String outputMode) {
        InputFetcher inFetcher;
        ReportSender repSender;
        if(inputMode.equals("online")) {
            inFetcher = new InputFetcherImpl();
        } else {
            inFetcher = new InputFetcherDummy();
        }

        if(outputMode.equals("online")) {
            repSender = new ReportSenderImpl();
        } else {

            repSender = new ReportSenderDummy();
        }

        this.appFacade = new ApplicationFacade(inFetcher, repSender);
    }


    /** Returns the stored ApplicationFacade */
    public ApplicationFacade getAppFacade() {
        return appFacade;
    }


}
