package api.negative;

import core.Config;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static constants.Constants.Actions.GET_TRANSACTIONS;
import static constants.Constants.Statuses.BAD_REQUEST;
import static io.restassured.RestAssured.given;

@RunWith(Parameterized.class)
public class InvalidValuesGetTransactionsTests extends Config {

    @Parameterized.Parameters(name = "{0}")
    public static Iterable<Object[]> testCases() {
        return Arrays.asList(new Object[][]{
                {"", BAD_REQUEST},
                {RandomStringUtils.randomAlphabetic(1), BAD_REQUEST}
        });
    }

    @Parameterized.Parameter()
    public String value;

    @Parameterized.Parameter(1)
    public int status;

    @Test
    public void getTransactionsTest() {

        given()
                .when()
                .pathParam("accountId", value)
                .get(GET_TRANSACTIONS)
                .then()
                .statusCode(status);
    }
}
