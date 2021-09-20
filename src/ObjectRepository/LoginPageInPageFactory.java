package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Factory jest to jeden ze sposobów na implementację page-object-model, który jest wbudowany w Selenium.
 * Sposób trochę szybszy, niż ten, który robiłem wcześniej
 */
public class LoginPageInPageFactory {

    WebDriver driver;
    public LoginPageInPageFactory(WebDriver driver) {
        this.driver = driver;
        /**
         * Dodatkowy step, który trzeba wykonać, żeby test kejsy w page-factory działały
         */
        PageFactory.initElements(driver, this);
    }

    /**
     * In POM, you define locators using ‘By’ while in Page Factory, you use FindBy annotation to define page objects.
     */
    @FindBy(id="email")
    WebElement emailField;

    @FindBy(id="passwd")
    WebElement passwordField;

    @FindBy(id="SubmitLogin")
    WebElement signinButton;

    @FindBy(xpath="//i[@class='icon-home']")
    WebElement homeButton;

    public WebElement emailField() {
        return emailField;
    }

    public WebElement passwordField() {
     return passwordField;
    }

    public WebElement signinButton() {
        return signinButton;
    }

    public WebElement homeButton() {
        return homeButton;
    }

}
