package API;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specification {

    public static RequestSpecification requestSpec(){
        return (RequestSpecification) new RequestSpecBuilder()
                .setBaseUri("https://demoqa.com/BookStore/v1/Books")
                .setContentType(ContentType.JSON);
    }
}
