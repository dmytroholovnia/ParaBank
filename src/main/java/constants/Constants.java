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
        public static String GET_TRANSACTIONS = "services_proxy/bank/accounts/{accountId}/transactions";
        public static String REQUEST_LOAN = "services_proxy/bank/requestLoan";
    }

    public static class Statuses {
        public static int SUCCESS = 200;
        public static int REDIRECT = 302;
        public static int BAD_REQUEST = 400;
    }
}
