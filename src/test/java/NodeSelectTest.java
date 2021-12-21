import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NodeSelectTest {

  private final static String HUB_URL = "http://localhost:4444/wd/hub";
  private final static String BROWSER_VERSION = "94.0.4606.81";

  @RepeatedTest(5)
  public void testNodeSelect() throws MalformedURLException {
    DesiredCapabilities options = new DesiredCapabilities();
    options.setCapability("browserName", "chrome");
    options.setCapability("version", BROWSER_VERSION);

    RemoteWebDriver driver = null;
    try {
      driver = new RemoteWebDriver(new URL(HUB_URL), options);
      assertEquals(BROWSER_VERSION, driver.getCapabilities().getBrowserVersion());
    } catch (Exception e) {
      e.printStackTrace();
      assertEquals(true, driver != null, "Driver is null");
    } finally {
      if (driver != null) {
        driver.quit();
      }
    }
  }
}
