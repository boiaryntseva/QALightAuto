package org.nyrr.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class MarathonPage extends ParentPage {
    public MarathonPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//*[@data-countdown-days]")
    private WebElement daysCountdown;

    @FindBy(xpath = ".//li[@data-dropdown-id='header_dropdown0'][5]//a[@href='#']")
    public WebElement resultsLink;

    @FindBy(xpath = ".//li//a[@href='/tcsnycmarathon/results/race-results']")
    public WebElement raceResultsLink;


    @FindBy(xpath = " .//a[@href='https://results.nyrr.org/event/M2021/finishers']")
    //@FindBy(xpath = ".//section[@class='story_detail__text story_detail__text--with_title']//ul[1]//li[1]")
    public WebElement year2021Results;

    //@FindBy(xpath = ".//div[@class='cookies__inner']")
    @FindBy(xpath = ".//a[@href='javascript:void(0);']")
    public WebElement acceptCookies;

    public void checkMarathonCountDownDays() throws ParseException {
        String actualDaysCount = daysCountdown.getText().trim();
        // System.out.println(actualDaysCount);
        try {
            LocalDate todaysDate = LocalDate.now();
            LocalDate marathonDate = LocalDate.parse("2022-11-06");

            long daysDiff = ChronoUnit.DAYS.between(todaysDate, marathonDate) - 1;
            String expectedDaysTillMarathon = String.valueOf(daysDiff);
            //    System.out.println(todaysDate);
            Assert.assertEquals(actualDaysCount, expectedDaysTillMarathon);
            logger.info(String.format("Expected days till marathon %s , displayed value " +
                    "is %s", expectedDaysTillMarathon, actualDaysCount));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public MarathonResultsPage open2021MarathonResults() {
        //TODO add wait before cookies
        clickOnElement(resultsLink);
        clickOnElement(raceResultsLink);
//        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(year2021Results));//       Thread.sleep(5000);
//        Actions actions = new Actions(webDriver);
//        actions.moveToElement(year2021Results);
//        actions.click(year2021Results).build().perform();
        clickOnElement(acceptCookies);
        clickOnElement(year2021Results);

        return new MarathonResultsPage(webDriver);
    }
}
