package Util;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;

public class BaseTest {
@BeforeAll
    public  static void setupConfig() {
    ConfigFileReader UrlSetUp = new ConfigFileReader();
        RestAssured.baseURI =UrlSetUp.configFileReader();


    }
}
