package org.nyrr;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class MarathonResultsTest extends BaseTest {

    WebDriver webDriver;

    @Test

    public void marathonResultsShouldBeShownInAscendingOrder() {
        homePage.openHomepage()
                .clickOnMarathonLink(homePage.marathonLink)
                .open2021MarathonResults()
                .checkResultsSortingByPlace();
    }
}
