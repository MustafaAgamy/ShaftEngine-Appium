import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage {
    private SHAFT.GUI.WebDriver driver;

    private final By preference_tab = AppiumBy.accessibilityId("Preference");
    private final By views_tab = AppiumBy.accessibilityId("Views");

    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Navigate To Views")
    public HomePage navigateToViews() {
        driver.element().click(views_tab);
        return this;
    }
}
