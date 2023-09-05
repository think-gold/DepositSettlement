import lombok.Getter;

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

    public void updateEntryDeposit(boolean isDepositPayed) {   //opcja, gdy klub najpierw się zgłasza, a pózniej opłaca depozyt
        if (isDepositPayed) this.currentDeposit = ENTRY_DEPOSIT_VALUE;
    }

    public void updateCurrentDeposit(Damage damage) { //pomnijszanie dpozytu po każdej szkodzie
        if (damage.getPenalizedClub().equals(this.sailingClub)) {
            this.currentDeposit = currentDeposit - damage.getCostOfDamage();
        }
        //todo
        //1. co jeśli ktoś wprowadzi nieprawidłową szkodę (nazwa klubu się nie zgadza)
        //2. szkoda przekracza aktualną wartość depozytu
    }
}