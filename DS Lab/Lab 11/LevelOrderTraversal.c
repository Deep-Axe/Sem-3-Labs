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

// inserting new node in BST
Node* insert(Node* root, int data) {
    if (root == NULL) {
        return createNode(data);
    }
    if (data < root->data) {
        root->left = insert(root->left, data);
    } else if (data > root->data) {
        root->right = insert(root->right, data);
    }
    return root;
}

void levelOrderTraversal(Node* root) {
    if (root == NULL) {
        return;
    }

    Node** queue = (Node**)malloc(100 * sizeof(Node*)); // Queue for level order traversal
    int front = 0, rear = 0;

    queue[rear++] = root;

    while (front < rear) {
        Node* current = queue[front++];

        printf("%d ", current->data);

        // Enqueue left child
        if (current->left != NULL) {
            queue[rear++] = current->left;
        }

        // Enqueue right child
        if (current->right != NULL) {
            queue[rear++] = current->right;
        }
    }
    free(queue);
}

int main() {
    Node* root = NULL;
    int n, value;

    printf("Enter the number of nodes to insert into the BST: ");
    scanf("%d", &n);

    printf("Enter %d values to insert into the BST:\n", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &value);
        root = insert(root, value);
    }

    printf("Level Order Traversal of the BST: ");
    levelOrderTraversal(root);
    printf("\n");

    return 0;
}
