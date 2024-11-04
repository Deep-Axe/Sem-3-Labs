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

Node* mergeLists(Node* list1, Node* list2, int m, int n) {
    Node* head3 = NULL;
    Node* tail3 = NULL;

    Node* current1 = list1;
    Node* current2 = list2;

    while (current1 != NULL && current2 != NULL) {
        if (head3 == NULL) {
            head3 = createNode(current1->data);
            tail3 = head3;
        } else {
            tail3->next = createNode(current1->data);
            tail3 = tail3->next;
        }

        tail3->next = createNode(current2->data);
        tail3 = tail3->next;

        current1 = current1->next;
        current2 = current2->next;
    }

    while (current1 != NULL) {
        tail3->next = createNode(current1->data);
        tail3 = tail3->next;
        current1 = current1->next;
    }

    while (current2 != NULL) {
        tail3->next = createNode(current2->data);
        tail3 = tail3->next;
        current2 = current2->next;
    }

    return head3;
}

void printList(Node* head) {
    while (head) {
        printf("%d -> ", head->data);
        head = head->next;
    }
    printf("NULL\n");
}

Node* createLinkedList(int size) {
    Node* head = NULL;
    Node* tail = NULL;

    for (int i = 0; i < size; i++) {
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
    int size1, size2;

    printf("Enter the number of elements in list1: ");
    scanf("%d", &size1);
    Node* list1 = createLinkedList(size1);

    printf("Enter the number of elements in list2: ");
    scanf("%d", &size2);
    Node* list2 = createLinkedList(size2);

    Node* mergedList = mergeLists(list1, list2, size1, size2);

    printf("Merged List: ");
    printList(mergedList);

    return 0;
}
