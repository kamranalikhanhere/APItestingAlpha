import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.User;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class SearchUserName {


    public void searchuser() {

        Response responseForAllUsers = given().contentType(ContentType.JSON)
                .when()
                .get("/users/")
                .then()
                .extract().response();
        User[] users = responseForAllUsers.getBody().as(User[].class);
        int count = (int) Arrays.stream(users)
                .filter(u -> u.username.equals("Delphine")).count();
        Assertions.assertEquals(String.valueOf(count), "1");
    }
}