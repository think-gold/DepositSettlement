import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DepositAcceptanceTest {

    @Test
    void should_return_vale_of_deposit_if_true() {
        //given
        SailingClub ykpSzczecin = new SailingClub("YKP Szczecin");
        DepositAcceptance depositAcceptance = new DepositAcceptance();
        depositAcceptance.allocateDepositToClubs(ykpSzczecin, true);
        //when
        Map<SailingClub, Double> test = depositAcceptance.getMapOfClubsAndDeposit();
        //then
        assertThat(test.get(ykpSzczecin)).isEqualTo(15000);
    }

    @Test
    void should_return_0_if_false() {
        //given
        SailingClub ykpGdynia = new SailingClub("YKP Gdynia");
        DepositAcceptance depositAcceptance = new DepositAcceptance();
        depositAcceptance.allocateDepositToClubs(ykpGdynia, false);
        //when
        Map<SailingClub, Double> test = depositAcceptance.getMapOfClubsAndDeposit();
        //then
        assertThat(test.get(ykpGdynia)).isEqualTo(0);
    }

    @Test
    void should_update_deposit_value_for_entry(){
        //given
        SailingClub legia = new SailingClub("Legia");
        DepositAcceptance depositAcceptance = new DepositAcceptance();
        depositAcceptance.allocateDepositToClubs(legia, false);
        //when
        depositAcceptance.updateEntry(legia);
        //then
        assertThat(depositAcceptance.getMapOfClubsAndDeposit().get(legia)).isEqualTo(15000d);
    }
}