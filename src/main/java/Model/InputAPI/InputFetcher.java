package Model.InputAPI;

import Model.InputAPI.InputObjects.League;
import org.json.*;

import java.util.List;

public interface InputFetcher {

    String getLeagues(String authToken);

    JSONObject generateLeagueJSONObject(String jsonData);

    String generateLeagueOutputString(JSONObject jsonObject);

    String getSeries(String authToken, String leagueID);

    JSONObject generateSeriesJSONObject(String jsonData);

    String generateSeriesOutputString(JSONObject jsonObject);

}