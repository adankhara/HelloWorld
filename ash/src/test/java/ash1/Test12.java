package ash1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test12 {

    public static WebDriver driver;
        int expectedProducts = 2;
        public static void main(String[] args) {

            System.setProperty("webdriver.chrome.driver","src\\test\\java\\browserdriver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().fullscreen();
            driver.get("https://demo.nopcommerce.com");
            driver.findElement(By.linkText("Books")).click();
            driver.findElement(By.xpath("//input[contains(@onclick,'/compareproducts/add/37')]\n")).click();
            //driver.findElement(By.linkText("Apple MacBook Pro 13-inch")).click();
            driver.findElement(By.xpath("//input[contains(@onclick,'/compareproducts/add/38')]\n")).click();
            driver.findElement(By.xpath("//a[contains(.,'product comparison')]\n")).click();

            int products = driver.findElement(By.xpath("//tr[@class='product-picture']")).findElements(By.tagName("td")).size();
            Assert.assertEquals(3, products);

//        String pagination_no[]=driver.findElement(By.xpath("//*[@id='category_filter']/section/div[1]/div/div[1]/h1")).getText().split(" ");
//
//        String[] pagination=pagination_no[1].split("-");



        }

    }

