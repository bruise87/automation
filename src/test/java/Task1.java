import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Task1 {
    WebDriver driver;
    @Test
    public void RandomPassNotEqual() {
        System.setProperty("webdriver.chrome.driver", "DriverChrom\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://passwordsgenerator.net/ru/");
        WebElement generateBtn = driver.findElement(By.xpath("//div[@class='button GenerateBtn']"));
        generateBtn.click();
        WebElement findPass = driver.findElement(By.id("final_pass"));
        String firstPassword = findPass.getAttribute("value");
        Assert.assertNotEquals("", firstPassword);
        generateBtn.click();
        String secondPassword = findPass.getAttribute("value");
        Assert.assertNotEquals(firstPassword, secondPassword);
        driver.findElement(By.id("Symbols")).click();
        WebElement selectElem = driver.findElement(By.id("pgLength"));
        Select select = new Select(selectElem);
        select.selectByValue("22");
        generateBtn.click();
        String thirdPassword = findPass.getAttribute("value");
        Assert.assertEquals(22, thirdPassword.length());
    }

    @After
    public void affterAll() {
        driver.quit();
    }
}

