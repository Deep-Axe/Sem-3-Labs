#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

typedef struct Node {
    char value;
    struct Node* left;
    struct Node* right;
} Node;

Node* createNode(char value) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->value = value;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

int isOperator(char c) {
    return (c == '+' || c == '-' || c == '*' || c == '/');
}

int precedence(char op) {
    if (op == '+' || op == '-') return 1;
    if (op == '*' || op == '/') return 2;
    return 0;
}

void infixToPostfix(char infix[], char postfix[]) {
    char stack[100];
    int top = -1;
    int j = 0;
    for (int i = 0; infix[i] != '\0'; i++) {
        char token = infix[i];
        if (isdigit(token)) {
            postfix[j++] = token;
        } else if (token == '(') {
            stack[++top] = token;
        } else if (token == ')') {
            while (top != -1 && stack[top] != '(') {
                postfix[j++] = stack[top--];
            }
            top--;
        } else if (isOperator(token)) {
            while (top != -1 && precedence(stack[top]) >= precedence(token)) {
                postfix[j++] = stack[top--];
            }
            stack[++top] = token;
        }
    }
    while (top != -1) {
        postfix[j++] = stack[top--];
    }
    postfix[j] = '\0';
}

Node* buildExpressionTree(char postfix[]) {
    Node* stack[100];
    int top = -1;
    for (int i = 0; postfix[i] != '\0'; i++) {
        char token = postfix[i];
        if (isdigit(token)) {
            Node* node = createNode(token);
            stack[++top] = node;
        } else if (isOperator(token)) {
            Node* node = createNode(token);
            node->right = stack[top--];
            node->left = stack[top--];
            stack[++top] = node;
        }
    }
    return stack[top];
}

int evaluateTree(Node* node) {
    if (node == NULL) {
        return 0;
    }
    if (node->left == NULL && node->right == NULL) {
        return node->value - '0';
    }
    int leftValue = evaluateTree(node->left);
    int rightValue = evaluateTree(node->right);
    switch (node->value) {
        case '+': return leftValue + rightValue;
        case '-': return leftValue - rightValue;
        case '*': return leftValue * rightValue;
        case '/': return leftValue / rightValue;
    }
    return 0;
}

int main() {
    char infix[100];
    char postfix[100];

    printf("Enter an infix expression: ");
    fgets(infix, sizeof(infix), stdin);
    infix[strcspn(infix, "\n")] = 0;

    infixToPostfix(infix, postfix);

    Node* root = buildExpressionTree(postfix);

    int result = evaluateTree(root);
    printf("Result of the infix expression: %d\n", result);
    return 0;
}
