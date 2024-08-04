#include <stdio.h>

int main(){
    int count, i, j, elem, flag = 0, min_idx, temp, mid;

    printf("Enter number of entries in array to search from: ");
    scanf("%d", &count);

    int arr[count];
    printf("Enter elements in array: ");
    for (i = 0; i < count; i++){
        scanf("%d", &arr[i]);
    }

    // Selection sort
    for (i = 0; i < (count - 1); i++){
        min_idx = i;
        for (j = i + 1; j < count; j++){
            if (arr[j] < arr[min_idx]){
                min_idx = j;
            }
        }
        temp = arr[min_idx];
        arr[min_idx] = arr[i];
        arr[i] = temp;
    }

    printf("Sorted array is: ");
    for (i = 0; i < count; i++){
        printf("%d ", arr[i]);
    }

    printf("\nElement to search for: ");
    scanf("%d", &elem);

    // Binary search
    int low = 0, high = count - 1;
    while (low <= high) {
        mid = (low + high) / 2;
        if (arr[mid] == elem) {
            flag = 1;
            break;
        }
        if (arr[mid] > elem) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

    if (flag == 1) {
        printf("Element found at index %d.\n", mid);
    } else {
        printf("Element not present.\n");
    }

    return 0;
}
