package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.MacBookPro15InchPage;


public class PageObjectManager {
    private WebDriver driver;
    MacBookPro15InchPage macBookPro15InchPage;


    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public MacBookPro15InchPage getMacBookPro15InchPage() {
        return (macBookPro15InchPage == null) ? macBookPro15InchPage = new MacBookPro15InchPage(driver) : macBookPro15InchPage;
    }

}
