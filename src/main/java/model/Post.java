package model;

import lombok.Data;

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
}
