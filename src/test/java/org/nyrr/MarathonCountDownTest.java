package org.nyrr;

import org.junit.Test;

import java.text.ParseException;

public class MarathonCountDownTest extends BaseTest {
    //    }

    @Test
    public void checkMarathonCountDownDays_TC1() throws ParseException {
        homePage
                .openHomepage()
                .clickOnMarathonLink()
                .checkMarathonCountDownDays();
    }
}