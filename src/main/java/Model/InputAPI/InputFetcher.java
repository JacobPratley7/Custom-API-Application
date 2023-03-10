package Model.InputAPI;

import java.io.IOException;

public interface InputFetcher {

    /**
     * Retrieves league information.
     *
     * @param authToken The user's authentication token for the input API.
     * @return String in json format representing league data.
     * @throws IOException If error is to occur whilst accessing input API.
     */
    String getLeagues(String authToken) throws IOException;

    /**
     * Retrieves series information for a particular league.
     *
     * @param authToken The user's authentication token for the input API.
     * @param leagueID The id of the league the user wants to get series information on.
     * @return String in json format representing series data.
     * @throws IOException If error is to occur whilst accessing input API.
     */
    String getSeries(String authToken, String leagueID) throws IOException;


}