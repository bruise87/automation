import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task2 {
    WebDriver driver;
    WebDriverWait browserWait;

    @Test
    public void HomeWork2() {
        System.setProperty("webdriver.chrome.driver", "DriverChrom\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://2017.makemepulse.com/");
        String mainWindowHandle = driver.getWindowHandles().iterator().next();
        WebElement logo = driver.findElement(By.className("logo"));
        browserWait = new WebDriverWait(driver, 10);
        browserWait.until(ExpectedConditions.visibilityOf(logo));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        WebElement logoScript = (WebElement) javascriptExecutor.executeScript("return document.querySelector('.logo')");
        logoScript.click();
        sleep(10000);
        driver.switchTo().window(mainWindowHandle);
        browserWait.until(ExpectedConditions.visibilityOf(logo));
        WebElement logoHide =
                (WebElement) javascriptExecutor.executeScript("document.querySelector('.logo').setAttribute('class', 'display:none'); return document.querySelector('.logo')");
        WebElement dragCursor = driver.findElement(By.className("dragger-cursor"));
        Actions actions = new Actions(driver);
        shiftCursor(dragCursor, actions);
        WebElement glCanvas = browserWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gl-canvas")));
        sleep(2000);
        actions.clickAndHold(glCanvas).moveByOffset(-200, 0).moveByOffset(400, 0).build().perform();
        sleep(1000);
        shiftCursor(dragCursor, actions);
        sleep(1000);
        actions.click(glCanvas);
        sleep(2000);
        shiftCursor(dragCursor, actions);
        sleep(2000);
        actions.clickAndHold(glCanvas).pause(7000).release().perform();
        sleep(2000);
        shiftCursor(dragCursor, actions);
        sleep(2000);
        actions.dragAndDropBy(glCanvas, -300, 0).perform();
        sleep(3000);
        shiftCursor(dragCursor, actions);
        sleep(2000);
        actions.clickAndHold(glCanvas).pause(2000).perform();
        sleep(2000);
        shiftCursor(dragCursor, actions);
        sleep(3000);
        driver.close();

    }

    private void shiftCursor(WebElement dragCursor, Actions actions) {
        actions.dragAndDropBy(dragCursor, 250, 0).perform();

    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


