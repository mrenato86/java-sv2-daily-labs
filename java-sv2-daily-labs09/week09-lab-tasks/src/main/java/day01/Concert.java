package day01;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Concert {

    private List<Person> attendees = new ArrayList<>();

    public void addPerson(Person person, LocalTime actualTime) {
        if (actualTime.isBefore(person.getTicket().entryTime())) {
            throw new IllegalArgumentException("Not a valid entrance");
        }
        attendees.add(person);
    }

    public List<Person> getAttendees() {
        return new ArrayList<>(attendees);
    }
}
