package utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReusableFunctions {

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

//    public static void waitForElementVisible(WebDriver driver, WebElement element, int timeoutInSeconds) {
//        waitForSeconds(500);
//        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }

    public static void waitForSeconds(int num) {
        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
