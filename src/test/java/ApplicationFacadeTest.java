import Model.ApplicationFacade;
import Model.InputAPI.InputFetcher;
import Model.InputAPI.InputFetcherDummy;
import Model.InputAPI.InputFetcherImpl;
import Model.InputAPI.InputObjects.League;
import org.json.*;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.*;

import org.mockito.Mock;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ApplicationFacadeTest {

    @Test
    public void testGetLeagueDataOnline() throws IOException {
        InputFetcher imp = mock(InputFetcherImpl.class);
        when(imp.getLeagues(anyString())).thenReturn("[{\"id\":5678,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"series\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}],\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\",\"videogame\":{\"current_version\":null,\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"}}]");
        ApplicationFacade appFacade = new ApplicationFacade(imp, null);
        String output = appFacade.getLeagueData("test");
        assertTrue(output.contains("id: 5678"));
        assertTrue(output.contains("image url: https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png"));
        assertTrue(output.contains("modified at: 2021-05-18T07:34:18Z"));
        assertTrue(output.contains("name: Hyperion x OEL Launch"));
        assertTrue(output.contains("slug: cs-go-hyperion-x-oel-launch"));
        assertTrue(output.contains("url: "));

    }

    @Test
    public void testGetLeagueDataError() throws IOException {
        InputFetcher imp = mock(InputFetcherImpl.class);
        when(imp.getLeagues(anyString())).thenReturn("{\"error\":\"something went wrong\"}");
        ApplicationFacade appFacade = new ApplicationFacade(imp, null);
        String output = appFacade.getLeagueData("test");
        assertTrue(output.contains("error: something went wrong"));
    }

    @Test
    public void testGetLeagueDataDummy() throws IOException {
        InputFetcher imp = mock(InputFetcherDummy.class);
        when(imp.getLeagues(anyString())).thenReturn("[{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"series\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}],\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\",\"videogame\":{\"current_version\":null,\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"}}]");
        ApplicationFacade appFacade = new ApplicationFacade(imp, null);
        String output = appFacade.getLeagueData("test");
        assertTrue(output.contains("id: 4590"));
        assertTrue(output.contains("image url: https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png"));
        assertTrue(output.contains("modified at: 2021-05-18T07:34:18Z"));
        assertTrue(output.contains("name: Hyperion x OEL Launch"));
        assertTrue(output.contains("slug: cs-go-hyperion-x-oel-launch"));
        assertTrue(output.contains("url: "));
    }

//    @Test
//    public void testConvertToLeagueObject() {
//        String output = "[{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"series\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}],\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\",\"videogame\":{\"current_version\":null,\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"}}]";
//        JSONArray outputObjects = new JSONArray(output);
//        JSONObject firstObject = (JSONObject )outputObjects.get(0);
//        ApplicationFacade appFacade = new ApplicationFacade(null, null);
//        League outputLeague = appFacade.convertToLeagueObject(firstObject);
//        assertEquals("4590", outputLeague.getID());
//        assertEquals("https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png", outputLeague.getImageUrl());
//        assertEquals("2021-05-18T07:34:18Z", outputLeague.getModifiedAt());
//        assertEquals()
//
//
//    }

}
