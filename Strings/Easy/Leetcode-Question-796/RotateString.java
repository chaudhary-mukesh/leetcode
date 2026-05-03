public class RotateString {

    public boolean rotateString(String originalString, String targetString) {

        // Step 1: If lengths are different, rotation is not possible
        if (originalString.length() != targetString.length()) {
            return false;
        }

        // Step 2: Concatenate original string with itself
        // This will contain all possible rotations
        String doubledString = originalString + originalString;

        // Step 3: Check if targetString is a substring
        // If yes → it is a valid rotation
        return doubledString.contains(targetString);
    }
}