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
        return null;
    }
}
