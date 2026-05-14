package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    protected void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.jetbrains.com/help/youtrack/server/youtrack-docker-installation.html#run-youtrack-service");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        initPage();
    }

    protected abstract void initPage();

    protected void takeScreenshot(WebDriver driver, String testName) {
        String dir = "test-output/screenshots/";
        new File(dir).mkdirs();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(dir + testName + "_" + timestamp + ".png"));
            System.out.println("Скриншот сохранён: " + dir + testName + "_" + timestamp + ".png");
        } catch (IOException e) {
            System.err.println("Не удалось сохранить скриншот: " + e.getMessage());
        }
    }

    @AfterMethod
    protected void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshot(driver, result.getMethod().getMethodName());
        }
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}