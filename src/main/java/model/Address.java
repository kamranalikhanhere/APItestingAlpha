package model;

import lombok.Data;

@Data
public class Address {
    public Geo geo;

    public class Geo {
        public String lat;
        public String lng;
    }
}
