package org.nyrr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends ParentPage{
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = ".//li//a[@href='/tcsnycmarathon']")
    public WebElement marathonLink;

    @FindBy(xpath = ".//*[@data-currentnav-regex='/train']")
    public WebElement trainingLink;

    @FindBy(xpath = ".//*[@id='portal']//ul[5]//li[3]")
    public WebElement groupTrainingLink;

    public HomePage openHomepage(){
        try {
            webDriver.get("https://www.nyrr.org/");
            logger.info("NYRR home page is opened");
        } catch (Exception e){
            logger.error(e);
        }
        return this;
    }

    public MarathonPage clickOnMarathonLink( WebElement marathonLink){
//        marathonLink.click();
//        logger.info("Marathon link was clicked");
        clickOnElement(marathonLink);
        return new MarathonPage(webDriver);

    }

    public GroupTrainingPage clickOnGroupTraining(){
        trainingLink.click();
        groupTrainingLink.click();
//        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(groupTrainingLink)).click();
        logger.info("Group training is clicked ");
        return new GroupTrainingPage(webDriver);
    }
}
