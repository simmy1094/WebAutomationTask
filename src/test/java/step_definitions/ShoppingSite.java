package step_definitions;

import Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import shoppingSite_Page_Objects.CartPage;
import shoppingSite_Page_Objects.HomePage;
import shoppingSite_Page_Objects.WishListPage;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ShoppingSite extends Driver {
    CartPage cartPage = new CartPage(driver);
    WishListPage wishlistPage = new WishListPage(driver);
    HomePage homePage = new HomePage(driver);

    @Given("I add four different products to my wishlist")
    public void i_add_four_different_products_to_my_wishlist() throws IOException {
        homePage.addFourItemsToWishList(driver);
    }

    @When("I view my wishlist table")
    public void i_view_my_wishlist_table() throws IOException {
        homePage.clickOnWishList(driver);
    }

    @Then("I find total four selected items in my Wishlist")
    public void i_find_total_four_selected_items_in_my_wishlist() {

        assertEquals(wishlistPage.countItemInList(), 4);
    }

    @When("I search for lowest price product")
    public void i_search_for_lowest_price_product() throws IOException{

        wishlistPage.findLowestPriceProduct(driver);
    }

    @When("I am able to add the lowest price item to my cart")
    public void i_am_able_to_add_the_lowest_price_item_to_my_cart() throws IOException{
        wishlistPage.addLowestPriceProduct(driver);
    }

    @Then("I am able to verify the item in my cart")
    public void i_am_able_to_verify_the_item_in_my_cart() throws IOException {
        cartPage.verifyCart(driver);

    }

}
