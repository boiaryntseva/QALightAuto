package org.nyrr.pages;

import libs.TestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GroupTrainingPage extends ParentPage {

    public GroupTrainingPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//table[@class='table']//tr[.//td[contains(text(), 'Nov. 15–Dec. 22')]]//td[2]")
    private WebElement registrationDateForTraining;

    @FindBy(xpath = ".//article[@class='intro_with_media'][1]//div[1]//div[@class='story_detail_accordion'][3]")
    private WebElement sessionDates;

    public GroupTrainingPage clickOnSessionDates(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(sessionDates));
        clickOnElement(sessionDates);
        return this;
    }
    public void verifyRegistrationOpenDate(){
        String registrationDate = registrationDateForTraining.getAttribute("innerHTML")
                .replaceAll("&nbsp;","");
        System.out.println(registrationDate);
        Assert.assertEquals(TestData.REGISTRATION_DATE, registrationDate);
    }
}
