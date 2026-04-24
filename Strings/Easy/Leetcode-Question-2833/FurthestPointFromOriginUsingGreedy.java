public class FurthestPointFromOriginUsingGreedy {

    public int furthestDistanceFromOrigin(String moves) {

        // Count how many times we move left, right, and unknown ('_')
        int leftMoves = 0;
        int rightMoves = 0;
        int flexibleMoves = 0; // '_' can be used as either L or R

        // Traverse the input string
        for (char move : moves.toCharArray()) {

            if (move == 'L') {
                leftMoves++;
            } 
            else if (move == 'R') {
                rightMoves++;
            } 
            else {
                // This represents '_' (flexible move)
                flexibleMoves++;
            }
        }

        // Core idea:
        // To maximize distance from origin,
        // we should use all flexible moves ('_') in the direction
        // that increases the imbalance between left and right.

        // Current imbalance = |leftMoves - rightMoves|
        // Each flexible move can increase this imbalance by 1

        int baseDistance = Math.abs(leftMoves - rightMoves);

        // Add all flexible moves to maximize final distance
        int maximumDistance = baseDistance + flexibleMoves;

        // Return final answer
        return maximumDistance;
    }
}