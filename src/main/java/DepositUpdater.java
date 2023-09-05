import java.util.Map;

public class DepositUpdater {  // jak połaczyć automatyczne wyszukiwanie po nazwie klubu i aktualizację depozytu?

    public void updateDepositAfterDamage(Damage damage, Deposit deposit){
        if(damage.getPenalizedClub().equals(deposit.getSailingClub())) deposit.updateCurrentDeposit(damage.getCostOfDamage());
        }
    }
