#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node* next;
} Node;

Node* createLinkedList(int n) {
    if (n <= 0) {
        return NULL; //if n is 0 or less, return NULL
    }
    Node* newNode = (Node*)malloc(sizeof(Node));
    printf("Enter data for node %d: ", n);
    scanf("%d", &newNode->data);

    newNode->next = createLinkedList(n - 1); //creation of the rest of the list
    return newNode;
}

void traverseLinkedList(Node* head) {
    if (head == NULL) {
        return;
    }
    printf("%d ", head->data);
    traverseLinkedList(head->next);
}

void freeLinkedList(Node* head) {
    if (head == NULL) {
        return;
    }
    freeLinkedList(head->next);
    free(head);
}

int main() {
    int n;
    printf("Enter the number of nodes to create: ");
    scanf("%d", &n);
    Node* head = createLinkedList(n);
    printf("Traversing the linked list: ");
    traverseLinkedList(head);
    printf("\n");
    freeLinkedList(head);
    return 0;
}
