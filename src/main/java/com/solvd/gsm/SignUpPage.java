package com.solvd.gsm;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends AbstractPage {

    @FindBy(xpath = "//h3[text()='Your account was created. ']")
    private ExtendedWebElement accountCreatedMessage;

    @FindBy(xpath = "//p[text()='Reason: You need to provide valid email. invalidemail@o']")
    private ExtendedWebElement invalidEmail;

    @FindBy(xpath = "//p[text()='Reason: Your nickname should have between 2 and 20 symbols.']")
    private ExtendedWebElement emptyNickname;

    @FindBy(xpath = "//form[@id='frmOpin']//input[@id='uname']")
    private ExtendedWebElement inputNickName;

    @FindBy(xpath = "//form[@id='frmOpin']//input[@name='sEmail']")
    private ExtendedWebElement inputEmail;

    @FindBy(xpath = "//form[@id='frmOpin']//input[@id='upass']")
    private ExtendedWebElement inputPassword;

    @FindBy(xpath = "//label[@for='iagree1']")
    private ExtendedWebElement iAgreeButton1;

    @FindBy(xpath = "//label[@for='iagree2']")
    private ExtendedWebElement iAgreeButton2;

    @FindBy(xpath = "//input[@class='button float-right']")
    private ExtendedWebElement submitButton;


    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setNicknameSignUp(String nickname) {
        inputNickName.type(nickname);
    }

    public void setEmailSignUp(String email) {
        inputEmail.type(email);
    }

    public void setInputPassword(String password) {
        inputPassword.type(password);
    }

    public void clickIAgreeButton1() {
        iAgreeButton1.click();
    }

    public void clickIAgreeButton2() {
        iAgreeButton2.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
//        return new PostSignUpPage(driver);
    }

    public String getAccountCreatedMessage() {
        return accountCreatedMessage.getText();
    }

    public String getInvalidEmailMessage() { return invalidEmail.getText(); }

    public String getEmptyNicknameMessage() { return emptyNickname.getText(); }

    public boolean isSubmitButtonClickable() { return submitButton.isClickable(); }
}
