package model;


/*
{
"id": 1,
"name": "Leanne Graham",
"username": "Bret",
"email": "Sincere@april.biz",
"address": {
"street": "Kulas Light",
"suite": "Apt. 556",
"city": "Gwenborough",
"zipcode": "92998-3874",
"geo": {
"lat": "-37.3159",
"lng": "81.1496"
}
},
"phone": "1-770-736-8031 x56442",
"website": "hildegard.org",
"company": {
"name": "Romaguera-Crona",
"catchPhrase": "Multi-layered client-server neural-net",
"bs": "harness real-time e-markets"
}
},
 */

import lombok.Data;

@Data
public class User {

    public int id;
    public String name;
    public String username;
    public String email;
    public Address address;
    public Company company;

    public class Company{
        public String name;
        public String bs;
        public String catchPhrase;
    }

    public class Address {
        public Geo geo;

        public class Geo {
            public String lat;
            public String lng;
        }
    }
}
