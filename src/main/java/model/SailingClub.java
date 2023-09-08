package model;

import lombok.Getter;


@Getter

public class SailingClub {
    private final String name;
    private Deposit deposit;
    public SailingClub(String name, boolean isDepositPayed) {
        this.name = name;
        this.deposit = new Deposit(isDepositPayed);
    }

}
