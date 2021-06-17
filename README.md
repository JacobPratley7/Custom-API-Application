# SCD2_2021_Exam
Simple Extension was required to complete the assignment.

I was unsure wheher or not I needed to disclose the reason needing the extension to staff, so I have opted not to write it here. Please email me if you need to know the reasons.

- PASS requirements met: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/a100ba5c3735defd7b3bb82184dc6396bb8a9316
- CREDIT requirements met: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/c6ead66b537641028449466eec99974cb535b4ac
- DISTINCTION requirements met: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/18099c31b28dec88bafd4338bf83f1b9f2c19588

# Running the Application
To run the application, you will need to modify the configuration file, "config.json". Here, you will need to enter your credentials for the input and output APIs, and for the output API, you will also need to provide a valid 'To' and 'From' number. Credentials should be in String format. All keys in the config file correspond to the details you must enter. For the output api/twilio, authentication will be done through the use of your SID and your Auth token, so you will need to provide these details. The config file will appear as follows:
- inputAuthToken: here, you will replace the place-holder string with your Auth token for the pandascore api.
- outputAuthToken: here, you will replace the place-holder string with your Auth token for the twilio api. 
- outputUsername: here, you will replace the place-holder string with your SID for the twilio api. 
- outputNumberTo: here, you will replace the place-holder string with your "To" number for the twilio api. If you are using the free trial, you will need to configure this in your account beforehand.
- outputNumberFrom: here, you will replace the place-holder string with your "From" number for the twilio api (the twilio number you get with your account).

The database will be created upon first running the application. As a result, upon the first run, the database will not actually contain any information. If the user requests cached data on the first run before requesting live data, the Leagues page just won't display any information.

When running the application, there are a total of 5 different scenes or pages the user can traverse to. In particular, there will be a page displaying leagues information, a page displaying series information, and a page displaying whether or not the message was successfully sent. On all three of these pages, there will be a button to traverse back to the home page. However, this button will be located at the bottom of each page, so, when on any of these pages, if you cannot see them home button, simply scroll to the bottom of the page to find it. There is also a page that asks the user to select between live data and cached data. This page does not have a back button, and thus the user must select one of these two options. This will take them to the leagues page, from which they can return to the home page.

There are a few important things tonote for the output api. As twilio has a character limit for text messages, I was unable to send all the data to the user and instead just selected a few attributes to send. These attributes are the following:
 - league id
 - seris id
 - series full name
 - series slug
 - series tier
 - series year
Note that, apart from the league id, all other attributes are listed once per series, so for example, if a league had two series, then you would see two lots of the series attributes.

Additionally, the output api allows you to send data regardless of what was returned from the input api. Hence, if the input api returned an error response, then the application would still allow to send a message to the output api. I have formatted this so that the message will just say "No data to report", but please be aware sending this will still communicate with the output api and will use some of your twilio credit.

Another thing worth noting is that in the ApplicationFacade class utilizes both org.json.JSONObject and org.json.simple.JSONObject. The reason for this is that the methods used to retrieve data from the config file required org.json.simple, however, this was not implemented until after the rest of the class had been implemented with org.json. To avoid too much refactoring, both were used in the final result.


# Acknowledgements
For the code relating to the database components, a majority of the code used took inspiration from the following links.
- https://www.sqlitetutorial.net/sqlite-java/create-database/
- https://www.javatpoint.com/java-sqlite
- https://www.sqlitetutorial.net/sqlite-java/create-table/
- https://www.sqlitetutorial.net/sqlite-java/update/

For the concurrency, parts of the code took inspiration from the following link.
- https://stackoverflow.com/questions/11703568/how-to-use-the-return-value-of-call-method-of-task-class-in-javafx

For the API calls and apache client code, parts of the code took inspiration from the follwing link
- https://www.tutorialspoint.com/apache_httpclient/apache_httpclient_http_get_request.htm

It should also be noted that the code in ApplicationFacade in which the contents are read from the config file used code I had implemented for Stickman last year for SOFT2201. I acknowledge that I did not write this code this year.



# RED-GREEN-REFACTOR LOG

