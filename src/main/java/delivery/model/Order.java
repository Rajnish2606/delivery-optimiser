package delivery.model;

/**
 * Represents a delivery order with source and destination locations, along with the preparation time.
 */
public class Order {
    Location source;
    Location destination;
    double preparationTime;

    /**
     * Constructs an Order object with the given source, destination, and preparation time.
     * @param source The source location of the order.
     * @param destination The destination location of the order.
     * @param preparationTime The preparation time required for the order.
     */
    public Order(Location source, Location destination, double preparationTime) {
        this.source = source;
        this.destination = destination;
        this.preparationTime = preparationTime;
    }
}
