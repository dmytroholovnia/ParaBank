package core;

import helper.Helper;
import helper.Logger;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.Cookie;
import io.restassured.specification.ResponseSpecification;
import models.User;
import org.junit.Before;

import java.util.HashMap;
import java.util.Map;

import static constants.Constants.Actions.LOGIN;
import static constants.Constants.RunVariable.path;
import static constants.Constants.RunVariable.server;
import static constants.Constants.Statuses.REDIRECT;
import static constants.Constants.Statuses.SUCCESS;
import static io.restassured.RestAssured.given;


public class Config {

    private static String url;
    private static String authCookieValue;
    private static Cookie authCookieNew;
    private final Logger logger = new Logger();
    protected User user = new User();

    public Config() {
        url = "https://parabank.parasoft.com/";
    }

    public String getUrl() {
        return url;
    }

    protected ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(SUCCESS)
            .build();

    //for API
    @Before
    public void setUp() {
        RestAssured.baseURI = server;
        RestAssured.basePath = path;

        if (authCookieNew == null) {
            RestAssured.requestSpecification = new RequestSpecBuilder()
                    .addCookie(getAuthCookieValueNew())
//                .addCookie("JSESSIONID", getAuthCookieValue())        //todo temporary leave
                    .build();
        }

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    public String getAuthCookieValue() {
        if (authCookieValue == null) {
            logger.log("No auth cookie found");
            logger.log("Creating an auth cookie");
            setAuthCookieValue(getAuthCookie());
        }

        logger.log("Auth cookie: " + authCookieValue);
        return authCookieValue;
    }

    public Cookie getAuthCookieValueNew() {
        if (authCookieNew == null) {
            logger.log("No auth cookie found");
            logger.log("Creating an auth cookie");
            setAuthCookieNew(getAuthCookieNew());
        }

        logger.log("Auth cookie: " + authCookieNew.toString());
        return authCookieNew;
    }

    private void setAuthCookieValue(String value) {
        authCookieValue = value;
    }

    private void setAuthCookieNew(Cookie cookie) {
        authCookieNew = cookie;
    }

    private String getAuthCookie() {

        return given()
                .when()
                .formParams(getCredentials())
                .post(LOGIN)
                .then().statusCode(REDIRECT)
                .extract().response()
                .getCookie("JSESSIONID");
    }

    private Cookie getAuthCookieNew() {

        Cookie cookie = given()
                .when()
                .formParams(getCredentials())
                .post(LOGIN)
                .then().statusCode(REDIRECT)
                .extract().response()
                .getDetailedCookie("JSESSIONID");

        return new Cookie
                .Builder("JSESSIONID", cookie.getValue())
                .setMaxAge(-1)
                .build();
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
