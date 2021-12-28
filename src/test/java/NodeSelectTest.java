import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@Slf4j
public class NodeSelectTest {

  private final static String HUB_URL = "http://localhost:4444/wd/hub";

  @RepeatedTest(5)
  public void testNodeSelect() {
    RemoteWebDriver driver = null;
    try {
      ChromeOptions options = new ChromeOptions();
      log.info("Creating remote driver");
      driver = new RemoteWebDriver(new URL(HUB_URL), options);
      log.info("Chrome remote created");
    } catch (Exception e) {
      assertEquals(true, driver != null, "Driver is null");
    } finally {
      if (driver != null) {
        log.info("Destroying driver");
        driver.quit();
        log.info("Driver destroyed");
      }
    }
  }
}
