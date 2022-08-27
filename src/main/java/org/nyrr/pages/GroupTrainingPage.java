package org.nyrr.pages;

import libs.TestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GroupTrainingPage extends ParentPage {

    public GroupTrainingPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//table[@class='table']//tr[.//td[contains(text(), 'Nov. 15–Dec. 22')]]//td[2]")
    private WebElement registrationDateForTraining;

    public void verifyRegistrationOpenDate(){
        String registrationDate = registrationDateForTraining.getAttribute("innerHTML")
                .replaceAll("&nbsp;","");
        System.out.println(registrationDate);
        Assert.assertEquals(TestData.REGISTRATION_DATE, registrationDate);
    }
}
