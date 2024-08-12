#include <stdio.h>
#include <stdlib.h>
#define MAX_SIZE 100

typedef struct {
    int row;
    int column;
    int value;
} Sparse;
void set(Sparse *s, int r, int c, int v) {
    s->row = r;
    s->column = c;
    s->value = v;
}
void FTranspose(Sparse *a, Sparse *b, int numElements) {
    int r = a[0].row;
    int c = a[0].column;
    int v = a[0].value;
    int frequency[MAX_SIZE] = {0};
    int start[MAX_SIZE];

    set(&b[0], c, r, v);
    if (v > 0) {
        for (int i = 1; i <= v; i++) {
            frequency[a[i].column]++;
        }
        start[0] = 1;
        for (int i = 1; i < c; i++) {
            start[i] = start[i - 1] + frequency[i - 1];
        }
        for (int i = 1; i <= v; i++) {
            int j = start[a[i].column]++;
            set(&b[j], a[i].column, a[i].row, a[i].value);
        }
    }
}
void display(Sparse *s, int numElements) {
    for (int i = 0; i <= numElements; i++) {
        printf("%d %d %d\n", s[i].row, s[i].column, s[i].value);
    }
}
int main() {
    int m, n;
    printf("Enter the size of the matrix (rows columns):\n");
    scanf("%d %d", &m, &n);

    int arr[m][n];
    int count = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            printf("Enter [%d][%d]: ", i, j);
            scanf("%d", &arr[i][j]);
            if (arr[i][j] != 0)
                count++;
        }
    }
    printf("ORIGINAL MATRIX \n");
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            printf("%d ", arr[i][j]);
        }
        printf("\n");
    }

    Sparse s[count + 1];
    set(&s[0], m, n, count);
    int k = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (arr[i][j] != 0) {
                set(&s[++k], i, j, arr[i][j]);
            }
        }
    }
    printf("Matrix before Transposing:\n");
    display(s, count);

    Sparse b[count + 1];
    FTranspose(s, b, count + 1);

    printf("Matrix after Transposing:\n");
    display(b, count);
    return 0;
}
