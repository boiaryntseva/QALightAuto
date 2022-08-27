package org.nyrr;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class GroupTrainingDatesTest extends BaseTest{
    WebDriver webDriver;

    @Test

    public void verifyRegistrationOpenDateForNov (){
        homePage
                .openHomepage()
                .clickOnGroupTraining()
                .verifyRegistrationOpenDate();
    }
}
