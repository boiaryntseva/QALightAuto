package org.nyrr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//li//a[@href='/tcsnycmarathon']")
    private WebElement marathonLink;

    @FindBy(xpath = ".//*[@data-currentnav-regex='/train']")
    private WebElement trainingLink;

    @FindBy(xpath = ".//*[@id='portal']//ul[5]//li[3]")
    private WebElement groupTrainingLink;

    @FindBy(xpath = ".//a[@href='/run/race-calendar'][2]")
    private WebElement calendarLink;

    public HomePage openHomepage() {
        try {
            webDriver.get("https://www.nyrr.org/");
            logger.info("NYRR home page is opened");
        } catch (Exception e) {
            logger.error(e);
        }
        return this;
    }

    public MarathonPage clickOnMarathonLink() {
//        marathonLink.click();
//        logger.info("Marathon link was clicked");
        clickOnElement(marathonLink);
        return new MarathonPage(webDriver);

    }

    public GroupTrainingPage openGroupTrainingThroughTrainingTab() {
        trainingLink.click();
        groupTrainingLink.click();
//        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(groupTrainingLink)).click();
        logger.info("Group training is clicked ");
        return new GroupTrainingPage(webDriver);
    }

    public CalendarPage clickOnCalendarLink() {
        clickOnElement(calendarLink);
        return new CalendarPage(webDriver);
    }
}
