package testData;






import Utilities.PropertyUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class TestCaseExecutor {
    private static JSONObject jsonObject = null;
    private static final PropertyUtils appProperty = new PropertyUtils();
    private static final String jsonFile = appProperty.getPropertyValue("TestCaseJSON");
   /* public void main(String args[]) throws IOException, ParseException {
        *//*System.out.println("Dir path is"+System.getProperty("user.dir"));
        System.out.println("Path is"+System.getProperty("user.dir")+"/resources/"+"TestCases.json");
        File file = new File(System.getProperty("user.dir")+"\\src\\"+"\\test\\"+"\\resources\\"+"TestCases.json");
        Object obj = new JSONParser().parse(new FileReader(file));

        // typecasting obj to JSONObject
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject jsonObject1 = (JSONObject) jsonObject.get("ComputerTest Dashboard_TC001Verify that user is able to create a computer");
        System.out.println("Info is"+jsonObject1.get("Info"));
*//*
        getTestCaseScenario("UTE2");


    }*/
   public void TestcaseJSONReader() {
       String inputStream = PropertyUtils.appProperties.get("TestCaseJSON");
       createJsonObject(inputStream);

   }
    public static void createJsonObject(String jsonDataFile) {
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(new FileReader(jsonDataFile));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        jsonObject = (JSONObject) obj;
    }

    /**Get Jsonobject for each testcase based on test case name
     *
     * @param testCaseName - test case name
     * @return json object for each test case
     */

    public JSONObject getJsonObject(String testCaseName){
        JSONObject testcaseObject = new JSONObject();
        testcaseObject = (JSONObject) jsonObject.get(testCaseName);
        return testcaseObject;
    }
    public static List<TestCaseScenario> getTestCaseScenario(String env) {
        createJsonObject(jsonFile);
        List<TestCaseScenario> scenarios = new ArrayList<>();
        for (Object o : jsonObject.keySet()) {

            // Get the key
            String name = (String) o;

            // Get the value
            JSONObject testcaseObject = (JSONObject) jsonObject.get(name);
            int id =  Integer.parseInt(testcaseObject.get("id").toString());
            boolean execute;
            if (env.contains("LE") || env.contains("Live"))
                execute = (boolean) testcaseObject.get("ExecuteLE");
            else
                execute = (boolean) testcaseObject.get("ExecuteUTE");
            String info = (String) testcaseObject.get("Info");
            String feature = (String) testcaseObject.get("Feature");
            String finalDataStatus = getParameterFromJson(name, "FinalDataStatus");
            String environment = getParameterFromJson(name,"Environment");
            String testName = getParameterFromJson(name,"testName");
            String testData = getParameterFromJson(name,"testData");
            TestCaseScenario scenario = new TestCaseScenario(id, name, testName,execute, info, feature,finalDataStatus,environment,testData);
            scenarios.add(scenario);
        }
        scenarios.sort(Comparator.comparing(TestCaseScenario::getId));
        return scenarios;
    }
    public TestCaseScenario getTestScenario(String currentMethodName) {
        TestCaseScenario testCaseScenario = null;
        List<TestCaseScenario> testCaseScenarios = getTestCaseScenario("UTE");
        for(int i=0;i<testCaseScenarios.size();i++){
            if(testCaseScenarios.get(i).getTestName().equalsIgnoreCase(currentMethodName));
            testCaseScenario=testCaseScenarios.get(i);
                
        }


        return testCaseScenario;
    }
    public String getSheetName(String testData){
        String[] parts = testData.split(",");
        String sheetName = parts[0];
        return sheetName;

    }
    public String getRowNumber(String testData){
        String[] parts = testData.split(",");
        String rowNumber = parts[1];
        return rowNumber;

    }

    /**
     * Get parameter Value from input JSON file
     *
     * @param testcaseName testcase
     * @param parameter parameter
     * @return parameter value
     */
    private static String getParameterFromJson(String testcaseName, String parameter) {
        JSONObject testcaseObject = (JSONObject) jsonObject.get(testcaseName);
        if (testcaseObject.get(parameter) != null)
            return testcaseObject.get(parameter).toString();
        return "";
    }
    public static void main(String args[]){
        List<TestCaseScenario> testCaseScenario = getTestCaseScenario("UTE");
        for(int i=0;i<testCaseScenario.size();i++){
            System.out.println("Test case information:----------------------------");
            System.out.println("Test Case environment is"+testCaseScenario.get(i).getEnvironment());
            System.out.println("Test case name is"+testCaseScenario.get(i).getName());
        }
    }
    public void getTestDataUsingMethodName(){

    }
}
