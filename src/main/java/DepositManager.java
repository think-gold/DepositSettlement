import lombok.extern.slf4j.Slf4j;
import model.Damage;
import model.Deposit;
import model.SailingClub;

@Slf4j
public class DepositManager {

    public void updateEntryDeposit(SailingClub sailingClub, boolean isDepositPayed) {   //opcja, gdy klub najpierw się zgłasza, a pózniej opłaca depozyt
        if (isDepositPayed) sailingClub.getDeposit().setUpdatedDepositValue(Deposit.ENTRY_DEPOSIT_VALUE);
    }

    public void updateDepositBasedOnDamage(SailingClub sailingClub, Damage damage) { //pomnijszanie depozytu po każdej szkodzie
        if (damage.getPenalizedClub().equals(sailingClub)) {
            double updatedValueOfDeposit = sailingClub
                    .getDeposit()
                    .getCurrentDeposit() - damage
                    .getCostOfDamage();

            if (updatedValueOfDeposit < 0) {
                log.info("Wartość szkody przekracza aktualną wartość depozytu o: {}", updatedValueOfDeposit);
            }

            sailingClub.getDeposit()
                    .setUpdatedDepositValue(updatedValueOfDeposit);
        } else log.info("Szkoda dotyczy innego klubu. Sprawdź wprowadzoną nazwę klubu");
    }
}
