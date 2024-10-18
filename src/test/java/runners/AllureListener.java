package runners;

import io.qameta.allure.Allure;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

import static Utilities.Driver.getDriver;

public class AllureListener implements StepLifecycleListener {

    @Override
    public void beforeStepStop(StepResult result) {
        if (result.getStatus() == Status.FAILED || result.getStatus() == Status.BROKEN) {
            WebDriver driver = getDriver();
            if (driver != null) {
                Allure.attachment("Error Message:", result.getStatusDetails().getMessage());
            }
            Allure.addAttachment("Screenshot:",
                    new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } else {

            if (true) {
                WebDriver driver = getDriver();
                if (driver != null) {
                    Allure.addAttachment("Screenshot:",
                            new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
                }
            }
        }
    }
}
