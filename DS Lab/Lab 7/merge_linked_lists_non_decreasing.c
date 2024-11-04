#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node* next;
} Node;

Node* createNode(int data) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

void printList(Node* head) {
    while (head) {
        printf("%d -> ", head->data);
        head = head->next;
    }
    printf("NULL\n");
}

Node* mergeLists(Node* headX, Node* headY) {
    if (!headX) return headY;
    if (!headY) return headX;

    Node* headZ = NULL;
    Node* currentZ = NULL;

    if (headX->data <= headY->data) {
        headZ = headX;
        headX = headX->next;
    } else {
        headZ = headY;
        headY = headY->next;
    }
    currentZ = headZ;

    while (headX && headY) {
        if (headX->data <= headY->data) {
            currentZ->next = headX;
            currentZ = currentZ->next;
            headX = headX->next;
        } else {
            currentZ->next = headY;
            currentZ = currentZ->next;
            headY = headY->next;
        }
    }

    if (headX) {
        currentZ->next = headX;
    } else {
        currentZ->next = headY;
    }

    return headZ;
}

Node* createLinkedList(int n) {
    if (n <= 0) return NULL;

    Node* head = NULL;
    Node* tail = NULL;

    for (int i = 0; i < n; i++) {
        int data;
        printf("Enter element %d: ", i + 1);
        scanf("%d", &data);
        Node* newNode = createNode(data);
        if (head == NULL) {
            head = newNode;
            tail = newNode;
        } else {
            tail->next = newNode;
            tail = newNode;
        }
    }

    return head;
}

int main() {
    int nX, nY;

    printf("Enter the number of elements in list X: ");
    scanf("%d", &nX);
    Node* listX = createLinkedList(nX);

    printf("Enter the number of elements in list Y: ");
    scanf("%d", &nY);
    Node* listY = createLinkedList(nY);

    printf("List X: ");
    printList(listX);
    printf("List Y: ");
    printList(listY);

    Node* mergedList = mergeLists(listX, listY);

    printf("Merged List Z: ");
    printList(mergedList);

    return 0;
}
