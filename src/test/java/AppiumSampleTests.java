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

    //Before Class To Set up the Service And Properties
    @BeforeClass
    public void beforeClassSetUp() {
        service = new AppiumServiceBuilder()
                //The Port for the Service, on must match it with the executionAddress port
                .usingPort(Integer.parseInt(System.getProperty("port")))
                //The IP Address for the Service, on must match it with the executionAddress Address
                .withIPAddress(System.getProperty("ipAddress"))
                //To Add Special Arguments to the running Appium Service
                //This command will run the service on UiAutomator2
                .withArgument(() -> System.getProperty("commandName"), AutomationName.ANDROID_UIAUTOMATOR2.toLowerCase())
                .build();
        service.start();

        System.setProperty("mobile_autoGrantPermissions", "true");

        //common attributes, set them according to your needs
        //Note that you can also add the value to the custom.properties file, for more info visit:
        //https://shafthq.github.io/docs/Properties/PropertiesList#mobile
        //https://shafthq.github.io/docs/Properties/PropertiesList#platform
        SHAFT.Properties.platform.set().targetPlatform(Platform.ANDROID.name());
        SHAFT.Properties.mobile.set().automationName(AutomationName.ANDROID_UIAUTOMATOR2);
        SHAFT.Properties.platform.set().executionAddress("127.0.0.1:4723");
        SHAFT.Properties.mobile.set().app("src/test/resources/testDataFiles/ApiDemos-debug.apk");
        SHAFT.Properties.mobile.set().deviceName("Medium Phone API 35");
    }

    //Before Method To Set up the SHAFT driver
    @BeforeMethod
    public void beforeMethodSetUp() {
        driver = new SHAFT.GUI.WebDriver();
    }

    //After Method To Quit the Running Driver instance
    @AfterMethod
    public void afterMethodTearDown() {
        driver.quit();
    }

    //After Method To Quit the Running Service instance
    @AfterClass
    public void afterClassTearDown() {
        service.close();
    }

}
