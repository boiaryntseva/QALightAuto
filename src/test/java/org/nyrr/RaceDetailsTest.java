package org.nyrr;

import libs.TestData;
import org.junit.Assert;
import org.junit.Test;

public class RaceDetailsTest extends BaseTest {
    TestData testData = new TestData();


    @Test
    public void checkRaceDetailsInformation_TC4() {

        homePage
                .openHomepage()
                .clickOnCalendarLink()
                .saveRaceDateFromCalendarPage()
                .clickOnMoreInfoLinkOfRightmostRace()
                .saveActualRaceDateFromRacePage()
                .checkRaceLocationIsNotEmpty()
                .checkHashTagIsNotEmpty()
                .checkDistanceDetails()
                .checkRegisterButton();
        Assert.assertEquals(testData.getExpectedRaceDateFromCalendarPage()
                , testData.getActualRaceDateFromRacePage());


    }
}
