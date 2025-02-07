import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SpinnerPage {
    private SHAFT.GUI.WebDriver driver;

    private final By colorField = AppiumBy.accessibilityId("Color:");

    public SpinnerPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Verify Color Field Exists")
    public SpinnerPage verifyColorFieldExists() {
        driver.verifyThat().element(colorField).exists();
        return this;
    }
}
