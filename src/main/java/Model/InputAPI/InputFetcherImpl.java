package Model.InputAPI;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class InputFetcherImpl implements InputFetcher {

    public String getLeagues(String auth) throws IOException {
        String json = null;
        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String url = "https://api.pandascore.co/leagues?page[size]=50&page[number]=1";
            HttpGet httpGet = new HttpGet(url);
            String authToken = "Bearer ".concat(auth);
            httpGet.setHeader("Authorization", authToken);
            URI uri = new URIBuilder(httpGet.getUri()).build();
            ((HttpUriRequestBase) httpGet).setUri(uri);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();

            try {
                json = EntityUtils.toString(entity);
                System.out.println("\n" + json + "\n");
            } catch (ParseException e) {
                e.printStackTrace();
            }

            EntityUtils.consume(entity);
            return json;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return json;
    }

    public String getSeries(String auth, String leagueID) throws IOException {
        String json = null;
        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String url = (("https://api.pandascore.co/leagues/").concat(leagueID)).concat("/series?page[size]=50&page[number]=1");
            HttpGet httpGet = new HttpGet(url);
            String authToken = "Bearer ".concat(auth);
            httpGet.setHeader("Authorization", authToken);
            URI uri = new URIBuilder(httpGet.getUri()).build();
            ((HttpUriRequestBase) httpGet).setUri(uri);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();

            try {
                json = EntityUtils.toString(entity);
                //System.out.println("\n" + json + "\n");
            } catch (ParseException e) {
                e.printStackTrace();
            }

            EntityUtils.consume(entity);
            return json;
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        return json;
    }



}
