package resources;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

import java.io.IOException;

public class Listeners implements ITestListener {

    Base baseClassObject = new Base();

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult resultMethod) {
        try {
            baseClassObject.takeScreenshots(resultMethod.getName(), resultMethod.getEndMillis());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
