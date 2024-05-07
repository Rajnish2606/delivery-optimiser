# delivery-optimiser
Delivery Optimiser for Lucidity Hiring Challenge

# Delivery Optimizer

This Java application optimizes the delivery route for two orders in the shortest possible time.

## Usage

1. **Location**: Represents a geographical location with latitude and longitude coordinates.

2. **Order**: Represents a delivery order with source and destination locations, along with the preparation time.

3. **DeliveryOptimizer**: Provides methods for optimizing delivery routes and calculating total delivery time.

4. **Main**: Main class to demonstrate the usage of DeliveryOptimizer.

## Installation

1. Clone the repository:

git clone https://github.com/Rajnish2606/delivery-optimiser


2. Open the project in your Java IDE (e.g., IntelliJ IDEA).

3. Run the `Main` class to see the optimal delivery route for the given orders.


## use Cases

#### Pickup one order, deliver it, then pickup and deliver the second order: The delivery executive picks up the first order from its source, delivers it to its destination, then picks up the second order from its source and delivers it to its destination.
#### Pickup both orders first, then deliver them in an optimized sequence: The delivery executive picks up both orders from their respective sources without any specific order, then delivers them in an optimized sequence to their respective destinations to minimize the total delivery time.
#### Alternative sequence: Both the above scenarios are also considered with an alternative sequence where the delivery executive picks up the second order first before the first order.

## Note

### I had considered only two orders in a batch.

