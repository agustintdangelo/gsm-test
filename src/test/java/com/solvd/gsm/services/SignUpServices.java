package com.solvd.gsm.services;

import com.solvd.gsm.HomePage;
import com.solvd.gsm.SignUpPage;
import org.openqa.selenium.WebDriver;

public interface SignUpServices {
    default SignUpPage goToSignUpPageSuccessfully(WebDriver driver, String nickname, String email, String pwd){
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = homePage.clickSignUpButton();
        signUpPage.setNicknameSignUp(nickname);
        signUpPage.setEmailSignUp(email);
        signUpPage.setInputPassword(pwd);
        signUpPage.clickIAgreeButton1();
        signUpPage.clickIAgreeButton2();
        signUpPage.clickSubmitButton();
        return signUpPage;
    }
    default SignUpPage goToSignUpPageWithEmptyEmail(WebDriver driver, String nickname, String pwd){
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = homePage.clickSignUpButton();
        signUpPage.setNicknameSignUp(nickname);
        signUpPage.setInputPassword(pwd);
        signUpPage.clickIAgreeButton1();
        signUpPage.clickIAgreeButton2();
        return signUpPage;
    }

    default  SignUpPage goToSignUpPageWithEmptyNickname(WebDriver driver, String email, String pwd){
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = homePage.clickSignUpButton();
        signUpPage.setEmailSignUp(email);
        signUpPage.setInputPassword(pwd);
        signUpPage.clickIAgreeButton1();
        signUpPage.clickIAgreeButton2();
        signUpPage.clickSubmitButton();
        return signUpPage;
    }

    default SignUpPage goToSignUpPageWithInvalidEmail(WebDriver driver, String nickname, String email, String pwd){
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = homePage.clickSignUpButton();
        signUpPage.setNicknameSignUp(nickname);
        signUpPage.setEmailSignUp(email);
        signUpPage.setInputPassword(pwd);
        signUpPage.clickIAgreeButton1();
        signUpPage.clickIAgreeButton2();
        signUpPage.clickSubmitButton();
        return signUpPage;
    }
}
