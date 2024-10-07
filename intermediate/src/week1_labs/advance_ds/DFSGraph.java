package intermediate.src.week1_labs.advance_ds;

import java.util.*;

public class DFSGraph {
    private final Map<Integer, List<Integer>> adjacencyList; // Graph represented as an adjacency list
    
    // Constructor to initialize the graph
    public DFSGraph () {
        adjacencyList = new HashMap<>();
    }
    
    // Adds an edge to the graph (undirected graph)
    public void addEdge(int source, int destination) {
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
        adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>()).add(source);
    }
    
    // DFS algorithm to traverse all nodes in the graph
    public void dfs(int startNode) {
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(startNode, visited);
    }
    
    // Recursive DFS helper method
    private void dfsRecursive(int node, Set<Integer> visited) {
        // Mark the node as visited
        visited.add(node);
        System.out.print(node + " "); // Print the node as we visit it
        
        // Recursively visit all the adjacent nodes
        for (int neighbor : adjacencyList.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }
    
    public static void main(String[] args) {
        DFSGraph graph = new DFSGraph();
        
        // Adding edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        
        // Perform DFS starting from node 0
        System.out.println("DFS traversal starting from node 0:");
        graph.dfs(0);  // Output: 0 1 3 4 2 5 6
        System.out.println();
        System.out.println("DFS traversal starting from node 2:");
        graph.dfs(2); //2 0 1 3 4 5 6
    }
}
