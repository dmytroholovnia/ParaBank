package core;

import helper.Helper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.junit.Before;

import java.util.HashMap;
import java.util.Map;

import static constants.Constants.Actions.LOGIN;
import static constants.Constants.RunVariable.path;
import static constants.Constants.RunVariable.server;
import static io.restassured.RestAssured.given;

public class Config {

    private static String url;
    private static String authCookieValue;

    public Config() {
        url = "https://parabank.parasoft.com/";
    }

    public String getUrl() {
        return url;
    }

    //for API
    @Before
    public void setUp() {
        RestAssured.baseURI = server;
        RestAssured.basePath = path;

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addCookie("JSESSIONID", getAuthCookieValue())
                .build();

        //todo add response spec
        //todo add log spec
    }

    public String getAuthCookieValue() {
        if (authCookieValue == null) {
            System.out.println("No auth cookie found");
            System.out.println("Creating an auth cookie");
            setAuthCookieValue(getAuthCookie());
        }

        System.out.println("Auth cookie: " + authCookieValue);
        return authCookieValue;
    }

    private void setAuthCookieValue(String value) {
        authCookieValue = value;
    }

    private String getAuthCookie() {    //todo add validation for successfully login

        return given()
                .when()
                .formParams(getCredentials())
                .post(LOGIN)
                .getCookie("JSESSIONID");
    }

    protected HashMap<String, String> getCredentials() {
        HashMap<String, String> credentials = new HashMap<>();

        credentials.put("username", Helper.getProperty("login"));
        credentials.put("password", Helper.getProperty("pass"));

        return credentials;
    }

    protected void getAllCookies() {
        Map<String, String> allCookies =
                given()
                        .when()
                        .formParams(getCredentials())
                        .post(LOGIN)
                        .getCookies();

        String myCookieValues = allCookies.get("JSESSIONID");

        System.out.println(myCookieValues);
    }
}
