#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

typedef struct User {
    char name[50];
    int duration;
    struct User* next;
    struct User* prev;
} User;

typedef struct {
    User* header;
} CircularDoublyLinkedList;

User* createUser(char* name, int duration) {
    User* newUser = (User*)malloc(sizeof(User));
    strcpy(newUser->name, name);
    newUser->duration = duration;
    newUser->next = newUser;
    newUser->prev = newUser;
    return newUser;
}

CircularDoublyLinkedList* createList() {
    CircularDoublyLinkedList* list = (CircularDoublyLinkedList*)malloc(sizeof(CircularDoublyLinkedList));
    list->header = createUser("Header", 0);
    return list;
}

void addUser(CircularDoublyLinkedList* list, char* name, int duration) {
    User* newUser = createUser(name, duration);
    User* current = list->header;

    while (current->next != list->header) {
        current = current->next;
    }

    current->next = newUser;
    newUser->prev = current;
    newUser->next = list->header;
    list->header->prev = newUser;
}

void removeUser(CircularDoublyLinkedList* list) {
    if (list->header->next == list->header) {
        printf("No users in the queue.\n");
        return;
    }

    User* userToRemove = list->header->next;
    printf("Handing over washing machine to: %s for %d minutes.\n", userToRemove->name, userToRemove->duration);

    list->header->next = userToRemove->next;
    userToRemove->next->prev = list->header;

    free(userToRemove);
}

void displayQueue(CircularDoublyLinkedList* list) {
    if (list->header->next == list->header) {
        printf("No users in the queue.\n");
        return;
    }

    User* current = list->header->next;
    printf("Current Queue:\n");
    while (current != list->header) {
        printf("User: %s, Duration: %d minutes\n", current->name, current->duration);
        current = current->next;
    }
}

void simulateWashingMachine(CircularDoublyLinkedList* list) {
    while (list->header->next != list->header) {
        User* userToRemove = list->header->next;
        int duration = userToRemove->duration;

        removeUser(list);
        sleep(duration);
        printf("%s has finished using the washing machine.\n\n", userToRemove->name);
        free(userToRemove);
    }
}

int main() {
    CircularDoublyLinkedList* userList = createList();
    int choice;
    char name[50];
    int duration;

    while (1) {
        printf("Washing Machine Renting System\n");
        printf("1. Book Washing Machine\n");
        printf("2. Display Current Queue\n");
        printf("3. Start Washing Machine\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter your name: ");
                scanf("%s", name);
                printf("Enter duration (in minutes): ");
                scanf("%d", &duration);
                addUser(userList, name, duration);
                break;
            case 2:
                displayQueue(userList);
                break;
            case 3:
                simulateWashingMachine(userList);
                break;
            case 4:
                free(userList->header);
                free(userList);
                return 0;
            default:
                printf("Invalid choice. Please try again.\n");
        }
    }
}
