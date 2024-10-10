import java.util.Scanner;
//doing custom overflow exception instead of inbuilt arrayoutofbounds exception
class ArrayOverflowException extends Exception {
    public ArrayOverflowException(String message) {
        super(message);
        
    }
    public ArrayOverflowException(Exception e) {
        super(e);
        
    }
    
}

public class ArrayOverflowCustomException {
    private int[] array;
    private int size;
    private int index;

    public ArrayOverflowCustomException(int size) {
        this.size = size;
        this.array = new int[size];
        this.index = 0;
    }

    public void add(int item) throws ArrayOverflowException {
        if (index >= size) {
            throw new ArrayOverflowException("Array size limit reached.");
        }
        array[index++] = item;
    }

    public int get(int index) {
        if (index < 0 || index >= this.index) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        return array[index];
    }



    public static void main(String[] args) {
        ArrayOverflowCustomException array = new ArrayOverflowCustomException(5);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in array: (predefined max : 5)");
        int num = sc.nextInt();
        int cnt;
        try {
            for (int i = 0; i < num; i++) {
                System.out.println("Enter element to be added: ");
                cnt = sc.nextInt();
                array.add(cnt);
                System.out.println("Element added: "+cnt);
            }
        } catch (ArrayOverflowException e) {
            System.out.println(e);
        }
        sc.close();
    }
}
