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
        return null;
    }

    public String getLeagueData(String inputAuth) throws IOException {
        return null;
    }
}
