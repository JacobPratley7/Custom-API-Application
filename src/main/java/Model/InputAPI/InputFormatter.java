package Model.InputAPI;

import Model.InputAPI.InputObjects.League;
import Model.InputAPI.InputObjects.Series;
import Model.InputAPI.InputObjects.Tournament;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class InputFormatter {


    private League convertToLeagueObjectSimple(org.json.JSONObject leagueData) {
        League newLeague = new League();
        newLeague.setID(leagueData.get("id"));
        newLeague.setImageUrl(leagueData.get("image_url"));
        newLeague.setModifiedAt(leagueData.get("modified_at"));
        newLeague.setName(leagueData.get("name"));
        newLeague.setSlug(leagueData.get("slug"));
        newLeague.setUrl(leagueData.get("url"));
        return newLeague;
    }

    private League convertToLeagueObject(org.json.JSONObject leagueData) {
        League newLeague = new League();
        newLeague.setID(leagueData.get("id"));
        newLeague.setImageUrl(leagueData.get("image_url"));
        newLeague.setModifiedAt(leagueData.get("modified_at"));
        newLeague.setName(leagueData.get("name"));
        newLeague.setSlug(leagueData.get("slug"));
        newLeague.setUrl(leagueData.get("url"));
        JSONArray series = leagueData.getJSONArray("series");
        List<Series> leagueSeries = new ArrayList<>();
        for(int i = 0; i < series.length(); i++) {
            org.json.JSONObject currentSeriesInfo = (org.json.JSONObject) series.get(i);
            Series currentSeries = convertToSeriesObjectSimple(currentSeriesInfo);
            leagueSeries.add(currentSeries);
        }
        newLeague.setSeries(leagueSeries);
        org.json.JSONObject videoGame = leagueData.getJSONObject("videogame");
        newLeague.setVideoGameCurrentVersion(videoGame.get("current_version"));
        newLeague.setVideoGameName(videoGame.get("name"));
        newLeague.setVideoGameSlug(videoGame.get("slug"));
        newLeague.setVideoGameID(videoGame.get("id"));
        return newLeague;
    }

    public String generateLeagueOutput(String jsonData) {
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
                leagueOutput = leagueOutput.concat("\nseries:");
                List<Series> currentSeries = currentLeague.getSeries();
                for(Series s: currentSeries) {
                    leagueOutput = (leagueOutput.concat("\n\tbegin at: ")).concat(s.getBeginAt());
                    leagueOutput = (leagueOutput.concat("\n\tdescription: ")).concat(s.getDescription());
                    leagueOutput = (leagueOutput.concat("\n\tend at: ")).concat(s.getEndAt());
                    leagueOutput = (leagueOutput.concat("\n\tfull name: ")).concat(s.getFullName());
                    leagueOutput = (leagueOutput.concat("\n\tid: ")).concat(s.getID());
                    leagueOutput = (leagueOutput.concat("\n\tleague id: ")).concat(s.getLeagueId());
                    leagueOutput = (leagueOutput.concat("\n\tmodified at: ")).concat(s.getModifiedAt());
                    leagueOutput = (leagueOutput.concat("\n\tname: ")).concat(s.getName());
                    leagueOutput = (leagueOutput.concat("\n\tseason: ")).concat(s.getSeason());
                    leagueOutput = (leagueOutput.concat("\n\tslug: ")).concat(s.getSlug());
                    leagueOutput = (leagueOutput.concat("\n\ttier: ")).concat(s.getTier());
                    leagueOutput = (leagueOutput.concat("\n\twinner id: ")).concat(s.getWinnerId());
                    leagueOutput = (leagueOutput.concat("\n\twinner type: ")).concat(s.getWinnerType());
                    leagueOutput = (leagueOutput.concat("\n\tyear: ")).concat(s.getYear());
                    leagueOutput = leagueOutput.concat("\n");
                }
                leagueOutput = leagueOutput.concat("video game:");
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

    private Series convertToSeriesObjectSimple(org.json.JSONObject seriesData) {
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
        newSeries.setWinnerId(seriesData.get("winner_id"));
        newSeries.setWinnerType(seriesData.get("winner_type"));
        newSeries.setYear(seriesData.get("year"));

        return newSeries;
    }

    public String generateSeriesOutput(String jsonData, List<Series> lastRetrievedSeries) {
        return null;
    }
}
