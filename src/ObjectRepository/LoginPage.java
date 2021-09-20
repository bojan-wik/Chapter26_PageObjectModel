package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    /**
     * Definiuję zmienną driver, ale nie przypisuję od niej ChromeDriver().
     * Następnie tworzę konstruktor z parametrem driver, poprzez który będę przekazywał wiedzę o ChromeDriver() z test kejsów
     * w momencie utworzenia obiektu tej klasy.
     */
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailFieldLocator = By.id("email");
    By passwordFieldLocator = By.id("passwd");
    By signinButtonLocator = By.id("SubmitLogin");
    By homeButtonLocator = By.xpath("//i[@class='icon-home']");

    public WebElement emailField() {
        return driver.findElement(emailFieldLocator);
    }

    public WebElement passwordField() {
        return driver.findElement(passwordFieldLocator);
    }

    public WebElement signinButton() {
        return driver.findElement(signinButtonLocator);
    }

    public WebElement homeButton() {
        return driver.findElement(homeButtonLocator);
    }
}
