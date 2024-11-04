#include <stdio.h>

#define MAX_NODES 10

void createAdjMatrix(int adjMatrix[MAX_NODES][MAX_NODES], int nodes, int edges, int directed) {
    int i, u, v;
    for (i = 0; i < edges; i++) {
        printf("Enter edge (u v): ");
        scanf("%d %d", &u, &v);
        adjMatrix[u][v] = 1;
        if (!directed) {
            adjMatrix[v][u] = 1;
        }
    }
}

void displayAdjMatrix(int adjMatrix[MAX_NODES][MAX_NODES], int nodes) {
    int i, j;
    printf("Adjacency Matrix:\n");
    for (i = 0; i < nodes; i++) {
        for (j = 0; j < nodes; j++) {
            printf("%d ", adjMatrix[i][j]);
        }
        printf("\n");
    }
}

int main() {
    int adjMatrix[MAX_NODES][MAX_NODES] = {0};
    int nodes, edges, directed;

    printf("Enter number of nodes: ");
    scanf("%d", &nodes);
    printf("Enter number of edges: ");
    scanf("%d", &edges);
    printf("Enter 1 if directed, 0 if undirected: ");
    scanf("%d", &directed);

    createAdjMatrix(adjMatrix, nodes, edges, directed);
    displayAdjMatrix(adjMatrix, nodes);

    return 0;
}
