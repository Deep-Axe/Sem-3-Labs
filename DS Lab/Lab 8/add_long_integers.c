#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Node {
    int digit;
    struct Node* next;
    struct Node* prev;
} Node;

typedef struct {
    Node* head;
    Node* tail;
} DoublyLinkedList;

DoublyLinkedList* createList() {
    DoublyLinkedList* list = (DoublyLinkedList*)malloc(sizeof(DoublyLinkedList));
    list->head = NULL;
    list->tail = NULL;
    return list;
}

void insertDigit(DoublyLinkedList* list, int digit) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->digit = digit;
    newNode->next = NULL;

    if (list->head == NULL) {
        newNode->prev = NULL;
        list->head = newNode;
        list->tail = newNode;
    } else {
        newNode->prev = list->tail;
        list->tail->next = newNode;
        list->tail = newNode;
    }
}

void freeList(DoublyLinkedList* list) {
    Node* current = list->head;
    while (current != NULL) {
        Node* temp = current;
        current = current->next;
        free(temp);
    }
    free(list);
}

DoublyLinkedList* createListFromString(const char* str) {
    DoublyLinkedList* list = createList();
    for (int i = 0; i < strlen(str); i++) {
        insertDigit(list, str[i] - '0');
    }
    return list;
}

DoublyLinkedList* addLists(DoublyLinkedList* num1, DoublyLinkedList* num2) {
    DoublyLinkedList* result = createList();
    Node* ptr1 = num1->tail;
    Node* ptr2 = num2->tail;
    int carry = 0;

    while (ptr1 != NULL || ptr2 != NULL || carry != 0) {
        int sum = carry;
        if (ptr1 != NULL) {
            sum += ptr1->digit;
            ptr1 = ptr1->prev;
        }
        if (ptr2 != NULL) {
            sum += ptr2->digit;
            ptr2 = ptr2->prev;
        }
        carry = sum / 10;
        insertDigit(result, sum % 10);
    }

    return result;
}

void displayList(DoublyLinkedList* list) {
    Node* current = list->head;
    while (current != NULL) {
        printf("%d", current->digit);
        current = current->next;
    }
    printf("\n");
}

int main() {
    char num1[100], num2[100];

    printf("Enter the first long positive integer: ");
    scanf("%s", num1);
    printf("Enter the second long positive integer: ");
    scanf("%s", num2);

    DoublyLinkedList* list1 = createListFromString(num1);
    DoublyLinkedList* list2 = createListFromString(num2);

    DoublyLinkedList* sumList = addLists(list1, list2);

    printf("Sum: ");
    displayList(sumList);

    freeList(list1);
    freeList(list2);
    freeList(sumList);

    return 0;
}
