#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX 100

typedef struct {
    int top;
    char items[MAX];
} Stack;

void initStack(Stack* s) {
    s->top = -1;
}

int isEmpty(Stack* s) {
    return s->top == -1;
}


void push(Stack* s, char* item) {
    if (s->top < MAX - 1) {
        s->items[++(s->top)] = *item;
    } else {
        printf("Stack overflow\n");
        exit(EXIT_FAILURE);
    }
}


char* pop(Stack* s) {
    if (!isEmpty(s)) {
        return &s->items[(s->top)--];
    } else {
        printf("Stack underflow\n");
        exit(EXIT_FAILURE);
    }
}

/*void reverseString(char* str) {
    int length = strlen(str);
    for (int i = 0; i < length / 2; i++) {
        char temp = str[i];
        str[i] = str[length - i - 1];
        str[length - i - 1] = temp;
    }
}*/
// didn't use reversing here, started from i = len instead in the for loop


void prefixToInfix(char* prefix, char* infix) {
    Stack s;
    initStack(&s);
    int length = strlen(prefix);
    char temp[MAX];


    for (int i = length - 1; i >= 0; i--) {
        char c = prefix[i];


        if (isspace(c)) continue;

        if (isalnum(c)) {

            char* operand = (char*)malloc(2 * sizeof(char));
            operand[0] = c;
            operand[1] = '\0';
            push(&s, operand);
        } else if (c == '+' || c == '-' || c == '*' || c == '/') {

            char* op1 = pop(&s);
            char* op2 = pop(&s);

            sprintf(temp, "(%s %c %s)", op1, c, op2);

            char* newExpr = (char*)malloc(strlen(temp) + 1);
            strcpy(newExpr, temp);
            push(&s, newExpr);
        } else {
            printf("Invalid character %c in the expression\n", c);
            exit(EXIT_FAILURE);
        }
    }

    char* result = pop(&s);
    strcpy(infix, result);
    free(result);
}

int main() {
    char prefix[MAX], infix[MAX];

    printf("Enter a prefix expression: ");
    fgets(prefix, MAX, stdin);

    size_t len = strlen(prefix);
    if (len > 0 && prefix[len - 1] == '\n') {
        prefix[len - 1] = '\0';
    }
    prefixToInfix(prefix, infix);
    printf("Infix expression: %s\n", infix);

    return 0;
}
