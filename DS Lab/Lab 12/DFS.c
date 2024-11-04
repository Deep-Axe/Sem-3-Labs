#include <stdio.h>

#define MAX 10

int adj[MAX][MAX];
int visited[MAX];

void dfs(int vertex, int n) {
    printf("%d ", vertex);
    visited[vertex] = 1;

    for (int i = 0; i < n; i++) {
        if (adj[vertex][i] && !visited[i]) {
            dfs(i, n);
        }
    }
}

int main() {
    int nodes, edges, u, v;

    printf("Enter number of nodes and edges: ");
    scanf("%d %d", &nodes, &edges);

    for (int i = 0; i < edges; i++) {
        printf("Enter edge (u v): ");
        scanf("%d %d", &u, &v);
        adj[u][v] = 1;
        adj[v][u] = 1;
    }

    int start;
    printf("Enter start vertex for DFS: ");
    scanf("%d", &start);

    for (int i = 0; i < nodes; i++) visited[i] = 0;

    printf("DFS Traversal: ");
    dfs(start, nodes);
    printf("\n");

    return 0;
}
