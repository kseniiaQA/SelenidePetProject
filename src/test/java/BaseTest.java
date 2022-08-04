import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;


abstract public class BaseTest {

     public void  Setup() {
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

