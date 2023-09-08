import model.Damage;
import model.Event;
import model.SailingClub;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DepositManagerTest {
    @Test
    void should_update_EntryDeposit() {
        //given
        SailingClub ykp = new SailingClub("YKP", false);
        DepositManager depositManager = new DepositManager();
        //when
        depositManager.updateEntryDeposit(ykp, true);
        double test = ykp.getDeposit().getCurrentDeposit();
        //then
        assertThat(test).isEqualTo(15000);
    }

    @Test
    void should_update_DepositValue_after_damage_when_damageCost_is_smaller_than_currentDepositValue() {
        //given
        Event event = new Event("Pierwsza runda", LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 5));
        SailingClub ykp = new SailingClub("YKP", true);
        DepositManager depositManager = new DepositManager();
        Damage damage = new Damage(event, 1, 7, ykp, 3500.5);
        //when
        depositManager.updateDepositBasedOnDamage(ykp,damage);
        double currentDepositTest = ykp.getDeposit().getCurrentDeposit();
        //then
        assertThat(currentDepositTest).isEqualTo(11499.5);
    }

    @Test
    void should_update_DepositValue_after_damage_when_damageCost_is_greater_than_currentDepositValue(){
        //given
        Event event = new Event("Pierwsza runda", LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 5));
        SailingClub ykp = new SailingClub("YKP", true);
        DepositManager depositManager = new DepositManager();
        Damage damage = new Damage(event, 1, 7, ykp, 16000);
        //when
        depositManager.updateDepositBasedOnDamage(ykp,damage);
        double currentDepositTest = ykp.getDeposit().getCurrentDeposit();
        //then
        assertThat(currentDepositTest).isEqualTo(-1000);
    }

}