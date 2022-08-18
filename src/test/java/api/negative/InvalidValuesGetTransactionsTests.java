package api.negative;

import core.Config;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static constants.Constants.Actions.GET_TRANSACTIONS;
import static constants.Constants.Statuses.BAD_REQUEST;
import static helper.Helper.Mode;
import static helper.Helper.randomString;
import static io.restassured.RestAssured.given;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class InvalidValuesGetTransactionsTests extends Config {

    @Parameters(name = "{0}")
    public static Iterable<Object[]> testCases() {
        return Arrays.asList(new Object[][]{
                {"Empty value", "", BAD_REQUEST},
                {"Invalid value", RandomStringUtils.randomAlphabetic(1), BAD_REQUEST},
                {"Symbol value", randomString(Mode.SYMBOLS, 1), BAD_REQUEST}
        });
    }

    @Parameter
    public String name;

    @Parameter(1)
    public String value;

    @Parameter(2)
    public int status;

    @Test
    public void getTransactionsTest() {

        given()
                .when()
                .pathParam("accountId", value).log().cookies()
                .get(GET_TRANSACTIONS)
                .then()
                .statusCode(status)
                .log().all();
    }
}
