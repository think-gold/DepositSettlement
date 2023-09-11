package model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Event {
    private final String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Set<Damage> setOfDamages;


    public Event(YearEvents yearEvents, String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.setOfDamages = new HashSet<>();
        yearEvents.addEvent(this);
    }

      public void addDamage(Damage damage) {
        setOfDamages.add(damage);
    }

    public Set<Damage> getDamagesBasedOnClub(SailingClub sailingClub) {
        Set<Damage> damages = new HashSet<>();
        for (Damage item : setOfDamages) {
            if (item.getPenalizedClub().equals(sailingClub)) {
                damages.add(item);
            }
        }
        return damages;
    }

    public Set<Damage> getDamagesBasedOnRaceNo(int raceNo) {
        Set<Damage> damages = new HashSet<>();
        for (Damage item : setOfDamages) {
            if (item.getRaceNr() == raceNo) {
                damages.add(item);
            }
        }
        return damages;
    }

    public Set<Damage> getDamagesBasedOnBoatNr(int boatNumber) {
        Set<Damage> damages = new HashSet<>();
        for (Damage item : setOfDamages) {
            if (item.getBoatNr() == boatNumber) {
                damages.add(item);
            }
        }
        return damages;
    }
}
