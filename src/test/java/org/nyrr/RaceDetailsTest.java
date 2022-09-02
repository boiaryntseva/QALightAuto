package org.nyrr;

import org.junit.Test;

public class RaceDetailsTest extends BaseTest{


    @Test
    public void checkRaceDetailsInformation_TC4(){

        homePage
                .openHomepage()
                .clickOnCalendarLink()
                .clickOnMoreInfoLinkOfRightmostRace();
    }
}
