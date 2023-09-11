package model;

import lombok.Getter;

@Getter

public class SailingClub {
    private final String name;
    private Deposit deposit;
    public SailingClub(String name, YearEvents yearEvents, boolean isDepositPayed) {
        this.name = name;
        this.deposit = new Deposit(isDepositPayed);
        yearEvents.addSailingCub(this);
    }

}
