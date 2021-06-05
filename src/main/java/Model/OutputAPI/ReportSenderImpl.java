package Model.OutputAPI;

import org.apache.commons.codec.binary.Base64;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ReportSenderImpl implements ReportSender {

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
    public String sendMessage(String userSID, String userAuthToken, String toNumber,
                             String fromNumber, String message) throws IOException {
        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
            List<NameValuePair> nameValuePairs = new ArrayList<>();
            nameValuePairs.add(new BasicNameValuePair("accountSid", userSID));
            nameValuePairs.add(new BasicNameValuePair("To", toNumber));
            nameValuePairs.add(new BasicNameValuePair("From", fromNumber));
            nameValuePairs.add(new BasicNameValuePair("Body", message));

            String uri = (("https://api.twilio.com/2010-04-01/Accounts/").concat(userSID)).concat("/Messages.json");
            HttpPost httpPost = new HttpPost(uri);
            String encodedDetails = Base64.encodeBase64String((userSID + ":" + userAuthToken).getBytes());
            httpPost.setHeader("Authorization", "Basic " + encodedDetails);
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, StandardCharsets.UTF_8));
            CloseableHttpResponse response = httpClient.execute(httpPost);

            HttpEntity entity = response.getEntity();
            String json;
            try {
                json = EntityUtils.toString(entity);
                return json;
            } catch (ParseException e) {
                e.printStackTrace();
            }

            EntityUtils.consume(entity);
            return null;
        }
    }
}
