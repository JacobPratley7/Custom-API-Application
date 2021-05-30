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
