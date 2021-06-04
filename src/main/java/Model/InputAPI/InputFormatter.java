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

        org.json.JSONObject newLeagueData = seriesData.getJSONObject("league");
        League newLeague = convertToLeagueObjectSimple(newLeagueData);
        newSeries.setLeague(newLeague);

        newSeries.setVideoGameTitle(seriesData.get("videogame_title"));
        newSeries.setWinnerId(seriesData.get("winner_id"));
        newSeries.setWinnerType(seriesData.get("winner_type"));
        newSeries.setYear(seriesData.get("year"));
        org.json.JSONObject videoGame = seriesData.getJSONObject("videogame");
        newSeries.setVideoGameID(videoGame.get("id"));
        newSeries.setVideoGameName(videoGame.get("name"));
        newSeries.setVideoGameSlug(videoGame.get("slug"));
        JSONArray tournaments = seriesData.getJSONArray("tournaments");
        newSeries.setTournaments(generateTournamentList(tournaments));
        return newSeries;
    }

    private List<Tournament> generateTournamentList(JSONArray tournaments) {
        List<Tournament> newList = new ArrayList<>();
        for(int i = 0; i < tournaments.length(); i++) {
            org.json.JSONObject currentTournament = (org.json.JSONObject) tournaments.get(i);
            newList.add(convertToTournamentObject(currentTournament));
        }

        return newList;
    }

    private Tournament convertToTournamentObject(org.json.JSONObject tournamentData) {
        Tournament newTournament = new Tournament();
        newTournament.setBeginAt(tournamentData.get("begin_at"));
        newTournament.setEndAt(tournamentData.get("end_at"));
        newTournament.setID(tournamentData.get("id"));
        newTournament.setLeagueID(tournamentData.get("league_id"));
        newTournament.setLiveSupported(tournamentData.get("live_supported"));
        newTournament.setName(tournamentData.get("name"));
        newTournament.setPrizePool(tournamentData.get("prizepool"));
        newTournament.setSeriesID(tournamentData.get("serie_id"));
        newTournament.setSlug(tournamentData.get("slug"));
        newTournament.setWinnerID(tournamentData.get("winner_id"));
        newTournament.setWinnerType(tournamentData.get("winner_type"));
        newTournament.setModifiedAt(tournamentData.get("modified_at"));
        return newTournament;
    }

    public String generateSeriesOutput(String jsonData, List<Series> lastRetrievedSeries) {
        if(jsonData.contains("error")) {
            lastRetrievedSeries = null;
            org.json.JSONObject errorMessage = new org.json.JSONObject(jsonData);
            String output = "error: ".concat(errorMessage.getString("error"));
            return output;
        } else {
            lastRetrievedSeries = new ArrayList<>();
            JSONArray seriesData = new JSONArray(jsonData);
            String seriesOutput = "";
            for(int i = 0; i < seriesData.length(); i++) {
                org.json.JSONObject current = (org.json.JSONObject) seriesData.get(i);
                Series currentSeries = convertToSeriesObject(current);
                lastRetrievedSeries.add(currentSeries);
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
                seriesOutput = seriesOutput.concat("\nleague: ");
                seriesOutput = (seriesOutput.concat("\n\tid: ")).concat(currentSeries.getLeague().getID());
                seriesOutput = (seriesOutput.concat("\n\timage url: ")).concat(currentSeries.getLeague().getImageUrl());
                seriesOutput = (seriesOutput.concat("\n\tmodified at: ")).concat(currentSeries.getLeague().getModifiedAt());
                seriesOutput = (seriesOutput.concat("\n\tname: ")).concat(currentSeries.getLeague().getName());
                seriesOutput = (seriesOutput.concat("\n\tslug: ")).concat(currentSeries.getLeague().getSlug());
                seriesOutput = (seriesOutput.concat("\n\turl: ")).concat(currentSeries.getLeague().getUrl());

                seriesOutput = seriesOutput.concat("\ntournaments:");
                List<Tournament> currentTournaments = currentSeries.getTournaments();
                for(Tournament t: currentTournaments) {
                    seriesOutput = seriesOutput.concat("\n\tbegin at: ").concat(t.getBeginAt());
                    seriesOutput = seriesOutput.concat("\n\tend at: ").concat(t.getEndAt());
                    seriesOutput = seriesOutput.concat("\n\tid: ").concat(t.getID());
                    seriesOutput = seriesOutput.concat("\n\tleague id: ").concat(t.getLeagueID());
                    seriesOutput = seriesOutput.concat("\n\tlive supported: ").concat(t.getLiveSupported());
                    seriesOutput = seriesOutput.concat("\n\tmodified at: ").concat(t.getModifiedAt());
                    seriesOutput = seriesOutput.concat("\n\tname: ").concat(t.getName());
                    seriesOutput = seriesOutput.concat("\n\tprize pool: ").concat(t.getPrizePool());
                    seriesOutput = seriesOutput.concat("\n\tserie id: ").concat(t.getSeriesID());
                    seriesOutput = seriesOutput.concat("\n\tslug: ").concat(t.getSlug());
                    seriesOutput = seriesOutput.concat("\n\twinner id: ").concat(t.getWinnerID());
                    seriesOutput = seriesOutput.concat("\n\twinner type: ").concat(t.getWinnerType());
                    seriesOutput = seriesOutput.concat("\n");
                }
                seriesOutput = seriesOutput.concat("video game:");
                seriesOutput = seriesOutput.concat("\n\tid: ").concat(currentSeries.getVideoGameID());
                seriesOutput = seriesOutput.concat("\n\tname: ").concat(currentSeries.getVideoGameName());
                seriesOutput = seriesOutput.concat("\n\tslug: ").concat(currentSeries.getVideoGameSlug());
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
