package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MacBookPro15InchPage {
    WebDriver driver;

    public MacBookPro15InchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[7]/div[2]/bundle-selection/div[2]/sticky/div/fieldset/div/span/button[2]")
    private WebElement select_15InchScreen;
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[7]/div[2]/bundle-selection/div[3]/div[2]/div[2]/div/div[2]/div/bundle-selector/div[2]/fieldset/ul/li[2]/label/span[1]")
    private WebElement select_SilverColour;
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[7]/div[2]/bundle-selection/div[3]/div[2]/div[2]/div/div[2]/div/bundle-selector/div[3]/div[2]/div/h3")
    private WebElement select_Processor;
    @FindBy(how = How.CSS, using = "span.as-price-currentprice")
    private WebElement select_TotalPrice;
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[7]/div[2]/bundle-selection/div[3]/div[2]/div[2]/div/div[2]/div/bundle-selector/div[3]/div[2]/div/div[4]/form/div/span/button")
    private WebElement select_Product;
    @FindBy(how = How.XPATH, using = "//*[@id='sw_logic_pro_x_z0ue_065_c29h_2']")
    private WebElement select_LogicProX;
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[6]/div[1]/form/div[3]/div/div[2]/div/div/div[2]/button")
    private WebElement select_AddToBagButton;
    @FindBy(how = How.XPATH, using = "/html/body/div[3]/nav/div/ul[2]/li[9]/a")
    private WebElement select_SearchButton;
    @FindBy(how = How.XPATH, using = "//*[@id='ac-gn-searchform-input']")
    private WebElement select_SearchBox;
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div[3]/div[2]/div[2]/div/div[1]/div[4]/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[1]/img")
    private WebElement select_USBCToUSB;
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[6]/div/div[1]/div[1]/div/div[3]/div/ul/li[5]/form/div/div[1]/span/button")
    private WebElement select_AddToBagAccessories;
    @FindBy(how = How.ID, using = "cart-actions-checkout")
    private WebElement select_CheckoutButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[4]/div[3]/div[3]/div[2]/div/div/table/tr[9]/td[2]")
    private WebElement actual_ProductPrice;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[4]/div[3]/div[3]/div[2]/div/div/table/tr[12]/td/span[2]")
    private WebElement actual_VATPrice;


    public void click_15InchScreen(String monitorSize) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Choosen monitor size:" + monitorSize);
        select_15InchScreen.click();
    }

    public void click_SilverColour(String machineColour) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Choosen machine colour:" + machineColour);
        select_SilverColour.click();
    }

    public void click_Processor(String processorType) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Choosen processor type:" + processorType);

    }


    public void setSelect_Product() throws InterruptedException {
        Thread.sleep(3000);
        select_Product.click();

    }

    public void setSelect_LogicProX(String logixXPro) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Choosen software:" + logixXPro);
        select_LogicProX.click();
    }

    public void click_AddToBag() throws InterruptedException {
        Thread.sleep(2000);
        select_AddToBagButton.click();
        Thread.sleep(5000);
    }

    public void search_ForUSBCtoUSB(String accessories) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Choosen accessory:" + accessories);
        select_SearchButton.click();
        Thread.sleep(1000);
        select_SearchBox.click();
        Thread.sleep(1000);
        select_SearchBox.clear();
        Thread.sleep(1000);
        select_SearchBox.sendKeys(accessories);
        Thread.sleep(1000);
        select_SearchBox.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        select_USBCToUSB.click();
        Thread.sleep(1000);
        select_AddToBagAccessories.click();
        Thread.sleep(2000);
    }

    public void clickCheckoutButton() throws InterruptedException {
        Thread.sleep(2000);
        select_CheckoutButton.click();
        System.out.println("A user can now login and complete the checkout process");
    }

    public void buyMacBookPro(String machineName, String software, String adapater) throws InterruptedException {
        Thread.sleep(2000);
        select_15InchScreen.click();
        Thread.sleep(500);
        select_SilverColour.click();
        Thread.sleep(500);
        select_Product.click();
        Thread.sleep(3000);
        System.out.println("Choosen laptop:" + machineName);
        System.out.println("Choosen software:" + software);
        Thread.sleep(3000);
        select_LogicProX.click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,2500)", "");
        select_LogicProX.click();
        select_AddToBagButton.click();
        Thread.sleep(2000);
        select_SearchButton.click();
        select_SearchBox.click();
        select_SearchBox.clear();
        select_SearchBox.sendKeys("USB-C to USB Adapter");
        select_SearchBox.sendKeys(Keys.ENTER);
        select_USBCToUSB.click();
        select_AddToBagAccessories.click();
        System.out.println("Choosen adapater:" + adapater);
    }

    public void verify_ProductPrice() throws InterruptedException {
        Thread.sleep(2000);
        String productPrice = actual_ProductPrice.getText();
        if (productPrice.equals("£2,917.99")) {
            System.out.println("Product price is as expected" + productPrice);
        } else {
            System.out.println("Product price has changed" + productPrice);
        }
    }

    public void verify_VATPrice() throws InterruptedException {
        Thread.sleep(2000);
        String vatPrice = actual_VATPrice.getText();
        if (vatPrice.equals("Includes VAT of £486.34")) {
            System.out.println("Product price is as expected" + vatPrice);
        } else {
            System.out.println("Product price has changed" + vatPrice);
        }
    }
}
