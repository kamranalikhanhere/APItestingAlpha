package model;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.Data;

import static io.restassured.RestAssured.given;
import static junit.framework.Assert.assertEquals;

/*
 "postId": 1,
    "id": 2,
    "name": "quo vero reiciendis velit similique earum",
    "email": "Jayne_Kuhic@sydney.com",
    "body":
 */
@Data
public class Post {
    public String title;
    public int id;
    public String body;
    public String name;
    public String email;
    public int postId;

    public void post() {

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
}
