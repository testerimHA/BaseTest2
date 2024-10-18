package runners;

import Steps.Hooks;
import Utilities.PropertyReader;
import org.json.JSONObject;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;


public class TestResultAnalizer {

    private static final String RESULT_FILE = "test_results.json";
    private static final String jsonFilePath = "target/test-output/cucumber-reports/cucumber.json";
    private static final String resultHtml = "target/test-output/cucumber-reports/test_results.html";

    static JSONObject previousResults = loadTestResults();
    static int passCount = 0;
    static int failCount = 0;
    static int otherCount = 0;
    static int eskiPassCount = previousResults.getInt("passCount");
    static int eskiFailCount = previousResults.getInt("failCount");
    static int eskiOtherCount = previousResults.getInt("otherCount");
    static String jenkinsCucumberReportLink="";
    static String jenkinsAlureReportLink="";
    static String jenkinsReportUsername="";
    static String jenkinsReportPassword="";

    public  static void testRueltsAnalizer() {
        jenkinsCucumberReportLink = PropertyReader.read().get("jenkinsHost") + PropertyReader.read().get("jenkinsCucumberReportLink");
        jenkinsAlureReportLink = PropertyReader.read().get("jenkinsHost") + PropertyReader.read().get("jenkinsAllureReportLink");
        jenkinsReportUsername = PropertyReader.read().get("jenkinsReportUsername");
        jenkinsReportPassword = PropertyReader.read().get("jenkinsReportPassword");

        try {
            passCount= Hooks.passScenario;
            failCount=Hooks.failScenario;

//            // JSON dosyasını oku
//            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
//            JSONArray featureArray = new JSONArray(jsonContent);
//
//            // Geçen, başarısız ve diğer durumları sayacak değişkenler
//
//            // Her bir senaryoyu kontrol et
//            for (int i = 0; i < featureArray.length(); i++) {
//                JSONObject feature = featureArray.getJSONObject(i);
//                JSONArray elements = feature.getJSONArray("elements");
//                for (int j = 0; j < elements.length(); j++) {
//                    JSONObject scenario = elements.getJSONObject(j);
//                    JSONArray steps = scenario.getJSONArray("steps");
//
//                    boolean scenarioFailed = false;
//                    for (int k = 0; k < steps.length(); k++) {
//                        JSONObject step = steps.getJSONObject(k);
//                        String status = step.getJSONObject("result").getString("status");
//                        if ("failed".equals(status)) {
//                            scenarioFailed = true;
//                            break;
//                        }
//                    }
//
//                    if (scenarioFailed) {
//                        failCount++;
//                    } else {
//                        passCount++;
//                    }
//                }
//            }

            // Sonuçları yazdır
            System.out.println("Pass: " + passCount);
            System.out.println("Fail: " + failCount);
            System.out.println("Other: " + otherCount);

            // Önceki sonuçları yükle ve göster
            eskiPassCount = previousResults.getInt("passCount");
            eskiFailCount = previousResults.getInt("failCount");
            eskiOtherCount = previousResults.getInt("otherCount");
            System.out.println("Bir Önceki Test Sonuçları");
            System.out.println("Pass: " + eskiPassCount);
            System.out.println("Fail: " + eskiFailCount);
            System.out.println("Other: " + eskiOtherCount);

            // Mevcut sonuçları JSON dosyasına kaydet
            JSONObject testResults = new JSONObject();
            testResults.put("passCount", passCount);
            testResults.put("failCount", failCount);
            testResults.put("otherCount", otherCount);
            saveTestResults(testResults);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private static void saveTestResults(JSONObject testResults) {
        try {
            FileWriter writer = new FileWriter(RESULT_FILE);
            writer.write(testResults.toString(4));
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JSONObject loadTestResults() {
        try {
            if (Files.exists(Paths.get(RESULT_FILE))) {
                String content = new String(Files.readAllBytes(Paths.get(RESULT_FILE)));
                return new JSONObject(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONObject();
    }

    public static void createHTMLReport() {
        try {
            FileWriter writer = new FileWriter(resultHtml);
            writer.write("<!DOCTYPE html>\n");
            writer.write("<html lang=\"en\">\n");
            writer.write("<head>\n");
            writer.write("<meta charset=\"UTF-8\">\n");
            writer.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
            writer.write("<title>Test Results</title>\n");
            writer.write("<style>\n");
            writer.write("body {\n");
            writer.write("    font-family: Arial, sans-serif;\n");
            writer.write("    margin: 0;\n");
            writer.write("    padding: 0;\n");
            writer.write("    background-color: #f0f0f0;\n");
            writer.write("}\n");
            writer.write(".container {\n");
            writer.write("    max-width: 800px;\n");
            writer.write("    margin: 20px auto;\n");
            writer.write("    padding: 20px;\n");
            writer.write("    background-color: #fff;\n");
            writer.write("    border-radius: 8px;\n");
            writer.write("    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n");
            writer.write("}\n");
            writer.write("h2 {\n");
            writer.write("    text-align: center;\n");
            writer.write("    margin-bottom: 20px;\n");
            writer.write("}\n");
            writer.write("table {\n");
            writer.write("    width: 100%;\n");
            writer.write("    border-collapse: collapse;\n");
            writer.write("    margin-bottom: 20px;\n");
            writer.write("}\n");
            writer.write("th, td {\n");
            writer.write("    border: 1px solid #ddd;\n");
            writer.write("    padding: 8px;\n");
            writer.write("    text-align: center;\n");
            writer.write("}\n");
            writer.write("th {\n");
            writer.write("    background-color: #f2f2f2;\n");
            writer.write("}\n");
            writer.write("a {\n");
            writer.write("    color: #007bff;\n");
            writer.write("    text-decoration: none;\n");
            writer.write("}\n");
            writer.write("a:hover {\n");
            writer.write("    text-decoration: underline;\n");
            writer.write("}\n");
            writer.write("</style>\n");
            writer.write("</head>\n");
            writer.write("<body>\n");
            writer.write("<div class=\"container\">\n");
            writer.write("<h2>Test Results</h2>\n");
            writer.write("<table>\n");
            writer.write("<tr>\n");
            writer.write("<th>Test</th>\n");
            writer.write("<th>Son Testin Sonuçları</th>\n");
            writer.write("<th>Önceki Test Sonuçları</th>\n");
            writer.write("</tr>\n");
            writer.write("<tr>\n");
            writer.write("<td>Pass Count</td>\n");
            writer.write("<td>" + passCount + "</td>\n");
            writer.write("<td>" + eskiPassCount + "</td>\n");
            writer.write("</tr>\n");
            writer.write("<tr>\n");
            writer.write("<td>Fail Count</td>\n");
            writer.write("<td>" + failCount + "</td>\n");
            writer.write("<td>" + eskiFailCount + "</td>\n");
            writer.write("</tr>\n");
            writer.write("<tr>\n");
            writer.write("<td>Other Count</td>\n");
            writer.write("<td>" + otherCount + "</td>\n");
            writer.write("<td>" + eskiOtherCount + "</td>\n");
            writer.write("</tr>\n");
            writer.write("</table>\n");
            writer.write("<div style=\"text-align: center;\">\n");
            writer.write("<a href=" + jenkinsCucumberReportLink + " target=\"_blank\">Cucumber Report</a> |\n");
            writer.write("<a href=" + jenkinsAlureReportLink + " target=\"_blank\">Allure Report</a><br><br>");
            writer.write("Username: " + jenkinsReportUsername + "<br>");
            writer.write("Password: " + jenkinsReportPassword);

            writer.write("</div>\n");
            writer.write("</div>\n");
            writer.write("</body>\n");
            writer.write("</html>\n");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
