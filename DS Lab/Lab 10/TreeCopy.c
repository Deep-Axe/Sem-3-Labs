#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node* left;
    struct Node* right;
} Node;

Node* createNode(int data) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

//insert a new node in the binary tree
Node* insert(Node* root, int data) {
    if (root == NULL) {
        return createNode(data);
    }
    if (data < root->data) {
        root->left = insert(root->left, data);
    } else {
        root->right = insert(root->right, data);
    }
    return root;
}

// copying  binary tree
Node* copyTree(Node* root) {
    if (root == NULL) {
        return NULL;
    }
    Node* newNode = createNode(root->data); // Copy the root node
    newNode->left = copyTree(root->left);    // Recursively copy the left subtree and then right subtree
    newNode->right = copyTree(root->right);
    return newNode;
}

void inorderTraversal(Node* root) {
    if (root != NULL) {
        inorderTraversal(root->left);
        printf("%d ", root->data);
        inorderTraversal(root->right);
    }
}

void freeTree(Node* root) {
    if (root != NULL) {
        freeTree(root->left);
        freeTree(root->right);
        free(root);
    }
}

int main() {
    Node* originalTree = NULL;
    Node* copiedTree = NULL;
    int n, value;

    printf("Enter the number of nodes to insert into binary tree: ");
    scanf("%d", &n);

    printf("Enter %d values to insert into binary tree:\n", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &value);
        originalTree = insert(originalTree, value);
    }

    printf("Original Tree (In-order): ");
    inorderTraversal(originalTree);
    printf("\n");

    copiedTree = copyTree(originalTree);

    printf("Copied Tree (In-order ): ");
    inorderTraversal(copiedTree);
    printf("\n");

    freeTree(originalTree);
    freeTree(copiedTree);

    return 0;
}
