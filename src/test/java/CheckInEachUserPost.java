import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import model.Post;
import model.User;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class CheckInEachUserPost {

    public void checkSthInEachUserPost(){
        Response responseForAllUsers = given().contentType(ContentType.JSON)
                .when()
                .get("/users/")
                .then()
                .extract().response();
        User[] users = responseForAllUsers.getBody().as(User[].class);
        Arrays.stream(users).forEach(userItem->{
            Response response = given().contentType(ContentType.JSON)
                    .when()
                    .get("/posts/"+userItem.getId())
                    .then()
                    .extract().response();
            ResponseBody body = response.getBody();
// Deserialize the Response body into JSONSuccessResponse
            Post postForSth = body.as(Post.class);
            Assertions.assertEquals(200, response.statusCode());
            Assertions.assertTrue(postForSth.getTitle()!=null);
        });



    }
}
