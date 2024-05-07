package delivery.service;

import delivery.model.Location;
import delivery.model.Order;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides methods for optimizing delivery routes and calculating total delivery time.
 */
public class DeliveryOptimizer {

    private static final int EARTH_RADIUS_KM = 6371;

    /**
     * Calculates the distance (in kilometers) between two locations using the Haversine formula.
     * @param loc1 The first location.
     * @param loc2 The second location.
     * @return The distance between the two locations in kilometers.
     */
    public static double calculateDistance(Location loc1, Location loc2) {
        // Haversine formula implementation
        double lat1Rad = Math.toRadians(loc1.latitude);
        double lon1Rad = Math.toRadians(loc1.longitude);
        double lat2Rad = Math.toRadians(loc2.latitude);
        double lon2Rad = Math.toRadians(loc2.longitude);

        double deltaLat = lat2Rad - lat1Rad;
        double deltaLon = lon2Rad - lon1Rad;

        double a = Math.pow(Math.sin(deltaLat / 2), 2)
                + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin(deltaLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS_KM * c;
    }

    /**
     * Calculates the total time required to travel along a given path and deliver the orders.
     * @param path The path to be traveled.
     * @param orders The list of orders to be delivered.
     * @param speed The average speed of the delivery executive in kilometers per hour.
     * @return The total time required to complete the delivery.
     */
    public static double calculateTotalTime(List<Location> path, List<Order> orders, double speed) {
        double totalTime = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            Location start = path.get(i);
            Location end = path.get(i + 1);
            double distance = calculateDistance(start, end);
            totalTime += distance / speed;
            if (i % 2 == 0) {
                totalTime += orders.get(i / 2).preparationTime;
            }
        }
        return totalTime;
    }

    /**
     * Finds the optimal path for delivering the given orders in the shortest possible time.
     * @param startingLocation The starting location of the delivery executive.
     * @param order1 The first order to be delivered.
     * @param order2 The second order to be delivered.
     * @param speed The average speed of the delivery executive in kilometers per hour.
     * @return The optimal path for delivering the orders.
     */
    public static List<Location> findOptimalPath(Location startingLocation, Order order1, Order order2, double speed) {
        List<Location> path1 = new ArrayList<>();
        path1.add(startingLocation);
        path1.add(order1.source);
        path1.add(order1.destination);
        path1.add(order2.source);
        path1.add(order2.destination);

        List<Location> path2 = new ArrayList<>();
        path2.add(startingLocation);
        path2.add(order2.source);
        path2.add(order1.source);
        path2.add(order2.destination);
        path2.add(order1.destination);

        double time1 = calculateTotalTime(path1, List.of(order1, order2), speed);
        double time2 = calculateTotalTime(path2, List.of(order1, order2), speed);

        return time1 < time2 ? path1 : path2;
    }
}
