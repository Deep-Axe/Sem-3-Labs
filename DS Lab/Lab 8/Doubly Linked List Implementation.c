#include <stdio.h>
#include <stdlib.h>

// Define the structure for a node in the doubly linked list
typedef struct Node {
    int data;
    struct Node* prev;
    struct Node* next;
} Node;

Node* head = NULL;

// Function to insert an element at the rear end of the list
void insertRear(int data) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = data;
    newNode->next = NULL;
    if (head == NULL) {
        newNode->prev = NULL;
        head = newNode;
        return;
    }
    Node* temp = head;
    while (temp->next != NULL) {
        temp = temp->next;
    }
    temp->next = newNode;
    newNode->prev = temp;
}

// Function to delete an element from the rear end of the list
void deleteRear() {
    if (head == NULL) {
        printf("List is empty.\n");
        return;
    }
    if (head->next == NULL) {
        free(head);
        head = NULL;
        return;
    }
    Node* temp = head;
    while (temp->next != NULL) {
        temp = temp->next;
    }
    temp->prev->next = NULL;
    free(temp);
}

// Function to insert an element at a given position
void insertAtPosition(int data, int position) {
    if (position < 1) {
        printf("Invalid position.\n");
        return;
    }
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = data;
    if (position == 1) {
        newNode->next = head;
        newNode->prev = NULL;
        if (head != NULL) {
            head->prev = newNode;
        }
        head = newNode;
        return;
    }
    Node* temp = head;
    for (int i = 1; i < position - 1; i++) {
        if (temp == NULL) {
            printf("Position out of bounds.\n");
            free(newNode);
            return;
        }
        temp = temp->next;
    }
    newNode->next = temp->next;
    newNode->prev = temp;
    if (temp->next != NULL) {
        temp->next->prev = newNode;
    }
    temp->next = newNode;
}

// Function to delete an element from a given position
void deleteAtPosition(int position) {
    if (position < 1 || head == NULL) {
        printf("Invalid position or list is empty.\n");
        return;
    }
    Node* temp = head;
    if (position == 1) {
        head = head->next;
        if (head != NULL) {
            head->prev = NULL;
        }
        free(temp);
        return;
    }
    for (int i = 1; i < position; i++) {
        temp = temp->next;
        if (temp == NULL) {
            printf("Position out of bounds.\n");
            return;
        }
    }
    if (temp->prev != NULL) {
        temp->prev->next = temp->next;
    }
    if (temp->next != NULL) {
        temp->next->prev = temp->prev;
    }
    free(temp);
}

// Function to insert an element after another element
void insertAfter(int target, int data) {
    Node* temp = head;
    while (temp != NULL && temp->data != target) {
        temp = temp->next;
    }
    if (temp == NULL) {
        printf("Element not found.\n");
        return;
    }
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = data;
    newNode->next = temp->next;
    newNode->prev = temp;
    if (temp->next != NULL) {
        temp->next->prev = newNode;
    }
    temp->next = newNode;
}

// Function to insert an element before another element
void insertBefore(int target, int data) {
    if (head == NULL) {
        printf("List is empty.\n");
        return;
    }
    if (head->data == target) {
        insertAtPosition(data, 1);
        return;
    }
    Node* temp = head;
    while (temp != NULL && temp->data != target) {
        temp = temp->next;
    }
    if (temp == NULL) {
        printf("Element not found.\n");
        return;
    }
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = data;
    newNode->prev = temp->prev;
    newNode->next = temp;
    if (temp->prev != NULL) {
        temp->prev->next = newNode;
    }
    temp->prev = newNode;
}

// Function to traverse the list
void traverseList() {
    Node* temp = head;
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

// Function to reverse the list
void reverseList() {
    Node *temp = NULL;
    Node *current = head;
    while (current != NULL) {
        temp = current->prev;
        current->prev = current->next;
        current->next = temp;
        current = current->prev;
    }
    if (temp != NULL) {
        head = temp->prev;
    }
}

// Menu-driven interface
int main() {
    int choice, data, position, target;
    while (1) {
        printf("\nMenu:\n");
        printf("1. Insert at rear\n");
        printf("2. Delete from rear\n");
        printf("3. Insert at position\n");
        printf("4. Delete at position\n");
        printf("5. Insert after element\n");
        printf("6. Insert before element\n");
        printf("7. Traverse list\n");
        printf("8. Reverse list\n");
        printf("9. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter data to insert at rear: ");
                scanf("%d", &data);
                insertRear(data);
                break;
            case 2:
                deleteRear();
                break;
            case 3:
                printf("Enter data and position to insert: ");
                scanf("%d %d", &data, &position);
                insertAtPosition(data, position);
                break;
            case 4:
                printf("Enter position to delete: ");
                scanf("%d", &position);
                deleteAtPosition(position);
                break;
            case 5:
                printf("Enter target element and data to insert after: ");
                scanf("%d %d", &target, &data);
                insertAfter(target, data);
                break;
            case 6:
                printf("Enter target element and data to insert before: ");
                scanf("%d %d", &target, &data);
                insertBefore(target, data);
                break;
            case 7:
                traverseList();
                break;
            case 8:
                reverseList();
                break;
            case 9:
                exit(0);
            default:
                printf("Invalid choice.\n");
        }
    }
    return 0;
}
