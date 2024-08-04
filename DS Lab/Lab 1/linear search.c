#include <stdio.h>
int main(){
    int count,i, elem, flag = 0;
    printf("Enter number of entries in array to search from: ");
    scanf("%d", &count);

    int arr[count];
    printf("Enter elements in array: ");
    for (i=0;i<count;i++){
        scanf("%d", &arr[i]);
    }

    printf("Enter element to search for: ");
    scanf("%d", &elem);
    for (i=0;i<count;i++){
        if (arr[i] == elem){
            flag = 1;
            break;
        }
    }
    if (flag == 1){
        printf("Element found at index %d",i);
    }
    else{
        printf("Element not found");
    }
    return 0;

}
