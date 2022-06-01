package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{
    @FindBy(css = "td[class='product-name'] a") private WebElement productNameField;
    @FindBy (css = "input[type=\"number\"]") private WebElement quantityField;
    @FindBy (css = ".checkout-button") private WebElement proceedToCheckOutBtn;
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName (){
        return wait.until(ExpectedConditions.visibilityOf(productNameField)).getText();
    }

    public Integer getQuantity (){
        return Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(quantityField)).getAttribute("value"));
    }

    public void tapCheckOutBtn (){
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckOutBtn)).click();
    }
}
