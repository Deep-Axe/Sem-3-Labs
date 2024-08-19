#include <stdio.h>
#include <ctype.h>
#include <string.h>

#define MAX 100

struct Stack {
    int top;
    char items[MAX][MAX];
} stack;

void initStack() {
    stack.top = -1;
}

int isEmpty() {
    return stack.top == -1;
}

void push(char value[]) {
    if (stack.top < MAX - 1) {
        stack.top++;
        strcpy(stack.items[stack.top], value);
    }
}

void pop(char result[]) {
    if (!isEmpty()) {
        strcpy(result, stack.items[stack.top]);
        stack.top--;
    }
}

void postfixToInfix(char exp[]) {
    initStack();
    char result[MAX], op1[MAX], op2[MAX];
    int i = 0, j;

    while (exp[i] != '\0') {
        if (isalnum(exp[i])) {
            char operand[2] = {exp[i], '\0'};
            push(operand);
        } else {
            pop(op1);
            pop(op2);

            result[0] = '(';
            j = 1;

            strcpy(&result[j], op2);
            j += strlen(op2);

            result[j++] = exp[i];

            strcpy(&result[j], op1);
            j += strlen(op1);

            result[j++] = ')';
            result[j] = '\0';

            push(result);
        }
        i++;
    }

    pop(result);
    printf("Infix Expression: %s\n", result);
}

int main() {
    char exp[MAX];
    printf("Enter postfix expression: ");
    scanf("%s", exp);

    postfixToInfix(exp);

    return 0;
}