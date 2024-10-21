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
        return createNode(value);
    }
    if (value < root->data) {
        root->left = insert(root->left, value);
    } else {
        root->right = insert(root->right, value);
    }
    return root;
}

// In-order traversal (Iterative)
void inOrderTraversal(Node* root) {
    Node* stack[100];
    int top = -1;
    Node* current = root;

    while (current != NULL || top != -1) {
        while (current != NULL) {
            stack[++top] = current;
            current = current->left;
        }
        current = stack[top--];
        printf("%d ", current->data);
        current = current->right;
    }
}

// Post-order traversal (Iterative)
void postOrderTraversal(Node* root) {
    if (root == NULL) return;

    Node* stack1[100], *stack2[100];
    int top1 = -1, top2 = -1;

    stack1[++top1] = root;

    while (top1 != -1) {
        Node* current = stack1[top1--];
        stack2[++top2] = current;

        if (current->left != NULL) stack1[++top1] = current->left;
        if (current->right != NULL) stack1[++top1] = current->right;
    }

    while (top2 != -1) {
        printf("%d ", stack2[top2--]->data);
    }
}

// Pre-order traversal (Iterative)
void preOrderTraversal(Node* root) {
    if (root == NULL) return;

    Node* stack[100];
    int top = -1;

    stack[++top] = root;

    while (top != -1) {
        Node* current = stack[top--];
        printf("%d ", current->data);

        if (current->right != NULL) stack[++top] = current->right;
        if (current->left != NULL) stack[++top] = current->left;
    }
}

// Print the parent of the given element
void printParent(Node* root, int value) {
    if (root == NULL) return;

    Node* queue[100];
    int front = 0, rear = 0;
    queue[rear++] = root;

    while (front < rear) {
        Node* current = queue[front++];

        if (current->left != NULL) {
            if (current->left->data == value) {
                printf("Parent of %d: %d\n", value, current->data);
                return;
            }
            queue[rear++] = current->left;
        }

        if (current->right != NULL) {
            if (current->right->data == value) {
                printf("Parent of %d: %d\n", value, current->data);
                return;
            }
            queue[rear++] = current->right;
        }
    }

    printf("Element %d not found.\n", value);
}

// Print the depth of the tree
int depth(Node* node) {
    if (node == NULL) return 0;
    int leftDepth = depth(node->left);
    int rightDepth = depth(node->right);
    return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
}

// Print the ancestors of a given element
int findAncestors(Node* node, int value) {
    if (node == NULL) return 0;

    if (node->data == value) return 1;

    if (findAncestors(node->left, value) || findAncestors(node->right, value)) {
        printf("%d ", node->data);
        return 1;
    }
    return 0;
}

// Count the number of leaf nodes in a binary tree
int countLeaves(Node* node) {
    if (node == NULL) return 0;
    if (node->left == NULL && node->right == NULL) return 1; // Leaf node
    return countLeaves(node->left) + countLeaves(node->right);
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

    printf("In-order Traversal: ");
    inOrderTraversal(root);
    printf("\n");

    printf("Post-order Traversal: ");
    postOrderTraversal(root);
    printf("\n");

    printf("Pre-order Traversal: ");
    preOrderTraversal(root);
    printf("\n");

    printf("Enter a value to find its parent: ");
    scanf("%d", &value);
    printParent(root, value);

    printf("Depth of the tree: %d\n", depth(root));

    printf("Ancestors of the last entered value: ");
    findAncestors(root, value);
    printf("\n");

    printf("Number of leaf nodes: %d\n", countLeaves(root));

    return 0;
}
