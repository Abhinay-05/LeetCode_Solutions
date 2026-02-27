/*
There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.

 

Example 1:


Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
Example 2:


Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
 

Constraints:

graph.length == n
1 <= n <= 100
0 <= graph[u].length < n
0 <= graph[u][i] <= n - 1
graph[u] does not contain u.
All the values of graph[u] are unique.
If graph[u] contains v, then graph[v] contains u.
 

*/

// No towo adjacent nodes should have same colour
class Solution {
    // TC: O(V+E)
    // SC: O(V) -> stack space
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colour = new int[n];//visited array to store colours
        Arrays.fill(colour, -1);//fill with no colour
        // use 2 colours -> (0,1)
        // visit every node
        for (int i = 0; i < n; i++) {
            if(colour[i] == -1) {
                // node is unvisited
                if(!DFS(i, colour, 0, graph)){
                    // adjacent nodes have same colour
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean DFS(int node, int[] colours, int colour, int[][] graph) {
        colours[node] = colour;//paint current node with current colour
        // neighbour of current node
        for (int neighbour : graph[node]) {
            if(colours[neighbour] == colour){
                // if neighbour and current node have same colour
                return false;
            }
            if(colours[neighbour] == -1 && !DFS(neighbour, colours, colour ^ 1, graph)){
                // further traversals
                return false;
            }
        }
        return true;
    }
}
