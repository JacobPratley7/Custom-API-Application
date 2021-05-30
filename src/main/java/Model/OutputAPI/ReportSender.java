package Model.OutputAPI;

import java.io.IOException;

public interface ReportSender {

    String sendMessage(String userSID, String userAuthToken, String toNumber,
                       String fromNumber, String message) throws IOException;
}
