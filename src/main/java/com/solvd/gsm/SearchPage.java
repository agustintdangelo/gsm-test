package com.solvd.gsm;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchPage extends AbstractPage {

    @FindBy (xpath = "//h1")
    private ExtendedWebElement phoneTitle;

    @FindBy (xpath = "//div[@class='makers']/ul/li/a")
    private List<ExtendedWebElement> specsResults;

    @FindBy(xpath = "//div[@id='reviews']/div/div/div/h3/a")
    private List<ExtendedWebElement> reviewsResults;

    @FindBy(xpath = "//div[@id='news']/div/div/a")
    private List<ExtendedWebElement> newsResults;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<ExtendedWebElement> getAllGeneralResults(){
        return Stream.of(specsResults,reviewsResults,newsResults).flatMap(x->x.stream()).collect(Collectors.toList());
    }

    public String getTitlePhone(){
        return phoneTitle.getText();
    }
}
