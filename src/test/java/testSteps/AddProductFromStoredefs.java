package testSteps;

import apis.CartApi;
import constants.EndPoint;
import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.Product;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.PageFactoryManager;
import pages.StorePage;

public class AddProductFromStoredefs {
    private StorePage storePage;
    private CartPage cartPage;
    private TestContext context;

    public AddProductFromStoredefs(TestContext context) {
        this.context = context;
        storePage = PageFactoryManager.getStorePage(context.driver);
        cartPage = PageFactoryManager.getCartPage(context.driver);
    }



    @Given("I'm on the Store page")
    public void i_m_on_the_store_page() {
        storePage.load(EndPoint.STORE.url);
    }
    @When("I add a {product} to the cart")
    public void i_add_a_to_the_cart(Product productName){
        storePage.addToCart(productName.getName());
    }
    @Then("I see {int} {product} in the cart")
    public void i_see_in_the_cart(Integer quantityNumber, Product productName) {
        Assert.assertEquals(cartPage.getProductName(),productName.getName());
        Assert.assertEquals(cartPage.getQuantity(),quantityNumber);
    }

    @Given("I have already added( one) quantity/quantities")
    public void i_have_already_added_one_quantity() {
        // Write code here that turns the phrase above into concrete actions
        System.out.print("\nI have already added one quantity\n");
        CartApi cartApi = new CartApi(context.cookies.getCookies());
        cartApi.addToCart(1215, 1);
        context.cookies.setCookies(cartApi.getCookies());
        context.cookies.injectCookiesToBrowser(context.driver);
    }
    @When("I press Add to Cart")
    public void i_press_add_to_cart() {
        // Write code here that turns the phrase above into concrete actions
        System.out.print("\nI press Add to Cart\n");
    }
    @Then("I see number of {int} quantity in the cart")
    public void i_see_quantity_in_the_cart(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        System.out.print("\nI see product number quantity in the cart\n");
    }

    @Given("I'm on the Product page")
    public void i_m_on_the_product_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I add {int} Blue Shoes to the cart")
    public void i_add_blue_shoes_to_the_cart(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I see {int} Blue Shoes in the cart")
    public void i_see_blue_shoes_in_the_cart(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I enter zero quantity")
    public void i_enter_zero_quantity() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I see the warning message")
    public void i_see_the_warning_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I press up arrow")
    public void i_press_up_arrow() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the quantity increase by {int}")
    public void the_quantity_increase_by(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
