#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node* prev;
    struct Node* next;
} Node;

Node* createNode(int data) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = data;
    newNode->prev = NULL;
    newNode->next = NULL;
    return newNode;
}

void insertRear(Node** head, int data) {
    Node* newNode = createNode(data);
    if (*head == NULL) {
        *head = newNode;
        return;
    }
    Node* temp = *head;
    while (temp->next != NULL) {
        temp = temp->next;
    }
    temp->next = newNode;
    newNode->prev = temp;
}

void traverseList(Node* head) {
    Node* temp = head;
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

void concatenateLists(Node** X1, Node* X2) {
    if (*X1 == NULL) {
        *X1 = X2;
        return;
    }
    if (X2 == NULL) {
        return;
    }

    Node* temp = *X1;
    while (temp->next != NULL) {
        temp = temp->next;
    }
    temp->next = X2;
    X2->prev = temp;
}

void freeList(Node* head) {
    Node* temp;
    while (head != NULL) {
        temp = head;
        head = head->next;
        free(temp);
    }
}

int main() {
    Node* X1 = NULL;
    Node* X2 = NULL;

    int n1, n2, data;
    printf("Enter the number of elements in the first list: ");
    scanf("%d", &n1);
    printf("Enter %d elements for the first list:\n", n1);
    for (int i = 0; i < n1; i++) {
        scanf("%d", &data);
        insertRear(&X1, data);
    }

    printf("Enter the number of elements in the second list: ");
    scanf("%d", &n2);
    printf("Enter %d elements for the second list:\n", n2);
    for (int i = 0; i < n2; i++) {
        scanf("%d", &data);
        insertRear(&X2, data);
    }
    printf("List X1 before concatenation: ");
    traverseList(X1);

    printf("List X2: ");
    traverseList(X2);
    concatenateLists(&X1, X2);

    printf("List X1 after concatenation: ");
    traverseList(X1);

    freeList(X1);

    return 0;
}
