
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;


public class AppleTest extends BaseTest {


    private final static String BASE_URL = "https://demoqa.com/automation-practice-form";


    @Test
    public void checkHref() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openSite(BASE_URL);


    }

    @Test
    public void emptySubmit() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openSite(BASE_URL);
        mainPage.empty();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(BASE_URL, currentUrl);

    }


    @Test
    public void allFieldsFilled() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openSite(BASE_URL);
        mainPage.fillAllFields();
        Thread.sleep(20000);


    }

    @Test
    public void newTabOpen() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openSite("https://demoqa.com/browser-windows");
        Thread.sleep(20000);
        mainPage.newTab();
        switchTo().window(1);
        $x("//h1[@id='sampleHeading']").shouldHave(text("This is a sample page"));

    }

    @Test
    public void neeWindowOpen() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openSite("https://demoqa.com/browser-windows");
        Thread.sleep(20000);
        mainPage.newWindow();
        switchTo().window(1);
        $x("//h1[@id='sampleHeading']").shouldHave(text("This is a sample page"));

    }

    @Test
    public void newWindowMessage() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openSite("https://demoqa.com/browser-windows");
        Thread.sleep(20000);
        mainPage.newWindowMessage();
        switchTo().frame(1);

    }


    @Test
    public void alert() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openSite("https://demoqa.com/alerts");
        Thread.sleep(20000);
        mainPage.alert();
        Selenide.switchTo().alert().accept();
        $x("//span[@id='confirmResult']").shouldHave(text("You selected "));


    }
}


