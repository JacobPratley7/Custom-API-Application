import Model.ApplicationFacade;
import Model.Database.DataBaseManager;
import Model.InputAPI.InputFetcher;
import Model.InputAPI.InputFetcherDummy;
import Model.InputAPI.InputFetcherImpl;
import Model.OutputAPI.ReportSender;
import Model.OutputAPI.ReportSenderImpl;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class ApplicationFacadeTest {

    @Test
    public void testGetLeagueDataOnline() throws IOException {
        InputFetcher imp = mock(InputFetcherImpl.class);
        when(imp.getLeagues(anyString())).thenReturn("[{\"id\":5678,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"series\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}],\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\",\"videogame\":{\"current_version\":null,\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"}}]");
        DataBaseManager db = mock(DataBaseManager.class);
        when(db.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(db.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(db.insertData(anyString())).thenReturn("Data successfully inserted");
        when(db.updateData(anyString())).thenReturn("Data successfully updated");

        ApplicationFacade appFacade = new ApplicationFacade(imp, null, db);
        String output = appFacade.getLeagueData(false);
        assertTrue(output.contains("id: 5678"));
        assertTrue(output.contains("image url: https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png"));
        assertTrue(output.contains("modified at: 2021-05-18T07:34:18Z"));
        assertTrue(output.contains("name: Hyperion x OEL Launch"));
        assertTrue(output.contains("slug: cs-go-hyperion-x-oel-launch"));
        assertTrue(output.contains("url: "));

    }

    @Test
    public void testGetLeagueDataOnlineUpdated() throws IOException {
        InputFetcher imp = mock(InputFetcherImpl.class);
        when(imp.getLeagues(anyString())).thenReturn("[{\"id\":5678,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"series\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}],\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\",\"videogame\":{\"current_version\":null,\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"}}]");

        DataBaseManager db = mock(DataBaseManager.class);
        when(db.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(db.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(db.insertData(anyString())).thenReturn("Data successfully inserted");
        when(db.updateData(anyString())).thenReturn("Data successfully updated");

        ApplicationFacade appFacade = new ApplicationFacade(imp, null, db);
        String output = appFacade.getLeagueData(false);
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
    public void testGetLeagueDataError() throws IOException {
        InputFetcher imp = mock(InputFetcherImpl.class);
        when(imp.getLeagues(anyString())).thenReturn("{\"error\":\"something went wrong\"}");
        DataBaseManager db = mock(DataBaseManager.class);
        when(db.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(db.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(db.insertData(anyString())).thenReturn("Data successfully inserted");
        when(db.updateData(anyString())).thenReturn("Data successfully updated");

        ApplicationFacade appFacade = new ApplicationFacade(imp, null, db);
        String output = appFacade.getLeagueData(false);
        assertTrue(output.contains("error: something went wrong"));
    }

    @Test
    public void testGetLeagueDataDummyUpdated() throws IOException {
        InputFetcher imp = mock(InputFetcherDummy.class);
        when(imp.getLeagues(anyString())).thenReturn("[{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"series\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}],\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\",\"videogame\":{\"current_version\":null,\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"}}]");
        DataBaseManager db = mock(DataBaseManager.class);
        when(db.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(db.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(db.insertData(anyString())).thenReturn("Data successfully inserted");
        when(db.updateData(anyString())).thenReturn("Data successfully updated");

        ApplicationFacade appFacade = new ApplicationFacade(imp, null, db);
        String output = appFacade.getLeagueData(false);
        assertTrue(output.contains("id: 4590"));
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
    public void testGetLeagueDataDummy() throws IOException {
        InputFetcher imp = mock(InputFetcherDummy.class);
        when(imp.getLeagues(anyString())).thenReturn("[{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"series\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}],\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\",\"videogame\":{\"current_version\":null,\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"}}]");
        DataBaseManager db = mock(DataBaseManager.class);
        when(db.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(db.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(db.insertData(anyString())).thenReturn("Data successfully inserted");
        when(db.updateData(anyString())).thenReturn("Data successfully updated");

        ApplicationFacade appFacade = new ApplicationFacade(imp, null, db);
        String output = appFacade.getLeagueData(false);
        assertTrue(output.contains("id: 4590"));
        assertTrue(output.contains("image url: https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png"));
        assertTrue(output.contains("modified at: 2021-05-18T07:34:18Z"));
        assertTrue(output.contains("name: Hyperion x OEL Launch"));
        assertTrue(output.contains("slug: cs-go-hyperion-x-oel-launch"));
        assertTrue(output.contains("url: "));
    }

    @Test
    public void testGetSeriesDataOnline() throws IOException {
        InputFetcher imp = mock(InputFetcherImpl.class);
        when(imp.getSeries(anyString(), anyString())).thenReturn("[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league\":{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\"},\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"tournaments\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"end_at\":\"2021-05-23T14:10:00Z\",\"id\":6082,\"league_id\":4590,\"live_supported\":false,\"modified_at\":\"2021-05-24T08:29:01Z\",\"name\":\"Playoffs\",\"prizepool\":null,\"serie_id\":3621,\"slug\":\"cs-go-hyperion-x-oel-launch-2021-playoffs\",\"winner_id\":126439,\"winner_type\":\"Team\"}],\"videogame\":{\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"},\"videogame_title\":null,\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}]");
        DataBaseManager db = mock(DataBaseManager.class);
        when(db.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(db.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(db.insertData(anyString())).thenReturn("Data successfully inserted");
        when(db.updateData(anyString())).thenReturn("Data successfully updated");

        ApplicationFacade appFacade = new ApplicationFacade(imp, null, db);
        String output = appFacade.getSeriesData("randomSlug");
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
        assertTrue(output.contains("videogame title: null"));
        assertTrue(output.contains("winner id: 126439"));
        assertTrue(output.contains("winner type: Team"));
        assertTrue(output.contains("year: 2021"));
    }

    @Test
    public void testGetSeriesDataOnlineUpdated() throws IOException {
        InputFetcher imp = mock(InputFetcherImpl.class);
        when(imp.getSeries(anyString(), anyString())).thenReturn("[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league\":{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\"},\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"tournaments\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"end_at\":\"2021-05-23T14:10:00Z\",\"id\":6082,\"league_id\":4590,\"live_supported\":false,\"modified_at\":\"2021-05-24T08:29:01Z\",\"name\":\"Playoffs\",\"prizepool\":null,\"serie_id\":3621,\"slug\":\"cs-go-hyperion-x-oel-launch-2021-playoffs\",\"winner_id\":126439,\"winner_type\":\"Team\"}],\"videogame\":{\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"},\"videogame_title\":null,\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}]");
        DataBaseManager db = mock(DataBaseManager.class);
        when(db.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(db.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(db.insertData(anyString())).thenReturn("Data successfully inserted");

        ApplicationFacade appFacade = new ApplicationFacade(imp, null, db);
        String output = appFacade.getSeriesData("randomSlug");
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
    public void testGetSeriesDataError() throws IOException {
        InputFetcher imp = mock(InputFetcherImpl.class);
        when(imp.getSeries(anyString(), anyString())).thenReturn("{\"error\":\"something went wrong\"}");
        DataBaseManager db = mock(DataBaseManager.class);
        when(db.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(db.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(db.insertData(anyString())).thenReturn("Data successfully inserted");

        ApplicationFacade appFacade = new ApplicationFacade(imp, null, db);
        String output = appFacade.getSeriesData("test");
        assertTrue(output.contains("error: something went wrong"));
    }

    @Test
    public void testGetSeriesDataDummy() throws IOException {
        InputFetcher imp = mock(InputFetcherDummy.class);
        when(imp.getSeries(anyString(), anyString())).thenReturn("[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league\":{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\"},\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"tournaments\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"end_at\":\"2021-05-23T14:10:00Z\",\"id\":6082,\"league_id\":4590,\"live_supported\":false,\"modified_at\":\"2021-05-24T08:29:01Z\",\"name\":\"Playoffs\",\"prizepool\":null,\"serie_id\":3621,\"slug\":\"cs-go-hyperion-x-oel-launch-2021-playoffs\",\"winner_id\":126439,\"winner_type\":\"Team\"}],\"videogame\":{\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"},\"videogame_title\":null,\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}]");
        DataBaseManager db = mock(DataBaseManager.class);
        when(db.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(db.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(db.insertData(anyString())).thenReturn("Data successfully inserted");

        ApplicationFacade appFacade = new ApplicationFacade(imp, null, db);
        String output = appFacade.getSeriesData( "randomSlug");
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
        assertTrue(output.contains("videogame title: null"));
        assertTrue(output.contains("winner id: 126439"));
        assertTrue(output.contains("winner type: Team"));
        assertTrue(output.contains("year: 2021"));
    }

    @Test
    public void testGetSeriesDataDummyUpdated() throws IOException {
        InputFetcher imp = mock(InputFetcherDummy.class);
        when(imp.getSeries(anyString(), anyString())).thenReturn("[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league\":{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\"},\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"tournaments\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"end_at\":\"2021-05-23T14:10:00Z\",\"id\":6082,\"league_id\":4590,\"live_supported\":false,\"modified_at\":\"2021-05-24T08:29:01Z\",\"name\":\"Playoffs\",\"prizepool\":null,\"serie_id\":3621,\"slug\":\"cs-go-hyperion-x-oel-launch-2021-playoffs\",\"winner_id\":126439,\"winner_type\":\"Team\"}],\"videogame\":{\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"},\"videogame_title\":null,\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}]");
        DataBaseManager db = mock(DataBaseManager.class);
        when(db.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(db.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(db.insertData(anyString())).thenReturn("Data successfully inserted");

        ApplicationFacade appFacade = new ApplicationFacade(imp, null, db);
        String output = appFacade.getSeriesData("randomSlug");
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
    public void testSendReportOnline() throws IOException {
        InputFetcher imp = mock(InputFetcherImpl.class);
        when(imp.getSeries(anyString(), anyString())).thenReturn("[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league\":{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\"},\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"tournaments\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"end_at\":\"2021-05-23T14:10:00Z\",\"id\":6082,\"league_id\":4590,\"live_supported\":false,\"modified_at\":\"2021-05-24T08:29:01Z\",\"name\":\"Playoffs\",\"prizepool\":null,\"serie_id\":3621,\"slug\":\"cs-go-hyperion-x-oel-launch-2021-playoffs\",\"winner_id\":126439,\"winner_type\":\"Team\"}],\"videogame\":{\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"},\"videogame_title\":null,\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}]");
        ReportSender rep = mock(ReportSenderImpl.class);
        when(rep.sendMessage(anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn("{\"sid\": \"dummySID\", \"date_created\": \"Sun, 30 May 2021 01:29:42 +0000\", \"date_updated\": \"Sun, 30 May 2021 01:29:42 +0000\", \"date_sent\": null, \"account_sid\": \"dummy\", \"to\": \"random number\", \"from\": \"random number\", \"messaging_service_sid\": null, \"body\": \"report data\", \"status\": \"queued\", \"num_segments\": \"1\", \"num_media\": \"0\", \"direction\": \"outbound-api\", \"api_version\": \"2010-04-01\", \"price\": null, \"price_unit\": \"USD\", \"error_code\": null, \"error_message\": null, \"uri\": \"/2010-04-01/Accounts/dummyAccount/Messages/dummySID.json\", \"subresource_uris\": {\"media\": \"/2010-04-01/Accounts/dummyAccount/Messages/dummySID/Media.json\"}}\n");
        DataBaseManager db = mock(DataBaseManager.class);
        when(db.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(db.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(db.insertData(anyString())).thenReturn("Data successfully inserted");

        ApplicationFacade appFacade = new ApplicationFacade(imp, rep, db);
        appFacade.getSeriesData( "test");
        String output = appFacade.sendReport();
        assertTrue(output.contains("Message sent Successfully!"));
    }

    @Test
    public void testSendReportDummy() throws IOException {
        InputFetcher imp = mock(InputFetcherImpl.class);
        when(imp.getSeries(anyString(), anyString())).thenReturn("[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league\":{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\"},\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"tournaments\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"end_at\":\"2021-05-23T14:10:00Z\",\"id\":6082,\"league_id\":4590,\"live_supported\":false,\"modified_at\":\"2021-05-24T08:29:01Z\",\"name\":\"Playoffs\",\"prizepool\":null,\"serie_id\":3621,\"slug\":\"cs-go-hyperion-x-oel-launch-2021-playoffs\",\"winner_id\":126439,\"winner_type\":\"Team\"}],\"videogame\":{\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"},\"videogame_title\":null,\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}]");
        ReportSender rep = mock(ReportSenderImpl.class);
        when(rep.sendMessage(anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn("{\"sid\": \"dummySID\", \"date_created\": \"Sun, 30 May 2021 01:29:42 +0000\", \"date_updated\": \"Sun, 30 May 2021 01:29:42 +0000\", \"date_sent\": null, \"account_sid\": \"dummy\", \"to\": \"random number\", \"from\": \"random number\", \"messaging_service_sid\": null, \"body\": \"report data\", \"status\": \"queued\", \"num_segments\": \"1\", \"num_media\": \"0\", \"direction\": \"outbound-api\", \"api_version\": \"2010-04-01\", \"price\": null, \"price_unit\": \"USD\", \"error_code\": null, \"error_message\": null, \"uri\": \"/2010-04-01/Accounts/dummyAccount/Messages/dummySID.json\", \"subresource_uris\": {\"media\": \"/2010-04-01/Accounts/dummyAccount/Messages/dummySID/Media.json\"}}\n");
        DataBaseManager db = mock(DataBaseManager.class);
        when(db.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(db.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(db.insertData(anyString())).thenReturn("Data successfully inserted");

        ApplicationFacade appFacade = new ApplicationFacade(imp, rep, db);
        appFacade.getSeriesData( "test");
        String output = appFacade.sendReport();
        assertTrue(output.contains("Message sent Successfully"));
    }

    @Test
    public void testSendReportNothingToReport() throws IOException {
        InputFetcher imp = mock(InputFetcherImpl.class);
        when(imp.getSeries(anyString(), anyString())).thenReturn("{\"error\":\"something went wrong\"}");
        ReportSender repSender = mock(ReportSenderImpl.class);
        when(repSender.sendMessage(anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn("{\"message\":\"this shouldnt be seen\"}");
        DataBaseManager db = mock(DataBaseManager.class);
        when(db.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(db.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(db.insertData(anyString())).thenReturn("Data successfully inserted");

        ApplicationFacade appFacade = new ApplicationFacade(imp, repSender, db);
        appFacade.getSeriesData("test");
        String output = appFacade.sendReport();
        assertTrue(output.contains("Message sent Successfully"));
        assertTrue(output.contains("No data to report"));
    }

    @Test
    public void testSendReportError() throws IOException {
        InputFetcher imp = mock(InputFetcherImpl.class);
        when(imp.getSeries(anyString(), anyString())).thenReturn("[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league\":{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\"},\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"tournaments\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"end_at\":\"2021-05-23T14:10:00Z\",\"id\":6082,\"league_id\":4590,\"live_supported\":false,\"modified_at\":\"2021-05-24T08:29:01Z\",\"name\":\"Playoffs\",\"prizepool\":null,\"serie_id\":3621,\"slug\":\"cs-go-hyperion-x-oel-launch-2021-playoffs\",\"winner_id\":126439,\"winner_type\":\"Team\"}],\"videogame\":{\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"},\"videogame_title\":null,\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}]");
        ReportSender repSender = mock(ReportSenderImpl.class);
        when(repSender.sendMessage(anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn("{\"code\": 20404, \"message\": \"The requested resource /2010-04-01/Accounts/test/Messages.json was not found\", \"more_info\": \"https://www.twilio.com/docs/errors/20404\", \"status\": 404}");
        DataBaseManager db = mock(DataBaseManager.class);
        when(db.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(db.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(db.insertData(anyString())).thenReturn("Data successfully inserted");

        ApplicationFacade appFacade = new ApplicationFacade(imp, repSender, db);
        appFacade.getSeriesData("test");
        String output = appFacade.sendReport();
        assertTrue(output.contains("Something went wrong."));
        assertTrue(output.contains("code: 20404"));
        assertTrue(output.contains("message: The requested resource /2010-04-01/Accounts/test/Messages.json was not found"));
        assertTrue(output.contains("more info: https://www.twilio.com/docs/errors/20404"));
    }

    @Test
    public void testGetSeriesDataInputNull() throws IOException {
        InputFetcher imp = mock(InputFetcherImpl.class);
        when(imp.getSeries(anyString(), anyString())).thenReturn("[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league\":{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\"},\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"tournaments\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"end_at\":\"2021-05-23T14:10:00Z\",\"id\":6082,\"league_id\":4590,\"live_supported\":false,\"modified_at\":\"2021-05-24T08:29:01Z\",\"name\":\"Playoffs\",\"prizepool\":null,\"serie_id\":3621,\"slug\":\"cs-go-hyperion-x-oel-launch-2021-playoffs\",\"winner_id\":126439,\"winner_type\":\"Team\"}],\"videogame\":{\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"},\"videogame_title\":null,\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}]");
        ReportSender repSender = mock(ReportSenderImpl.class);
        when(repSender.sendMessage(anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn("{\"code\": 20404, \"message\": \"The requested resource /2010-04-01/Accounts/test/Messages.json was not found\", \"more_info\": \"https://www.twilio.com/docs/errors/20404\", \"status\": 404}");
        DataBaseManager db = mock(DataBaseManager.class);
        when(db.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(db.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(db.insertData(anyString())).thenReturn("Data successfully inserted");

        ApplicationFacade appFacade = new ApplicationFacade(imp, repSender, db);
        String output = appFacade.getSeriesData(null);
        assertTrue(output.contains("error: please provide a valid id or slug"));
    }

    @Test
    public void testGetSeriesDataInputEmpty() throws IOException {
        InputFetcher imp = mock(InputFetcherImpl.class);
        when(imp.getSeries(anyString(), anyString())).thenReturn("[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league\":{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\"},\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"tournaments\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"end_at\":\"2021-05-23T14:10:00Z\",\"id\":6082,\"league_id\":4590,\"live_supported\":false,\"modified_at\":\"2021-05-24T08:29:01Z\",\"name\":\"Playoffs\",\"prizepool\":null,\"serie_id\":3621,\"slug\":\"cs-go-hyperion-x-oel-launch-2021-playoffs\",\"winner_id\":126439,\"winner_type\":\"Team\"}],\"videogame\":{\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"},\"videogame_title\":null,\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}]");
        ReportSender repSender = mock(ReportSenderImpl.class);
        when(repSender.sendMessage(anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn("{\"code\": 20404, \"message\": \"The requested resource /2010-04-01/Accounts/test/Messages.json was not found\", \"more_info\": \"https://www.twilio.com/docs/errors/20404\", \"status\": 404}");
        DataBaseManager db = mock(DataBaseManager.class);
        when(db.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(db.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(db.insertData(anyString())).thenReturn("Data successfully inserted");

        ApplicationFacade appFacade = new ApplicationFacade(imp, repSender, db);
        String output = appFacade.getSeriesData("");
        assertTrue(output.contains("error: please provide a valid id or slug"));
    }

    @Test
    public void testGetSeriesDataInputNonASCII() throws IOException {
        InputFetcher imp = mock(InputFetcherImpl.class);
        when(imp.getSeries(anyString(), anyString())).thenReturn("[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league\":{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\"},\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"tournaments\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"end_at\":\"2021-05-23T14:10:00Z\",\"id\":6082,\"league_id\":4590,\"live_supported\":false,\"modified_at\":\"2021-05-24T08:29:01Z\",\"name\":\"Playoffs\",\"prizepool\":null,\"serie_id\":3621,\"slug\":\"cs-go-hyperion-x-oel-launch-2021-playoffs\",\"winner_id\":126439,\"winner_type\":\"Team\"}],\"videogame\":{\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"},\"videogame_title\":null,\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}]");
        ReportSender repSender = mock(ReportSenderImpl.class);
        when(repSender.sendMessage(anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn("{\"code\": 20404, \"message\": \"The requested resource /2010-04-01/Accounts/test/Messages.json was not found\", \"more_info\": \"https://www.twilio.com/docs/errors/20404\", \"status\": 404}");
        DataBaseManager db = mock(DataBaseManager.class);
        when(db.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(db.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(db.insertData(anyString())).thenReturn("Data successfully inserted");

        ApplicationFacade appFacade = new ApplicationFacade(imp, repSender, db);
        String output = appFacade.getSeriesData("®");
        assertTrue(output.contains("error: please provide a valid id or slug"));
    }

    @Test
    public void testGetLeagueDataCachedDataValid() throws IOException {
        InputFetcher imp = mock(InputFetcherImpl.class);
        when(imp.getLeagues(anyString())).thenReturn("[{\"id\":5678,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"series\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}],\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\",\"videogame\":{\"current_version\":null,\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"}}]");

        when(imp.getSeries(anyString(), anyString())).thenReturn("[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league\":{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\"},\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"tournaments\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"end_at\":\"2021-05-23T14:10:00Z\",\"id\":6082,\"league_id\":4590,\"live_supported\":false,\"modified_at\":\"2021-05-24T08:29:01Z\",\"name\":\"Playoffs\",\"prizepool\":null,\"serie_id\":3621,\"slug\":\"cs-go-hyperion-x-oel-launch-2021-playoffs\",\"winner_id\":126439,\"winner_type\":\"Team\"}],\"videogame\":{\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"},\"videogame_title\":null,\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}]");
        ReportSender repSender = mock(ReportSenderImpl.class);
        when(repSender.sendMessage(anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn("{\"code\": 20404, \"message\": \"The requested resource /2010-04-01/Accounts/test/Messages.json was not found\", \"more_info\": \"https://www.twilio.com/docs/errors/20404\", \"status\": 404}");
        DataBaseManager dbManager = mock(DataBaseManager.class);
        when(dbManager.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(dbManager.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(dbManager.insertData(anyString())).thenReturn("Data successfully inserted");
        when(dbManager.retrieveData()).thenReturn("{\"error\":\"no cached data available\"}");
        ApplicationFacade appFacade = new ApplicationFacade(imp, repSender, dbManager);
        String output = appFacade.getLeagueData(true);
        assertTrue(output.contains("error: no cached data available"));
        when(dbManager.updateData(anyString())).thenReturn("Data successfully updated");
        appFacade.getLeagueData(false);
        when(dbManager.retrieveData()).thenReturn("[{\"id\":5678,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"series\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}],\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\",\"videogame\":{\"current_version\":null,\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"}}]");
        String nextOutput = appFacade.getLeagueData(true);
        assertTrue(nextOutput.contains("id: 5678"));
        assertTrue(nextOutput.contains("image url: https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png"));
        assertTrue(nextOutput.contains("modified at: 2021-05-18T07:34:18Z"));
        assertTrue(nextOutput.contains("name: Hyperion x OEL Launch"));
        assertTrue(nextOutput.contains("slug: cs-go-hyperion-x-oel-launch"));
        assertTrue(nextOutput.contains("url: "));
//        verify(dbManager, times(1)).deleteTable();
//        verify(dbManager, times(1)).createTable();
//        verify(dbManager, times(1)).insertData(anyString());
        verify(dbManager, times(1)).updateData(anyString());
        verify(dbManager, times(2)).retrieveData();

    }

    @Test
    public void testSetYearValid() {
        DataBaseManager dbManager = mock(DataBaseManager.class);
        when(dbManager.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(dbManager.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(dbManager.insertData(anyString())).thenReturn("Data successfully inserted");
        when(dbManager.retrieveData()).thenReturn("{\"error\":\"no cached data available\"}");
        ApplicationFacade appFacade = new ApplicationFacade(null, null, dbManager);
        assertEquals("Success", appFacade.setYear("2000"));
    }

    @Test
    public void testSetYearEdgeOne() {
        DataBaseManager dbManager = mock(DataBaseManager.class);
        when(dbManager.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(dbManager.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(dbManager.insertData(anyString())).thenReturn("Data successfully inserted");
        when(dbManager.retrieveData()).thenReturn("{\"error\":\"no cached data available\"}");
        ApplicationFacade appFacade = new ApplicationFacade(null, null, dbManager);
        assertEquals("Success", appFacade.setYear("1900"));
    }

    @Test
    public void testSetYearEdgeTwo() {
        DataBaseManager dbManager = mock(DataBaseManager.class);
        when(dbManager.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(dbManager.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(dbManager.insertData(anyString())).thenReturn("Data successfully inserted");
        when(dbManager.retrieveData()).thenReturn("{\"error\":\"no cached data available\"}");
        ApplicationFacade appFacade = new ApplicationFacade(null, null, dbManager);
        assertEquals("Success", appFacade.setYear("2021"));
    }

    @Test
    public void testSetYearTooSmall() {
        DataBaseManager dbManager = mock(DataBaseManager.class);
        when(dbManager.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(dbManager.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(dbManager.insertData(anyString())).thenReturn("Data successfully inserted");
        when(dbManager.retrieveData()).thenReturn("{\"error\":\"no cached data available\"}");
        ApplicationFacade appFacade = new ApplicationFacade(null, null, dbManager);
        assertEquals("Please enter a valid year", appFacade.setYear("1899"));
    }

    @Test
    public void testSetYearTooLarge() {
        DataBaseManager dbManager = mock(DataBaseManager.class);
        when(dbManager.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(dbManager.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(dbManager.insertData(anyString())).thenReturn("Data successfully inserted");
        when(dbManager.retrieveData()).thenReturn("{\"error\":\"no cached data available\"}");
        ApplicationFacade appFacade = new ApplicationFacade(null, null, dbManager);
        assertEquals("Please enter a valid year", appFacade.setYear("2022"));
    }

    @Test
    public void testSetYearNotAnInteger() {
        DataBaseManager dbManager = mock(DataBaseManager.class);
        when(dbManager.deleteTable()).thenReturn("Table Leagues has successfully been created");
        when(dbManager.createTable()).thenReturn("Table Leagues has successfully been created/loaded");
        when(dbManager.insertData(anyString())).thenReturn("Data successfully inserted");
        when(dbManager.retrieveData()).thenReturn("{\"error\":\"no cached data available\"}");
        ApplicationFacade appFacade = new ApplicationFacade(null, null, dbManager);
        assertEquals("Please enter a number", appFacade.setYear("hello there"));
    }




}
