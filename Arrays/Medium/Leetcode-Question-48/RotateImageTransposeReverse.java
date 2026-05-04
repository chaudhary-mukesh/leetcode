public class RotateImageTransposeReverse {

    public void rotate(int[][] matrix) {

        int matrixSize = matrix.length;

        // Step 1: Transpose the matrix
        // Convert rows into columns
        for (int row = 0; row < matrixSize; row++) {
            for (int col = row; col < matrixSize; col++) {

                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int row = 0; row < matrixSize; row++) {

            int left = 0;
            int right = matrixSize - 1;

            while (left < right) {

                int temp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;

                left++;
                right--;
            }
        }
    }
}