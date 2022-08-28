package org.nyrr;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;

public class MarathonCountDownTest extends BaseTest {
    WebDriver webDriver;
//    }

    @Test
    public void checkMarathonCountDownDays() throws ParseException {
        homePage.openHomepage().clickOnMarathonLink(homePage.marathonLink)
                .checkMarathonCountDownDays();
    }
}