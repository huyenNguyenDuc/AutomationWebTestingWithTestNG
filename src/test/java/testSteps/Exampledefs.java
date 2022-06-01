package testSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Exampledefs {
    @Given("my bank account balance is ${int}")
    public void my_bank_account_balance_is_$(Integer int1) {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("I withdraw ${int}")
    public void i_withdraw_$(Integer int1) {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("the withdraw process should be successfully")
    public void the_withdraw_process_should_be_successfully() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("the bank account balance should be ${int}")
    public void the_bank_account_balance_should_be_$(Integer int1) {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("the warning message should be shown")
    public void theWarningMessageShouldBeShown() {
        
    }

    @And("the withdraw process should be stopped")
    public void theWithdrawProcessShouldBeStopped() {

    }

    @And("the below mess should be shown")
    public void theBelowMessShouldBeShown(String mess) {
        System.out.print("The Message displays: " + mess);
    }
}
