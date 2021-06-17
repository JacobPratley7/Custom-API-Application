package Model;

import Model.Database.DataBaseManager;
import Model.InputAPI.InputFetcher;
import Model.InputAPI.InputFormatter;
import Model.InputAPI.InputObjects.Series;
import Model.OutputAPI.OutputFormatter;
import Model.OutputAPI.ReportSender;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ApplicationFacade {

    private String inputAuth;
    private String outputAuth;
    private String outputSID;
    private String outputToNumber;
    private String twilioNumber;
    private InputFetcher inputFetcher;
    private ReportSender reportSender;
    private DataBaseManager dbManager;
    private List<Series> lastRetrievedSeries;
    private InputFormatter inputFormatter;
    private OutputFormatter outputFormatter;
    private int year;

    /**
     * Class Constructor. Will also retrieve/store the contents of the config file.
     *
     * @param inputFetcher The InputFetcher object used to access the input API.
     * @param reportSender The ReportSender object used to access the output API.
     */
    public ApplicationFacade(InputFetcher inputFetcher, ReportSender reportSender, DataBaseManager dbManager) {
        this.inputFetcher = inputFetcher;
        this.reportSender = reportSender;
        this.dbManager = dbManager;
        this.inputFormatter = new InputFormatter();
        this.outputFormatter = new OutputFormatter();

        this.dbManager.createTable();
        readConfigFile();
    }

    private void readConfigFile() {
        JSONParser jsonParser = new JSONParser();
        try {
            Object fileContents = jsonParser.parse(new FileReader("config.json"));
            org.json.simple.JSONObject configDetails = (JSONObject) fileContents;
            this.inputAuth = (String) configDetails.get("inputAuthToken");

            this.outputAuth = (String) configDetails.get("outputAuthToken");
            this.outputSID = (String) configDetails.get("outputUsername");
            this.outputToNumber = (String) configDetails.get("outputNumberTo");
            this.twilioNumber = (String) configDetails.get("outputNumberFrom");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves league information from input API,
     * then formats this data into a more human readable string.
     *
     * @param cachedDataWanted Indicates whether or not the user requested cached data.
     * @return String in human readable format representing league data.
     * @throws IOException If error is to occur whilst accessing input API.
     */
    public String getLeagueData(boolean cachedDataWanted) throws IOException {

        String jsonData = null;
        if(cachedDataWanted) {
            jsonData = this.dbManager.retrieveData();
        } else {
            jsonData = this.inputFetcher.getLeagues(inputAuth);
            this.dbManager.updateData(jsonData);
        }

        return this.inputFormatter.generateLeagueOutput(jsonData, this.year);
    }


    private boolean confirmInputValid(String input) {
        if(input == null) {
            return false;
        }

        if(input.equals("")) {
            return false;
        }

        return input.chars().allMatch(c -> c < 128);
    }


    /**
     * Retrieves series information from input API,
     * then formats this data into a more human readable string.
     *
     * @param leagueID the id or the slug of the league the users wants series data on.
     * @return String in human readable format representing series data.
     * @throws IOException If error is to occur whilst accessing input API.
     */
    public String getSeriesData(String leagueID) throws IOException {
        if(confirmInputValid(leagueID) == false) {
            return "error: please provide a valid id or slug";
        }
        String jsonData = this.inputFetcher.getSeries(inputAuth, leagueID);
        String output = this.inputFormatter.generateSeriesOutput(jsonData, this.year);
        if(output.contains("error")) {
            this.lastRetrievedSeries = null;
        } else {
            this.lastRetrievedSeries = this.inputFormatter.generateSeriesList(jsonData, this.year);
        }
        return output;
    }

    /**
     * Generates a report and sends it the the pre-configured number.
     * Returns a string displaying the report if the message was sent successfully,
     * or the error message if the message was not able to send.
     *
     * @return String displaying either the report or the error message.
     * @throws IOException if error is to occur whilst accessing output API.
     */
    public String sendReport() throws IOException {
        String report = this.outputFormatter.generateReport(this.lastRetrievedSeries);
        String feedback = this.reportSender.sendMessage(this.outputSID, this.outputAuth, this.outputToNumber,
                this.twilioNumber, report);
        org.json.JSONObject feedbackData = new org.json.JSONObject(feedback);
        if(feedback.contains("more_info")) {
            String output = "Something went wrong.";
            output = output.concat("code: ").concat(Integer.toString(feedbackData.getInt("code")));
            output = output.concat("\nmessage: ").concat(feedbackData.getString("message"));
            output = output.concat("\nmore info: ").concat(feedbackData.getString("more_info"));
            return output;
        }

        return "Message sent Successfully!\n".concat(report);
    }

    private String checkYear(String year) {
        try {
            int potentialYear = Integer.parseInt(year);

            if (potentialYear < 1900 || potentialYear > 2021) {
                return "Please enter a valid year";
            }

            this.year = potentialYear;
            return "Success";
        } catch(NumberFormatException n) {
            return "Please enter a number";
        } catch(Exception e) {
            return "Something went wrong, please try again";
        }
    }

    /**
     * Sets the year that application will use when retrieving data.
     * Returns a string displaying whether or not the year was valid
     *
     * @return String displaying whether or not the year was valid.
     */
    public String setYear(String year) {
        return checkYear(year);
    }

}
