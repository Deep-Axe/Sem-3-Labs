#include <stdio.h>
void bubble(int arr[], int count){

    int i,temp,j;
    for (i=0;i<count-1;i++){
       for (j=0; j<count-i-1;j++){
            if (arr[j] > arr[j+1]){
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                }
            }
    }
    printf("Sorted array using Bubble Sort: ");
    for (i=0;i<count;i++){
        printf("%d ", arr[i]);
    }
    printf("\n");
}

void insertion(int arr[], int count){   
    int key, i, j;    
        for (i = 1; i < count; i++) {
        key = arr[i];
        j = i - 1;

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
    printf("Sorted Array using Insertion Sort: ");
    for (i = 0; i < count; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}
int main(){
    int count,i;
    printf("Enter number of entries in array: ");
    scanf("%d", &count);

    int arr[count];
    printf("Enter elements in array: ");
    for (i=0;i<count;i++){
        scanf("%d", &arr[i]);
    }

    bubble(arr, count);
    insertion(arr, count);
    return 0;
}

