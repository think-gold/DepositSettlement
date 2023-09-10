package model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Event {
    private final String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private static Set<SailingClub> setOfClubs;
    private static Set<Damage> setOfDamages;


    public Event(String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.setOfClubs = new HashSet<>();
        this.setOfDamages = new HashSet<>();
    }

    public static void addSailingClub (SailingClub sailingClub){
        setOfClubs.add(sailingClub);
    }

    public void addDamage (Damage damage){
        setOfDamages.add(damage);
    }
}
