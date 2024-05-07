package delivery.service;

import delivery.model.Location;
import delivery.model.Order;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for DeliveryOptimizer.
 */
public class DeliveryOptimizerTest {

    @Test
    public void testCalculateDistance() {
        // Test case for calculateDistance method
        Location loc1 = new Location(40.7128, -74.0060);
        Location loc2 = new Location(40.7306, -73.9352);
        double expectedDistance = 10.441;
        double actualDistance = DeliveryOptimizer.calculateDistance(loc1, loc2);
        assertEquals(expectedDistance, actualDistance, 0.001); // Tolerance of 0.001 km
    }

    @Test
    public void testCalculateTotalTime() {
        // Test case for calculateTotalTime method
        Location startingLocation = new Location(40.7128, -74.0060);
        Location restaurant1 = new Location(40.7306, -73.9352);
        Location restaurant2 = new Location(34.0522, -118.2437);
        Location consumer1 = new Location(40.7128, -74.0060);
        Location consumer2 = new Location(34.0522, -118.2437);

        Order order1 = new Order(consumer1, restaurant1, 15);  // Order from consumer 1 to restaurant 1 with preparation time 15 mins
        Order order2 = new Order(consumer2, restaurant2, 20);  // Order from consumer 2 to restaurant 2 with preparation time 20 mins

        List<Location> path = new ArrayList<>();
        path.add(startingLocation);
        path.add(restaurant1);
        path.add(consumer1);
        path.add(restaurant2);
        path.add(consumer2);

        double speed = 20; // Average speed in km/hr

        double expectedTotalTime = 12.829; // Total time in hours
        double actualTotalTime = DeliveryOptimizer.calculateTotalTime(path, List.of(order1, order2), speed);
        assertEquals(expectedTotalTime, actualTotalTime, 0.001); // Tolerance of 0.001 hours
    }

    @Test
    public void testFindOptimalPath() {
        // Test case for findOptimalPath method
        Location startingLocation = new Location(40.7128, -74.0060);
        Location restaurant1 = new Location(40.7306, -73.9352);
        Location restaurant2 = new Location(34.0522, -118.2437);
        Location consumer1 = new Location(40.7128, -74.0060);
        Location consumer2 = new Location(34.0522, -118.2437);

        Order order1 = new Order(consumer1, restaurant1, 15);  // Order from consumer 1 to restaurant 1 with preparation time 15 mins
        Order order2 = new Order(consumer2, restaurant2, 20);  // Order from consumer 2 to restaurant 2 with preparation time 20 mins

        double speed = 20; // Average speed in km/hr

        List<Location> expectedOptimalPath = new ArrayList<>();
        expectedOptimalPath.add(startingLocation);
        expectedOptimalPath.add(restaurant1);
        expectedOptimalPath.add(consumer1);
        expectedOptimalPath.add(restaurant2);
        expectedOptimalPath.add(consumer2);

        List<Location> actualOptimalPath = DeliveryOptimizer.findOptimalPath(startingLocation, order1, order2, speed);
        assertEquals(expectedOptimalPath, actualOptimalPath);
    }
}
