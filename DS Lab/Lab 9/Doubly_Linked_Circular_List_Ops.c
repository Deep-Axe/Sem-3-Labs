#include <stdio.h>
#include <stdlib.h>

// Define the Node structure
struct Node {
    int data;
    struct Node* next;
    struct Node* prev;
};

// Define the Doubly Circular Linked List structure
struct DoublyCircularLinkedList {
    struct Node* head;
};

// Function to create a new node
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = newNode;
    newNode->prev = newNode;
    return newNode;
}

// Function to insert an element into the doubly circular linked list
void insert(struct DoublyCircularLinkedList* list, int data) {
    struct Node* newNode = createNode(data);

    if (list->head == NULL) {
        list->head = newNode;
    } else {
        struct Node* tail = list->head->prev;
        tail->next = newNode;
        newNode->prev = tail;
        newNode->next = list->head;
        list->head->prev = newNode;
    }
}

// Function to delete an element from the doubly circular linked list
void deleteNode(struct DoublyCircularLinkedList* list, int data) {
    if (list->head == NULL) {
        printf("List is empty.\n");
        return;
    }

    struct Node* current = list->head;
    do {
        if (current->data == data) {
            if (current->next == current) { // Only one node in the list
                list->head = NULL;
            } else {
                current->prev->next = current->next;
                current->next->prev = current->prev;
                if (current == list->head) {
                    list->head = current->next; // Move head if necessary
                }
            }
            free(current);
            printf("Deleted: %d\n", data);
            return;
        }
        current = current->next;
    } while (current != list->head);

    printf("Element %d not found in the list.\n", data);
}

// Function to display the list
void display(struct DoublyCircularLinkedList* list) {
    if (list->head == NULL) {
        printf("List is empty.\n");
        return;
    }
    struct Node* current = list->head;
    do {
        printf("%d ", current->data);
        current = current->next;
    } while (current != list->head);
    printf("\n");
}

// Main function with menu-driven interface
int main() {
    struct DoublyCircularLinkedList list;
    list.head = NULL;

    int choice, data;

    while (1) {
        printf("Menu:\n");
        printf("1. Insert an element\n");
        printf("2. Delete an element\n");
        printf("3. Display the list\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter the element to insert: ");
                scanf("%d", &data);
                insert(&list, data);
                break;
            case 2:
                printf("Enter the element to delete: ");
                scanf("%d", &data);
                deleteNode(&list, data);
                break;
            case 3:
                display(&list);
                break;
            case 4:
                exit(0);
            default:
                printf("Invalid choice. Please try again.\n");
        }
    }

    return 0;
}
