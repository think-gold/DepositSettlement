package model;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
@Getter
public class YearEvents {
    private int year;
    private Set<Event> setOfEvents;
    private Set<SailingClub> setOfClubs;
    YearEvents(int year){
        this.year = year;
        this.setOfEvents = new HashSet<>();
        this.setOfClubs = new HashSet<>();
    }

    public void addEvent(Event event){
        setOfEvents.add(event);
    }
    public void addSailingCub(SailingClub sailingClub){
        setOfClubs.add(sailingClub);
    }
}
