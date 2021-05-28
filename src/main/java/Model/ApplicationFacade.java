package Model;

import Model.InputAPI.InputFetcher;
import Model.InputAPI.InputFetcherDummy;
import Model.InputAPI.InputFetcherImpl;
import Model.InputAPI.InputObjects.League;
import Model.InputAPI.InputObjects.Series;
import org.json.*;

import java.io.IOException;

public class ApplicationFacade {

    private String inputAuth;
    private String outputAuth;
    private InputFetcher inputFetcher;

    public ApplicationFacade(InputFetcher inputFetcher, InputFetcher fake) {
        this.inputFetcher = inputFetcher;
    }



    private League convertToLeagueObject(JSONObject leagueData) {
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
            JSONObject errorMessage = new JSONObject(jsonData);
            String output = "error: ".concat(errorMessage.getString("error"));
            return output;
        } else {
            JSONArray leagueData = new JSONArray(jsonData);
            String leagueOutput = "";
            for(int i = 0; i < leagueData.length(); i++) {
                JSONObject current = (JSONObject) leagueData.get(i);
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

    private Series convertToSeriesObject(JSONObject seriesData) {
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
            JSONObject errorMessage = new JSONObject(jsonData);
            String output = "error: ".concat(errorMessage.getString("error"));
            return output;
        } else {
            JSONArray seriesData = new JSONArray(jsonData);
            String seriesOutput = "";
            for(int i = 0; i < seriesData.length(); i++) {
                JSONObject current = (JSONObject) seriesData.get(i);
                Series currentSeries = convertToSeriesObject(current);
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
}
