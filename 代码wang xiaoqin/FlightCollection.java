import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FlightCollection {
    private static final Map<Integer, Flight> flights = new HashMap<>();
    private static final Set<String> VALID_CITIES = new HashSet<>();

    static {
        // 初始化有效城市列表
        VALID_CITIES.add("New York");
        VALID_CITIES.add("London");
        VALID_CITIES.add("Sydney");
        VALID_CITIES.add("Tokyo");
        VALID_CITIES.add("Paris");
        VALID_CITIES.add("Berlin");
        VALID_CITIES.add("Shanghai");
        VALID_CITIES.add("Beijing");
        VALID_CITIES.add("Los Angeles");
        VALID_CITIES.add("Moscow");
        VALID_CITIES.add("Melbourne");
    }

    public static ArrayList<Flight> getFlights() {
        return new ArrayList<>(flights.values());
    }

    public static void addFlights(ArrayList<Flight> newFlights) {
        if (newFlights == null) {
            throw new IllegalArgumentException("Cannot add null list of flights.");
        }
        for (Flight flight : newFlights) {
            if (isValidFlight(flight)) {
                flights.put(flight.getFlightID(), flight);
            } else {
                throw new IllegalArgumentException("Invalid flight data.");
            }
        }
    }

    public static void updateFlight(Flight updatedFlight) {
        if (updatedFlight == null || !flights.containsKey(updatedFlight.getFlightID())) {
            throw new IllegalArgumentException("Flight does not exist or invalid flight data.");
        }
        if (isValidFlight(updatedFlight)) {
            flights.put(updatedFlight.getFlightID(), updatedFlight);
        } else {
            throw new IllegalArgumentException("Invalid flight data.");
        }
    }

    public static void removeFlight(int flightID) {
        if (!flights.containsKey(flightID)) {
            throw new IllegalArgumentException("Flight with given ID does not exist.");
        }
        flights.remove(flightID);
    }

    private static boolean isValidFlight(Flight flight) {
        return flight != null && isValidCity(flight.getDepartTo()) && isValidCity(flight.getDepartFrom());
    }

    private static boolean isValidCity(String city) {
        return VALID_CITIES.contains(city);
    }

    public static Flight getFlightInfo(String cityto, String cityfrom) {
        for (Flight flight : flights.values()) {
            if (flight.getDepartTo().equalsIgnoreCase(cityto) && flight.getDepartFrom().equalsIgnoreCase(cityfrom)) {
                return flight;
            }
        }
        return null;
    }

    public static Flight getFlightInfo(String city) {
        for (Flight flight : flights.values()) {
            if (flight.getDepartTo().equalsIgnoreCase(city) || flight.getDepartFrom().equalsIgnoreCase(city)) {
                return flight;
            }
        }
        return null;
    }

    public static Flight getFlightInfo(int flight_id) {
        return flights.get(flight_id);
    }
}

