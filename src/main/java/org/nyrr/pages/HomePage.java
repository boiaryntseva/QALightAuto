package org.nyrr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = ".//li//a[@href='/tcsnycmarathon']")
    public WebElement marathonLink;

    public HomePage openHomepage(){
        try {
            webDriver.get("https://www.nyrr.org/");
            logger.info("NYRR home page is opened");
        } catch (Exception e){
            logger.error(e);
        }
        return this;
    }

    public MarathonPage clickOnMarathonLink(){
        marathonLink.click();
        logger.info("Marathon link was clicked");
        return new MarathonPage(webDriver);

    }
}
