import api.ApiGetAccountsTest;
import api.ApiLoginTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        ApiLoginTest.class,
        ApiGetAccountsTest.class
})

public class ApiSuite {
}
