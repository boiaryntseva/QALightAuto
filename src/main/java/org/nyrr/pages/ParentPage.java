package org.nyrr.pages;

import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ParentPage {
    protected  WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected WebDriverWait webDriverWait;


    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
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
