import java.util.Arrays;
public class ArrayMergeAndSort {
    public static void main(String[] args) {
        int[] array1 = {3, 5, 1, 9};
        int[] array2 = {2, 6, 8, 7};
        int[] mergedArray = mergeArrays(array1, array2);
        Arrays.sort(mergedArray);
        System.out.println("Merged and sorted array: " + Arrays.toString(mergedArray));
    }
    public static int[] mergeArrays(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            mergedArray[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            mergedArray[array1.length + i] = array2[i];
        }
        return mergedArray;
    }
}
