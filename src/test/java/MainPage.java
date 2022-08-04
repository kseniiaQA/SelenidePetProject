//главная страница сайта

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;
import java.util.Random;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    String s = RandomStringUtils.randomAlphanumeric(8);


    private final SelenideElement submit = $x("//button[@id='submit']");
    private final SelenideElement firstName = $x("//input[@id='firstName']");
    private final SelenideElement lastName = $x("//input[@id='lastName']");
    private final SelenideElement userEmail = $x("//input[@id='userEmail']");
    private final SelenideElement gender = $(byXpath("//label[text()='Male']"));
    private final SelenideElement userNumber = $x("//input[@id='userNumber']");
    private final SelenideElement birth = $x("//input[@id='dateOfBirthInput']");
    private final SelenideElement month = $x("//select[@class='react-datepicker__year-select']");
    private final SelenideElement year = $x("//option[@value='1996']");
    private final SelenideElement subject = $x("//div[@id='subjectsContainer']");
    private final SelenideElement close = $x("//div[@class='main-header']");
    private final SelenideElement hobby = $x("//label[@title for='hobbies-checkbox-2']");
    private final SelenideElement picture = $x("//input[@id='uploadPicture']");
    private final SelenideElement upload = $x("//input[@type='file']");

    private final SelenideElement tab = $x("//button[@id='tabButton']");
    private final SelenideElement window = $x("//button[@id='windowButton']");
    private final SelenideElement message = $x("//button[@id='messageWindowButton']");
    private final SelenideElement alert = $x("//button[@id='confirmButton']");


    //выполняется поиск среди статей и нажимается enter
    protected String getEmail() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public void openSite(String url) throws InterruptedException {
        Selenide.open(url);
    }

    public void empty() {
        submit.click();
    }

    public void fillAllFields() {
//    picture.click();

        upload.uploadFile(new File("Зума 1.jpg"));
        firstName.sendKeys(s);
        lastName.sendKeys(s);
        userEmail.sendKeys(getEmail() + "@gmail.com");
        gender.click();
        userNumber.sendKeys("89999999999");
//        birth.click();
//        month.click();
//        year.click();
        close.click();
//        subject.sendKeys("subject");
//        hobby.click();
        submit.click();


    }

    public void newTab() {
        tab.click();
    }

    public void newWindow() {
        window.click();
    }

    public void newWindowMessage() {
        message.click();
    }

    public void alert() {
        alert.click();
    }
}
