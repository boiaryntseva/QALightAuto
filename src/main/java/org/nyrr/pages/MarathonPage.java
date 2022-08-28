package org.nyrr.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
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
}
