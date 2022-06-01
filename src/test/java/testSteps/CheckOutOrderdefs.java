package testSteps;

import apis.CartApi;
import constants.EndPoint;
import context.TestContext;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.BillingDetails;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.PageFactoryManager;
import pages.StorePage;
import java.util.List;

public class CheckOutOrderdefs {
    private BillingDetails billingDetails;
    private StorePage storePage;
    private CheckoutPage checkoutPage;
    private CartPage cartPage;
    private TestContext context;

    public CheckOutOrderdefs(TestContext context) {
        this.context = context;
        storePage = PageFactoryManager.getStorePage(context.driver);
        checkoutPage =  PageFactoryManager.getCheckoutPage(context.driver);
        cartPage = PageFactoryManager.getCartPage(context.driver);
    }




    @Given("I'm a guest customer")
    public void iMGuestCustomer() {
        storePage.load(EndPoint.STORE.url);
        //new  StorePage(driver).load(EndPoint.STORE.url);
    }

    @Given("I have a product in the cart")
    public void iHaveProductInCart() {
        //storePage.addToCart("Blue Shoes");
        CartApi cartApi = new CartApi(context.cookies.getCookies());
        cartApi.addToCart(1215, 1);
        context.cookies.setCookies(cartApi.getCookies());
        context.cookies.injectCookiesToBrowser(context.driver);
    }

    @Given("I'm on the checkout page")
    public void iMOnCheckOutPage() {
        //cartPage.tapCheckOutBtn();
        checkoutPage.load(EndPoint.CHECKOUT.url);
    }

    @When("I provide billing details follow")
    public void provideBillingDetails(DataTable billingDetail) {
        List<String> billingDetails = billingDetail.row(1);
        System.out.print("FIRST NAME: " + billingDetails.get(0));
        checkoutPage.provideBillingDetails(
                billingDetails.get(0),
                billingDetails.get(1),
                billingDetails.get(2),
                billingDetails.get(3),
                billingDetails.get(4),
                billingDetails.get(5),
                billingDetails.get(6),
                billingDetails.get(7)
        );
    }

    @When("I place an order")
    public void placeOrder(){
        checkoutPage.placeOrder();
    }

    @Then("the order should be placed successfully")
    public void getOrderSuccessMess(){
        String mess =checkoutPage.getOrderSuccessMess();
        Assert.assertEquals(mess,"Thank you. Your order has been received.");
    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        this.billingDetails = billingDetails;
    }

    @When("I provide billing details at 2nd step")
    public void iProvideBillingDetailsAtNdStep() {
        checkoutPage.provideBillingDetails(
                billingDetails.getFirstName(),
                billingDetails.getLastName(),
                billingDetails.getCountry(),
                billingDetails.getAddress_line1(),
                billingDetails.getCity(),
                billingDetails.getState(),
                billingDetails.getZip(),
                billingDetails.getEmail()
        );
    }
}
