package Model.InputAPI;

import Model.InputAPI.InputObjects.League;
import org.json.*;

import java.io.IOException;
import java.util.List;

public interface InputFetcher {

    String getLeagues(String authToken) throws IOException;

    String getSeries(String authToken, String leagueID) throws IOException;


}