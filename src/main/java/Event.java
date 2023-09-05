import java.time.LocalDate;

public class Event {
    String name;
    LocalDate startDateOfEvent;

    public Event(String name, LocalDate startDateOfEvent) {
        this.name = name;
        this.startDateOfEvent = startDateOfEvent;
    }
}
