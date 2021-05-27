package Model.InputAPI;

//import org.json.simple.JSONObject;
import org.json.*;

public class InputFetcherDummy implements InputFetcher {

    public String getLeagues(String authToken) {
        String returnValue = "[{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"series\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}],\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\",\"videogame\":{\"current_version\":null,\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"}}]";
        return returnValue;
    }

    public String getSeries(String authToken, String leagueID) {
        String returnValue = "[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league\":{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\"},\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"tournaments\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"end_at\":\"2021-05-23T14:10:00Z\",\"id\":6082,\"league_id\":4590,\"live_supported\":false,\"modified_at\":\"2021-05-24T08:29:01Z\",\"name\":\"Playoffs\",\"prizepool\":null,\"serie_id\":3621,\"slug\":\"cs-go-hyperion-x-oel-launch-2021-playoffs\",\"winner_id\":126439,\"winner_type\":\"Team\"}],\"videogame\":{\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"},\"videogame_title\":null,\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}]";
        return returnValue;
    }



}
