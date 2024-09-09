#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX 100

typedef struct {
    int top;
    char items[MAX];
} Stack;

void initStack(Stack* s) {
    s->top = -1;
}

bool isEmpty(Stack* s) {
    return s->top == -1;
}


void push(Stack* s, char item) {
    if (s->top < (MAX - 1)) {
        s->items[++(s->top)] = item;
    } else {
        printf("Stack overflow\n");
        exit(EXIT_FAILURE);
    }
}


char pop(Stack* s) {
    if (!isEmpty(s)) {
        return s->items[(s->top)--];
    } else {
        printf("Stack underflow\n");
        exit(EXIT_FAILURE);
    }
}

char peek(Stack* s) {
    if (!isEmpty(s)) {
        return s->items[s->top];
    } else {
        printf("Stack is empty\n");
        exit(EXIT_FAILURE);
    }
}

bool areParenthesesBalanced(const char* expr) {
    Stack stack;
    initStack(&stack);

    for (int i = 0; expr[i] != '\0'; i++) {
        char ch = expr[i];

        if (ch == '(' || ch == '{' || ch == '[') {
            push(&stack, ch);
        }
        else if (ch == ')' || ch == '}' || ch == ']') {
            if (isEmpty(&stack)) {
                return false;
            }
            char top = pop(&stack);

            if ((ch == ')' && top != '(') ||
                (ch == '}' && top != '{') ||
                (ch == ']' && top != '[')) {
                return false;
            }
        }
    }

    return isEmpty(&stack);
}

int main() {
    char expr[MAX];

    printf("Enter an expression: ");
    fgets(expr, MAX, stdin);

    size_t len = strlen(expr);
    if (len > 0 && expr[len - 1] == '\n') {
        expr[len - 1] = '\0';
    }

    if (areParenthesesBalanced(expr)) {
        printf("The parentheses are balanced.\n");
    } else {
        printf("The parentheses are not balanced.\n");
    }

    return 0;
}
