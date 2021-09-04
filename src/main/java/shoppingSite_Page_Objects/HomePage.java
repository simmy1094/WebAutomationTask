package shoppingSite_Page_Objects;

import Utilities.Screenshots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends Screenshots {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "(//li[1]/div/div[2]/div/div/a)[1]")
    private WebElement firstItem;

    @FindBy(how = How.XPATH, using = "(//li[2]/div/div[2]/div/div/a)[1]")
    private WebElement secondItem;

    @FindBy(how = How.XPATH, using = "(//li[3]/div/div[2]/div/div/a)[1]")
    private WebElement thirdItem;

    @FindBy(how = How.XPATH, using = "(//li[4]/div/div[2]/div/div/a)[1]")
    private WebElement fourthItem;

    @FindBy(how = How.XPATH, using = "(//*[@class='header-wishlist'])[1]")
    private WebElement verifyWishList;
    Screenshots screenshots = new Screenshots();

    public void addFourItemsToWishList(WebDriver driver) throws IOException {
        try {
            screenshots.takeScreenShot(driver);
            firstItem.isDisplayed();
            Thread.sleep(1000);
            firstItem.click();
            Thread.sleep(1000);
            secondItem.isDisplayed();
            secondItem.click();
            thirdItem.isDisplayed();
            Thread.sleep(1000);
            thirdItem.click();
            fourthItem.isDisplayed();
            Thread.sleep(1000);
            fourthItem.click();
            Thread.sleep(1000);

            screenshots.takeScreenShot(driver);
        } catch (Exception e) {
            screenshots.takeScreenShot(driver);
            e.printStackTrace();
        }

    }

    public void clickOnWishList(WebDriver driver) throws IOException {
        try {
            verifyWishList.click();
            screenshots.takeScreenShot(driver);
        } catch (Exception e){
            screenshots.takeScreenShot(driver);
            e.printStackTrace();
        }

    }

}
