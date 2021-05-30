package Model;

import Model.InputAPI.InputFetcher;
import Model.InputAPI.InputFetcherDummy;
import Model.InputAPI.InputFetcherImpl;
import Model.InputAPI.InputObjects.League;
import Model.InputAPI.InputObjects.Series;
import Model.OutputAPI.ReportSender;
import org.apache.commons.codec.binary.Base64;
import org.apache.hc.client5.http.auth.AuthScope;
import org.apache.hc.client5.http.auth.CredentialsProvider;
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.json.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ApplicationFacade {

    private String inputAuth;
    private String outputAuth;
    private String outputSID;
    private String outputToNumber;
    private String twilioNumber;
    private InputFetcher inputFetcher;
    private ReportSender reportSender;
    private List<Series> lastRetrievedSeries;

    public ApplicationFacade(InputFetcher inputFetcher, ReportSender reportSender) {
        this.inputFetcher = inputFetcher;
        this.reportSender = reportSender;

        JSONParser jsonParser = new JSONParser();
        try {
            Object fileContents = jsonParser.parse(new FileReader("config.json"));
            org.json.simple.JSONObject configDetails = (JSONObject) fileContents;
            this.inputAuth = (String) configDetails.get("inputAuthToken");

            this.outputAuth = (String) configDetails.get("outputAuthToken");
            this.outputSID = (String) configDetails.get("outputUsername");
            this.outputToNumber = (String) configDetails.get("outputNumberTo");
            this.twilioNumber = (String) configDetails.get("outputNumberFrom");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private League convertToLeagueObject(org.json.JSONObject leagueData) {
        League newLeague = new League();
        newLeague.setID(leagueData.get("id"));
        newLeague.setImageUrl(leagueData.get("image_url"));
        newLeague.setModifiedAt(leagueData.get("modified_at"));
        newLeague.setName(leagueData.get("name"));
        newLeague.setSlug(leagueData.get("slug"));
        newLeague.setUrl(leagueData.get("url"));
        return newLeague;
    }

    public String getLeagueData(String inputAuth) throws IOException {
        String jsonData = this.inputFetcher.getLeagues(inputAuth);
        if(jsonData.contains("error")) {
            org.json.JSONObject errorMessage = new org.json.JSONObject(jsonData);
            String output = "error: ".concat(errorMessage.getString("error"));
            return output;
        } else {
            JSONArray leagueData = new JSONArray(jsonData);
            String leagueOutput = "";
            for(int i = 0; i < leagueData.length(); i++) {
                org.json.JSONObject current = (org.json.JSONObject) leagueData.get(i);
                League currentLeague = convertToLeagueObject(current);
                leagueOutput = (leagueOutput.concat("id: ")).concat(currentLeague.getID());
                leagueOutput = (leagueOutput.concat("\nimage url: ")).concat(currentLeague.getImageUrl());
                leagueOutput = (leagueOutput.concat("\nmodified at: ")).concat(currentLeague.getModifiedAt());
                leagueOutput = (leagueOutput.concat("\nname: ")).concat(currentLeague.getName());
                leagueOutput = (leagueOutput.concat("\nslug: ")).concat(currentLeague.getSlug());
                leagueOutput = (leagueOutput.concat("\nurl: ")).concat(currentLeague.getUrl());
                leagueOutput = leagueOutput.concat("\n");
                leagueOutput = leagueOutput.concat("\n");
            }
            return leagueOutput;
        }
    }

    private Series convertToSeriesObject(org.json.JSONObject seriesData) {
        Series newSeries = new Series();
        newSeries.setID(seriesData.get("id"));
        newSeries.setBeginAt(seriesData.get("begin_at"));
        newSeries.setDescription(seriesData.get("description"));
        newSeries.setEndAt(seriesData.get("end_at"));
        newSeries.setFullName(seriesData.get("full_name"));
        newSeries.setLeagueID(seriesData.get("league_id"));
        newSeries.setModifiedAt(seriesData.get("modified_at"));
        newSeries.setName(seriesData.get("name"));
        newSeries.setSeason(seriesData.get("season"));
        newSeries.setSlug(seriesData.get("slug"));
        newSeries.setTier(seriesData.get("tier"));
        newSeries.setVideoGameTitle(seriesData.get("videogame_title"));
        newSeries.setWinnerId(seriesData.get("winner_id"));
        newSeries.setWinnerType(seriesData.get("winner_type"));
        newSeries.setYear(seriesData.get("year"));

        return newSeries;
    }

    public String getSeriesData(String auth, String leagueID) throws IOException {
        String jsonData = this.inputFetcher.getSeries(auth, leagueID);
        if(jsonData.contains("error")) {
            org.json.JSONObject errorMessage = new org.json.JSONObject(jsonData);
            String output = "error: ".concat(errorMessage.getString("error"));
            return output;
        } else {
            this.lastRetrievedSeries = new ArrayList<>();
            JSONArray seriesData = new JSONArray(jsonData);
            String seriesOutput = "";
            for(int i = 0; i < seriesData.length(); i++) {
                org.json.JSONObject current = (org.json.JSONObject) seriesData.get(i);
                Series currentSeries = convertToSeriesObject(current);
                this.lastRetrievedSeries.add(currentSeries);
                seriesOutput = (seriesOutput.concat("begin at: ")).concat(currentSeries.getBeginAt());
                seriesOutput = (seriesOutput.concat("\ndescription: ")).concat(currentSeries.getDescription());
                seriesOutput = (seriesOutput.concat("\nend at: ")).concat(currentSeries.getEndAt());
                seriesOutput = (seriesOutput.concat("\nfull name: ")).concat(currentSeries.getFullName());
                seriesOutput = (seriesOutput.concat("\nid: ")).concat(currentSeries.getID());
                seriesOutput = (seriesOutput.concat("\nleague id: ")).concat(currentSeries.getLeagueId());
                seriesOutput = (seriesOutput.concat("\nmodified at: ")).concat(currentSeries.getModifiedAt());
                seriesOutput = (seriesOutput.concat("\nname: ")).concat(currentSeries.getName());
                seriesOutput = (seriesOutput.concat("\nseason: ")).concat(currentSeries.getSeason());
                seriesOutput = (seriesOutput.concat("\nslug: ")).concat(currentSeries.getSlug());
                seriesOutput = (seriesOutput.concat("\ntier: ")).concat(currentSeries.getTier());
                seriesOutput = (seriesOutput.concat("\nvideogame title: ")).concat(currentSeries.getVideoGameTitle());
                seriesOutput = (seriesOutput.concat("\nwinner id: ")).concat(currentSeries.getWinnerId());
                seriesOutput = (seriesOutput.concat("\nwinner type: ")).concat(currentSeries.getWinnerType());
                seriesOutput = (seriesOutput.concat("\nyear: ")).concat(currentSeries.getYear());
                seriesOutput = seriesOutput.concat("\n");
                seriesOutput = seriesOutput.concat("\n");
            }

            return seriesOutput;
        }
    }

    public String sendReport() {
        return null;
    }


}
