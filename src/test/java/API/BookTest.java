package API;

import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class BookTest {
    private final static String URL = "https://demoqa.com/";

    @Test
    public void checkTitle() {

        List<UserData> books = given()
                .when()
                .contentType(ContentType.JSON)
                .get("https://demoqa.com/BookStore/v1/Books")
                .then().log().all()
                .extract().body().jsonPath().getList("title", UserData.class);
//books.stream().forEach(x-> Assert.assertTrue(x.getAuthor().contains(x.getTitle())));
        List<String> description = books.stream().map(UserData::getDescription).collect(Collectors.toList());
        List<String> id = books.stream().map(UserData::getIsbn).collect(Collectors.toList());
        for (int i = 0; i < description.size(); i++) {
            Assert.assertTrue(description.get(i).contains(id.get(i)));
        }
    }

}
