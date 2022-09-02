package org.nyrr.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CalendarPage extends ParentPage{
    public CalendarPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy (xpath = ".//div[@class='card_group_full__item'][4]//span[@class='btn__inner']")
    private WebElement moreInfoLinkOfRightmostRace;

    public RacePage clickOnMoreInfoLinkOfRightmostRace(){
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(moreInfoLinkOfRightmostRace));
//        clickOnElement(moreInfoLinkOfRightmostRace);
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        js.executeScript("arguments[0].click();", moreInfoLinkOfRightmostRace);
        return new RacePage(webDriver);
    }
}
