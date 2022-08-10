import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.Before;
import org.junit.Test;
import resources.BookPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class BuyBook    extends BaseTest {


    @Before
    public void init() {
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/books");
        $x(("//button[@id='login']")).click();
        $x(("//input[@id='userName']")).sendKeys("KsenQA");
        $x(("//input[@id='password']")).sendKeys("Password1!");
        $x(("//button[@id='login']")).click();

    }


    @Test
    public void buyBookAndDelete() throws InterruptedException {
        BookPage bookPage = new BookPage();
        bookPage.putBookToCollection();
        Thread.sleep(20000);
        open("https://demoqa.com/profile");
        $x(("//span[@id='see-book-Git Pocket Guide']")).shouldBe(visible);
        bookPage.deleteAndAcceptDeletion();
        Selenide.switchTo().alert().accept(); 
        Thread.sleep(20000);
        $x(("//span[@id='see-book-Git Pocket Guide']")).shouldNotBe(visible);

    }


    @Test
    public void buyBookAndDeclinesDeletion() throws InterruptedException {
        BookPage bookPage = new BookPage();
        bookPage.putBookToCollection();
        Selenide.switchTo().alert().accept();
        Thread.sleep(20000);
        open("https://demoqa.com/profile");
        $x(("//span[@id='see-book-Git Pocket Guide']")).shouldBe(visible);
        bookPage.deleteAndDeclineDeletion();
        Thread.sleep(20000);
        $x(("//span[@id='see-book-Git Pocket Guide']")).shouldBe(visible);
    }
}



