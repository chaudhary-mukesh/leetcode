public class TwoFurthestHousesWithDifferentColors1 {

    public int maxDistance(int[] houseColors) {

        // This function finds the maximum distance between
        // two houses that have different colors in O(n) time

        // Total number of houses
        int totalHouses = houseColors.length;

        // Variable to store the maximum distance
        int maximumDistance = 0;

        // Step 1: Compare from the start with the last house
        for (int currentIndex = 0; currentIndex < totalHouses; currentIndex++) {

            // If colors are different from the last house
            if (houseColors[currentIndex] != houseColors[totalHouses - 1]) {

                // Update maximum distance
                maximumDistance = Math.max(maximumDistance,
                                           (totalHouses - 1) - currentIndex);
            }
        }

        // Step 2: Compare from the end with the first house
        for (int currentIndex = totalHouses - 1; currentIndex >= 0; currentIndex--) {

            // If colors are different from the first house
            if (houseColors[currentIndex] != houseColors[0]) {

                // Update maximum distance
                maximumDistance = Math.max(maximumDistance,
                                           currentIndex - 0);
            }
        }

        // Return the maximum distance found
        return maximumDistance;
    }
}
