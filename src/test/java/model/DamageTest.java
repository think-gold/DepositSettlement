package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DamageTest {
    @Test
    void should_udpate_deposit_value_after_adding_new_damage(){
        //given
        Event event = new Event("Pierwsza runda", LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 5));
        SailingClub legia = new SailingClub("Legia", true);
        //when
        Damage damage = new Damage(event, 1, 1, legia, 1500);
        //then
        assertThat(legia.getDeposit().getCurrentDeposit()).isEqualTo(13500);

    }

}