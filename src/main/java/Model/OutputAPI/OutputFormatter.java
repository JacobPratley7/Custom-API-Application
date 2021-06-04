package Model.OutputAPI;

import Model.InputAPI.InputObjects.Series;

import java.util.List;

public class OutputFormatter {

    public String generateReport(List<Series> lastRetrievedSeries) {
        if(lastRetrievedSeries == null) {
            System.out.println("hi");
            return "No data to report";
        }
        String report = "league id: ".concat(lastRetrievedSeries.get(0).getLeagueId());
        report = report.concat("\nseries:");
        for(Series s: lastRetrievedSeries) {
            String currentSeriesData = "\n\tid: ".concat(s.getID());
            currentSeriesData = currentSeriesData.concat("\n\tfull name: ").concat(s.getFullName());
            currentSeriesData = currentSeriesData.concat("\n\tslug: ").concat(s.getSlug());
            currentSeriesData = currentSeriesData.concat("\n\ttier: ").concat(s.getTier());
            currentSeriesData = currentSeriesData.concat("\n\tyear: ").concat(s.getYear());
            currentSeriesData = currentSeriesData.concat("\n");
            currentSeriesData = currentSeriesData.concat("\n");
            if(report.length() + currentSeriesData.length() >= 1600) {
                break;
            } else {
                report = report.concat(currentSeriesData);
            }
        }

        return report;
    }
}