import api.ApiGetAccountsTest;
import api.ApiGetTransactionsTest;
import api.ApiLoginTest;
import api.ApiRequestLoanTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        ApiLoginTest.class,
        ApiGetAccountsTest.class,
        ApiGetTransactionsTest.class,
        ApiRequestLoanTest.class
})

public class ApiSuite {
}
