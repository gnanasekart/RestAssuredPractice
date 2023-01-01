package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class ExtendReport {

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

    @BeforeSuite
    public void setUpSuite() {
        extentReports = new ExtentReports();
        extendSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/index.html");

        extendSparkReporter.config().setDocumentTitle("Rest Assured Automation Report");
        extendSparkReporter.config().setTheme(Theme.DARK);
        extendSparkReporter.config().setReportName("Gnana Report");
        extentReports.attachReporter(extendSparkReporter);
    }

    @BeforeMethod
    public void setUpMethod(Method method) {
        test = extentReports.createTest(method.getName()).assignAuthor("Gnana Sekar")
                            .assignCategory("Booking").assignDevice("Chrome Device");
        setExTest(test);
        test.log(Status.PASS, "Logging event");
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) {
        if(!result.isSuccess())
            getTest().fail(result.getThrowable().toString());
    }

    @AfterSuite
    public void tearDownSuite() {
        extentReports.flush();
    }
}