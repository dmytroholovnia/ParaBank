import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AuthorizationTest.class,
        OpenNewAccountTest.class,
        LogOutTest.class
})

public class SmokeTestSuite {
}
