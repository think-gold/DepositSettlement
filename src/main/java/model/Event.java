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
    private static YearEvents yearEvents;


    public Event(String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.setOfClubs = new HashSet<>();
        this.setOfDamages = new HashSet<>();
        yearEvents.addEvent(this);
    }

    public static void addSailingClub (SailingClub sailingClub){
        setOfClubs.add(sailingClub);
    }

    public void addDamage (Damage damage){
        setOfDamages.add(damage);
    }

    public static Set<SailingClub> getSetOfClubs() {
        return setOfClubs;
    }

    public Set<Damage> getDamagesBasedOnClub(SailingClub sailingClub){
        Set<Damage> damages = new HashSet<>();
        for (Damage item: setOfDamages){
            if (item.getPenalizedClub().equals(sailingClub)){
                damages.add(item);
            }
        }
        return damages;
    }

    public Set<Damage> getDamagesBasedOnRaceNo(int raceNo){
        Set<Damage> damages = new HashSet<>();
        for (Damage item: setOfDamages){
            if (item.getRaceNr() == raceNo){
                damages.add(item);
            }
        }
        return damages;
    }
    public Set<Damage> getDamagesBasedOnBoatNr(int boatNumber){
        Set<Damage> damages = new HashSet<>();
        for (Damage item: setOfDamages){
            if (item.getBoatNr() == boatNumber){
                damages.add(item);
            }
        }
        return damages;
    }
}
