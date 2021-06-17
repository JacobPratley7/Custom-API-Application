import Model.InputAPI.InputObjects.League;
import Model.InputAPI.InputObjects.Series;
import Model.OutputAPI.OutputFormatter;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

public class OutputFormatterTest {

    @Test
    public void testGenerateReportValid() {
        Series newSeries = mock(Series.class);
        when(newSeries.getID()).thenReturn("3621");
        when(newSeries.getFullName()).thenReturn("2021");
        when(newSeries.getSlug()).thenReturn("cs-go-hyperion-x-oel-launch");
        when(newSeries.getTier()).thenReturn("d");
        when(newSeries.getYear()).thenReturn("2021");
        when(newSeries.getLeagueId()).thenReturn("4590");
        League newLeague = mock(League.class);
        when(newLeague.isTooNew()).thenReturn(false);
        when(newSeries.getLeague()).thenReturn(newLeague);
        List<Series> series = new ArrayList<>();
        series.add(newSeries);
        OutputFormatter outputFormatter = new OutputFormatter();
        String report = outputFormatter.generateReport(series);
        assertFalse(report.contains("*league id: 4590"));
        assertTrue(report.contains("league id: 4590"));
        assertTrue(report.contains("id: 3621"));
        assertTrue(report.contains("full name: 2021"));
        assertTrue(report.contains("slug: cs-go-hyperion-x-oel-launch"));
        assertTrue(report.contains("tier: d"));
        assertTrue(report.contains("year: 2021"));
    }

    @Test
    public void testGenerateReportTooNew() {
        Series newSeries = mock(Series.class);
        when(newSeries.getID()).thenReturn("3621");
        when(newSeries.getFullName()).thenReturn("2021");
        when(newSeries.getSlug()).thenReturn("cs-go-hyperion-x-oel-launch");
        when(newSeries.getTier()).thenReturn("d");
        when(newSeries.getYear()).thenReturn("2021");
        when(newSeries.getLeagueId()).thenReturn("4590");
        League newLeague = mock(League.class);
        when(newLeague.isTooNew()).thenReturn(true);
        when(newSeries.getLeague()).thenReturn(newLeague);
        List<Series> series = new ArrayList<>();
        series.add(newSeries);
        OutputFormatter outputFormatter = new OutputFormatter();
        String report = outputFormatter.generateReport(series);
        assertTrue(report.contains("*league id: 4590"));
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
