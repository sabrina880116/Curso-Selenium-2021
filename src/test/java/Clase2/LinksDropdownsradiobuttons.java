package Clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LinksDropdownsradiobuttons {

    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        return driver;
    }

    @Test
    public void forgotAccountTest() {
        WebDriver driver = getDriver();
        System.out.println("El titulo  de la pagina es:" + driver.getTitle());

        driver.findElement(By.linkText("Forgot Password?")).click();
        driver.get("https://www.facebook.com/login/identify/?ctx=recover&ars=facebook_login&from_login_screen=0");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Forgot Password | Can't Log In | Facebook", "Sesión contraseña");
        Assert.assertNotEquals(driver.getCurrentUrl(), ("https://www.facebook.com/"), "Deberias estar en otra url");

        driver.close();

    }

    @Test
    public void forgotAccountPartialLinkTest() {
        WebDriver driver = getDriver();
        System.out.println("El titulo  de la pagina es:" + driver.getTitle());

        driver.findElement(By.partialLinkText("Forgot")).click();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Forgot Password | Can't Log In | Facebook", "Sesión contraseña");
        //driver.close();

    }

    @Test
    public void customSalesforceLink() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");

        driver.findElement(By.linkText("Use Custom Domain")).click();
        driver.findElement(By.name("mydomain")).sendKeys("as");
        driver.findElement(By.id("mydomainContinue")).click();
        driver.findElement(By.name("username")).sendKeys("test@test.com");

    }


    @Test
    public void checkBoxAndComboboxTest() throws InterruptedException {
        WebDriver driver = getDriver();

        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(3000);

        driver.findElement(By.name("firstname")).sendKeys("Allan");
        driver.findElement(By.name("lastname")).sendKeys("Smith");


        WebElement elementMonths = driver.findElement(By.id("month"));
        Select selectMonths = new Select(elementMonths);
        selectMonths.selectByVisibleText("Apr");

        WebElement elementDays = driver.findElement(By.id("day"));
        Select selectDays = new Select(elementDays);
        selectDays.selectByIndex(4);

        WebElement elementYears = driver.findElement(By.id("year"));
        Select selectYears = new Select(elementYears);
        selectYears.selectByValue("2012");
        //Thread.sleep(3000);

        List<WebElement> sexList = driver.findElements(By.name("sex"));
        Assert.assertEquals(sexList.size(), 3);

        WebElement selectMale = sexList.get(1);
        selectMale.click();


    }


    @Test
    public void birthTest() throws InterruptedException {
        WebDriver driver = getDriver();

        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(3000);

        driver.findElement(By.name("firstname")).sendKeys("Allan");
        driver.findElement(By.name("lastname")).sendKeys("Smith");


        WebElement elementMonths = driver.findElement(By.id("month"));
        Select selectMonths = new Select(elementMonths);
        selectMonths.selectByVisibleText("Dec");

        WebElement elementDays = driver.findElement(By.id("day"));
        Select selectDays = new Select(elementDays);
        selectDays.selectByIndex(20);

        WebElement elementYears = driver.findElement(By.id("year"));
        Select selectYears = new Select(elementYears);
        selectYears.selectByValue("1990");


    }


    @Test
    public void comboboxTest() throws InterruptedException {
        WebDriver driver = getDriver();

        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(3000);

        List<WebElement> monthList = driver.findElements(By.id("month"));

        Assert.assertNotNull(monthList.size(), "No está vacía");
        WebElement elementMonths = driver.findElement(By.id("month"));
        Select selectMonths = new Select(elementMonths);
        selectMonths.selectByVisibleText("Jan");
        selectMonths.selectByVisibleText("Feb");
        selectMonths.selectByVisibleText("Mar");

        for (WebElement month : monthList) {
            if (monthList.equals("Jun")) {
                System.out.println("Is here");
            }
        }


    }


    @Test
    public void completeRegistration() throws InterruptedException {
        WebDriver driver = getDriver();

        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(3000);

        driver.findElement(By.name("firstname")).sendKeys("Allan");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("reg_email__")).sendKeys("sabrina");
        driver.findElement(By.name("reg_passwd__")).sendKeys("123456");
        setBirthdate(driver, "6", "Jan", "2000");

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
