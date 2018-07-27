package qa.PetAssessmentSelenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import qa.PetAssessment.NavBar;

public class RunSelenium {
	
	
	WebDriver driver; 
	
	@Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();
    }
	
	@After
    public void teardown(){
        driver.quit();
    }
	
	 @Test
	    public void methodTest(){
	        driver.manage().window().maximize();
	        driver.get("http://10.0.10.10:4200/petclinic/welcome");
	        NavBar clickBtn = PageFactory.initElements(driver,NavBar.class);
	        clickBtn.clickOwnerBtn();
	        clickBtn.clickAllOwnerBtn();
	        
	        try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e);
            }
	        

}
}

