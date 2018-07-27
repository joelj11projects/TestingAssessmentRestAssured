package qa.PetAssessment;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

	public class NavBar {

	    @FindBy(xpath="/html/body/app-root/div[1]/nav/div/ul/li[2]/a")
	    private WebElement OwnerBtn;

	    public void clickOwnerBtn(){
	        OwnerBtn.click();

	    }

	    
	    @FindBy(xpath="/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[1]/a/span[2]")
	    private WebElement allOwnerBtn;
		public void clickAllOwnerBtn() {
			allOwnerBtn.click();
			
		}



}
