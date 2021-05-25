package resources;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
//ExtentSparkReporter reporter;
 ExtentReports extent;
	public  ExtentReports getReport()
	
	{
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		String path=System.getProperty("user.dir") + "\\Reporter\\" + timestamp + "index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("UI AUTOMATION");
		reporter.config().setDocumentTitle("TEST RESULTS");
		
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester-Name", "Godbless");
		return extent;
		
		
		
		
	}
	
	
	
	
}
