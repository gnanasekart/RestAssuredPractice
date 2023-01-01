package Listeners;

import Report.ExtendReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.*;

public class TestListener implements ISuiteListener, ITestListener {
    public static ExtentReports extentReports = null;
    public static ExtentSparkReporter extendSparkReporter = null;
    public static ExtentTest test = null;

    private static ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();
    public static ExtentTest getTest(){
        return exTest.get();
    }

    public static void setExTest(ExtentTest test){
        exTest.set(test);
    }

    @Override
    public void onStart(ISuite suite) {
        extentReports = new ExtentReports();
        extendSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/index.html");

        extendSparkReporter.config().setDocumentTitle("Rest Assured Automation Report");
        extendSparkReporter.config().setTheme(Theme.DARK);
        extendSparkReporter.config().setReportName("Gnana Report");
        extentReports.attachReporter(extendSparkReporter);
    }

    @Override
    public void onFinish(ISuite suite) {
        extentReports.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extentReports.createTest(result.getName()).assignAuthor("Gnana Sekar")
                .assignCategory("Booking").assignDevice("Chrome Device");
        setExTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        getTest().log(Status.PASS, "Logging event");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if(!result.isSuccess())
            getTest().fail(result.getThrowable().toString());
    }
}
