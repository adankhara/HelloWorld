package com.seleniumhw;
import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SeleniumHomeWork1 {
    public  WebDriver driver;
    final static Logger logger = Logger.getLogger(SeleniumHomeWork1.class);
    private final static String expectedRegisterMessage = "Your registration completed";
    private final static String expectedPrice = "Ђ1032.00";
    private final static String expectedMessage = "Only registered customers can use email a friend feature";
    private final static int expectedNumberOfProducts = 2;

    @Before
    public void Setup()
    {
        logger.info("setup");
        System.setProperty("webdriver.chrome.driver","src\\test\\java\\browserdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }

    @Test
    public void registraion()
    {
        logger.info("registration");
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Rahul");
        driver.findElement(By.id("LastName")).sendKeys("Mehra");

        Select dateOfBirth = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']\n")));
        dateOfBirth.selectByIndex(15);
        Select dateOfMonth = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']\n")));
        dateOfMonth.selectByVisibleText("June");
        Select dateOfYear = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']\n")));
        dateOfYear.selectByValue("1999");

        DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");
        Date date = new Date();
        String date1 = dateFormat.format(date);

        driver.findElement(By.id("Email")).sendKeys("rahulmehra+"+date1+"@gmail.com");
        driver.findElement(By.id("Company")).sendKeys("Test1234");
        driver.findElement(By.id("Newsletter")).isSelected();
        driver.findElement(By.id("Password")).sendKeys("rahul1234");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("rahul1234");
        driver.findElement(By.id("register-button")).click();

        String actualRegisterMessage = driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals("Test case registration scenario failed",expectedRegisterMessage,actualRegisterMessage);

        driver.findElement(By.linkText("Log out")).click();
    }
    @Test
    public void currency()
    {
        logger.info("currency");
        driver.get("https://demo.nopcommerce.com/");
        Select currency = new Select(driver.findElement(By.id("customerCurrency")));
        currency.selectByVisibleText("Euro");

        String actualPrice = driver.findElement(By.xpath("//div[@class='item-grid']/div[1]/div/div[2]/div[3]/div[1]/span")).getText();
        Assert.assertEquals("Test case change of currency scenario failed",expectedPrice,actualPrice);
    }
    @Test
    public void emailFriend()
    {
        logger.info("emailFriend");
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.linkText("Build your own computer")).click();
        driver.findElement(By.xpath("//input[contains(@onclick,'/productemailafriend/1')]")).click();
        driver.findElement(By.id("FriendEmail")).sendKeys("test123@yahoo.com");
        driver.findElement(By.id("YourEmailAddress")).sendKeys("meena123@yahoo.com");
        driver.findElement(By.id("PersonalMessage")).sendKeys("Look at this product.");
        driver.findElement(By.xpath("//input[@name='send-email']")).click();

        String actualMessage = driver.findElement(By.xpath("//li[contains(.,'Only registered customers can use email a friend feature')]\n")).getText();
        Assert.assertEquals("Testcase email a friend scenario failed",expectedMessage,actualMessage);
    }

    @Test
    public void compareProducts(){
        logger.info("compare2products");
        driver.get("https://demo.nopcommerce.com");
        driver.findElement(By.linkText("Build your own computer")).click();
        driver.findElement(By.xpath("//input[contains(@onclick,'/compareproducts/add/1')]\n")).click();
        driver.findElement(By.linkText("Apple MacBook Pro 13-inch")).click();
        driver.findElement(By.xpath("//input[contains(@onclick,'/compareproducts/add/4')]\n")).click();
        driver.findElement(By.xpath("//a[contains(.,'product comparison')]\n")).click();

        int actualNumberOfProducts = driver.findElement(By.xpath("//tr[@class='product-picture']"))
         .findElements(By.tagName("td"))
         .size() -1;
        Assert.assertEquals("Testcase compare 2 products scenario failed",expectedNumberOfProducts, actualNumberOfProducts);
    }

    @After
    public void TearDown(){
        logger.info("teardown");
        driver.quit();
    }

}
