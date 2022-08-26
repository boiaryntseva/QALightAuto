package org.nyrr.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPage{
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openHomepage(){
        try {
            webDriver.get("https://www.nyrr.org/");
            logger.info("NYRR home page is opened");
        } catch (Exception e){
            logger.error(e);
        }
    }
}
