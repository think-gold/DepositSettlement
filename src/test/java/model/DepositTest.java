package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class DepositTest {
    @Test
    void should_return_correct_EntryDeposit_when_true(){
        //given
        SailingClub sailingClub = new SailingClub("YKP Szczecin", true);
        //when
        double depositTest = sailingClub.getDeposit().getCurrentDeposit();
        //then
        assertThat(depositTest).isEqualTo(15000);
    }

    @Test
    void should_return_correct_EntryDeposit_when_false(){
        //given
        SailingClub sailingClub = new SailingClub("YKP Gdynia", false);
        //when
        double depositTest = sailingClub.getDeposit().getCurrentDeposit();
        //then
        assertThat(depositTest).isZero();
    }

}