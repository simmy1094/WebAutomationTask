package shoppingSite_Page_Objects;

import Utilities.Screenshots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class WishListPage {
    public WishListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//*[@class='wishlist-items-wrapper']/tr")
    private  List<WebElement> tableItems;

    @FindBy(how = How.XPATH, using = "//*[@class='product-price']")
    private List<WebElement> price;

    @FindBy(how = How.XPATH, using = "//div[@class=\"woocommerce-message\"]")
    private WebElement message;

    public int countItemInList(){
        return tableItems.size();

    }
    Screenshots screenshots = new Screenshots();
    public void findLowestPriceProduct(WebDriver driver) throws IOException
    {
        try{
            screenshots.takeScreenShot(driver);
            List<WebElement> productPrice = price;
            List<String> allValues = new ArrayList<>();
            for(int i=0;i<productPrice.size();i++) {
                String [] l1= productPrice.get(i).getText().replace("-", "").split(" ");
                for(int j=0; j<l1.length; j++){
                    allValues.add(l1[j].replace("£", ""));
                }
                Collections.sort(allValues);
            }
            driver.findElement(By.xpath("//*[contains(text(),'"+allValues.get(0)+"')]//following::td[2]")).click();
            Thread.sleep(1000);
        }catch (Exception e)
        {
            screenshots.takeScreenShot(driver);
            e.printStackTrace();
            driver.quit();
        }
    }

    public void addLowestPriceProduct(WebDriver driver) throws IOException{
        try{
            screenshots.takeScreenShot(driver);
            Thread.sleep(1000);
            message.isDisplayed();
            assertEquals(message.getText(), "Product added to cart successfully");
        }catch (Exception e){
            screenshots.takeScreenShot(driver);
            e.printStackTrace();
            driver.quit();
        }

    }
}
