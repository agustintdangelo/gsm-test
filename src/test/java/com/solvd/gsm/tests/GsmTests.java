package com.solvd.gsm.tests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.gsm.HomePage;
import com.solvd.gsm.SearchPage;
import com.solvd.gsm.SignUpPage;
import com.solvd.gsm.services.HomePageServices;
import com.solvd.gsm.services.SearchPageServices;
import com.solvd.gsm.services.SignUpServices;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.*;

public class GsmTests implements IAbstractTest, SignUpServices, HomePageServices, SearchPageServices {
    @Test
    public void verifyWelcomeMessageSignUp(){
//        PostSignUpPage postSignUpPage = goToPostSignUpPageSuccessfully(getDriver());
        SignUpPage signUpPage = goToSignUpPageSuccessfully(getDriver(), "nuevoNickname123.", "pepi_1_2@gmail.com", "password");
        assertEquals(signUpPage.getAccountCreatedMessage(), "Your account was created.", "FATAL!, error");
    }

    @Test
    public void verifyInvalidEmail(){
        SignUpPage signUpPage = goToSignUpPageWithInvalidEmail(getDriver(), "ed90gardo12", "invalidemail@e","password");
        assertEquals(signUpPage.getInvalidEmailMessage(),"Reason: You need to provide valid email. invalidemail@o","FATAL!, error");
    }

    @Test
    public void verifyEmptyNameNotAllowed(){
        SignUpPage signUpPage = goToSignUpPageWithEmptyNickname(getDriver(), "ji89asd87@gmail.com", "password");
        assertEquals(signUpPage.getEmptyNicknameMessage(),"Reason: Your nickname should have between 2 and 20 symbols.","FATAL!, error, empty nicknames must be an error");
    }

    @Test
    public void verifyEmptyEmailNotAllowed(){
        SignUpPage signUpPage = goToSignUpPageWithEmptyEmail(getDriver(), "est187buin21", "password");
        assertFalse(signUpPage.isSubmitButtonClickable(), "FATAL!, The button is clickable, and it shouldn't be.");
    }

    @Test
    public void verifyLoginSucessfulMessage(){
        HomePage homePage = goToLoginSuccessfully(getDriver(), "agussabe10@hotmail.com", "password");
        assertEquals(homePage.getLoginSuccessMessage(), "Login successful.", "FATAL!, login wasn't successful.");
    }

    @Test
    public void verifyLoginWithWrongEmail(){
        HomePage homePage = goToLoginWithInvalidEmail(getDriver(), "agussabb10@hotmail.com", "password");
        assertEquals(homePage.getWrongEmailMessage(),"Reason: User record not found.","FATAL!, email is valid.");
    }

    @Test
    public void verifyLoginWithWrongPassword(){
        HomePage homePage = goToLoginWithInvalidPassword(getDriver(), "agussabe10@hotmail.com", "wrongpassword");
        assertEquals(homePage.getWrongPasswordMessage(), "Reason: Wrong password.","FATAL!, error password is valid");
    }

    @Test
    public void verifyLoginWithEmptyEmail(){
        HomePage homePage = goToLoginWithEmptyEmail(getDriver(), "password");
        assertFalse(homePage.logOutButton.isElementPresent(5), "FATAL!, log out button is clickable so email wasn't empty.");
    }

    @Test
    public void verifyLoginWithEmptyPassword(){
        HomePage homePage = goToLoginWithEmptyPassword(getDriver(), "agussabe10@hotmail.com");
        assertFalse(homePage.logOutButton.isElementPresent(15), "FATAL!, log out button is clickable so password wasn't empty.");
    }

    @Test
    public void verifyGeneralSearch(){
        String samsung = "Samsung";
        SearchPage searchPage = goToSearchPageWithGeneralResults(getDriver(), samsung);
        List<ExtendedWebElement> searchItems = searchPage.getAllGeneralResults();
        SoftAssert softAssert = new SoftAssert();
        for(ExtendedWebElement i : searchItems){
            System.out.println(i.getText());
            softAssert.assertTrue(StringUtils.containsIgnoreCase(i.getText(), samsung),"Invalid search results for " + i.getText());
        }
    }

    @Test
    public void verifySpecificSearch(){
        String phone = "samsung a72";
        SearchPage searchPage = goToSearchPageWithSpecificResult(getDriver(),phone);
        assertEquals(searchPage.getTitlePhone(),"Samsung Galaxy A72", "FATAL!, error");
    }
}
