package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DamageTest {
    YearEvents yearEvents = new YearEvents(2023);
    Event event = new Event(yearEvents,"Pierwsza runda", LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 5));

    SailingClub legia = new SailingClub("Legia", yearEvents, true);


    @Test
    void should_update_depositValue_after_adding_new_damage_lesser_than_deposit() {
        //when
        Damage damage = new Damage(event, 1, 1, legia, 1500);
        //then
        assertThat(legia.getDeposit().getCurrentDeposit()).isEqualTo(13500);
    }

    @Test
    void should_update_depositValue_after_adding_new_damage_greater_than_deposit() {
        //when
        Damage damage = new Damage(event, 1, 1, legia, 16000);
        //then
        assertThat(legia.getDeposit().getCurrentDeposit()).isEqualTo(-1000);
    }

}