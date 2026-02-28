/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
*/

class Solution {
//    if cycle is detected return false
//    as the courses cannot be completed
//    due to deadlock
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // TC: O(numCourses + prerequisites.length)
        // TC: O(V+E)
        // SC: O(numCourses + prerequisites.length)
        // SC: O(V+E)
        List<List<Integer>> connections = new ArrayList<>();

        for(int i = 0 ; i < numCourses ; i++){
            connections.add(new ArrayList<Integer>());
        }

        for(int[] arr : prerequisites){
            connections.get(arr[0]).add(arr[1]);
        }

        boolean[] visit = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(!visit[i]){
                if(DFS(i, visit, path, connections)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean DFS(int node, boolean[] visit, boolean[] path, List<List<Integer>> connections){
        if(path[node]){
            return true;//cycle detected
        }
        if(visit[node]){
            return false;//node has already been visited, no cycle will be detected by going furthermore
        }
        //mark visited
        visit[node] = true;
        path[node] = true;

        for(Integer neighbour : connections.get(node)){
            if(DFS(neighbour, visit, path, connections)){
                return true;//cycle detected
            }
        }

        path[node] = false;//mark unvisited for backtracking
        return false;//no cycle detected
    }
}
