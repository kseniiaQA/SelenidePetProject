package resources;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.files.DownloadActions.click;

public class BookPage {

    private final SelenideElement book = $x(("//span[@id='see-book-Git Pocket Guide']"));
    private final SelenideElement buy = $x(("//div[@class='text-right fullButton']"));
    private final SelenideElement delete = $x(("//span[@id='delete-record-undefined']"));

    private final SelenideElement cancel = $x(("//button[@id='closeSmallModal-cancel']"));
    private final SelenideElement accept = $x(("//button[@id='closeSmallModal-ok']"));

    public void putBookToCollection() {
        book.click();
        buy.click();
    }


    public void deleteAndAcceptDeletion() throws InterruptedException {
        delete.click();
        accept.click();
        Thread.sleep(20000);


    }

    public void deleteAndDeclineDeletion() {
        delete.click();
        cancel.click();


    }
}


