package Model.OutputAPI;

public class ReportSenderDummy implements ReportSender {

    public String sendMessage(String userSID, String userAuthToken, String toNumber,
                       String fromNumber, String message) {
        return "{\"sid\": \"dummySID\", \"date_created\": \"Sun, 30 May 2021 01:29:42 +0000\", \"date_updated\": \"Sun, 30 May 2021 01:29:42 +0000\", \"date_sent\": null, \"account_sid\": \"dummy\", \"to\": \"random number\", \"from\": \"random number\", \"messaging_service_sid\": null, \"body\": \"report data\", \"status\": \"queued\", \"num_segments\": \"1\", \"num_media\": \"0\", \"direction\": \"outbound-api\", \"api_version\": \"2010-04-01\", \"price\": null, \"price_unit\": \"USD\", \"error_code\": null, \"error_message\": null, \"uri\": \"/2010-04-01/Accounts/dummyAccount/Messages/dummySID.json\", \"subresource_uris\": {\"media\": \"/2010-04-01/Accounts/dummyAccount/Messages/dummySID/Media.json\"}}\n";
    }


}
