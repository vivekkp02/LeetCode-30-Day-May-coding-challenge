/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.

Constraints:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //  define adjancency list
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        //  to keep track unvisited(0), visited(1) and completed(2)
        int[] visited = new int[numCourses];
        //  initialize adj. list
        for(int i=0; i<numCourses; i++){
            adj[i] = new ArrayList<>();
        }
        //  build adj. list
        for(int[] pre : prerequisites){
            adj[pre[0]].add(pre[1]); 
        }
        //  traverse the list using dfs and if we encounter a back edge then return false
        for(int course=0; course<numCourses; course++){
            if(visited[course]==0 && !dfs(adj, visited, course))
                return false;
        }
        return true;
    }
    private boolean dfs(ArrayList<Integer>[] adj, int[] visited, int v){
        //  if already visited that means we encounter back edge
        if(visited[v]==1)
            return false;
        // mark as visited
        visited[v]=1;
        //  visit nodes dfs
        for(int neighbour : adj[v]){
            if(!dfs(adj, visited, neighbour))
                return false;
        }
        //  mark as complete once we dfs all neighbours
        visited[v]=2;
        return true;
    }
}
