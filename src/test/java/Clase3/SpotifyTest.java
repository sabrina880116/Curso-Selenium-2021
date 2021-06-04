package Clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SpotifyTest {

    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/signup/");
        driver.getTitle();
        return driver;
    }

    @Test
    public void  spotifyByNameTest(){
        WebDriver driver= getDriver();


        driver.findElement(By.xpath("//input[@placeholder='Introduce tu correo electrónico.']")).sendKeys("alma2021@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("alma2021@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Crea una contraseña.']")).sendKeys("Alma2021*-+");
        driver.findElement(By.xpath("//input[@placeholder='Introduce un nombre de perfil.']")).sendKeys("Alma2021");

        driver.findElement(By.xpath("//input[@placeholder='DD']")).sendKeys("11");

        WebElement monthElement= driver.findElement(By.xpath("//select[@id='month']"));
        Select selectMonth=new Select (monthElement);
        selectMonth.selectByIndex(02);

       driver.findElement(By.xpath("//input[@placeholder='DD']")).sendKeys("2000");
       driver.findElement(By.xpath("//label[@for='gender_option_female']")).click();
       driver.findElement(By.xpath("(//*[@for='marketing-opt-checkbox'])[1]")).click();
        driver.findElement(By.xpath("(//*[@for='marketing-opt-checkbox'])[2]")).click();





    }


}
