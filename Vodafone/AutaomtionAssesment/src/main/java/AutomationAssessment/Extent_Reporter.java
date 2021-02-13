package AutomationAssessment;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.List;
import java.util.Map;

public class Extent_Reporter implements IReporter {
    private ExtentReports extent;
    ExtentHtmlReporter htmlReporter;

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\htmlreport.html");
        //where the reports will be generated on machine
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
            //get the results and store them in Map object

            for (ISuiteResult r : result.values()) {

                // iterate in each result
                ITestContext context = r.getTestContext();

                buildTestNodes(context.getPassedTests(), Status.PASS);
                //if it's pass then build a new node in the html report >> saying that this test is passed
                buildTestNodes(context.getFailedTests(), Status.FAIL);
                buildTestNodes(context.getSkippedTests(), Status.SKIP);
            }
        }

        extent.flush();

    }

    private void buildTestNodes(IResultMap tests, Status status) {
        ExtentTest test;

        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.createTest(result.getMethod().getMethodName());

                /*test.getTest(). = getTime(result.getStartMillis());
                test.getTest().endedTime = getTime(result.getEndMillis());*/

                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);

                String message = "Test " + status.toString().toLowerCase() + "ed";

                if (result.getThrowable() != null)
                    message = result.getThrowable().getMessage();

                test.log(status, message);

                //      extent.endTest(test);
            }
        }
    }

 /*   private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }*/
}