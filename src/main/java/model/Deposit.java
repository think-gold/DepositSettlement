package model;

import lombok.Getter;

@Getter
public class Deposit {        //przyjęcie zgłoszenia
    public static final
    double ENTRY_DEPOSIT_VALUE = 15000d;//Depozyt obowiązakowy przy zgłoszeniu
    private double currentDeposit;

    private SailingClub sailingClub;

    public Deposit(boolean isDepositPayed) { //sprawdza, czy przy zgłoszeniu został opłacony depozyt i tworzy aktualną wpis
        if (isDepositPayed) this.currentDeposit = ENTRY_DEPOSIT_VALUE;
        else this.currentDeposit = 0;
    }
    public void setUpdatedDepositValue(double updatedValue) {
        this.currentDeposit = updatedValue;
    }
}
