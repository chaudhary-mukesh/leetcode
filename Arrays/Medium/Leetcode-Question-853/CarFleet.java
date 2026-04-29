import java.util.Arrays;

public class CarFleet {

    public int carFleet(int targetDistance, int[] positions, int[] speeds) {

        int numberOfCars = positions.length;

        // Each car will store:
        // [0] -> position
        // [1] -> time required to reach target
        double[][] carData = new double[numberOfCars][2];

        // Step 1: Prepare car data (position + time to reach target)
        for (int i = 0; i < numberOfCars; i++) {
            carData[i][0] = positions[i];

            // Time = distance / speed
            carData[i][1] = (double) (targetDistance - positions[i]) / speeds[i];
        }

        // Step 2: Sort cars based on position in descending order
        // (Start checking from the car closest to the target)
        Arrays.sort(carData, (a, b) -> Double.compare(b[0], a[0]));

        int fleetCount = 0;

        // This will track the slowest time (fleet leader time)
        double lastFleetTime = 0;

        // Step 3: Traverse cars from closest to farthest
        for (double[] car : carData) {

            double currentCarTime = car[1];

            // If current car takes more time than the previous fleet,
            // it cannot catch up → forms a new fleet
            if (currentCarTime > lastFleetTime) {
                fleetCount++;

                // Update fleet time to current car's time
                lastFleetTime = currentCarTime;
            }
            // Else:
            // This car joins the existing fleet (no new count)
        }

        return fleetCount;
    }
}