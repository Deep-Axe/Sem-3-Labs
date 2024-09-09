#include <stdio.h>
#include <stdlib.h>


typedef struct Node {
    int data;
    struct Node* next;
} Node;

void insertAfter(Node** head, int prevData, int newData);
void insertBefore(Node** head, int nextData, int newData);
void deleteElement(Node** head, int key);
void traverse(Node* head);
void reverse(Node** head);
void sort(Node** head);
void deleteAlternate(Node** head);
void insertSorted(Node** head, int newData);

Node* createNode(int data) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

void insertAfter(Node** head, int prevData, int newData) {
    Node* current = *head;
    while (current != NULL) {
        if (current->data == prevData) {
            Node* newNode = createNode(newData);
            newNode->next = current->next;
            current->next = newNode;
            return;
        }
        current = current->next;
    }
    printf("Element %d not found.\n", prevData);
}

void insertBefore(Node** head, int nextData, int newData) {
    if (*head == NULL) {
        printf("List is empty.\n");
        return;
    }

    if ((*head)->data == nextData) {
        Node* newNode = createNode(newData);
        newNode->next = *head;
        *head = newNode;
        return;
    }

    Node* current = *head;
    Node* prev = NULL;
    while (current != NULL && current->data != nextData) {
        prev = current;
        current = current->next;
    }

    if (current == NULL) {
        printf("Element %d not found.\n", nextData);
        return;
    }

    Node* newNode = createNode(newData);
    prev->next = newNode;
    newNode->next = current;
}

void deleteElement(Node** head, int key) {
    Node* temp = *head;
    Node* prev = NULL;

    if (temp != NULL && temp->data == key) {
        *head = temp->next;
        free(temp);
        return;
    }

    while (temp != NULL && temp->data != key) {
        prev = temp;
        temp = temp->next;
    }

    if (temp == NULL) {
        printf("Element %d not found.\n", key);
        return;
    }

    prev->next = temp->next;
    free(temp);
}

void traverse(Node* head) {
    Node* temp = head;
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

void reverse(Node** head) {
    Node* prev = NULL;
    Node* current = *head;
    Node* next = NULL;

    while (current != NULL) {
        next = current->next;
        current->next = prev;
        prev = current;
        current = next;
    }
    *head = prev;
}


void sort(Node** head) {
    if (*head == NULL) return;

    int swapped;
    Node* ptr1;
    Node* lptr = NULL;

    do {
        swapped = 0;
        ptr1 = *head;

        while (ptr1->next != lptr) {
            if (ptr1->data > ptr1->next->data) {
                int temp = ptr1->data;
                ptr1->data = ptr1->next->data;
                ptr1->next->data = temp;
                swapped = 1;
            }
            ptr1 = ptr1->next;
        }
        lptr = ptr1;
    } while (swapped);
}

void deleteAlternate(Node** head) {
    if (*head == NULL) return;

    Node* current = *head;
    Node* next_node;

    while (current != NULL && current->next != NULL) {
        next_node = current->next;
        current->next = next_node->next;
        free(next_node);
        current = current->next;
    }
}

void insertSorted(Node** head, int newData) {
    Node* newNode = createNode(newData);
    Node* current;

    if (*head == NULL || (*head)->data >= newData) {
        newNode->next = *head;
        *head = newNode;
    } else {
        current = *head;
        while (current->next != NULL && current->next->data < newData) {
            current = current->next;
        }
        newNode->next = current->next;
        current->next = newNode;
    }
}

int main() {
    Node* head = NULL;
    int choice, data, before, after;

    while (1) {
        printf("\nMenu:\n");
        printf("1. Insert element after another element\n");
        printf("2. Insert element before another element\n");
        printf("3. Delete element\n");
        printf("4. Traverse list\n");
        printf("5. Reverse list\n");
        printf("6. Sort list\n");
        printf("7. Delete every alternate node\n");
        printf("8. Insert element in a sorted list\n");
        printf("9. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter the element to insert after and the new element: ");
                scanf("%d %d", &after, &data);
                insertAfter(&head, after, data);
                break;
            case 2:
                printf("Enter the element to insert before and the new element: ");
                scanf("%d %d", &before, &data);
                insertBefore(&head, before, data);
                break;
            case 3:
                printf("Enter the element to delete: ");
                scanf("%d", &data);
                deleteElement(&head, data);
                break;
            case 4:
                traverse(head);
                break;
            case 5:
                reverse(&head);
                break;
            case 6:
                sort(&head);
                break;
            case 7:
                deleteAlternate(&head);
                break;
            case 8:
                printf("Enter the element to insert in sorted list: ");
                scanf("%d", &data);
                insertSorted(&head, data);
                break;
            case 9:
                exit(0);
                break;
            default:
                printf("Invalid choice. Please try again.\n");
        }
    }
    return 0;
}
