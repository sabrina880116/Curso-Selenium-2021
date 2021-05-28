import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class EjerciciosSelenium {

    @Test
    public void mostrarTitulo(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        System.out.println("El titulo  de la pagina es:" + driver.getTitle());

    }
    @Test
    public  void bbcMundTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bbc.com/mundo");

        List<WebElement>list_h1=driver.findElements(By.tagName("h1"));
        System.out.println("La cantidad de h1 es:" + list_h1.size());
         for (WebElement element:list_h1){
             System.out.println("Los titulos son:"+ element.getText());
         }

         System.out.println("******************************");


        List<WebElement>list_h2=driver.findElements(By.tagName("h2"));
        System.out.println("La cantidad de h2 es:" + list_h2.size());
        for (WebElement element:list_h2){
            System.out.println("The tittle is:"+ element.getText());
        }

        System.out.println("******************************");

        List<WebElement>link= driver.findElements(By.tagName("a"));
        System.out.println("La cantidad de links es:" + link.size());
        int vacio=0;
        for(WebElement element:link){
            if(element.getText().isEmpty()==false){
                System.out.println("Texto del link:" + element.getText());
            }else {
               vacio++;
            }
        }
        System.out.println("La cantidad de links vacíos es:" + vacio);
        driver.close();
    }



    @Test
    public void bbcMundoListas(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bbc.com/mundo");

        List<WebElement>list_li=driver.findElements(By.tagName("li"));
        System.out.println("La cantidad de li es:" + list_li.size());
        for (WebElement element:list_li){
            System.out.println("Elemento li:" + element.getText());
        }

        driver.close();

    }


    @Test
    public void spotifyTitleTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spotify.com");
        String title= driver.getTitle();
       // System.out.println(title);
        if(title.equals("Escuchar es todo - Spotify")){
            System.out.println("Test Passed!!");
        }else{
            System.out.println(title);
            System.out.println("Test failed");
        }
        //driver.close();
    }


    @Test
    public void getWindowsSizeTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        int height= driver.manage().window().getSize().getHeight();
        int widht= driver.manage().window().getSize().getWidth();
        System.out.println("The height is:" +height + " and the width is:"+ widht);

        Dimension dimension=new Dimension(1024,  768);
        driver.manage().window().setSize(dimension);
        height= driver.manage().window().getSize().getHeight();
        widht= driver.manage().window().getSize().getWidth();
        System.out.println("The height is:" +height + " and the width is:"+ widht);

        driver.close();
    }


    @Test //Ejercicio 8
    public  WebDriver getGoogleDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        return  driver;
    }

    @Test //Ejercicio 9
    public  WebDriver getDriver(String url){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        return  driver;
    }


    @Test //Ejercicio 10
    public void  searchInGoogle(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
       // String n= toString(driver.findElement(By.name("q")).getText()) ;
       driver.findElement(By.name("q")).sendKeys("game" + Keys.ENTER);
    }

    @Test //Ejercicio 11
    public void searchInGoogleAndGoBack(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        System.out.println(driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("game" + Keys.ENTER);
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
    }
    @Test //Ejercicio 12
    public void facebookPageTest(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://www.facebook.com");

        List<WebElement>divs= driver.findElements(By.tagName("div"));
        System.out.println(" In the facebook page exist: " + divs.size() + " div");

        System.out.println(" *********************************** ");

        List<WebElement>a = driver.findElements(By.tagName("a"));
        for(WebElement element:a){
            System.out.println(element.getText());
        }

        System.out.println(" *********************************** ");

        List<WebElement>button= driver.findElements(By.tagName("button"));
        System.out.println(" In the facebook page exist: " + divs.size() + " buttons");
        for(WebElement bElements:button){
            System.out.println("Button: " + bElements.getText());
        }
    }


    @Test //Ejercicio 13
    public void sendKeysToFacebook(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://www.facebook.com");

        driver.findElement(By.id("email")).sendKeys( "test@test.com");
        driver.findElement(By.id("pass")).sendKeys( "holamundo");
        driver.findElement(By.name("login")).click();

        driver.close();
    }

    @Test //Ejercicio 14
    public  void netflix(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.netflix.com/uy/\n");


        System.out.println(" ************Mostrar los elementos h1 que hay en el sitio****************** ");
        List<WebElement>h1= driver.findElements(By.tagName("h1"));
        for(WebElement h1Elements:h1){
            System.out.println("Elemento h1: " + h1Elements.getText());
        }

        System.out.println(" ************Mostrar los elementos h2 que hay en el sitio****************** ");
       List<WebElement>h2= driver.findElements(By.tagName("h2"));
        for(WebElement h2Elements:h2){
            System.out.println("Elemento h2: " + h2Elements.getText());
        }

        driver.navigate().refresh();

        System.out.println(" ************Mostrar el texto de los botones que se encuentran en la página********** ");

        List<WebElement>button= driver.findElements(By.tagName("button"));
        for(WebElement bElements:button){
            System.out.println("Button: " + bElements.getText());
        }

        System.out.println(" ********Mostrar la cantidad de elementos div que contiene el sitio******* ");
        List<WebElement>div= driver.findElements(By.tagName("div"));
        System.out.println("In the web site are: " + div.size());

        System.out.println(" ********Obtener y mostrar el título de la página********************* ");

        System.out.println("The web site title is: " + driver.getTitle());

        System.out.println(" *************Cantidad de elementos de tipos link******************* ");

        List<WebElement>link= driver.findElements(By.tagName("a"));
        System.out.println("In the web site are: " + div.size());

        driver.close();
    }
}
