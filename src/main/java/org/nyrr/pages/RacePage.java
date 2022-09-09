package org.nyrr.pages;

import com.beust.ah.A;
import libs.TestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Locale;

public class RacePage extends ParentPage {
    public RacePage(WebDriver webDriver) {
        super(webDriver);
    }

    CalendarPage calendarPage = new CalendarPage(webDriver);
    @FindBy(xpath = ".//li[1]//*[@class='race_detail-meta_list__value']")
    private WebElement raceDateOnRacePage;

    @FindBy(xpath = ".//li[2]//*[@class='race_detail-meta_list__value']")
    private WebElement raceLocation;

    @FindBy (xpath = ".//*[@class='race_detail-meta_list__value hashtag_value_size']")
    private WebElement hashTagDetails;
    
    @FindBy (xpath = ".//li[3]//*[@class='race_detail-meta_list__value']")
    private WebElement distanceDetails;

    @FindBy (xpath = ".//*[@id='registerButton']")
    private WebElement registerButton;


    public RacePage saveActualRaceDateFromRacePage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(raceDateOnRacePage));
        String actualDate = raceDateOnRacePage.getText();
        String actualRaceDateTrimmedOnRacePage = actualDate.substring(0, actualDate.indexOf(","));

        TestData testData = new TestData();
        testData.setActualRaceDateFromRacePage(actualRaceDateTrimmedOnRacePage);

        logger.info("Race Date on Race Page is " + actualRaceDateTrimmedOnRacePage);
        return this;
    }

    public RacePage checkRaceLocationIsNotEmpty() {
        Assert.assertFalse("Race location is empty", raceLocation.getText().isEmpty());
        logger.info("Race location is " + raceLocation.getText());
        return this;
    }

    public RacePage checkHashTagIsNotEmpty(){
        Assert.assertFalse("Hashtag is emty", hashTagDetails.getText().isEmpty());
        logger.info("Hashtag is " + hashTagDetails.getText());
        return this;
    }
    
    public RacePage checkDistanceDetails(){
        String distance = distanceDetails.getText();
        Assert.assertTrue(distance.toLowerCase().contains("miles") ||
                distance.toLowerCase().contains("kilometres"));
        logger.info("Distance is not empty and it is " + distanceDetails.getText());
        return this;
    }

    public RacePage checkRegisterButton () {
        Assert.assertTrue("Register button is absent",registerButton.isDisplayed());
        logger.info("Register button is present");
        return this;
    }
}
