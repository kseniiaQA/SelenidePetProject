import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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


//    @Test
//    public void autocomplete() throws InterruptedException {
//        MainPage mainPage = new MainPage();
//        mainPage.openSite("https://demoqa.com/auto-complete");
//        Thread.sleep(20000);
//
//
////        mainPage.autocomplete();
////        Thread.sleep(20000);
////        $(byXpath("//div[text()='Green']")).shouldBe(visible);
////
////        $(byXpath("//div[text()='Green']")).shouldBe(visible);
//        $x(("//div[@class='auto-complete__value-container css-1hwfws3']")).findElement(By.xpath("//div[@class='auto-complete__placeholder css-1wa3eu0-placeholder']")).sendKeys("gr");
//    }


    @Test
    public void autocomplete() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openSite("https://demoqa.com/accordian");
        Thread.sleep(20000);
        $x(("//div[@id='section1Heading']")).click();
        $x(("//div[@id='section1Content']")).shouldHave(text("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));


    }

    @Test
    public void datePicker() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openSite("https://demoqa.com/date-picker");
        Thread.sleep(20000);
        $x(("//input[@id='datePickerMonthYearInput']")).click();
        $x(("//select[@class='react-datepicker__month-select']")).click();
        $x(("//option[@value='0']")).click();
        $(byXpath("//div[text()='10']")).click();

        $x(("//input[@id='datePickerMonthYearInput']")).shouldHave(value("01/10/2022"));


    }


    @Test
    public void timePicker() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openSite("https://demoqa.com/date-picker");
        Thread.sleep(20000);
        $x(("//input[@id='dateAndTimePickerInput']")).click();
        $(byXpath("//li[text()='13:00']")).click();

        $x(("//input[@id='dateAndTimePickerInput']")).shouldHave(value("August 5, 2022 1:00 PM"));


    }


//    @Test
//    public void dragAndDrop() throws InterruptedException {
////
////
////
//        WebDriver driver = new FirefoxDriver();
//        MainPage mainPage = new MainPage();
//        mainPage.openSite("https://demoqa.com/slider");
//        Thread.sleep(20000);
//////        Actions move = new Actions(driver);
////
////
//        WebElement slider = driver.findElement(By.id("//input[@class='range-slider range-slider--primary']"));
//        slider.sendKeys(Keys.ARROW_RIGHT);
////
////
//////        int width=slider.getSize().getWidth();
//////
//////        move.moveToElement(slider, 100, 0).click();
//////        move.build().perform();
////
//    }


    @Test
    public void tabs() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openSite("https://demoqa.com/tabs");
        Thread.sleep(20000);
        $(byXpath("//a[text()='Origin']")).click();
        $x(("//div[@id='demo-tabpane-origin']")).shouldHave(text("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32."));


    }

    @Test
    public void hover() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openSite("https://demoqa.com/tool-tips");
        Thread.sleep(20000);
        $x(("//button[@id='toolTipButton']")).hover().shouldHave(text("Hover me to see"));


    }

    @Test
    public void menu() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openSite("https://demoqa.com/menu#");
        Thread.sleep(20000);
        $(byXpath("//a[text()='Main Item 2']")).click();
        $(byXpath("//a[text()='Sub Item']")).click();
        $(byXpath("//a[text()='SUB SUB LIST »']")).click();
        $(byXpath("//a[text()='Sub Sub Item 1']")).click();


    }

    @Test
    public void selectMenu() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openSite("https://demoqa.com/select-menu");
        Thread.sleep(20000);
        $(byXpath("//div[text()='Select Option']")).click();
        $(byXpath("//div[text()='Group 2, option 1']")).click();

        $(byXpath("//div[text()='Select Title']")).click();
        $(byXpath("//div[text()='Ms.']")).click();

        $x(("//select[@id='oldSelectMenu']")).click();
        $x(("//option[@value='3']")).click();
        $x(("//div[@class=' css-1wa3eu0-placeholder']")).click();

        $(byXpath("//div[text()='Blue']")).click();
        $x(("//option[@value='opel']")).click();


    }

    @Test
    public void sort() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openSite("https://demoqa.com/sortable");
        Thread.sleep(20000);
        $x(("//a[@id='demo-tab-list']")).click();
        $(byXpath("//div[text()='Two']")).click();


