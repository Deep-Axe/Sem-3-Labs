public class MinMaxFinder {

    public static void main(String[] args) {
        int[] array = {3, 5, 1, 2, 9, 9, 4};


        int[] result = findMinMax(array);
        System.out.println("Minimum value: " + result[0]);
        System.out.println("Maximum value: " + result[1]);
    }

    public static int[] findMinMax(int[] array) {

        int minValue = array[0];
        int maxValue = array[0];

        for (int num : array) {
            if (num < minValue) {
                minValue = num;
            } else if (num > maxValue) {
                maxValue = num;
            }
        }

        return new int[]{minValue, maxValue};
    }
}
