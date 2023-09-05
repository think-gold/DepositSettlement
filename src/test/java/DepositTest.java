import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DepositTest {
    public SailingClub ykpSzczecin = new SailingClub("YKP Szczecin");
    public SailingClub ykpGdynia = new SailingClub("YKP Gdynia");
    public SailingClub legia = new SailingClub("Legia");
    @Test
    void should_return_updated_value_when_true(){
        //given
        Deposit ykpSzczecinDeposit = new Deposit(ykpSzczecin, true);
        //when
        ykpSzczecinDeposit.updateEntryDeposit(true);
        //then
        assertThat(ykpSzczecinDeposit.getCurrentDeposit()).isEqualTo(15000);
    }
    @Test
    void should_return_updated_value_when_false(){
        //given
        Deposit ykpGdyniaDeposit = new Deposit(ykpGdynia, false);
        //when
        ykpGdyniaDeposit.updateEntryDeposit(true);
        //then
        assertThat(ykpGdyniaDeposit.getCurrentDeposit()).isEqualTo(15000);
    }
    @Test
    void should_update_current_deposit_based_on_damage(){
        //given
        Event event1 = new Event("Extraklasa Finał", LocalDate.of(2023, 10,7));
        Deposit deposit = new Deposit(legia, true);
        Damage damage = new Damage(event1, 3, 7, legia, 1500.5);
        //when
        deposit.updateCurrentDeposit(damage);
        //then
        assertThat(deposit.getCurrentDeposit()).isEqualTo(13499.5);
    }

}