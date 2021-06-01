package Model;

import Model.InputAPI.InputFetcher;
import Model.InputAPI.InputFetcherDummy;
import Model.InputAPI.InputFetcherImpl;
import Model.InputAPI.InputObjects.League;
import Model.InputAPI.InputObjects.Series;
import Model.InputAPI.InputObjects.Tournament;
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

    /**
     * Class Constructor. Will also retrieve/store the cpntents of the config file
     * @param inputFetcher The InputFetcher object used to access the input API
     * @param reportSender The ReportSender object used to access the output API
     * @return new ApplicationFacade instance
     */
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
        org.json.JSONObject videoGame = leagueData.getJSONObject("videogame");
        newLeague.setVideoGameCurrentVersion(videoGame.get("current_version"));
        newLeague.setVideoGameName(videoGame.get("name"));
        newLeague.setVideoGameSlug(videoGame.get("slug"));
        newLeague.setVideoGameID(videoGame.get("id"));
        return newLeague;
    }

    /**
     * Retrieves league information from input API,
     * then formats this data into a more human readable string.
     *
     * @return String in human readable format representing league data
     * @throws IOException if error is to occur whilst accessing input API
     */
    public String getLeagueData() throws IOException {
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
                leagueOutput = leagueOutput.concat("\nvideo game:");
                leagueOutput = (leagueOutput.concat("\n\tcurrent version: ")).concat(currentLeague.getVideoGameCurrentVersion());
                leagueOutput = (leagueOutput.concat("\n\tid: ")).concat(currentLeague.getVideoGameID());
                leagueOutput = (leagueOutput.concat("\n\tname: ")).concat(currentLeague.getVideoGameName());
                leagueOutput = (leagueOutput.concat("\n\tslug: ")).concat(currentLeague.getVideoGameSlug());
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



    /**
     * Retrieves series information from input API,
     * then formats this data into a more human readable string.
     *
     * @param leagueID the id or the slug of the league the users wants series data on
     * @return String in human readable format representing series data
     * @throws IOException if error is to occur whilst accessing input API
     */
    public String getSeriesData(String leagueID) throws IOException {
        String jsonData = this.inputFetcher.getSeries(inputAuth, leagueID);
        if(jsonData.contains("error")) {
            this.lastRetrievedSeries = null;
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

    private String generateReport() {
        if(this.lastRetrievedSeries == null) {
            return "No data to report";
        }
        String report = "league id: ".concat(this.lastRetrievedSeries.get(0).getLeagueId());
        report = report.concat("\nseries:");
        for(Series s: this.lastRetrievedSeries) {
            String currentSeriesData = "\n\tid: ".concat(s.getID());
            currentSeriesData = currentSeriesData.concat("\n\tfull name: ").concat(s.getFullName());
            currentSeriesData = currentSeriesData.concat("\n\tslug: ").concat(s.getSlug());
            currentSeriesData = currentSeriesData.concat("\n\ttier: ").concat(s.getTier());
            currentSeriesData = currentSeriesData.concat("\n\tyear: ").concat(s.getYear());
            currentSeriesData = currentSeriesData.concat("\n");
            currentSeriesData = currentSeriesData.concat("\n");
            if(report.length() + currentSeriesData.length() >= 1600) {
                break;
            } else {
                report = report.concat(currentSeriesData);
            }
        }

        return report;
    }

    /**
     * Generates a report and sends it the the pre-configured number.
     * Returns a string displaying the report if the message was sent successfully,
     * or the error message if the message was not able to send
     *
     * @return String displaying either the report or the error message
     * @throws IOException if error is to occur whilst accessing output API
     */
    public String sendReport() throws IOException {
        String report = this.generateReport();
        String feedback = this.reportSender.sendMessage(this.outputSID, this.outputAuth, this.outputToNumber,
                this.twilioNumber, report);
        org.json.JSONObject feedbackData = new org.json.JSONObject(feedback);
        if(feedback.contains("more_info")) {
            String output = "Something went wrong.";
            output = output.concat("code: ").concat(Integer.toString(feedbackData.getInt("code")));
            output = output.concat("\nmessage: ").concat(feedbackData.getString("message"));
            output = output.concat("\nmore info: ").concat(feedbackData.getString("more_info"));
            return output;

        }

        return "Message sent Successfully!\n".concat(report);
    }

}
