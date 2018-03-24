package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pageObjects.MacBookPro15InchPage;

import java.util.List;
import java.util.Map;

public class BuyMacBookProStepDefs {
    WebDriver driver;
    WebDriverManager webdrivermanager;
    PageObjectManager pageobjectmanager;
    MacBookPro15InchPage macBookPro15InchPage;
    @Given("^I go to the website$")
    public void iGoToTheWebsite() throws Throwable {
        webdrivermanager = new WebDriverManager();
        driver = webdrivermanager.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.apple.com/uk/");
    }

    @When("^I choose a MacBook Pro with the following features and accessories$")
    public void iChooseAMacBookProWithTheFollowingFeaturesAndAccessories(DataTable featuresandaccessories) throws Throwable {
        driver.get("https://www.apple.com/uk/shop/buy-mac/macbook-pro");
        System.out.println("User navigating to Mac book pro product page");
        List<Map<String,String>> spec = featuresandaccessories.asMaps(String.class,String.class);
        pageobjectmanager = new PageObjectManager(driver);
        macBookPro15InchPage = pageobjectmanager.getMacBookPro15InchPage();
        macBookPro15InchPage.click_15InchScreen(spec.get(0).get("Specification"));
        macBookPro15InchPage.click_SilverColour(spec.get(1).get("Specification"));
        macBookPro15InchPage.click_Processor(spec.get(2).get("Specification"));
        macBookPro15InchPage.setSelect_Product();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,2000)", "");
        macBookPro15InchPage.setSelect_LogicProX(spec.get(3).get("Specification"));
        macBookPro15InchPage.click_AddToBag();
        macBookPro15InchPage.search_ForUSBCtoUSB(spec.get(4).get("Specification"));
    }

    @Then("^I can place an order for it.$")
    public void iCanPlaceAnOrderForIt() throws Throwable {
        macBookPro15InchPage.clickCheckoutButton();
        driver.quit();
    }

    @Given("^when I choose the following items:$")
    public void whenIChooseTheFollowingItems(DataTable items) throws Throwable {
        webdrivermanager = new WebDriverManager();
        driver = webdrivermanager.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.apple.com/uk/");
        driver.get("https://www.apple.com/uk/shop/buy-mac/macbook-pro");
        System.out.println("User navigating to Mac book pro product page");
        List<Map<String,String>> spec = items.asMaps(String.class,String.class);
        pageobjectmanager = new PageObjectManager(driver);
        macBookPro15InchPage = pageobjectmanager.getMacBookPro15InchPage();
        macBookPro15InchPage.click_15InchScreen(spec.get(0).get("Option"));
        macBookPro15InchPage.click_SilverColour("");
        macBookPro15InchPage.click_Processor("");
        macBookPro15InchPage.setSelect_Product();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,2000)", "");
        macBookPro15InchPage.setSelect_LogicProX(spec.get(1).get("Option"));
        macBookPro15InchPage.click_AddToBag();
        macBookPro15InchPage.search_ForUSBCtoUSB("USB-C to USB Adapter");
    }

    @When("^I proceed to the checkout$")
    public void iProceedToTheCheckout() throws Throwable {
        System.out.println("I am currently on the checkout page");
    }
    @Then("^a total price of £2917.99 will be displayed$")
    public void a_total_price_of_291799_will_be_displayed() throws Throwable {
        macBookPro15InchPage.verify_ProductPrice();
    }

    @And("^£486.34 will be listed for VAT.$")
    public void a_VATPRICE_will_be_listed_for_vat() throws Throwable {
        macBookPro15InchPage.verify_VATPrice();
        driver.quit();
    }

}
