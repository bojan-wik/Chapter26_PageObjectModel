package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By searchBoxLocator = By.id("search_query_top");
    By searchButtonLocator = By.xpath("//button[@name='submit_search']");

    public WebElement searchBox() {
        return driver.findElement(searchBoxLocator);
    }

    public WebElement searchButton() {
        return driver.findElement(searchButtonLocator);
    }
}
