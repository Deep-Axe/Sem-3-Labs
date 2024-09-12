#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX 100

int top = -1;
char stack[MAX];

void push(char a) {
    if (top < MAX - 1) {
        stack[++top] = a;
    }
}

char pop() {
    if (top >= 0) {
        return stack[top--];
    }
    return '\0';
}

int isEmpty() {
    return top == -1;
}

void printLetterFrequency(char *s) {
    int freq[26] = {0};
    char ch;

    for (int i = 0; s[i] != '\0'; i++) {
        ch = tolower(s[i]);
        if (ch >= 'a' && ch <= 'z') {
            freq[ch - 'a']++;
        }
    }

    printf("\nLetter Frequencies:\n");
    for (int i = 0; i < 26; i++) {
        if (freq[i] > 0) {
            printf("%c: %d\n", 'a' + i, freq[i]);
        }
    }
}

int main() {
    char s[MAX];
    char b;

    printf("Enter the String: ");
    fgets(s, MAX, stdin);
    s[strcspn(s, "\n")] = '\0';

    if (strchr(s, ' ')) {
        printf("BLANK SPACE NOT VALID, EXITING PROGRAM\n");
        return 1;
    }

    int length = strlen(s);
    int front = 0;
    int back = length - 1;
    int isPalindrome = 1;

    while (front < back) {
        if (s[front] != s[back]) {
            isPalindrome = 0;
            break;
        }
        front++;
        back--;
    }

    if (isPalindrome) {
        printf("%s is a palindrome.\n", s);
    } else {
        printf("%s is not a palindrome.\n", s);
    }

    printLetterFrequency(s);

    return 0;
}
