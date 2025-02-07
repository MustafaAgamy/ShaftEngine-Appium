import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ViewsPage {
    private SHAFT.GUI.WebDriver driver;

    private final By spinner_tab = AppiumBy.accessibilityId("Spinner");

    public ViewsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Navigate To Spinner")
    public ViewsPage navigateToSpinner() {
        driver.touch().swipeElementIntoView("Spinner")
                .element().click(spinner_tab);
        return this;
    }
}
