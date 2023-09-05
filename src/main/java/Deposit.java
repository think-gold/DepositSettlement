import lombok.Getter;

import java.util.Map;

@Getter
public class Deposit {        //przyjęcie zgłoszenia
    private static final
    double ENTRY_DEPOSIT_VALUE = 15000d;//Depozyt obowiązakowy przy zgłoszeniu
    private double currentDeposit;
    private SailingClub sailingClub;

    public Deposit(SailingClub sailingClub, boolean isDepositPayed) { //sprawdza, czy przy zgłoszeniu został opłacony depozyt i tworzy aktualną wpis
        this.sailingClub = sailingClub;
        if (isDepositPayed) this.currentDeposit = ENTRY_DEPOSIT_VALUE;
        else this.currentDeposit = 0;
    }
    public void updateEntry(boolean isDepositPayed) {   //opcja, gdy klub najpierw się zgłasza, a pózniej opłaca depozyt
        if (isDepositPayed) this.currentDeposit = ENTRY_DEPOSIT_VALUE;
    }
}