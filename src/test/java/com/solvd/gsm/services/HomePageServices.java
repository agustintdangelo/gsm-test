package com.solvd.gsm.services;

import com.solvd.gsm.HomePage;
import org.openqa.selenium.WebDriver;

public interface HomePageServices {
    default HomePage goToLoginSuccessfully(WebDriver driver, String email, String pwd) {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        homePage.setInputEmailLogin(email);
        homePage.setInputPasswordLogin(pwd);
        homePage.clickSubmitLoginButton();
        return homePage;
    }

    default HomePage goToLoginWithInvalidEmail(WebDriver driver, String email, String pwd) {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        homePage.setInputEmailLogin(email);
        homePage.setInputPasswordLogin(pwd);
        homePage.clickLoginButton();
        return homePage;
    }

    default HomePage goToLoginWithInvalidPassword(WebDriver driver, String email, String pwd){
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        homePage.setInputEmailLogin(email);
        homePage.setInputPasswordLogin(pwd);
        homePage.clickLoginButton();
        return homePage;
    }

    default HomePage goToLoginWithEmptyEmail(WebDriver driver, String pwd){
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        homePage.setInputPasswordLogin("password");
        homePage.clickLoginButton();
        return homePage;
    }

    default HomePage goToLoginWithEmptyPassword(WebDriver driver, String email){
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        homePage.setInputEmailLogin("agussabe10@hotmail.com");
        homePage.clickLoginButton();
        return homePage;
    }
}
