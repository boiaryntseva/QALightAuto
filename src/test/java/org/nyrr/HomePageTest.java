package org.nyrr;

import org.junit.Test;
import org.nyrr.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class HomePageTest extends BaseTest{
    WebDriver driver;

@Test
    public void openHomePage(){
    homePage
            .openHomepage()
            .clickOnMarathonLink();

}
}