//                $x("//a[@id='demo-tab-grid']");
//        $x(("//div[@id='demo-tabpane-grid']")).click();
//        $(byXpath("//div[text()='Three']")).click();


    }


    @Test
    public void select() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openSite("https://demoqa.com/selectable");
        Thread.sleep(20000);
        $x(("//a[@id='demo-tab-list']")).click();
        $(byXpath("//li[text()='Cras justo odio']")).click();

        $x(("//a[@id='demo-tab-grid']")).click();
        $(byXpath("//li[text()='Five']")).click();
    }


    @Test
    public void resize() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openSite("https://demoqa.com/resizable");
        Thread.sleep(20000);
        var element = $(byXpath("//div[@id='resizableBoxWithRestriction']"));
        actions().clickAndHold(element).moveByOffset(150, 100).perform();
    }


    @Test
    public void draganddrop() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openSite("https://demoqa.com/droppable");
        Thread.sleep(20000);
        var element = $(byXpath("//div[@id='draggable']"));
        var element2 = $(byXpath("//div[@id='droppable']"));
        actions().dragAndDrop(element, element2).moveToElement(element2).build().perform();
// var element3 = $(byXpath("//div[@class='.droppable-container .ui-state-highlight']")).getCssValue("background-color");
//        System.out.println(element3);

//        $x(("//a[@id='droppableExample-tab-accept']")).click();
//        var element3 = $(byXpath("//div[@id='acceptable']"));
//        var element4 = $(byXpath("//div[@id='droppable']"));
//        actions().dragAndDrop(element3,element4).moveToElement(element4).build().perform();
//        var element5 = $(byXpath("//div[@class='drop-box ui-droppable ui-state-highlight']")).getCssValue();
//
//        System.out.println(element5);
    }


    @Test
    public void loginCheckFields() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openSite("https://demoqa.com/login");
        Thread.sleep(20000);
        $x(("//button[@id='login']")).click();
        $x(("//input[@class='mr-sm-2 is-invalid form-control']")).shouldBe(visible);


    }

    @Test
    public void loginInvalid() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openSite("https://demoqa.com/login");
        Thread.sleep(20000);
        $x(("//input[@id='userName']")).sendKeys("555");
        $x(("//input[@id='password']")).sendKeys("555");
        $x(("//button[@id='login']")).click();
        $x(("//p[@id='name']")).shouldHave(text("Invalid username or password!"));


    }

    @Test
    public void newUser() throws InterruptedException {

        MainPage mainPage = new MainPage();
        mainPage.openSite("https://demoqa.com/login");
        Thread.sleep(20000);
        $x(("//button[@id='newUser']")).click();

        $x(("//input[@id='firstname']")).sendKeys(mainPage.getEmail());
        $x(("//input[@id='lastname']")).sendKeys("Aleks");
        $x(("//input[@id='userName']")).sendKeys(mainPage.getEmail());
        $x(("//input[@id='password']")).sendKeys(mainPage.getEmail() + "d1!");
        Thread.sleep(20000);
        $x(("//div[@class='recaptcha-checkbox-checkmark']")).click();
        $x(("//button[@id='register']")).click();
        mainPage.alert();
        Selenide.switchTo().alert().accept();
    }


    @Test
    public void loginNewUser() throws InterruptedException {

        MainPage mainPage = new MainPage();
        mainPage.openSite("https://demoqa.com/login");
        Thread.sleep(20000);


        $x(("//input[@id='userName']")).sendKeys("KsenQA");
        $x(("//input[@id='password']")).sendKeys("Password1!");
        $x(("//button[@id='login']")).click();
        $x(("//div[@class='main-header']")).shouldHave(text("Profile"));
    }
}
