#include <stdio.h>
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

void PrefixToPostfix(char exp[]) {
    initStack();
    int length = strlen(exp);

    for (int i = length - 1; i >= 0; i--) {

        if (isalnum(exp[i])) {
            char operand[2];
            operand[0] = exp[i];
            operand[1] = '\0';
            push(operand);
        }
        else if (strchr("+-*/^", exp[i])) {
            char op1[MAX], op2[MAX], result[MAX];

            pop(op1);
            pop(op2);
            strcpy(result, op1);
            strcat(result, op2);
            strncat(result, &exp[i], 1);
            push(result);
        }
    }
    char postfix[MAX];
    pop(postfix);

    printf("Postfix expression: %s\n", postfix);
}

int main() {
    char prefix[MAX];

    printf("Enter a prefix expression: ");
    gets(prefix);

    PrefixToPostfix(prefix);
    return 0;
}
