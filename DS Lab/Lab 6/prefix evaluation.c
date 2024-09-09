#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

#define MAX 100

typedef struct {
    int top;
    int items[MAX];
} Stack;

void initStack(Stack* s) {
    s->top = -1;
}

int isEmpty(Stack* s) {
    return s->top == -1;
}

void push(Stack* s, int item) {
    if (s->top < MAX - 1) {
        s->items[++(s->top)] = item;
    } else {
        printf("Stack overflow\n");
        exit(EXIT_FAILURE);
    }
}

int pop(Stack* s) {
    if (!isEmpty(s)) {
        return s->items[(s->top)--];
    } else {
        printf("Stack underflow\n");
        exit(EXIT_FAILURE);
    }
}

int evaluatePrefix(char* expr) {
    Stack s;
    initStack(&s);
    int i;


    for (i = strlen(expr) - 1; i >= 0; i--) {
        char c = expr[i];

        if (isspace(c)) continue;

        if (isdigit(c)) {
            push(&s, c - '0');
        } else if (c == '+' || c == '-' || c == '*' || c == '/') {

            int op1 = pop(&s);
            int op2 = pop(&s);

            switch (c) {
                case '+': push(&s, op1 + op2); break;
                case '-': push(&s, op1 - op2); break;
                case '*': push(&s, op1 * op2); break;
                case '/': push(&s, op1 / op2); break;
                default: printf("Unknown operator %c\n", c); exit(EXIT_FAILURE);
            }
        } else {
            printf("Invalid character %c in the expression\n", c);
            exit(EXIT_FAILURE);
        }
    }
    return pop(&s);
}

int main() {
    char expr[MAX];

    printf("Enter a prefix expression: ");
    fgets(expr, MAX, stdin);


    size_t len = strlen(expr);
    if (len > 0 && expr[len - 1] == '\n') {
        expr[len - 1] = '\0';
    }

    int result = evaluatePrefix(expr);
    printf("Result: %d\n", result);

    return 0;
}
