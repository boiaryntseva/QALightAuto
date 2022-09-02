package org.nyrr;

import org.junit.Test;

public class MarathonResultsTest extends BaseTest {

    @Test

    public void marathonResultsShouldBeShownInAscendingOrder_TC2() {
        homePage.openHomepage()
                .clickOnMarathonLink()
                .open2021MarathonResults()
                .checkResultsSortingByPlace();
    }

    @Test
    public void marathonResultsShouldShow51Result_TC3() {
        homePage.openHomepage()
                .clickOnMarathonLink()
                .open2021MarathonResults()
                .checkNumberOfResultsShown();
    }
}
