#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX 100

typedef struct {
    int top;
    int items[MAX];
} Stack;


void initStack(Stack* s) {
    s->top = -1;
}

bool isEmpty(Stack* s) {
    return s->top == -1;
}

void push(Stack* s, int item) {
    if (s->top < MAX - 1) {
        s->items[++(s->top)] = item;
    } else {
        printf("Stack overflow\n");
        exit(EXIT_FAILURE);
    }
}

int pop(Stack* s) {
    if (!isEmpty(s)) {
        return s->items[(s->top)--];
    } else {
        printf("Stack underflow\n");
        exit(EXIT_FAILURE);
    }
}

int peek(Stack* s) {
    if (!isEmpty(s)) {
        return s->items[s->top];
    } else {
        printf("Stack is empty\n");
        exit(EXIT_FAILURE);
    }
}

typedef struct {
    Stack stack1;
    Stack stack2;
} Queue;

void initQueue(Queue* q) {
    initStack(&(q->stack1));
    initStack(&(q->stack2));
}

void enqueue(Queue* q, int item) {
    push(&(q->stack1), item);
}

int dequeue(Queue* q) {

    if (isEmpty(&(q->stack2))) {
        while (!isEmpty(&(q->stack1))) {
            push(&(q->stack2), pop(&(q->stack1)));
        }
    }

    if (isEmpty(&(q->stack2))) {
        printf("Queue is empty\n");
        exit(EXIT_FAILURE);
    }
    return pop(&(q->stack2));
}

bool isQueueEmpty(Queue* q) {
    return isEmpty(&(q->stack1)) && isEmpty(&(q->stack2));
}


int main() {
    Queue q;
    initQueue(&q);

    int choice, value;

    while (1) {
        printf("\nQueue Operations Menu:\n");
        printf("1. Enqueue\n");
        printf("2. Dequeue\n");
        printf("3. Check if Queue is Empty\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter the value to enqueue: ");
                scanf("%d", &value);
                enqueue(&q, value);
                printf("Enqueued %d\n", value);
                break;

            case 2:
                if (!isQueueEmpty(&q)) {
                    value = dequeue(&q);
                    printf("Dequeued %d\n", value);
                } else {
                    printf("Queue is empty, cannot dequeue\n");
                }
                break;

            case 3:
                if (isQueueEmpty(&q)) {
                    printf("Queue is empty\n");
                } else {
                    printf("Queue is not empty\n");
                }
                break;

            case 4:
                printf("Exiting...\n");
                exit(0);

            default:
                printf("Invalid choice! Please try again.\n");
        }
    }

    return 0;
}
