#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX 100

typedef struct {
    int top;
    char items[MAX][MAX];
} Stack;

void initStack(Stack* s) {
    s->top = -1;
}

int isEmpty(Stack* s) {
    return s->top == -1;
}

void push(Stack* s, const char* item) {
    if (s->top < MAX - 1) {
        strcpy(s->items[++(s->top)], item);
    } else {
        printf("Stack overflow\n");
        exit(EXIT_FAILURE);
    }
}


void pop(Stack* s, char* item) {
    if (!isEmpty(s)) {
        strcpy(item, s->items[(s->top)--]);
    } else {
        printf("Stack underflow\n");
        exit(EXIT_FAILURE);
    }
}


void postfixToPrefix(const char* postfix, char* prefix) {
    Stack s;
    initStack(&s);
    char temp[MAX];
    int i;

    for (i = 0; postfix[i]; i++) {
        char c = postfix[i];

        if (isspace(c)) continue;

        if (isalnum(c)) {

            char operand[2] = {c, '\0'};
            push(&s, operand);
        } else if (c == '+' || c == '-' || c == '*' || c == '/') {

            char op1[MAX], op2[MAX];
            pop(&s, op2);
            pop(&s, op1);


            sprintf(temp, "%c%s%s", c, op1, op2);

            push(&s, temp);
        } else {
            printf("Invalid character %c in the expression\n", c);
            exit(EXIT_FAILURE);
        }
    }


    pop(&s, prefix);
}

int main() {
    char postfix[MAX], prefix[MAX];

    printf("Enter a postfix expression: ");
    fgets(postfix, MAX, stdin);

    size_t len = strlen(postfix);
    if (len > 0 && postfix[len - 1] == '\n') {
        postfix[len - 1] = '\0';
    }
    postfixToPrefix(postfix, prefix);
    printf("Prefix expression: %s\n", prefix);

    return 0;
}
