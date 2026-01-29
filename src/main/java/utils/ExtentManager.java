package utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extentReports;
    public static ExtentReports getExtentReports(){
        if(extentReports==null){
            ExtentSparkReporter spark=new ExtentSparkReporter("target/ExtentReport.html");
            spark.config().setDocumentTitle(ConfigReader.get("reportTitle"));
            spark.config().setReportName(ConfigReader.get("reportName"));

            extentReports=new ExtentReports();
            extentReports.attachReporter(spark);
        }
        return extentReports;
    }
}
