package com.solvd.gsm;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//i[@class='head-icon icon-user-plus']")
    private ExtendedWebElement signUpButton;

    @FindBy(xpath = "//i[@class='head-icon icon-login']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//input[@id='topsearch-text']")
    private ExtendedWebElement inputSearch;

    @FindBy(xpath = "//input[@name='sEmail']")
    private ExtendedWebElement inputEmailLogin;

    @FindBy(xpath = "//input[@name='sPassword']")
    private ExtendedWebElement inputPasswordLogin;

    @FindBy(xpath = "//input[@id='nick-submit']")
    private ExtendedWebElement submitLoginButton;

    @FindBy(xpath = "//h3[text()='Login successful.']")
    private ExtendedWebElement loginSuccessMessage;

    @FindBy(xpath = "//p[text()='Reason: Wrong password.']")
    private ExtendedWebElement wrongPasswordMessage;

    @FindBy(xpath = "//p[text()='Reason: User record not found.']")
    private ExtendedWebElement wrongEmailMessage;

    @FindBy(xpath = "//i[@class='head-icon icon-signout'")
    public ExtendedWebElement logOutButton;

    @FindBy(xpath = "//div/form/div/div[@class='phone-results']/ul/li/a")
    private ExtendedWebElement specificResult;

    public HomePage(WebDriver driver) {
        super(driver);
        open();
    }

    public SignUpPage clickSignUpButton() {
        new WebDriverWait(driver, 7).until(ExpectedConditions.visibilityOf(signUpButton.getElement()));
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public void clickLoginButton() {
        new WebDriverWait(driver, 7).until(ExpectedConditions.visibilityOf(loginButton.getElement()));
        loginButton.click();
    }

    public void setInputEmailLogin(String emailLogin) {
        inputEmailLogin.type(emailLogin);
    }

    public void setInputPasswordLogin(String passwordLogin) {
        inputPasswordLogin.type(passwordLogin);
    }

    public void clickSubmitLoginButton() {
        submitLoginButton.click();
    }

    public String getLoginSuccessMessage() {
        return loginSuccessMessage.getText();
    }

    public String getWrongPasswordMessage(){
        return wrongPasswordMessage.getText();
    }

    public String getWrongEmailMessage(){
        return wrongEmailMessage.getText();
    }

    public SearchPage clickGoButton(){
        inputSearch.sendKeys(Keys.ENTER);
        return new SearchPage(driver);
    }

    public void setInputSearch(String search){
        inputSearch.type(search);
    }

    public SearchPage getSpecificSearch(){
        Actions actions = new Actions(driver);
        inputSearch.click();
        new WebDriverWait(driver, 12).until(ExpectedConditions.elementToBeClickable(specificResult.getElement()));
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER)).perform();
        return new SearchPage(driver);
    }
}
