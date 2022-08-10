import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;


abstract public class BaseTest {

     public void  Setup() {

         WebDriver wd = new WebDriver();
         WebDriverManager.chromedriver();
         Configuration.browser = "chrome";
         Configuration.driverManagerEnabled = true;
         Configuration.browserSize = "1920x1080";
         Configuration.headless = false;

    }


    @Before
    public void init(){
         Setup();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}

