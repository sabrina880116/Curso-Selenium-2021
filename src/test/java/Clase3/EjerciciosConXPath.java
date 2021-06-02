package Clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EjerciciosConXPath {
    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://go.docusign.com/o/trial/");
        driver.getTitle();
        return driver;
    }
    @Test
    public void completeDocusignRegistrationForm(){
                 WebDriver driver=getDriver();
                 driver.findElement(By.xpath("//input[@name=first_name]")).sendKeys("lola");
    }
}
