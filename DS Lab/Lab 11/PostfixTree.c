#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

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

// Function to check if a character is an operator
int isOperator(char c) {
    return (c == '+' || c == '-' || c == '*' || c == '/');
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

// evaluate the expression tree
int evaluateTree(Node* node) {
    if (node == NULL) {
        return 0;
    }
    if (node->left == NULL && node->right == NULL) {
        return node->value - '0'; // Convert char to int
    }

    int leftValue = evaluateTree(node->left);
    int rightValue = evaluateTree(node->right);

    switch (node->value) {
        case '+': return leftValue + rightValue;
        case '-': return leftValue - rightValue;
        case '*': return leftValue * rightValue;
        case '/': return leftValue / rightValue; // not accounting for division by zero
    }
    return 0;
}

int main() {
    char postfix[100];

    printf("Enter a postfix expression : ");
    fgets(postfix, sizeof(postfix), stdin);
    postfix[strcspn(postfix, "\n")] = 0;

    Node* root = buildExpressionTree(postfix);

    int result = evaluateTree(root);
    printf("Result of the postfix expression: %d\n", result);
    return 0;
}
