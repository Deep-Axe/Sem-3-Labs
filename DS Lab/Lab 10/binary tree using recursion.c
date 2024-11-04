#include <stdio.h>
#include <stdlib.h>

// Define the structure for a node in the binary tree
typedef struct Node {
    int data;
    struct Node* left;
    struct Node* right;
} Node;

// Function to create a new node
Node* createNode(int value) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = value;
    newNode->left = newNode->right = NULL;
    return newNode;
}

// Recursive function to insert a value in the binary tree
Node* insert(Node* root, int value) {
    if (root == NULL) {
        return createNode(value); // Create a new node if the root is NULL
    }


    if (value < root->data) {
        root->left = insert(root->left, value);
    } else {
        // Insert in the right subtree if value is greater or equal
        root->right = insert(root->right, value);
    }

    return root;
}

// Recursive function to print the binary tree in in-order
void inOrderTraversal(Node* root) {
    if (root == NULL) return;

    inOrderTraversal(root->left); // Visit left subtree
    printf("%d ", root->data);     // Visit node
    inOrderTraversal(root->right); // Visit right subtree
}

// Main function for testing
int main() {
    Node* root = NULL;
    int value;
    char choice;


    do {
        printf("Enter a value to insert into the binary tree: ");
        scanf("%d", &value);
        root = insert(root, value);

        printf("Do you want to insert another value? (y/n): ");
        scanf(" %c", &choice);
    } while (choice == 'y' || choice == 'Y');

    printf("In-order Traversal of the Binary Tree: ");
    inOrderTraversal(root);
    printf("\n");

    return 0;
}
