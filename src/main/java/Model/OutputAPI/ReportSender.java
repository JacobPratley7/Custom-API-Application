package Model.OutputAPI;

import java.io.IOException;

public interface ReportSender {

    /**
     * Sends a message to a pre-configured number.
     *
     * @param userSID The user's sid for the output API.
     * @param userAuthToken The user's authentication token for the output API.
     * @param toNumber The pre-configured number the user wishes to send the report to.
     * @param fromNumber The twilio number used to send the report.
     * @param message The report to be sent.
     * @return String in json format representing API's response to the request.
     * @throws IOException If error is to occur whilst accessing output API.
     */
    String sendMessage(String userSID, String userAuthToken, String toNumber,
                       String fromNumber, String message) throws IOException;
}
