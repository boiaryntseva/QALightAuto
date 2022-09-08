package org.nyrr.pages;

import libs.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RacePage extends ParentPage{
    public RacePage(WebDriver webDriver) {
        super(webDriver);
    }
    CalendarPage calendarPage = new CalendarPage(webDriver);
    @FindBy(xpath = ".//li[1]//*[@class='race_detail-meta_list__value']")
    private WebElement raceDateOnRacePage;


    public RacePage saveActualRaceDateFromRacePage()  {
        webDriverWait.until(ExpectedConditions.visibilityOf(raceDateOnRacePage));
        String actualDate = raceDateOnRacePage.getText();
        String actualRaceDateTrimmedOnRacePage = actualDate.substring(0, actualDate.indexOf(","));

        TestData testData = new TestData();
        testData.setActualRaceDateFromRacePage(actualRaceDateTrimmedOnRacePage);

        logger.info("Race Date on Race Page is " + actualRaceDateTrimmedOnRacePage);
        return this;
    }
}
