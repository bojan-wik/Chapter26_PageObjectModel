package TestCases;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.LoginPageInPageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class DemoTestCases {

    /**
     * W test kejsach nie powinienem hardkodować żadnych obiektów.
     * Wszystkie obiekty powinny pochodzić z package 'ObjectRepository'. Dzięki trzymaniu wszystkich obiektów w jednym miejscu
     * w przypadku jakiejkolwiek zmiany wystarczy, że dokonam zmiany tam i ona się spopuluje na wszystkie test kejsy.
     */
    @Test
    public void login() {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\93\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php?controller=my-account");
        /**
         * Tworzę obiekt klasy 'ObjectRepository.LoginPage', aby mieć dostęp do jej metod, zmiennych itd.
         * Jako argument podaję driver i tym samym przekazuję temu obiektowi wiedzę o ChromeDriver() z tej klasy
         */
        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailField().sendKeys("test");
        loginPage.passwordField().sendKeys("test");
        loginPage.signinButton().click();
    }

    /**
     * Test kejs z użyciem page-factory
     */
    @Test
    public void loginInPageFactory() {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\93\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php?controller=my-account");

        LoginPageInPageFactory loginPageInPageFactory = new LoginPageInPageFactory(driver);
        loginPageInPageFactory.emailField().sendKeys("test page factory");
        loginPageInPageFactory.passwordField().sendKeys("eloooooooo");
        loginPageInPageFactory.signinButton().click();
    }

    /**
     * Tworzę osobny test kejs, który ze strony loginPage przechodzi do homePage i tam dalej wykonuje działania
     */
    @Test
    public void returnToHomePage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Webdrivers\\Chrome\\93\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php?controller=my-account");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.homeButton().click();
        /**
         * W tym momencie przechodzę do homePage. W tym celu stworzyłem osobną klasę 'ObjectRepository.HomePage', gdzie przechowuję
         * obiekty z tej strony - zgodnie z PageObjectModel
         */
        HomePage homePage = new HomePage(driver);
        homePage.searchBox().sendKeys("fancy dress");
        homePage.searchButton().click();
    }
}
