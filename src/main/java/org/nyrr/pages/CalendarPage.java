package org.nyrr.pages;

import libs.TestData;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CalendarPage extends ParentPage{
    public CalendarPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy (xpath = ".//div[@class='card_group_full__item'][4]//span[@class='btn__inner']")
    private WebElement moreInfoLinkOfRightmostRace;



    @FindBy(xpath = ".//div[@class='card_group_full__item'][4]//div[@class='card__desc']")
    private WebElement dateOfRightmostRace;

    public WebElement getDateOfRightmostRace() {
        return dateOfRightmostRace;
    }

    //String dateOnCalendarPageOfRightMostRace = dateOfRightmostRace.getText();

    public RacePage clickOnMoreInfoLinkOfRightmostRace(){
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(moreInfoLinkOfRightmostRace));
//        clickOnElement(moreInfoLinkOfRightmostRace);
        String linkName = moreInfoLinkOfRightmostRace.getAccessibleName();
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        js.executeScript("arguments[0].click();", moreInfoLinkOfRightmostRace);
        logger.info(linkName + " was clicked");
        return new RacePage(webDriver);

    }

    public CalendarPage saveRaceDateFromCalendarPage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(dateOfRightmostRace));
        String expectedRaceDateOnCalendarPage = new HomePage(webDriver)
                .clickOnCalendarLink()
                .getDateOfRightmostRace().getText();
        String [] expectedRaceDateOnCalendarPageTrimmedArray = expectedRaceDateOnCalendarPage
                .split(",");

        StringBuilder expectedRaceDateOnCalendarTrimmed;
        expectedRaceDateOnCalendarTrimmed = new StringBuilder(expectedRaceDateOnCalendarPageTrimmedArray[1].trim());

        String leadingZero= expectedRaceDateOnCalendarTrimmed.substring(expectedRaceDateOnCalendarTrimmed.length()-2
                , expectedRaceDateOnCalendarTrimmed.length()-1);
        if (leadingZero.equalsIgnoreCase("0")){
            expectedRaceDateOnCalendarTrimmed.deleteCharAt(expectedRaceDateOnCalendarTrimmed.length()-2);
        }
        String expectedRaceDateInRightFormat=expectedRaceDateOnCalendarTrimmed.toString();
        TestData testData = new TestData();
        testData.setExpectedRaceDateFromCalendarPage(expectedRaceDateInRightFormat);
        logger.info("Race date on Calendar Page is " + expectedRaceDateInRightFormat);
        return this;
    }


}
