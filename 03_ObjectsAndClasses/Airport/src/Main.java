import com.skillbox.airport.Airport;

public class Main {

    public static void main(String[] args) {

        Airport airport = Airport.getInstance();
        int aircraftCount = airport.getAllAircrafts().size();
        System.out.println(aircraftCount);
    }
}
