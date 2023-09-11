package model;

import java.util.Set;

public class YearEvents {
    private int year;
    private Set<Event> setOfEvents;

    public void addEvent(Event event){
        setOfEvents.add(event);
    }
}
