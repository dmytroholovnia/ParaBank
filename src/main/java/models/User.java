package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class User {

    private int customerId;
    private int accountId;

    public User() {
        this.customerId = 12212;
        this.accountId = 13344;
    }


}
