package delivery;

import delivery.model.Location;
import delivery.model.Order;
import delivery.service.DeliveryOptimizer;
import java.util.List;

/**
 * Main class to demonstrate the usage of DeliveryOptimizer.
 */
public class Main {
    public static void main(String[] args) {
        // Example usage
        Location startingLocation = new Location(40.7128, -74.0060);
        Location restaurant1 = new Location(40.7306, -73.9352);
        Location restaurant2 = new Location(34.0522, -118.2437);
        Location consumer1 = new Location(40.7128, -74.0060);
        Location consumer2 = new Location(34.0522, -118.2437);

        Order order1 = new Order(consumer1, restaurant1, 15);  // Order from consumer 1 to restaurant 1 with preparation time 15 mins
        Order order2 = new Order(consumer2, restaurant2, 20);  // Order from consumer 2 to restaurant 2 with preparation time 20 mins

        double speed = 20; // Average speed in km/hr given in problem

        List<Location> optimalPath = DeliveryOptimizer.findOptimalPath(startingLocation, order1, order2, speed);
        System.out.println("Optimal Path: " + optimalPath);
    }
}
