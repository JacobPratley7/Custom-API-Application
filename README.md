# SCD2_2021_Exam

- PASS requirements met: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/a100ba5c3735defd7b3bb82184dc6396bb8a9316
- CREDIT requirements met: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/c6ead66b537641028449466eec99974cb535b4ac
# Running the Application
To run the application, you will need to modify the configuration file, "config.json". Here, you will need to enter your credentials for the input and output APIs, and for the output API, you will also need to provide a valid 'To' and 'From' number. Credentials should be in String format. E.g., if you input API auth token is 'hello', then next to inputAuthToken enter "hello". All keys in the config file correspond to the details you must enter. Here, outputUsername refers to your twilio SID.

last working commit: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/6eb5426de4c49540487e54133e4100538e5ef712

# Acknowledgements
For the code relating to the database components, a majority of the code used was a combination of the following links. I do not claim that this code is my own.
- https://www.sqlitetutorial.net/sqlite-java/create-database/
- https://www.javatpoint.com/java-sqlite
- https://www.sqlitetutorial.net/sqlite-java/create-table/
- https://www.sqlitetutorial.net/sqlite-java/update/
# RED-GREEN-REFACTOR LOG

1. ApplicationFacadeLeagueOperations
- RED: tests do not compile: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/68333a0bca10915163d78a2232ef355398a675ac
- RED: tests compile, do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/80bd749db979b4143a775781dfcf65857fc16ef9
- GREEN: tests pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/1d6c8f923844f3cd8a10127634fbbb1bea9d9cf8
- REFACTOR: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/fc8551c5dcff289d882acebd788d5e91adc96dce

2. ApplicationFacadeSeriesOperations
- RED: tests do not compile: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/78929870efad20f45830c19bae360ad8964c84e5
- RED: tests compile, do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/86f96bff1dde39115b82448a216fc7fbf119a7ef
- GREEN: tests pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/a483166fe088070126118fc07ea7632b951f3173
- REFACTOR: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/0bfdae9da8c5b24832f04b621c8f2d5f11c96a80

3. ApplicationFacadeSendReportOperations
- RED: tests do not compile: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/63661fa7b5dcef44b3ba6a6e700f2899b79e0135
- RED: tests compile, do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/d394557d68b89f3426f5ad11a0ff9457f1b8998c
- GREEN: tests pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/89e7f44764d274a5d9c8c4985db67085a901b024
- REFACTOR: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/532139e64c0aba9da6ea5afb6e1a51c81f8a033e

4. ApplicationFacadeSeriesOperationsUpdated
- RED: test do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/8e25f43f8d22a2f58475f662232843a9c1c6aed5
- GREEN: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/0bfdae9da8c5b24832f04b621c8f2d5f11c96a80
- REFACTOR: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/6a370a2d2dd78a0fbd5f841e87ad065b863b9607

5. ApplicationFacadeSeriesOperationsUpdated-modified
- RED: tests do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/306a776382b2456ee3cfd884f8bd18d858edca7b
- GREEN: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/6a370a2d2dd78a0fbd5f841e87ad065b863b9607
- REFACTOR: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/7f458b2001ac4846667e251049aaa3e1854f0035

6. ApplicationFacadeLeagueOperations: updated to display series data
- RED: tests do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/68be577b19a7ec650cb62a5d69c399be2887702d
- GREEN: tests pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/fc8551c5dcff289d882acebd788d5e91adc96dce

7. ApplicationFacadeSeriesOperations: updated to display series data
- RED: tests do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/a8aed4ed5daa26fa0e7dab94b13bf40ab7466f92
- GREEN: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/7f458b2001ac4846667e251049aaa3e1854f0035

7. ApplicationFacadeSeriesOperationsDefensiveChecks
 - RED: tests do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/fe12df0fa9e1b5af90bc78c009542fe9eb03cd4e
 - GREEN: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/86481eaeeb459f920cc32833c2d4fa48faf0eed7
 
8. ApplicationFacadeCaching
- RED: tests do not pass : https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/8f004740cf18ac80aadb11de957c70ee4ca773ea
- GREEN: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/0f2b0f281f5eb40118d6d710e11231bc7db2a009
- REFACTOR: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/a0c648bc470eabda57071861eaaa71354303fba2

9.InputFormatterLeagueOperations
- RED: tests do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/46919c30f63f2a0df56f1270edb1d75d20993116
- GREEN: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/f9564e1b430936d5592a2fd4092f56197b5efe52

10. InputFormatterSeriesOperations
- RED: tests do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/4e5bdfb3736f3812ca2981d6799b9c05edd0fb0e
- GREEN: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/2726d90d2956cc692e5ad87209ce9283ecedb6d7
- REFACTOR: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/8f436049785ef44f5d114dd857a6dd7bdbaea579

11. InputFormatterGenerateSeriesList
- RED: tests do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/7213c6c39ca8eadbc924627cba0b3b9e428864b6
- GREEN: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/436a809bde67a331e9d2ab7f4371c0757d1bbf0a

12. OutputFormatterGenerateReport
- RED: tests do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/e0346c81a6a920cf4c612049f0b359512da921eb
- GREEN: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/0aa21fe61e6c813c56e2173c97d2a4857d8cd21e
