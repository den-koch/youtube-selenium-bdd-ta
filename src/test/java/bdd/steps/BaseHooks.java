package bdd.steps;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
public class BaseHooks {

    protected ThreadLocal<WebDriver> driver;

    @Before
    public void setUp(Scenario scenario) {
        log.info("Initializing the WebDriver...");
        driver = DriverManager.getDriver();
        log.info("WebDriver for scenario \"{}\" initialized successfully.", scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        log.info("Tearing down the WebDriver...");
        DriverManager.closeDriver();
        log.info("WebDriver for scenario \"{}\" removed successfully.", scenario.getName());
    }

}
