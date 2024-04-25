package TestPackage;

import com.shaft.driver.SHAFT;
import org.testng.annotations.*;

public class TestBase {

    public static SHAFT.GUI.WebDriver driver;
    private final String URL = System.getProperty("baseUrl");

    @BeforeSuite(description = "Setup Browser instance.")
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL(URL);
    }

    @AfterSuite(description = "Tear down Browser instance.")
    public void afterMethod() {
        driver.browser().closeCurrentWindow();
    }
}
