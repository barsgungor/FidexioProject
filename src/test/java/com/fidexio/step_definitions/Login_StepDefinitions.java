package com.fidexio.step_definitions;

import com.fidexio.pages.LoginPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("login.url"));
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {
        loginPage.usernameInput.sendKeys(username);
    }
    @When("user enters password {string}")
    public void user_enters_password(String password) {
        loginPage.passwordInput.sendKeys(password);
    }


    @When("user clicks on the log in button")
    public void user_clicks_on_the_log_in_button() {
        loginPage.loginButton.click();
    }
    @Then("user should see the inbox page")
    public void user_should_see_the_inbox_page() {
        BrowserUtils.waitFor(5);
        Assert.assertEquals("#Inbox - Odoo", Driver.getDriver().getTitle());
    }

    @Then("user should see the {string} message")
    public void user_should_see_the_message(String message) {
        Assert.assertTrue(loginPage.wrongLogin.getText().contains(message));
    }

    @Then("user should see the alert")
    public void user_should_see_the_alert() {
        Assert.assertEquals("true",loginPage.usernameInput.getAttribute("required"));
        Assert.assertEquals("true", loginPage.passwordInput.getAttribute("required"));

    }

    @Then("user should not be able to see the password")
    public void user_should_not_be_able_to_see_the_password() {
        Assert.assertTrue(loginPage.passwordInput.getAttribute("type").equals("password"));
    }

    @When("user clicks on the enter key")
    public void user_clicks_on_the_enter_key() {
        loginPage.passwordInput.sendKeys(Keys.ENTER);
    }

}
