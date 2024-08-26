#include <stdio.h>

#define MAX_STACKS 6
#define STACK_SIZE 10
#define TOTAL_SIZE (MAX_STACKS * STACK_SIZE)
typedef struct {
    int top[MAX_STACKS];
    int arr[TOTAL_SIZE];
} MultiStack;

void initialize(MultiStack *stack) {
    for (int i = 0; i < MAX_STACKS; i++) {
        stack->top[i] = i * STACK_SIZE - 1;
    }
}

int getIndex(MultiStack *stack, int stackIndex, int offset) {
    return stackIndex * STACK_SIZE + offset;
}

int isFull(MultiStack *stack, int stackIndex) {
    if (stackIndex < 0 || stackIndex >= MAX_STACKS) {
        return 0;
    }
    return stack->top[stackIndex] >= getIndex(stack, stackIndex, STACK_SIZE - 1);
}

int isEmpty(MultiStack *stack, int stackIndex) {
    if (stackIndex < 0 || stackIndex >= MAX_STACKS) {
        return 1;
    }
    return stack->top[stackIndex] < getIndex(stack, stackIndex, 0);
}

void push(MultiStack *stack, int stackIndex, int value) {
    if (isFull(stack, stackIndex)) {
        printf("Stack %d is full\n", stackIndex);
        return;
    }
    stack->top[stackIndex]++;
    stack->arr[stack->top[stackIndex]] = value;
}

int pop(MultiStack *stack, int stackIndex) {
    if (isEmpty(stack, stackIndex)) {
        printf("Stack %d is empty\n", stackIndex);
        return -1;
    }
    return stack->arr[stack->top[stackIndex]--];
}

int peek(MultiStack *stack, int stackIndex) {
    if (isEmpty(stack, stackIndex)) {
        printf("Stack %d is empty\n", stackIndex);
        return -1;
    }
    return stack->arr[stack->top[stackIndex]];
}

void printMenu() {
    printf("\nMenu:\n");
    printf("1. Push\n");
    printf("2. Pop\n");
    printf("3. Peek\n");
    printf("4. Exit\n");
    printf("Choose an option: ");
}

int main() {
    MultiStack stack;
    initialize(&stack);

    int choice, stackIndex, value;

    while (1) {
        printMenu();
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter stack index (0-%d): ", MAX_STACKS - 1);
                scanf("%d", &stackIndex);
                if (stackIndex < 0 || stackIndex >= MAX_STACKS) {
                    printf("Invalid stack index\n");
                    break;
                }
                printf("Enter value to push: ");
                scanf("%d", &value);
                push(&stack, stackIndex, value);
                break;

            case 2:
                printf("Enter stack index (0-%d): ", MAX_STACKS - 1);
                scanf("%d", &stackIndex);
                if (stackIndex < 0 || stackIndex >= MAX_STACKS) {
                    printf("Invalid stack index\n");
                    break;
                }
                value = pop(&stack, stackIndex);
                if (value != -1) {
                    printf("Popped value: %d\n", value);
                }
                break;

            case 3:
                printf("Enter stack index (0-%d): ", MAX_STACKS - 1);
                scanf("%d", &stackIndex);
                if (stackIndex < 0 || stackIndex >= MAX_STACKS) {
                    printf("Invalid stack index\n");
                    break;
                }
                value = peek(&stack, stackIndex);
                if (value != -1) {
                    printf("Top value: %d\n", value);
                }
                break;

            case 4:
                printf("Exiting...\n");
                return 0;

            default:
                printf("Invalid choice. Please try again.\n");
                break;
        }
    }
    return 0;
}
