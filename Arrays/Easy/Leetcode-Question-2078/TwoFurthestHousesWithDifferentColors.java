public class TwoFurthestHousesWithDifferentColors {

    public int maxDistance(int[] houseColors) {

        // This function finds the maximum distance between
        // two houses that have different colors

        // Total number of houses
        int totalHouses = houseColors.length;

        // Variable to store the maximum distance found
        int maximumDistance = 0;

        // Outer loop: pick the first house
        for (int firstHouseIndex = 0; firstHouseIndex < totalHouses; firstHouseIndex++) {

            // Inner loop: pick the second house after the first one
            for (int secondHouseIndex = firstHouseIndex + 1; secondHouseIndex < totalHouses; secondHouseIndex++) {

                // Check if the two houses have different colors
                if (houseColors[firstHouseIndex] != houseColors[secondHouseIndex]) {

                    // Update the maximum distance if current distance is larger
                    maximumDistance = Math.max(maximumDistance,
                                               secondHouseIndex - firstHouseIndex);
                }
            }
        }

        // Return the maximum distance found
        return maximumDistance;
    }
}