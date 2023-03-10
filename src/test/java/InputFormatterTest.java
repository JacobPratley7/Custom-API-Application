import Model.InputAPI.InputFormatter;
import Model.InputAPI.InputObjects.Series;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class InputFormatterTest {

    @Test
    public void testGenerateLeagueOutputValid() {
        InputFormatter formatter = new InputFormatter();
        String json = "[{\"id\":5678,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"series\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}],\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\",\"videogame\":{\"current_version\":null,\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"}}]";

        String output = formatter.generateLeagueOutput(json, 2021);
        assertNotNull(output);
        assertFalse(output.contains("Too New"));
        assertTrue(output.contains("id: 5678"));
        assertTrue(output.contains("image url: https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png"));
        assertTrue(output.contains("modified at: 2021-05-18T07:34:18Z"));
        assertTrue(output.contains("name: Hyperion x OEL Launch"));
        assertTrue(output.contains("slug: cs-go-hyperion-x-oel-launch"));
        assertTrue(output.contains("url: "));
        assertTrue(output.contains("current version: null"));
        assertTrue(output.contains("id: 3"));
        assertTrue(output.contains("name: CS:GO"));
        assertTrue(output.contains("slug: cs-go"));

        assertTrue(output.contains("begin at: 2021-05-19T04:00:00Z"));
        assertTrue(output.contains("description: null"));
        assertTrue(output.contains("end at: 2021-05-23T14:10:00Z"));
        assertTrue(output.contains("full name: 2021"));
        assertTrue(output.contains("id: 3621"));
        assertTrue(output.contains("league id: 4590"));
        assertTrue(output.contains("modified at: 2021-05-23T18:55:54Z"));
        assertTrue(output.contains("name: null"));
        assertTrue(output.contains("slug: cs-go-hyperion-x-oel-launch-2021"));
        assertTrue(output.contains("tier: d"));
        assertTrue(output.contains("winner id: 126439"));
        assertTrue(output.contains("winner type: Team"));
        assertTrue(output.contains("year: 2021"));
        assertTrue(output.contains("season: null"));
    }

    @Test
    public void testGenerateLeagueOutputTooNew() {
        InputFormatter formatter = new InputFormatter();
        String json = "[{\"id\":5678,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"series\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}],\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\",\"videogame\":{\"current_version\":null,\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"}}]";

        String output = formatter.generateLeagueOutput(json, 2020);
        assertNotNull(output);
        assertTrue(output.contains("Too New"));
        assertTrue(output.contains("id: 5678"));
        assertTrue(output.contains("image url: https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png"));
        assertTrue(output.contains("modified at: 2021-05-18T07:34:18Z"));
        assertTrue(output.contains("name: Hyperion x OEL Launch"));
        assertTrue(output.contains("slug: cs-go-hyperion-x-oel-launch"));
        assertTrue(output.contains("url: "));
        assertTrue(output.contains("current version: null"));
        assertTrue(output.contains("id: 3"));
        assertTrue(output.contains("name: CS:GO"));
        assertTrue(output.contains("slug: cs-go"));

        assertTrue(output.contains("begin at: 2021-05-19T04:00:00Z"));
        assertTrue(output.contains("description: null"));
        assertTrue(output.contains("end at: 2021-05-23T14:10:00Z"));
        assertTrue(output.contains("full name: 2021"));
        assertTrue(output.contains("id: 3621"));
        assertTrue(output.contains("league id: 4590"));
        assertTrue(output.contains("modified at: 2021-05-23T18:55:54Z"));
        assertTrue(output.contains("name: null"));
        assertTrue(output.contains("slug: cs-go-hyperion-x-oel-launch-2021"));
        assertTrue(output.contains("tier: d"));
        assertTrue(output.contains("winner id: 126439"));
        assertTrue(output.contains("winner type: Team"));
        assertTrue(output.contains("year: 2021"));
        assertTrue(output.contains("season: null"));
    }

    @Test
    public void testGenerateLeagueOutputError() {
        String json = "{\"error\":\"something went wrong\"}";
        InputFormatter formatter = new InputFormatter();

        String output = formatter.generateLeagueOutput(json, 2021);
        assertNotNull(output);
        assertTrue(output.contains("error: something went wrong"));
    }

    @Test
    public void testGenerateSeriesOutputValid() {
        String json = "[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league\":{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\"},\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"tournaments\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"end_at\":\"2021-05-23T14:10:00Z\",\"id\":6082,\"league_id\":4590,\"live_supported\":false,\"modified_at\":\"2021-05-24T08:29:01Z\",\"name\":\"Playoffs\",\"prizepool\":null,\"serie_id\":3621,\"slug\":\"cs-go-hyperion-x-oel-launch-2021-playoffs\",\"winner_id\":126439,\"winner_type\":\"Team\"}],\"videogame\":{\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"},\"videogame_title\":null,\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}]";
        InputFormatter formatter = new InputFormatter();

        List<Series> series = new ArrayList<>();
        String output = formatter.generateSeriesOutput(json, 2021);

        assertNotNull(output);

        assertFalse(output.contains("Too New"));
        assertTrue(output.contains("begin at: 2021-05-19T04:00:00Z"));
        assertTrue(output.contains("description: null"));
        assertTrue(output.contains("end at: 2021-05-23T14:10:00Z"));
        assertTrue(output.contains("full name: 2021"));
        assertTrue(output.contains("id: 3621"));
        assertTrue(output.contains("league id: 4590"));
        assertTrue(output.contains("modified at: 2021-05-23T18:55:54Z"));
        assertTrue(output.contains("name: null"));
        assertTrue(output.contains("season: null"));
        assertTrue(output.contains("slug: cs-go-hyperion-x-oel-launch-2021"));
        assertTrue(output.contains("tier: d"));

        assertTrue(output.contains("league:"));
        assertTrue(output.contains("id: 4590"));
        assertTrue(output.contains("image url: https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png"));
        assertTrue(output.contains("modified at: 2021-05-18T07:34:18Z"));
        assertTrue(output.contains("name: Hyperion x OEL Launch"));
        assertTrue(output.contains("slug: cs-go-hyperion-x-oel-launch"));
        assertTrue(output.contains("url: "));

        assertTrue(output.contains("tournaments:"));
        assertTrue(output.contains("begin at: 2021-05-19T04:00:00Z"));
        assertTrue(output.contains("end at: 2021-05-23T14:10:00Z"));
        assertTrue(output.contains("id: 6082"));
        assertTrue(output.contains("league id: 4590"));
        assertTrue(output.contains("live supported: false"));
        assertTrue(output.contains("modified at: 2021-05-24T08:29:01Z"));
        assertTrue(output.contains("name: Playoffs"));
        assertTrue(output.contains("prize pool: null"));
        assertTrue(output.contains("serie id: 3621"));
        assertTrue(output.contains("slug: cs-go-hyperion-x-oel-launch-2021-playoffs"));
        assertTrue(output.contains("winner id: 126439"));
        assertTrue(output.contains("winner type: Team"));

        assertTrue(output.contains("video game:"));
        assertTrue(output.contains("id: 3"));
        assertTrue(output.contains("name: CS:GO"));
        assertTrue(output.contains("slug: cs-go"));

        assertTrue(output.contains("videogame title: null"));
        assertTrue(output.contains("winner id: 126439"));
        assertTrue(output.contains("winner type: Team"));
        assertTrue(output.contains("year: 2021"));
        assertTrue(output.contains("begin at: 2021-05-19T04:00:00Z"));
    }

    @Test
    public void testGenerateSeriesOutputTooNew() {
        String json = "[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league\":{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\"},\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"tournaments\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"end_at\":\"2021-05-23T14:10:00Z\",\"id\":6082,\"league_id\":4590,\"live_supported\":false,\"modified_at\":\"2021-05-24T08:29:01Z\",\"name\":\"Playoffs\",\"prizepool\":null,\"serie_id\":3621,\"slug\":\"cs-go-hyperion-x-oel-launch-2021-playoffs\",\"winner_id\":126439,\"winner_type\":\"Team\"}],\"videogame\":{\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"},\"videogame_title\":null,\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}]";
        InputFormatter formatter = new InputFormatter();

        List<Series> series = new ArrayList<>();
        String output = formatter.generateSeriesOutput(json, 2020);

        assertNotNull(output);

        assertTrue(output.contains("begin at: 2021-05-19T04:00:00Z"));
        assertTrue(output.contains("description: null"));
        assertTrue(output.contains("end at: 2021-05-23T14:10:00Z"));
        assertTrue(output.contains("full name: 2021"));
        assertTrue(output.contains("id: 3621"));
        assertTrue(output.contains("league id: 4590"));
        assertTrue(output.contains("modified at: 2021-05-23T18:55:54Z"));
        assertTrue(output.contains("name: null"));
        assertTrue(output.contains("season: null"));
        assertTrue(output.contains("slug: cs-go-hyperion-x-oel-launch-2021"));
        assertTrue(output.contains("tier: d"));


        assertTrue(output.contains("league:"));
        assertTrue(output.contains("Too New"));
        assertTrue(output.contains("id: 4590"));
        assertTrue(output.contains("image url: https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png"));
        assertTrue(output.contains("modified at: 2021-05-18T07:34:18Z"));
        assertTrue(output.contains("name: Hyperion x OEL Launch"));
        assertTrue(output.contains("slug: cs-go-hyperion-x-oel-launch"));
        assertTrue(output.contains("url: "));

        assertTrue(output.contains("tournaments:"));
        assertTrue(output.contains("begin at: 2021-05-19T04:00:00Z"));
        assertTrue(output.contains("end at: 2021-05-23T14:10:00Z"));
        assertTrue(output.contains("id: 6082"));
        assertTrue(output.contains("league id: 4590"));
        assertTrue(output.contains("live supported: false"));
        assertTrue(output.contains("modified at: 2021-05-24T08:29:01Z"));
        assertTrue(output.contains("name: Playoffs"));
        assertTrue(output.contains("prize pool: null"));
        assertTrue(output.contains("serie id: 3621"));
        assertTrue(output.contains("slug: cs-go-hyperion-x-oel-launch-2021-playoffs"));
        assertTrue(output.contains("winner id: 126439"));
        assertTrue(output.contains("winner type: Team"));

        assertTrue(output.contains("video game:"));
        assertTrue(output.contains("id: 3"));
        assertTrue(output.contains("name: CS:GO"));
        assertTrue(output.contains("slug: cs-go"));

        assertTrue(output.contains("videogame title: null"));
        assertTrue(output.contains("winner id: 126439"));
        assertTrue(output.contains("winner type: Team"));
        assertTrue(output.contains("year: 2021"));
        assertTrue(output.contains("begin at: 2021-05-19T04:00:00Z"));
    }

    @Test
    public void testGenerateSeriesOutputError() {
        String json = "{\"error\":\"something went wrong\"}";
        InputFormatter formatter = new InputFormatter();

        List<Series> series = new ArrayList<>();
        String output = formatter.generateSeriesOutput(json, 2021);

        assertNotNull(output);

        assertTrue(output.contains("error: something went wrong"));
    }

    @Test
    public void testGenerateSeriesList() {
        String json = "[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league\":{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\"},\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"tournaments\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"end_at\":\"2021-05-23T14:10:00Z\",\"id\":6082,\"league_id\":4590,\"live_supported\":false,\"modified_at\":\"2021-05-24T08:29:01Z\",\"name\":\"Playoffs\",\"prizepool\":null,\"serie_id\":3621,\"slug\":\"cs-go-hyperion-x-oel-launch-2021-playoffs\",\"winner_id\":126439,\"winner_type\":\"Team\"}],\"videogame\":{\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"},\"videogame_title\":null,\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}]";
        InputFormatter formatter = new InputFormatter();
        assertEquals(1, formatter.generateSeriesList(json, 2021).size());
    }
}
