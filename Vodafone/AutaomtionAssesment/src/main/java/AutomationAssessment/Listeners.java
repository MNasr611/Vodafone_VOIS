package AutomationAssessment;

import freemarker.cache.URLTemplateLoader;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners implements ITestListener {
    String nameOfFailedTst;
    String nameOfTstCase;
    Utilities ul ;
    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("success");
        nameOfTstCase	= 	result.getName();
        System.out.println(nameOfTstCase);
        if(nameOfTstCase.endsWith("G")){
            System.out.println("AD =  " + result.getTestContext().getAttribute("G"));
        }

        else if (nameOfTstCase.endsWith("R")){
            System.out.println("SumInsured =  " + result.getTestContext().getAttribute("R"));
        }

        else if (nameOfTstCase.endsWith("P")){
            System.out.println("SumInsured =  " + result.getTestContext().getAttribute("P"));

        }
        else if (nameOfTstCase.endsWith("S")){
            System.out.println("SumInsured =  " + result.getTestContext().getAttribute("S"));

        }


    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        ul = new Utilities();
        System.out.println("***** Error "+result.getName()+" test has failed *****");
        nameOfTstCase = result.getName();
        try {
            ul.takeScreenshot(Base.driver ,nameOfTstCase);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }





    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub

    }



}