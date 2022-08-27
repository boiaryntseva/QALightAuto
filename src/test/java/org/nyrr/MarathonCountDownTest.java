package org.nyrr;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;

public class MarathonCountDownTest extends BaseTest {
    WebDriver webDriver;

//    TODO public MarathonCountDownTest(WebDriver webDriver) {
//        super (webDriver);
//    }

    @Test
    public void checkMarathonCountDownDays() throws ParseException {
        homePage.openHomepage().clickOnMarathonLink()
                .checkMarathonCountDownDays();
    }
}