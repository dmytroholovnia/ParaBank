import ui.AuthorizationTest;
import ui.LogOutTest;
import ui.OpenNewAccountTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ui.SignUpTest;

import static org.junit.runners.Suite.*;

@RunWith(Suite.class)
@SuiteClasses({
        AuthorizationTest.class,
        SignUpTest.class,
        OpenNewAccountTests.class,
        LogOutTest.class
})

public class SmokeTestSuite {
}
