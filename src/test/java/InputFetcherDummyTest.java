import Model.InputAPI.InputFetcherDummy;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.*;

public class InputFetcherDummyTest {

    @Test
    public void testInputFetcherDummyGetLeagues() {
        InputFetcherDummy dummy = new InputFetcherDummy();
        String expected = "[{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"series\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}],\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\",\"videogame\":{\"current_version\":null,\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"}}]";
        assertEquals(expected, dummy.getLeagues("hello"));
    }

    @Test
    public void testInputFetcherDummyGenerateLeagueJSONObject() {
        InputFetcherDummy dummy = new InputFetcherDummy();
        assertNotNull(dummy.generateLeagueJSONObject(dummy.getLeagues("hello")));
    }

    @Test
    public void testGenerateLeagueOutputString() {
        String output = "id:4590";
        output = output.concat("\nimage_url:https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png");
        output = output.concat("\nmodified_at:2021-05-18T07:34:18Z");
        output = output.concat("\nname:Hyperion x OEL Launch");
        output = output.concat("\nslug:cs-go-hyperion-x-oel-launch");
        output = output.concat("\nurl:");
        output = output.concat("\nvideogame:");
        output = output.concat("\n\tcurrent_version:null");
        output = output.concat("\n\tid:3");
        output = output.concat("\n\tname:CS:GO");
        output = output.concat("\n\tslug:cs-go");

        InputFetcherDummy dummy = new InputFetcherDummy();
        JSONObject data = dummy.generateLeagueJSONObject(dummy.getLeagues("hello"));
        assertEquals(output, dummy.generateLeagueOutputString(data));
    }

    @Test
    public void testGetSeries() {

    }

    @Test
    public void testGenerateSeriesJSONObject() {

    }

    @Test
    public void testGenerateSeriesOutputString() {

    }
}
