package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class CartElevenia {
    WebDriver driver;
    @Given("I navigate to {string}")
    public void iNavigateTo(String website) throws InterruptedException {
        final String dir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(website);
        Thread.sleep(1000);

        if(!driver.findElements(By.id("mainPopBanner")).isEmpty()){
            driver.findElement(By.className("closeBtnMainPromo")).click();
        }
    }
    @And("I enter {string} into input field having xpath {string}")
    public void iEnterIntoInputFieldHavingXpath(String keyword, String search_xpath) {
        driver.findElement(By.xpath(search_xpath)).sendKeys(keyword);
    }

    @And("I click button search having xpath {string}")
    public void iClickButtonSearchHavingXpath(String button_search) {
        driver.findElement(By.xpath(button_search)).click();
    }

    @And("I click sort by most buying having xpath {string}")
    public void iClickSortByMostBuyingHavingXpath(String button_sort) {
        driver.findElement(By.xpath(button_sort)).click();
    }
    @And("I click product having xpath {string}")
    public void iClickProductHavingXpath(String product) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;

        driver.findElement(By.xpath(product)).click();
    }

    @And("I enter {string} into input field having id {string}")
    public void iEnterIntoInputFieldHavingId(String qty_product, String input_qty) {
        driver.findElement(By.id(input_qty)).clear();
        driver.findElement(By.id(input_qty)).sendKeys(qty_product);
    }

    @And("I click button add to cart having xpath {string}")
    public void iClickButtonAddToCartHavingXpath(String button_add_cart) {
        driver.findElement(By.xpath(button_add_cart)).click();
    }

    @And("I check cart")
    public void iCheckCart() {
        if(!driver.findElements(By.id("mo_lay144")).isEmpty()){

            driver.findElement(By.xpath("//*[@id=\'mo_lay144\']/div[2]/a[1]")).click();
        }else{
            driver.get("https://www.elevenia.co.id/cart/CartAction/getCartList.do");
        }
    }

    @And("I click Change Delivery having name {string}")
    public void iClickChangeDeliveryHavingName(String button_change_delivery) {
        driver.findElement(By.name(button_change_delivery)).click();
    }

    @And("I click cancel by xpath {string}")
    public void iClickCancelByXpath(String button_cancel) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().frame(4);
        if(!driver.findElements(By.className("kurirPop")).isEmpty()) {
            System.out.println("ada");
            WebElement button_cncl = driver.findElement(By.xpath(button_cancel));
            button_cncl.click();
        }else{
            System.out.println("gaada");
        }
    }

    @And("I click delete by xpath {string}")
    public void iClickDeleteByXpath(String button_delete) {
        driver.switchTo().parentFrame();

        driver.findElement(By.xpath(button_delete)).click();
    }

    @When("I click yes on delete pop up by id {string}")
    public void iClickYesOnDeletePopUpById(String button_yes) {
        driver.findElement(By.id(button_yes)).click();
    }

    @Then("Show note Empty Cart")
    public void showNoteEmptyCart() {
        String note_cart = driver.findElement(By.xpath("//*[@id=\'frmTmall\']/table/tbody/tr/td")).getText();
        System.out.println(note_cart);


    }



}
