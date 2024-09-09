#include <stdio.h>

#define MAX 100

typedef struct {
    int row;
    int col;
    int value;
} SparseMatrixEntry;


void printSparseMatrix(SparseMatrixEntry matrix[], int nonZeroCount) {
    for (int i = 0; i < nonZeroCount; i++) {
        printf("Row: %d, Column: %d, Value: %d\n", matrix[i].row, matrix[i].col, matrix[i].value);
    }
}


void transposeSparseMatrix(SparseMatrixEntry input[], SparseMatrixEntry output[], int nonZeroCount) {
    int outputIndex = 0;

    for (int i = 0; i < nonZeroCount; i++) {

        output[outputIndex].row = input[i].col;
        output[outputIndex].col = input[i].row;
        output[outputIndex].value = input[i].value;
        outputIndex++;
    }
}


int main() {
    int nonZeroCount;

    printf("Enter the number of non-zero elements in the sparse matrix: ");
    scanf("%d", &nonZeroCount);

    if (nonZeroCount > MAX) {
        printf("Error: Number of non-zero elements exceeds maximum limit of %d.\n", MAX);
        return 1;
    }

    SparseMatrixEntry matrix[MAX];
    SparseMatrixEntry transpose[MAX];


    printf("Enter the entries of the sparse matrix (row column value):\n");
    for (int i = 0; i < nonZeroCount; i++) {
        printf("Entry %d: ", i + 1);
        scanf("%d %d %d", &matrix[i].row, &matrix[i].col, &matrix[i].value);
    }


    transposeSparseMatrix(matrix, transpose, nonZeroCount);


    printf("\nOriginal Sparse Matrix:\n");
    printSparseMatrix(matrix, nonZeroCount);

    printf("\nTransposed Sparse Matrix:\n");
    printSparseMatrix(transpose, nonZeroCount);

    return 0;
}
