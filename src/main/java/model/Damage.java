package model;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
@Getter
public class Damage {
    private final Event event;
    private final int raceNr;
    private final int boatNr;
    private String kindOfDamage;
    private String description;
    File file;
    private SailingClub penalizedClub;
    private double costOfDamage;

    public Damage(Event event, int raceNr, int boatNr, SailingClub penalizedClub, double costOfDamage) {
        this.event = event;
        this.raceNr = raceNr;
        this.boatNr = boatNr;
        this.penalizedClub = penalizedClub;
        this.costOfDamage = costOfDamage;
        updateDepositBasedOnDamage(this.penalizedClub, this);
        event.addDamage(this);
    }

    public void setKindOfDamage(String kindOfDamage) {
        this.kindOfDamage = kindOfDamage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void updateDepositBasedOnDamage(SailingClub sailingClub, Damage damage) { //pomnijszanie depozytu po każdej szkodzie
        double updatedDepositValue = sailingClub.getDeposit().getCurrentDeposit() - damage.getCostOfDamage();

        if (updatedDepositValue < 0) {
            log.warn("Wartość szkody przekracza aktualną wartość depozytu o: {}", updatedDepositValue);
        }

        sailingClub
                .getDeposit()
                .setUpdatedDepositValue(updatedDepositValue);

    }
}
