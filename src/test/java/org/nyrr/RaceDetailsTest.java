package org.nyrr;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class RaceDetailsTest extends BaseTest{

    WebDriver webDriver;

    @Test
    public void checkRaceDetailsInformation(){

        homePage
                .openHomepage()
                .clickOnCalendarLink()
                .clickOnMoreInfoLinkOfRightmostRace();
    }
}
