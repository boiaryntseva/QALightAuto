package org.nyrr;

import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.nyrr.pages.HomePage;
import org.nyrr.pages.MarathonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver webDriver;
    protected HomePage homePage;
    protected MarathonPage marathonPage;

    /**
     * Rigorous Test :-)
     */
    @Before
    public void openUrl() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        homePage = new HomePage(webDriver);
        marathonPage = new MarathonPage(webDriver);

    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
