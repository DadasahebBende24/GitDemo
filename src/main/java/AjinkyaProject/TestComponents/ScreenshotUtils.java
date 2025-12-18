package AjinkyaProject.TestComponents;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class ScreenshotUtils {
    public static String takeScreenshot(WebDriver driver, String testCaseName) throws IOException {
        if (driver == null) {
            throw new IOException("WebDriver instance is null - cannot take screenshot for: " + testCaseName);
        }
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
            FileUtils.copyFile(source, file);
            return file.getAbsolutePath();
        } catch (WebDriverException wde) {
            // driver may be quit/closed, or session invalid
            throw new IOException("Unable to capture screenshot - WebDriver error: " + wde.getMessage(), wde);
        }
    }
}