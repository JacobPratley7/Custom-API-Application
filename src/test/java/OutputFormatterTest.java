import Model.ApplicationFacade;
import Model.Database.DataBaseManager;
import Model.InputAPI.InputFetcher;
import Model.InputAPI.InputFetcherDummy;
import Model.InputAPI.InputFetcherImpl;
import Model.InputAPI.InputFormatter;
import Model.InputAPI.InputObjects.League;
import Model.InputAPI.InputObjects.Series;
import Model.OutputAPI.OutputFormatter;
import Model.OutputAPI.ReportSender;
import Model.OutputAPI.ReportSenderImpl;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class OutputFormatterTest {

    @Test
    public void testGenerateReportValid() {
        Series newSeries = mock(Series.class);
        League newLeague = mock(League.class);
        when(newLeague.getID()).thenReturn("4590");
        when(newSeries.getID()).thenReturn("3621");
        when(newSeries.getFullName()).thenReturn("2021");
        when(newSeries.getSlug()).thenReturn("cs-go-hyperion-x-oel-launch");
        when(newSeries.getTier()).thenReturn("d");
        when(newSeries.getYear()).thenReturn("2021");
        when(newSeries.getLeague()).thenReturn(newLeague);
        List<Series> series = new ArrayList<>();
        series.add(newSeries);
        OutputFormatter outputFormatter = new OutputFormatter();
        String report = outputFormatter.generateReport(series);
        assertTrue(report.contains("league id: 4590"));
        assertTrue(report.contains("id: 3621"));
        assertTrue(report.contains("full name: 2021"));
        assertTrue(report.contains("slug: cs-go-hyperion-x-oel-launch"));
        assertTrue(report.contains("tier: d"));
        assertTrue(report.contains("year: 2021"));
    }

    @Test
    public void testGenerateReportError() {
        OutputFormatter outputFormatter = new OutputFormatter();
        assertEquals("No data to report", outputFormatter.generateReport(null));
    }


}
