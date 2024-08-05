#include <stdio.h>

#define MAX 100

// Function to calculate the length of a string
int Length(char a[]) {
    int length = 0;
    while (a[length] != '\0') {
        length++;
    }
    return length;
}

// Function to remove newline character if present
void removeNewline(char *str) {
    int len = Length(str);
    if (len > 0 && str[len - 1] == '\n') {
        str[len - 1] = '\0';
    }
}

int main() {
    char str1[MAX], str2[MAX], str3[MAX], str4[MAX];
    char str5[MAX], str6[MAX];
    char str7[MAX], str8[MAX];
    int i, length, j, ind, superstr_len, substr_len;

    printf("Enter string 1: ");
    fgets(str1, sizeof(str1), stdin);
    removeNewline(str1);

    printf("Enter string 2: ");
    fgets(str2, sizeof(str2), stdin);
    removeNewline(str2);

    length = Length(str1);
    printf("Length of the first string is %d.\n", length);

    // Concatenate
    i = length;
    j = 0;
    while (str2[j] != '\0') {
        str1[i] = str2[j];
        j++;
        i++;
    }
    str1[i] = '\0'; // End the string
    printf("Concatenated string is: %s\n", str1);

    // String comparison
    printf("Enter string 1 for comparing: ");
    fgets(str3, sizeof(str3), stdin);
    removeNewline(str3);

    printf("Enter string 2 for comparing: ");
    fgets(str4, sizeof(str4), stdin);
    removeNewline(str4);

    int str3_len = Length(str3);
    int str4_len = Length(str4);
    int flag = 0;

    if (str3_len != str4_len) {
        flag = 1;
    } else {
        i = 0;
        while (str3[i] != '\0' && str4[i] != '\0') {
            if (str3[i] != str4[i]) {
                flag = 1;
                break;
            }
            i++;
        }
    if (flag == 1)
        printf("DIFFERENT STRING\n");
    else
        printf("SAME STRING\n");
    }

    // String insertion
    printf("Enter super-string: ");
    fgets(str5, sizeof(str5), stdin);
    removeNewline(str5);

    printf("Enter sub-string: ");
    fgets(str6, sizeof(str6), stdin);
    removeNewline(str6);

    printf("Enter index for insertion: ");
    scanf("%d", &ind);
    getchar(); // consume the newline left by scanf

    superstr_len = Length(str5);
    substr_len = Length(str6);

    if (ind > superstr_len) {
        ind = superstr_len;
        printf("Index clipped to last possible insertion point\n");
    }

    // Right character shift for substring
    for (i = superstr_len - 1; i >= ind; i--) {
        str5[i + substr_len] = str5[i];
    }
    // Insert the substring
    for (i = 0; i < substr_len; i++) {
        str5[ind + i] = str6[i];
    }
    str5[superstr_len + substr_len] = '\0';
    printf("String after insertion: %s\n", str5);

    // String deletion
    printf("Enter super-string: ");
    fgets(str7, sizeof(str7), stdin);
    removeNewline(str7);

    printf("Enter sub-string for deletion: ");
    fgets(str8, sizeof(str8), stdin);
    removeNewline(str8);

    int sup_len = Length(str7);
    int del_len = Length(str8);
    int found = 0;

    for (j = 0; j <= sup_len - del_len; j++) {
        int k;
        for (k = 0; k < del_len; k++) {
            if (str7[j + k] != str8[k]) {
                break;
            }
        }
        if (k == del_len) {
            found = 1;
            for (k = j; k <= sup_len - del_len; k++) {
                str7[k] = str7[k + del_len];
            }
            str7[sup_len - del_len] = '\0';
            sup_len -= del_len;
            j--; // Check same position for multiple occurrences
        }
    }

    if (found) {
        printf("Resulting string after deletion: %s\n", str7);
    } else {
        printf("NO SUBSTRING FOUND\n");
    }

    return 0;
}
