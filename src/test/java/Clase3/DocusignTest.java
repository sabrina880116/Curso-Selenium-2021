package Clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DocusignTest {
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
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("lola");
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("bell");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("lolabell@gmail.com");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("789654123");
        driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Teacher");

       // WebElement industry= driver.findElement(By.name("ds_industry"));
        WebElement industry= driver.findElement(By.xpath("//select[@name='ds_industry']"));
        Select selectIndustry= new Select(industry);
        selectIndustry.selectByValue("Education");
    }

    @Test
    public void  defaultxPath(){
        WebDriver driver=getDriver();
        driver.findElement(By.xpath("//*[@id='dsFormLabel_First_Name']/input")).sendKeys("lola");
        driver.findElement(By.xpath("//*[@id='dsFormLabel_Last_Name']/input")).sendKeys("bell");
        driver.findElement(By.xpath("//*[@id='dsFormLabel_Email']/input")).sendKeys("lolabell@gmail.com");
        driver.findElement(By.xpath("//*[@id='dsFormLabel_Phone']/input")).sendKeys("789654123");
        driver.findElement(By.xpath("//*[@id='dsFormLabel_Job_Title']/input")).sendKeys("Engineer");

        WebElement industry= driver.findElement(By.xpath("//*[@id='dsFormLabel_Industry']/select"));
        Select selectIndustry= new Select(industry);
        selectIndustry.selectByValue("Business Services");
    }

}
