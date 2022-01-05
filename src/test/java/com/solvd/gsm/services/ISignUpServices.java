package com.solvd.gsm.services;

import com.solvd.gsm.HomePage;
import com.solvd.gsm.SignUpPage;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Random;

public interface ISignUpServices {
    int number = 0;

    default SignUpPage goToSignUpPageSuccessfully(WebDriver driver, HashMap<String, String> args){
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = homePage.clickSignUpButton();
        signUpPage.setNicknameSignUp(args.get("user"));
        signUpPage.setEmailSignUp(args.get("email"));
        signUpPage.setInputPassword(args.get("pass"));
        signUpPage.clickIAgreeButton1();
        signUpPage.clickIAgreeButton2();
        signUpPage.clickSubmitButton();
        return signUpPage;
    }
    default SignUpPage goToSignUpPageWithEmptyEmail(WebDriver driver, HashMap<String, String> args){
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = homePage.clickSignUpButton();
        signUpPage.setNicknameSignUp(args.get("user"));
        signUpPage.setInputPassword(args.get("pass"));
        signUpPage.clickIAgreeButton1();
        signUpPage.clickIAgreeButton2();
        return signUpPage;
    }

    default  SignUpPage goToSignUpPageWithEmptyNickname(WebDriver driver, HashMap<String, String> args){
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = homePage.clickSignUpButton();
        signUpPage.setEmailSignUp(args.get("email"));
        signUpPage.setInputPassword(args.get("pass"));
        signUpPage.clickIAgreeButton1();
        signUpPage.clickIAgreeButton2();
        signUpPage.clickSubmitButton();
        return signUpPage;
    }

    default SignUpPage goToSignUpPageWithInvalidEmail(WebDriver driver, HashMap<String, String> args){
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = homePage.clickSignUpButton();
        signUpPage.setNicknameSignUp(args.get("user"));
        signUpPage.setEmailSignUp("invalidemail@a");
        signUpPage.setInputPassword(args.get("pass"));
        signUpPage.clickIAgreeButton1();
        signUpPage.clickIAgreeButton2();
        signUpPage.clickSubmitButton();
        return signUpPage;
    }
}
