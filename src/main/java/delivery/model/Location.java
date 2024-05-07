package delivery.model;

/**
 * Represents a geographical location with latitude and longitude coordinates.
 */
public class Location {
    double latitude;
    double longitude;

    /**
     * Constructs a Location object with the given latitude and longitude coordinates.
     * @param latitude The latitude coordinate of the location.
     * @param longitude The longitude coordinate of the location.
     */
    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
