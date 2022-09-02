package org.nyrr;

import org.junit.Test;

public class GroupTrainingDatesTest extends BaseTest{

    @Test

    public void verifyRegistrationOpenDateForNov_TC5(){
        homePage
                .openHomepage()
                .openGroupTrainingThroughTrainingTab()
                .clickOnSessionDates()
                .verifyRegistrationOpenDate();
    }
}
