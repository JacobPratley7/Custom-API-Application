# SCD2_2021_Exam

# Running the Application
To run the application, you will need to modify the configuration file, "config.json". Here, you will need to enter your credentials for the input and output APIs, and for the output API, you will also need to provide a valid 'To' and 'From' number. Credentials should be in String format. E.g., if you input API auth token is 'hello', then next to inputAuthToken enter "hello". All keys in the config file correspond to the details you must enter. Here, outputUsername refers to your twilio SID.

last working commit: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/6eb5426de4c49540487e54133e4100538e5ef712


# RED-GREEN-REFACTOR LOG

1. ApplicationFacadeLeagueOperations
- RED: tests do not compile: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/68333a0bca10915163d78a2232ef355398a675ac
- RED: tests compile, do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/80bd749db979b4143a775781dfcf65857fc16ef9
- GREEN: tests pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/1d6c8f923844f3cd8a10127634fbbb1bea9d9cf8
- REFACTOR: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/0b1deefe1da0c511bd3e8f318673e211296e187d

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

6. ApplicationFacadeLeagueOperations: updated to display series data
- RED: tests do not pass: https://github.sydney.edu.au/jpra3842/SCD2_2021_Exam/commit/68be577b19a7ec650cb62a5d69c399be2887702d
