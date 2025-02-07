import com.shaft.driver.SHAFT;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.Platform;
import org.testng.annotations.*;

public class AppiumSampleTests {
    private SHAFT.GUI.WebDriver driver;
    private AppiumDriverLocalService service;

    @Test
    public void AppiumDemo() {
        new HomePage(driver)
                .navigateToViews();
        new ViewsPage(driver)
                .navigateToSpinner();
        new SpinnerPage(driver)
                .verifyColorFieldExists();
    }

    @BeforeClass
    public void beforeClassSetUp() {
        service = new AppiumServiceBuilder()
                .usingPort(Integer.parseInt(System.getProperty("port")))
                .withIPAddress(System.getProperty("ipAddress"))
                .withArgument(() -> System.getProperty("commandName"), AutomationName.ANDROID_UIAUTOMATOR2.toLowerCase())
                .build();
        service.start();

        System.setProperty("mobile_autoGrantPermissions", "true");

        // common attributes
        SHAFT.Properties.platform.set().targetPlatform(Platform.ANDROID.name());
        SHAFT.Properties.mobile.set().automationName(AutomationName.ANDROID_UIAUTOMATOR2);
        SHAFT.Properties.platform.set().executionAddress("127.0.0.1:4723");
        SHAFT.Properties.mobile.set().app("src/test/resources/testDataFiles/ApiDemos-debug.apk");
        SHAFT.Properties.mobile.set().deviceName("Medium Phone API 35");
    }

    @BeforeMethod
    public void beforeMethodSetUp() {
        driver = new SHAFT.GUI.WebDriver();
    }


    @AfterMethod
    public void afterMethodTearDown() {
        driver.quit();
    }

    @AfterClass
    public void afterClassTearDown() {
        service.close();
    }

}
