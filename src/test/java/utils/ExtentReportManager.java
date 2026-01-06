package utils;//package utils;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//
//public class ExtentReportManager {
//    private static ExtentReports extent;
//    private static ExtentTest test;
//
//    public static ExtentReports createReport() {
//        ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
//        reporter.config().setDocumentTitle("Automation Test Results");
//        reporter.config().setReportName("Test Execution Report");
//
//        extent = new ExtentReports();
//        extent.attachReporter(reporter);
//        return extent;
//    }
//
//    public static ExtentTest createTest(String testName) {
//        test = extent.createTest(testName);
//        return test;
//    }
//}
