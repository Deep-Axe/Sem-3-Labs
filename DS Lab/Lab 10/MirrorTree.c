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

int areMirrors(Node* tree1, Node* tree2) {
    if (tree1 == NULL && tree2 == NULL) {
        return 1;
    }
    if (tree1 == NULL || tree2 == NULL) {
        return 0;
    }
    return (tree1->data == tree2->data) &&
           areMirrors(tree1->left, tree2->right) &&
           areMirrors(tree1->right, tree2->left);
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
    Node* tree1 = NULL;
    Node* tree2 = NULL;
    int n, value;

    printf("Enter the number of nodes for the first tree: ");
    scanf("%d", &n);
    printf("Enter %d values to insert into the first tree:\n", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &value);
        tree1 = insert(tree1, value);
    }

    printf("Enter the number of nodes for the second tree: ");
    scanf("%d", &n);
    printf("Enter %d values to insert into the second tree:\n", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &value);
        tree2 = insert(tree2, value);
    }

    printf("First Tree  ");
    inorderTraversal(tree1);
    printf("\n");

    printf("Second Tree ");
    inorderTraversal(tree2);
    printf("\n");

    if (areMirrors(tree1, tree2)) {
        printf("The two trees are mirror images of each other.\n");
    } else {
        printf("The two trees are not mirror images of each other.\n");
    }

    freeTree(tree1);
    freeTree(tree2);

    return 0;
}
