#include <stdio.h>
#include <ctype.h>

#define MAX 100

struct Stack {
    int top;
    int items[MAX];
} stack;

void initStack() {
    stack.top = -1;
}


int isEmpty() {
    return stack.top == -1;
}

void push(int value) {
    if (stack.top < MAX - 1) {
        stack.items[++(stack.top)] = value;
    } else {
        printf("Stack Overflow\n");
    }
}

int pop() {
    if (!isEmpty()) {
        return stack.items[(stack.top)--];
    } else {
        printf("Stack Underflow\n");
        return -1;
    }
}

int evaluatePostfix(char exp[]) {
    initStack();
    int i = 0;

    while (exp[i] != '\0') {
        if (isdigit(exp[i])) {
            push(exp[i] - '0'); 
        } else {
            int val1 = pop();
            int val2 = pop();

            switch (exp[i]) {
                case '+': push(val2 + val1); break;
                case '-': push(val2 - val1); break;
                case '*': push(val2 * val1); break;
                case '/': push(val2 / val1); break;
            }
        }
        i++;
    }
    return pop();
}


int main() {
    char exp[MAX];
    printf("Enter postfix expression: ");
    gets(exp);

    printf("Postfix Evaluation Result: %d\n", evaluatePostfix(exp));

    return 0;
}
