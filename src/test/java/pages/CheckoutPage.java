package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{
    @FindBy(id = "billing_first_name") private WebElement firstNameField;
    @FindBy(id = "billing_last_name") private WebElement lastNameField;
    @FindBy(id = "billing_country") private WebElement countryDropDown;
    @FindBy(id = "billing_address_1") private WebElement addressLine1Field;
    @FindBy(id = "billing_city") private WebElement cityField;
    @FindBy(id = "billing_state") private WebElement stateDropDown;
    @FindBy(id = "billing_postcode") private WebElement zipCodeField;
    @FindBy(id = "billing_email") private WebElement emailAddressField;
    @FindBy(id = "order_comments") private WebElement orderNoteTextBox;
    @FindBy(id = "place_order") private WebElement placeOrderBtn;
    @FindBy(css = ".woocommerce-notice") private WebElement informOrderSuccess;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName (String firstName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(firstNameField));
        e.clear();
        e.sendKeys(firstName);
    }

    public void enterLastName (String lastName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(lastNameField));
        e.clear();
        e.sendKeys(lastName);
    }

    public void selectCountry (String country){
        Select e = new Select(wait.until(ExpectedConditions.visibilityOf(countryDropDown)));
        e.selectByVisibleText(country);
    }

    public void enterStreetAddress (String address){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(addressLine1Field));
        e.clear();
        e.sendKeys(address);
    }

    public void enterCity (String city){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(cityField));
        e.clear();
        e.sendKeys(city);
    }

    public void selectState (String state){
        Select e = new Select(wait.until(ExpectedConditions.visibilityOf(stateDropDown)));
        e.selectByVisibleText(state);
    }

    public void enterZipCode (String zipCode){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(zipCodeField));
        e.clear();
        e.sendKeys(zipCode);
    }

    public void enterEmailAddress (String email){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(emailAddressField));
        e.clear();
        e.sendKeys(email);
    }

    public void enterNote (String note){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(orderNoteTextBox));
        e.clear();
        e.sendKeys(note);
    }

    public void provideBillingDetails (String firstName,String lastName, String country, String address, String city,
                                       String state, String zip, String mail){
        enterFirstName(firstName);
        enterLastName(lastName);
        selectCountry(country);
        enterStreetAddress(address);
        enterCity(city);
        selectState(state);
        enterZipCode(zip);
        enterEmailAddress(mail);
    }

    public void placeOrder (){
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
    }

    public String getOrderSuccessMess (){
        return wait.until(ExpectedConditions.visibilityOf(informOrderSuccess)).getText();
    }
}
