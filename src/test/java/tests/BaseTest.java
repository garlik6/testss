package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=C:\\Users\\fred2\\IdeaProjects\\User Data");
        options.addArguments("--profile-directory=C:\\Users\\fred2\\IdeaProjects\\User Data\\Default");
        options.addArguments("--remote-allow-origins=*");
        WebDriverRunner.setWebDriver(new ChromeDriver(options));
    }

}

