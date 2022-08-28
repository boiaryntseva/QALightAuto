package org.nyrr.pages;

import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class ParentPage {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickOnElement(WebElement webElement){
        try {
            String name = webElement.getAccessibleName();
            webElement.click();
            logger.info(name + " was clicked");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
