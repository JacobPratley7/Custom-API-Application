import Model.ApplicationFacade;
import Model.InputAPI.InputFetcher;
import Model.InputAPI.InputFetcherDummy;
import Model.InputAPI.InputFetcherImpl;
import Model.InputAPI.InputObjects.League;
import Model.OutputAPI.ReportSender;
import Model.OutputAPI.ReportSenderImpl;
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

    @Test
    public void testGetSeriesDataOnline() throws IOException {
        InputFetcher imp = mock(InputFetcherImpl.class);
        when(imp.getSeries(anyString(), anyString())).thenReturn("[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league\":{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\"},\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"tournaments\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"end_at\":\"2021-05-23T14:10:00Z\",\"id\":6082,\"league_id\":4590,\"live_supported\":false,\"modified_at\":\"2021-05-24T08:29:01Z\",\"name\":\"Playoffs\",\"prizepool\":null,\"serie_id\":3621,\"slug\":\"cs-go-hyperion-x-oel-launch-2021-playoffs\",\"winner_id\":126439,\"winner_type\":\"Team\"}],\"videogame\":{\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"},\"videogame_title\":null,\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}]");
        ApplicationFacade appFacade = new ApplicationFacade(imp, null);
        String output = appFacade.getSeriesData("test", "randomSlug");
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
    public void testGetSeriesDataError() throws IOException {
        InputFetcher imp = mock(InputFetcherImpl.class);
        when(imp.getSeries(anyString(), anyString())).thenReturn("{\"error\":\"something went wrong\"}");
        ApplicationFacade appFacade = new ApplicationFacade(imp, null);
        String output = appFacade.getSeriesData("test", "test");
        assertTrue(output.contains("error: something went wrong"));
    }

    @Test
    public void testGetSeriesDataDummy() throws IOException {
        InputFetcher imp = mock(InputFetcherDummy.class);
        when(imp.getSeries(anyString(), anyString())).thenReturn("[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league\":{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\"},\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"tournaments\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"end_at\":\"2021-05-23T14:10:00Z\",\"id\":6082,\"league_id\":4590,\"live_supported\":false,\"modified_at\":\"2021-05-24T08:29:01Z\",\"name\":\"Playoffs\",\"prizepool\":null,\"serie_id\":3621,\"slug\":\"cs-go-hyperion-x-oel-launch-2021-playoffs\",\"winner_id\":126439,\"winner_type\":\"Team\"}],\"videogame\":{\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"},\"videogame_title\":null,\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}]");
        ApplicationFacade appFacade = new ApplicationFacade(imp, null);
        String output = appFacade.getSeriesData("test", "randomSlug");
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
    public void testSendReportOnline() throws IOException {
        InputFetcher imp = mock(InputFetcherImpl.class);
        when(imp.getSeries(anyString(), anyString())).thenReturn("[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league\":{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\"},\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"tournaments\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"end_at\":\"2021-05-23T14:10:00Z\",\"id\":6082,\"league_id\":4590,\"live_supported\":false,\"modified_at\":\"2021-05-24T08:29:01Z\",\"name\":\"Playoffs\",\"prizepool\":null,\"serie_id\":3621,\"slug\":\"cs-go-hyperion-x-oel-launch-2021-playoffs\",\"winner_id\":126439,\"winner_type\":\"Team\"}],\"videogame\":{\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"},\"videogame_title\":null,\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}]");
        ReportSender rep = mock(ReportSenderImpl.class);
        when(rep.sendMessage(anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn("{\"sid\": \"dummySID\", \"date_created\": \"Sun, 30 May 2021 01:29:42 +0000\", \"date_updated\": \"Sun, 30 May 2021 01:29:42 +0000\", \"date_sent\": null, \"account_sid\": \"dummy\", \"to\": \"random number\", \"from\": \"random number\", \"messaging_service_sid\": null, \"body\": \"report data\", \"status\": \"queued\", \"num_segments\": \"1\", \"num_media\": \"0\", \"direction\": \"outbound-api\", \"api_version\": \"2010-04-01\", \"price\": null, \"price_unit\": \"USD\", \"error_code\": null, \"error_message\": null, \"uri\": \"/2010-04-01/Accounts/dummyAccount/Messages/dummySID.json\", \"subresource_uris\": {\"media\": \"/2010-04-01/Accounts/dummyAccount/Messages/dummySID/Media.json\"}}\n");
        ApplicationFacade appFacade = new ApplicationFacade(imp, rep);
        appFacade.getSeriesData("test", "test");
        String output = appFacade.sendReport();
        assertTrue(output.contains("Message sent Successfully!"));
    }

    @Test
    public void testSendReportDummy() throws IOException {
        InputFetcher imp = mock(InputFetcherImpl.class);
        when(imp.getSeries(anyString(), anyString())).thenReturn("[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league\":{\"id\":4590,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\"},\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"tournaments\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"end_at\":\"2021-05-23T14:10:00Z\",\"id\":6082,\"league_id\":4590,\"live_supported\":false,\"modified_at\":\"2021-05-24T08:29:01Z\",\"name\":\"Playoffs\",\"prizepool\":null,\"serie_id\":3621,\"slug\":\"cs-go-hyperion-x-oel-launch-2021-playoffs\",\"winner_id\":126439,\"winner_type\":\"Team\"}],\"videogame\":{\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"},\"videogame_title\":null,\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}]");
        ReportSender rep = mock(ReportSenderImpl.class);
        when(rep.sendMessage(anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn("{\"sid\": \"dummySID\", \"date_created\": \"Sun, 30 May 2021 01:29:42 +0000\", \"date_updated\": \"Sun, 30 May 2021 01:29:42 +0000\", \"date_sent\": null, \"account_sid\": \"dummy\", \"to\": \"random number\", \"from\": \"random number\", \"messaging_service_sid\": null, \"body\": \"report data\", \"status\": \"queued\", \"num_segments\": \"1\", \"num_media\": \"0\", \"direction\": \"outbound-api\", \"api_version\": \"2010-04-01\", \"price\": null, \"price_unit\": \"USD\", \"error_code\": null, \"error_message\": null, \"uri\": \"/2010-04-01/Accounts/dummyAccount/Messages/dummySID.json\", \"subresource_uris\": {\"media\": \"/2010-04-01/Accounts/dummyAccount/Messages/dummySID/Media.json\"}}\n");
        ApplicationFacade appFacade = new ApplicationFacade(imp, rep);
        appFacade.getSeriesData("test", "test");
        String output = appFacade.sendReport();
        assertTrue(output.contains("Message sent Successfully"));
    }


}
