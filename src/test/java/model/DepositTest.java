package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class DepositTest {

    YearEvents yearEvents = new YearEvents(2023);
    Event event = new Event(yearEvents, "Pierwsza runda", LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 5));

    @Test
    void should_return_correct_EntryDeposit_when_deposit_is_payed() {
        //given
        SailingClub sailingClub = new SailingClub("YKP Szczecin", yearEvents, true);
        //when
        double depositTest = sailingClub.getDeposit().getCurrentDeposit();
        //then
        assertThat(depositTest).isEqualTo(15000);
    }

    @Test
    void should_return_correct_EntryDeposit_when_deposit_is_not_payed() {
        //given
        SailingClub sailingClub = new SailingClub("YKP Gdynia", yearEvents, false);
        //when
        double depositTest = sailingClub.getDeposit().getCurrentDeposit();
        //then
        assertThat(depositTest).isZero();
    }

    @Test
    void should_update_EntryDeposit() {
        //given
        SailingClub sailingClub = new SailingClub("YKP Gdynia", yearEvents, false);
        //when
        sailingClub.getDeposit().updateEntryDeposit(true);
        //then
        assertThat(sailingClub.getDeposit().getCurrentDeposit()).isEqualTo(15000);
    }
}