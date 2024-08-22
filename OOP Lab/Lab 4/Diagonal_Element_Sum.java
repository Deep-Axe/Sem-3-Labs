import java.util.Scanner;
public class Diagonal_Element_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter dimension of matrix: ");
        int dim = sc.nextInt(); 
        int dim2 = sc.nextInt();
        int mat[][] = new int[dim][dim2];

        int i,j, sum = 0;
        System.out.println("ENTER MATRIX ELEMENTS: ");
        for (i=0;i<dim;i++){
            for (j=0;j<dim2;j++){
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("PRINCIPAL DIAGONAL ELEMENTS ARE: ");  
        for (i=0;i<dim;i++){
            for (j=0;j<dim2;j++){
                if ( i == j){
                    System.out.println(mat[i][j]);
                    sum = sum + (mat[i][j]);
                }
            }
        }
        int sum2 = 0;
        System.out.println("NON PRINCIPAL DIAGONAL ELEMENTS ARE: ");  
        for (i=0;i<dim;i++){
            for (j=(dim2-1);j>=0;j--){

                    if (( i + j + 1) == dim2){
                        System.out.println(mat[i][j]);
                        sum2 = sum2 + (mat[i][j]);
                    }
            }
        }
        System.out.println("SUM OF PRICIPAL DIAGONAL ELEMENTS IS - "+sum);
        System.out.println("SUM OF NON PRINCIPAL DIAGONAL ELEMENTS IS - "+sum2);
        sc.close();
    }
    
}
