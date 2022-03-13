import Util.EmailValidator;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import model.Post;
import model.Posts;
import model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaceHolderApiTests {

    @Test
    public void createPost() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Post post = new Post();
        post.setTitle("about dolphines");
        post.setBody("this is body for dolphines");
        post.setId(1);
        Response response = null;

        try {
            response = given()
                    .contentType(ContentType.JSON)
                    .body(new Gson().toJson(post))
                    .post("/posts");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Response :" + response.asString());
        System.out.println("Status Code :" + response.getStatusCode());
        assertEquals(201, response.getStatusCode());
    }

    @Test
    public void checkEmailInEachComment(){

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response responseForAllPosts = given().contentType(ContentType.JSON)
                .when()
                .get("/posts/")
                .then()
                .extract().response();
        Post[] posts = responseForAllPosts.getBody().as(Post[].class);
        Arrays.stream(posts).forEach(postItem->{
            Response response = given().contentType(ContentType.JSON)
                    .when()
                    .get("/posts/"+postItem.getPostId()+"/comments")
                    .then()
                    .extract().response();
            ResponseBody body = response.getBody();
// Deserialize the Response body into JSONSuccessResponse
            Post[] postForEmailCheck = body.as(Post[].class);
            Arrays.stream(postForEmailCheck).forEach(emailItem->{
                Assertions.assertEquals(200, response.statusCode());
                Assertions.assertTrue(EmailValidator.validate(emailItem.getEmail()));
            });

        });


    }

    @Test
    public void searchForUserName(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        Response responseForAllUsers = given().contentType(ContentType.JSON)
                .when()
                .get("/users/")
                .then()
                .extract().response();
        User[] users = responseForAllUsers.getBody().as(User[].class);
        int count = (int) Arrays.stream(users)
                .filter(u ->  u.username.equals("Delphine")).count();
        Assertions.assertEquals(String.valueOf(count),"1");
    }


    @Test
    public void checkSthInEachUserPost(){

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

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
