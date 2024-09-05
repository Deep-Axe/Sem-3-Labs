public class Swap {

    public static void swapPrimitives(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("Inside swapPrimitives method: a = " + a + ", b = " + b);
    }

    public static void swapReferences(int[] arr1, int[] arr2) {
        int temp = arr1[0];
        arr1[0] = arr2[0];
        arr2[0] = temp;
        System.out.println("Inside swapReferences method: arr1[0] = " + arr1[0] + ", arr2[0] = " + arr2[0]);
    }

    public static void main(String[] args) {

        int x = 10;
        int y = 20;

        System.out.println("Before swapPrimitives: x = " + x + ", y = " + y);
        swapPrimitives(x, y);
        System.out.println("After swapPrimitives: x = " + x + ", y = " + y);

        int[] array1 = {10};
        int[] array2 = {20};

        System.out.println("Before swapReferences: array1[0] = " + array1[0] + ", array2[0] = " + array2[0]);
        swapReferences(array1, array2);
        System.out.println("After swapReferences: array1[0] = " + array1[0] + ", array2[0] = " + array2[0]);
    }
}
