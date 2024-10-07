#include <stdio.h>
#include <stdlib.h>

struct Node{
    int coeff;
    int exp;
    struct Node *next;
};

struct Node *createNode(int coeff, int exp){
    struct Node *new = (struct Node*)malloc(sizeof(struct Node));
    new->coeff = coeff;
    new->exp = exp;
    new->next = NULL;
    return new;
}

struct Node *insertNode(struct Node *head, int coeff, int exp){
    struct Node *new = createNode(coeff,exp);
    if(head==NULL){
        return new;
    }
    struct Node *temp=head;
    while(temp->next!=NULL){
        temp=temp->next;
    }
    temp->next = new;
    return head;
}

struct Node *add(struct Node *p1,struct Node *p2 ){
    struct Node *result = NULL;
    struct Node *t1 = p1;
    struct Node *t2 = p2;
    while(t1!=NULL && t2!=NULL){
        if(t1->exp == t2->exp){
            result = insertNode(result,(t1->coeff+t2->coeff),t1->exp);
            t1=t1->next;
            t2=t2->next;

        }
        else if(t1->exp > t2->exp){
            result = insertNode(result,(t1->coeff),t1->exp);
            t1=t1->next;

        }
        else{
            result = insertNode(result,(t2->coeff),t2->exp);
                t2=t2->next;
        }
    }
    while(t1!=NULL){
            result = insertNode(result,t1->coeff,t1->exp);
            t1=t1->next;
    }
    while(t2!=NULL){
            result = insertNode(result,t2->coeff,t2->exp);
            t2=t2->next;
    }
    return result;
}

void printPoly(struct Node *poly){
    struct Node *t = poly;
    while(t!=NULL){
        if (t->exp != 0){
            printf("%dx^%d ",t->coeff,t->exp);
            if(t->next != NULL){
                printf("+");
            }
        t=t->next;
        }
        else{
            printf(" %d ",t->coeff,t->exp);
            if(t->next != NULL){
                printf("+");
            }
            t=t->next;
        }
    }
    printf("\n");
}

struct Node *inp(){
    int n,coeff,exp;
    struct Node *p = NULL;
    printf("Enter the number of terms: ");

    scanf("%d",&n);
    for(int i=0;i<n;i++){
            printf("Insert %dth term (coeff exp): ", i);
            scanf("%d %d", &coeff, &exp);
            p=insertNode(p,coeff,exp);
    }
    return p;
}

void freePoly(struct Node *poly) {
    struct Node *temp;
    while (poly != NULL) {
        temp = poly;
        poly = poly->next;
        free(temp);
    }
}

int main(){
    struct Node *p1=NULL;
    struct Node *p2=NULL;
    struct Node *result=NULL;
    printf("Entering terms for first polynomial\n");
    p1=inp();
    printf("Entering terms for second polynomial\n");
    p2=inp();

    printPoly(p1);
    printPoly(p2);
    result = add(p1,p2);
    printPoly(result);

    freePoly(p1);
    freePoly(p2);
    freePoly(result);
    return 0;
}
