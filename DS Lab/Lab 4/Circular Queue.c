# define MAX 50
int queue[MAX];
int front = -1;
int rear = -1;
void enqueue(int element)
{
    if(front == -1 && rear == -1) {
        front=0;
        rear=0;
        queue[rear]=element;
    }
    else if((rear+1)% MAX == front) {
        printf("\n Queue is overflow.");
    }
    else {
        rear=(rear+1)%MAX;
        queue[rear]=element;
    }
}

int dequeue()
{
    if((front == -1) && (rear == -1)){
        printf("\n Queue is underflow.");
    }
    else if(front == rear) {
        printf("\n The dequeued element is %d", queue[front]);
        front = -1;
        rear = -1;
    }
    else{
        printf("\n The dequeued element is %d", queue[front]);
        front= (front+1)% MAX;
    }
}
void display()
{
    int i=front;
    if(front == -1 && rear == -1) {
        printf("\n Queue is empty.");
    }
    else {
        printf("\n Elements in a Queue are: ");
        while(i <= rear){
            printf("%d, ", queue[i]);
            i=(i+1) % MAX;
        }
    }
}
int main()
{
    int choice = 1,x;
    while(choice < 4 && choice != 0){
        printf("\n Press 1: Insert an element");
        printf("\n Press 2: Delete an element");
        printf("\n Press 3: Display the element");
        printf("\n Enter your choice: ");
        scanf("%d", &choice);
        switch(choice) {
            case 1:
                printf(" Enter the element to be inserted: ");
                scanf("%d", &x);
                enqueue(x);
                break;

            case 2:
                dequeue();
                break;

            case 3:
                display();
                break;

            default:
                printf(" ENDING PROGRAM!! ");
                break;
        }
    }
    return 0;
}
