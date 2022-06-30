import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AuthorizationTest.class,
        SignUpTest.class,
        OpenNewAccountTests.class,
        LogOutTest.class
})

public class SmokeTestSuite {
}
