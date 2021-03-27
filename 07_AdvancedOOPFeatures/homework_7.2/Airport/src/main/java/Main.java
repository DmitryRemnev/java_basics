import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static final long TWO_HOURS_IN_MILLISECONDS = 7_200_000;

    public static void main(String[] args) {

        Airport airport = Airport.getInstance();

        for (Flight flight : findPlanesLeavingInTheNextTwoHours(airport)) {
            System.out.println(flight.toString());
        }
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {

        return airport.getTerminals()
                .stream()
                .flatMap((p) -> p.getFlights().stream().filter(flight -> isRightType(flight.getType()) && isRightTime(flight.getDate())))
                .collect(Collectors.toList());
    }

    public static boolean isRightType(Flight.Type type) {
        return type.equals(Flight.Type.DEPARTURE);
    }

    public static boolean isRightTime(Date date) {
        long flightTime = date.getTime();
        long currentTime = System.currentTimeMillis();

        return flightTime - currentTime < TWO_HOURS_IN_MILLISECONDS;
    }
}