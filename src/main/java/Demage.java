import lombok.Getter;

import java.io.File;

@Getter
public class Demage {
    private Event event;
    private int raceNr;
    private int boatNr;
    private String kindOfDemage;
    private String desciption;
    File file;
    private SailingClub penalizedClub;
    private double costOfDamage;

    public Demage(Event event, int raceNr, int boatNr, SailingClub penalizedClub, double costOfDamage) {
        this.event = event;
        this.raceNr = raceNr;
        this.boatNr = boatNr;
        this.penalizedClub = penalizedClub;
        this.costOfDamage = costOfDamage;
    }

    public void setKindOfDemage(String kindOfDemage) {
        this.kindOfDemage = kindOfDemage;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