1. ApplicationFacade League Operations
- RED: tests compile, do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/80bd749db979b4143a775781dfcf65857fc16ef9
- GREEN: tests pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/1d6c8f923844f3cd8a10127634fbbb1bea9d9cf8
- REFACTOR: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/fc8551c5dcff289d882acebd788d5e91adc96dce

2. ApplicationFacade Series Operations
- RED: tests compile, do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/86f96bff1dde39115b82448a216fc7fbf119a7ef
- GREEN: tests pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/a483166fe088070126118fc07ea7632b951f3173
- REFACTOR: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/0bfdae9da8c5b24832f04b621c8f2d5f11c96a80

3. ApplicationFacade Send Report Operations
- RED: tests compile, do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/d394557d68b89f3426f5ad11a0ff9457f1b8998c
- GREEN: tests pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/89e7f44764d274a5d9c8c4985db67085a901b024
- REFACTOR: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/532139e64c0aba9da6ea5afb6e1a51c81f8a033e

4. ApplicationFacade Series Operations Updated to Display Tournament Data
- RED: test do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/8e25f43f8d22a2f58475f662232843a9c1c6aed5
- GREEN: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/0bfdae9da8c5b24832f04b621c8f2d5f11c96a80
- REFACTOR: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/6a370a2d2dd78a0fbd5f841e87ad065b863b9607

5. ApplicationFacade SeriesOperations Updates Modified
- RED: tests do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/306a776382b2456ee3cfd884f8bd18d858edca7b
- GREEN: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/6a370a2d2dd78a0fbd5f841e87ad065b863b9607
- REFACTOR: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/7f458b2001ac4846667e251049aaa3e1854f0035

6. ApplicationFacade League Operations Updated to Display Series Data
- RED: tests do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/68be577b19a7ec650cb62a5d69c399be2887702d
- GREEN: tests pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/fc8551c5dcff289d882acebd788d5e91adc96dce

7. ApplicationFacade Series Operations Updated to Display League Data
- RED: tests do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/a8aed4ed5daa26fa0e7dab94b13bf40ab7466f92
- GREEN: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/7f458b2001ac4846667e251049aaa3e1854f0035

7. ApplicationFacade Series Operations Defensive Checks
 - RED: tests do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/fe12df0fa9e1b5af90bc78c009542fe9eb03cd4e
 - GREEN: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/86481eaeeb459f920cc32833c2d4fa48faf0eed7
 
8. ApplicationFacade Caching
- RED: tests do not pass : https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/8f004740cf18ac80aadb11de957c70ee4ca773ea
- GREEN: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/0f2b0f281f5eb40118d6d710e11231bc7db2a009
- REFACTOR: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/a0c648bc470eabda57071861eaaa71354303fba2

9.InputFormatter League Operations
- RED: tests do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/46919c30f63f2a0df56f1270edb1d75d20993116
- GREEN: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/f9564e1b430936d5592a2fd4092f56197b5efe52

10. InputFormatter Series Operations
- RED: tests do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/4e5bdfb3736f3812ca2981d6799b9c05edd0fb0e
- GREEN: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/2726d90d2956cc692e5ad87209ce9283ecedb6d7
- REFACTOR: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/8f436049785ef44f5d114dd857a6dd7bdbaea579

11. InputFormatter GenerateSeriesList
- RED: tests do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/7213c6c39ca8eadbc924627cba0b3b9e428864b6
- GREEN: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/436a809bde67a331e9d2ab7f4371c0757d1bbf0a

12. OutputFormatter GenerateReport
- RED: tests do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/e0346c81a6a920cf4c612049f0b359512da921eb
- GREEN: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/0aa21fe61e6c813c56e2173c97d2a4857d8cd21e

13. InputFormatter GenerateSeries/GenerateLeague Extension Task
- RED: tests do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/85cdafe29a4b7a8ba1a458235f1751d34409c48b
- GREEN: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/3ba82e6aed382f27edaf476ba4d65623e4db0d6f

14. OutputFormatter GenerateReport Extension Task
- RED: tests do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/8710b51ca5a134925a48e2ea274cca10d8968799
- GREEN: 
