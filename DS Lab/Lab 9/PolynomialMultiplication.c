#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int coeff;
    int exp;
    struct Node* next;
    struct Node* prev;
} Node;

typedef struct {
    Node* header;
} CircularDoublyLinkedList;

Node* createNode(int coeff, int exp) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->coeff = coeff;
    newNode->exp = exp;
    newNode->next = newNode;
    newNode->prev = newNode;
    return newNode;
}

CircularDoublyLinkedList* createList() {
    CircularDoublyLinkedList* list = (CircularDoublyLinkedList*)malloc(sizeof(CircularDoublyLinkedList));
    list->header = createNode(0, 0);
    return list;
}

void insertNode(CircularDoublyLinkedList* list, int coeff, int exp) {
    Node* newNode = createNode(coeff, exp);
    Node* current = list->header;

    while (current->next != list->header && current->next->exp > exp) {
        current = current->next;
    }

    if (current->next != list->header && current->next->exp == exp) {
        current->next->coeff += coeff;
        free(newNode);
        return;
    }

    newNode->next = current->next;
    newNode->prev = current;
    current->next->prev = newNode;
    current->next = newNode;
}

void multiplyPolynomials(CircularDoublyLinkedList* p1, CircularDoublyLinkedList* p2, CircularDoublyLinkedList* result) {
    Node* ptr1 = p1->header->next;
    while (ptr1 != p1->header) {
        Node* ptr2 = p2->header->next;
        while (ptr2 != p2->header) {
            int newCoeff = ptr1->coeff * ptr2->coeff;
            int newExp = ptr1->exp + ptr2->exp;
            insertNode(result, newCoeff, newExp);
            ptr2 = ptr2->next;
        }
        ptr1 = ptr1->next;
    }
}

void displayPolynomial(CircularDoublyLinkedList* list) {
    Node* current = list->header->next;
    if (current == list->header) {
        printf("0\n");
        return;
    }

    while (current != list->header) {
        printf("%dx^%d ", current->coeff, current->exp);
        if (current->next != list->header) {
            printf("+ ");
        }
        current = current->next;
    }
    printf("\n");
}

void freeList(CircularDoublyLinkedList* list) {
    Node* current = list->header->next;
    while (current != list->header) {
        Node* temp = current;
        current = current->next;
        free(temp);
    }
    free(list->header);
    free(list);
}

int main() {
    CircularDoublyLinkedList* poly1 = createList();
    CircularDoublyLinkedList* poly2 = createList();
    CircularDoublyLinkedList* result = createList();

    int n, coeff, exp;

    printf("Enter number of terms in 1st polynomial: ");
    scanf("%d", &n);
    printf("Enter the coefficients and exponents:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d %d", &coeff, &exp);
        insertNode(poly1, coeff, exp);
    }

    printf("Enter number of terms in 2nd polynomial: ");
    scanf("%d", &n);
    printf("Enter the coefficients and exponents:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d %d", &coeff, &exp);
        insertNode(poly2, coeff, exp);
    }

    printf("First Polynomial: ");
    displayPolynomial(poly1);
    printf("Second Polynomial: ");
    displayPolynomial(poly2);

    multiplyPolynomials(poly1, poly2, result);

    printf("Resultant Polynomial ");
    displayPolynomial(result);

    freeList(poly1);
    freeList(poly2);
    freeList(result);

    return 0;
}