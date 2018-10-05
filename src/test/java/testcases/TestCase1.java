package testcases;

import java.net.MalformedURLException;
import java.net.URL;

//import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjectRepository.HomePage_OR;



public class TestCase1 {
	
	//String chromePath = "D:\\Users\\703217907\\Documents\\chromedriver.exe";
	//DesiredCapabilities dc = DesiredCapabilities.chrome();
	protected WebDriver driver;	
		// Create a new instance of the chrome driver
	 @BeforeTest
	    public void setUp() throws MalformedURLException {
		 // System.setProperty("webdriver.chrome.driver", chromePath);
		 //  driver = new ChromeDriver();
		 
		 
		   DesiredCapabilities dr=null;
          // if(browserType.equals("firefox")){
           dr=DesiredCapabilities.chrome();
           dr.setBrowserName("chrome");
          // dr.setPlatform(Platform.WINDOWS);
       
            driver=new RemoteWebDriver(new URL("http://52.90.151.23:4444/wd/hub"), dr);
          
		   
	        //DesiredCapabilities dc = DesiredCapabilities.chrome();

	       // if (System.getProperty("browser").equals("firefox"))
	         //   dc = DesiredCapabilities.firefox();

	     //   String host = "52.90.151.23";
	        
	     //   driver = new RemoteWebDriver(new URL("http://" + host + ":4444/wd/hub"), dc);
	        
	    }	
  @Test
  public void verifyHomePage() 
  {
	 // System.setProperty("webdriver.chrome.driver", chromePath);
	 // WebDriver driver = new ChromeDriver();
	 HomePage_OR home=new HomePage_OR(); 
	 // driver.get("http://localhost:9090/demo/#/");
	  driver.get("http://35.174.137.193:9090/demo/#/");
      // Print a Log In message to the screen
      System.out.println("Successfully opened the demo App");

		//Wait for 5 Sec
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (!driver.findElement(home.txt_UserName()).getText().isEmpty())
			System.out.println("Username feild  beshould blank by default");
		if (!driver.findElement(home.txt_Age()).getText().isEmpty())
			System.out.println("Age feild should be blank by default");
		if (!driver.findElement(home.txt_Salary()).getText().isEmpty())
			System.out.println("Salary feild should be blank by default");
		if (!driver.findElement(home.btn_Reset()).isEnabled())
			System.out.println("reset button should be enabled by default");
		if (!driver.findElement(home.btn_Add()).isDisplayed())
			System.out.println("Add button should be displayed by default");
		 System.out.println("Successfully Verified home Page elements");
	/*	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//driver.wait("5000");
      // Close the driver
      driver.quit();
  }
}