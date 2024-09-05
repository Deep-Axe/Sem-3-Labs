public class MatrixSearch {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 2, 7, 2},
            {9, 2, 2, 10}
        };
        int target = 2;
        int occurrences = countOccurrences(matrix, target);
        System.out.println("Occurrences of " + target + ": " + occurrences);
    }

    public static int countOccurrences(int[][] matrix, int target) {

        int count = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                if (element == target) {
                    count++;
                }
            }
        }
        return count;
    }
}
