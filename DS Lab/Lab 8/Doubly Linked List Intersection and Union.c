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

int existsInList(Node* head, int data) {
    Node* temp = head;
    while (temp != NULL) {
        if (temp->data == data) {
            return 1;
        }
        temp = temp->next;
    }
    return 0;
}

Node* unionLists(Node* X1, Node* X2) {
    Node* result = NULL;

    Node* temp = X1;
    while (temp != NULL) {
        insertRear(&result, temp->data);
        temp = temp->next;
    }

    temp = X2;
    while (temp != NULL) {
        if (!existsInList(result, temp->data)) {
            insertRear(&result, temp->data);
        }
        temp = temp->next;
    }

    return result;
}

Node* intersectionLists(Node* X1, Node* X2) {
    Node* result = NULL;

    Node* temp = X1;
    while (temp != NULL) {
        if (existsInList(X2, temp->data)) {
            if (!existsInList(result, temp->data)) {
                insertRear(&result, temp->data);
            }
        }
        temp = temp->next;
    }

    return result;
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

    printf("List X1: ");
    traverseList(X1);

    printf("List X2: ");
    traverseList(X2);

    Node* unionList = unionLists(X1, X2);
    printf("Union of X1 and X2: ");
    traverseList(unionList);
    Node* intersectionList = intersectionLists(X1, X2);
    printf("Intersection of X1 and X2: ");
    traverseList(intersectionList);
    freeList(X1);
    freeList(X2);
    freeList(unionList);
    freeList(intersectionList);

    return 0;
}
