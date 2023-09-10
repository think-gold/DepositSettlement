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
