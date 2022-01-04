package com.solvd.gsm.services;

import com.solvd.gsm.HomePage;
import com.solvd.gsm.SearchPage;
import org.openqa.selenium.WebDriver;

public interface SearchPageServices {
    default SearchPage goToSearchPageWithGeneralResults(WebDriver driver, String search){
        HomePage homePage = new HomePage(driver);
        homePage.setInputSearch(search);
        SearchPage searchPage = homePage.clickGoButton();
        return searchPage;
    }
    default SearchPage goToSearchPageWithSpecificResult(WebDriver driver, String search){
        HomePage homePage = new HomePage(driver);
        homePage.setInputSearch(search);
        SearchPage searchPage = homePage.getSpecificSearch();
        return searchPage;
    }
}
