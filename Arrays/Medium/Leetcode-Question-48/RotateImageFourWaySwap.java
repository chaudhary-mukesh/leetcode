public class RotateImageFourWaySwap {

    public void rotate(int[][] matrix) {

        int matrixSize = matrix.length;

        // Traverse only half the rows and half the columns
        // because we rotate 4 elements at a time
        for (int row = 0; row < (matrixSize + 1) / 2; row++) {

            for (int col = 0; col < matrixSize / 2; col++) {

                // Store top-left value
                int topLeft = matrix[row][col];

                // Move bottom-left → top-left
                matrix[row][col] = matrix[matrixSize - 1 - col][row];

                // Move bottom-right → bottom-left
                matrix[matrixSize - 1 - col][row] =
                        matrix[matrixSize - 1 - row][matrixSize - 1 - col];

                // Move top-right → bottom-right
                matrix[matrixSize - 1 - row][matrixSize - 1 - col] =
                        matrix[col][matrixSize - 1 - row];

                // Move saved top-left → top-right
                matrix[col][matrixSize - 1 - row] = topLeft;
            }
        }
    }
}