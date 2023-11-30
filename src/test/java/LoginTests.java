import io.qameta.allure.Step;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class LoginTests {
    private WebDriver driver;

    @BeforeClass
    public void setUP() {
        // Инициализация WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\IdeaProjects\\TestLogin\\src\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public void tearDown() {
        // Закрытие WebDriver после выполнения всех тестов
        if (driver != null) {
            driver.quit();
        }
    }

    @Step ("Test 001")
    @Test (priority = 1)
    public void AllDataIsCorrect() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        username.sendKeys("student");
        password.sendKeys("Password123");
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("error")));
        WebElement logOutButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Log out")));
        logOutButton.click();

    }
    @Step ("Test 002")
    @Test (priority = 2)
    public void IncorrectUsername() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        username.sendKeys("incorrectstudent");
        password.sendKeys("Password123");
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));

        String expectedError = "Your username is invalid!";
        String actualError = error.getText();
        Assert.assertEquals(actualError, expectedError);
    }
    @Step ("Test 003")
    @Test (priority = 3)
    public void IncorrectPassword() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        username.sendKeys("student");
        password.sendKeys("incorrectPassword");
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));

        String expectedError = "Your password is invalid!";
        String actualError = error.getText();
        Assert.assertEquals(actualError, expectedError);
    }
    @Step ("Test 004")
    @Test (priority = 4)
    public void EmptyUsernameField() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));


        password.sendKeys("Password123");
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));

        String expectedError = "Your username is invalid!";
        String actualError = error.getText();
        Assert.assertEquals(actualError, expectedError);
    }
    @Step ("Test 005")
    @Test (priority = 5)
    public void EmptyPasswordField() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebElement username = driver.findElement(By.id("username"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        username.sendKeys("student");
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));

        String expectedError = "Your password is invalid!";
        String actualError = error.getText();
        Assert.assertEquals(actualError, expectedError);
    }
}
