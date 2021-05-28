package Clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RegistrationFacebookTest {

    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
       // driver.getTitle();
        return driver;
    }

    @Test
    public void fullRegistrationTest() throws InterruptedException {
        WebDriver driver = getDriver();

        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(2000);

        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("reg_email__")).sendKeys("5555555");
        driver.findElement(By.name("reg_passwd__")).sendKeys("123456789");
        setBirthdate(driver, "26", "Jun", "1988");

        List<WebElement> sexList = driver.findElements(By.name("sex"));
        Assert.assertEquals(sexList.size(), 3);

        WebElement selectMale = sexList.get(1);
        selectMale.click();
    }

    public void setBirthdate(WebDriver driver, String day, String month, String date) {

        WebElement elementMonths = driver.findElement(By.name("birthday_month"));
        Select selectMonths = new Select(elementMonths);
        selectMonths.selectByVisibleText(month);

        WebElement elementDays = driver.findElement(By.id("day"));
        Select selectDays = new Select(elementDays);
        selectDays.selectByValue(day);

        WebElement elementYears = driver.findElement(By.id("year"));
        Select selectYears = new Select(elementYears);
        selectYears.selectByValue(date);
    }
}
