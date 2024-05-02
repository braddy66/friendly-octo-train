import java.util.*;

public class RectanglePoints {

    // A method to find the largest rectangle in a matrix of 0s and 1s
    public static int largestRectangle(int[][] matrix) {
        int n = matrix.length; // Number of rows
        int m = matrix[0].length; // Number of columns
        int maxArea = 0; // Maximum area of the rectangle

        // Create two auxiliary arrays to store the maximum width of each row and column
        int[][] rowWidth = new int[n][m];
        int[][] colWidth = new int[n][m];

        // Fill the rowWidth array from left to right
        for (int i = 0; i < n; i++) {
            int width = 0;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    width++;
                } else {
                    width = 0;
                }
                rowWidth[i][j] = width;
            }
        }

        // Fill the colWidth array from top to bottom
        for (int j = 0; j < m; j++) {
            int width = 0;
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] == 1) {
                    width++;
                } else {
                    width = 0;
                }
                colWidth[i][j] = width;
            }
        }

        // Traverse the matrix and find the largest rectangle for each cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    // Get the minimum width of the row and column at this cell
                    int minWidth = Math.min(rowWidth[i][j], colWidth[i][j]);
                    // Try all possible heights from minWidth to 1
                    for (int h = minWidth; h >= 1; h--) {
                        // Get the minimum width of the row and column at the top-left corner of the rectangle
                        int tlRowWidth = rowWidth[i - h + 1][j];
                        int tlColWidth = colWidth[i][j - h + 1];
                        // Check if the rectangle is valid by comparing the widths
                        if (tlRowWidth >= h && tlColWidth >= h) {
                            // Update the maximum area if needed
                            maxArea = Math.max(maxArea, h * h);
                            break; // No need to try smaller heights
                        }
                    }
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt(); // Number of rows in the matrix
            int m = sc.nextInt(); // Number of columns in the matrix
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            System.out.println(largestRectangle(matrix));
        }
        sc.close();
    }
}
