import Model.ApplicationFacade;
import Model.Database.DataBaseManager;
import Model.InputAPI.InputFetcher;
import Model.InputAPI.InputFetcherDummy;
import Model.InputAPI.InputFetcherImpl;
import Model.InputAPI.InputFormatter;
import Model.OutputAPI.ReportSender;
import Model.OutputAPI.ReportSenderImpl;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class InputFormatterTest {

//    @Test
//    public void testGenerateLeagueOutputValid() {
//        InputFormatter formatter = new InputFormatter();
//        String json = "[{\"id\":5678,\"image_url\":\"https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png\",\"modified_at\":\"2021-05-18T07:34:18Z\",\"name\":\"Hyperion x OEL Launch\",\"series\":[{\"begin_at\":\"2021-05-19T04:00:00Z\",\"description\":null,\"end_at\":\"2021-05-23T14:10:00Z\",\"full_name\":\"2021\",\"id\":3621,\"league_id\":4590,\"modified_at\":\"2021-05-23T18:55:54Z\",\"name\":null,\"season\":null,\"slug\":\"cs-go-hyperion-x-oel-launch-2021\",\"tier\":\"d\",\"winner_id\":126439,\"winner_type\":\"Team\",\"year\":2021}],\"slug\":\"cs-go-hyperion-x-oel-launch\",\"url\":\"\",\"videogame\":{\"current_version\":null,\"id\":3,\"name\":\"CS:GO\",\"slug\":\"cs-go\"}}]";
//
//        String output = formatter.generateLeagueOutput(json);
//        assertNotNull(output);
//        assertTrue(output.contains("id: 5678"));
//        assertTrue(output.contains("image url: https://cdn.pandascore.co/images/league/image/4590/600px-Oceanic_Esports.png"));
//        assertTrue(output.contains("modified at: 2021-05-18T07:34:18Z"));
//        assertTrue(output.contains("name: Hyperion x OEL Launch"));
//        assertTrue(output.contains("slug: cs-go-hyperion-x-oel-launch"));
//        assertTrue(output.contains("url: "));
//        assertTrue(output.contains("current version: null"));
//        assertTrue(output.contains("id: 3"));
//        assertTrue(output.contains("name: CS:GO"));
//        assertTrue(output.contains("slug: cs-go"));
//
//        assertTrue(output.contains("begin at: 2021-05-19T04:00:00Z"));
//        assertTrue(output.contains("description: null"));
//        assertTrue(output.contains("end at: 2021-05-23T14:10:00Z"));
//        assertTrue(output.contains("full name: 2021"));
//        assertTrue(output.contains("id: 3621"));
//        assertTrue(output.contains("league id: 4590"));
//        assertTrue(output.contains("modified at: 2021-05-23T18:55:54Z"));
//        assertTrue(output.contains("name: null"));
//        assertTrue(output.contains("slug: cs-go-hyperion-x-oel-launch-2021"));
//        assertTrue(output.contains("tier: d"));
//        assertTrue(output.contains("winner id: 126439"));
//        assertTrue(output.contains("winner type: Team"));
//        assertTrue(output.contains("year: 2021"));
//        assertTrue(output.contains("season: null"));
//    }
//
//    @Test
//    public void testGenerateLeagueOutputError() {
//        String json = "{\"error\":\"something went wrong\"}";
//        InputFormatter formatter = new InputFormatter();
//
//        String output = formatter.generateLeagueOutput(json);
//        assertNotNull(output);
//        assertTrue(output.contains("error: something went wrong"));
//    }
}
