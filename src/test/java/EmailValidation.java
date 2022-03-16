import util.EmailValidator;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import model.Post;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class EmailValidation {
    public void emailvalidationIncomments() {
        Response responseForAllPosts = given().contentType(ContentType.JSON)
                .when()
                .get("/posts/")
                .then()
                .extract().response();
        Post[] posts = responseForAllPosts.getBody().as(Post[].class);
        Arrays.stream(posts).forEach(postItem -> {
            Response response = given().contentType(ContentType.JSON)
                    .when()
                    .get("/posts/" + postItem.getPostId() + "/comments")
                    .then()
                    .extract().response();
            ResponseBody body = response.getBody();
// Deserialize the Response body into JSONSuccessResponse
            Post[] postForEmailCheck = body.as(Post[].class);
            Arrays.stream(postForEmailCheck).forEach(emailItem -> {
                Assertions.assertEquals(200, response.statusCode());
                Assertions.assertTrue(EmailValidator.validate(emailItem.getEmail()));
            });

        });

    }

}
