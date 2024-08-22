import java.util.Scanner;
public class Symmetric_Matrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter dimension of square matrix: ");
        //Rectangular matrice can never by symmetric
        int dim = sc.nextInt();
        int mat[][] = new int[dim][dim];

        int i,j,flag = 1;
        System.out.println("ENTER MATRIX ELEMENTS: ");
        for (i=0;i<dim;i++){
            for (j=0;j<dim;j++){
                mat[i][j] = sc.nextInt();
            }
        }

        for (i=0;i<dim;i++){
            for (j=0;j<dim;j++){
                if (mat[i][j] != mat[j][i]){
                        flag = 0;
                        break;
                }
            }
        }

        if (flag == 0){
            System.out.println("NON SYMMETRIC MATRICE");
        }
        else{
            System.out.println("SYMMETRIC MATRICE");
        }

        sc.close();
    }
    
}
