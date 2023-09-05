import lombok.Getter;

import java.io.File;

@Getter
public class Damage {
    private Event event;
    private int raceNr;
    private int boatNr;
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
}
