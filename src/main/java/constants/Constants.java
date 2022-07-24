package constants;

import static constants.Constants.Path.PARA_BANK_PATH;
import static constants.Constants.Servers.*;

public class Constants {

    public static class RunVariable {
        public static String server = PARA_BANK;
        public static String path = PARA_BANK_PATH;
    }

    public static class Servers {
        public static String PARA_BANK = "https://parabank.parasoft.com/";
    }

    public static class Path {
        public static String PARA_BANK_PATH = "parabank/";
    }

    public static class Actions {
        public static String LOGIN = "login.htm";
        public static String GET_ACCOUNTS = "services_proxy/bank/customers/{customerId}/accounts";
    }

    public static class Statuses {
        public static int SUCCESS = 200;
        public static int REDIRECT = 302;
    }
}