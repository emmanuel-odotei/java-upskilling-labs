package intermediate.src.week1_labs.advance_ds;

import java.util.*;

class WeightedGraph {
    private final Map<String, List<Edge>> adjacencyList = new HashMap<>();
    
    // Edge class representing a road (edge) between two cities (nodes) with a weight (distance)
    private static class Edge {
        String destination;
        int weight;
        
        public Edge (String destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
    
    // Adds a road between two cities with a given distance (weight)
    public void addEdge (String source, String destination, int weight) {
        adjacencyList.computeIfAbsent( source, k -> new ArrayList<>() ).add( new Edge( destination, weight ) );
        adjacencyList.computeIfAbsent( destination, k -> new ArrayList<>() ).add( new Edge( source, weight ) ); // For undirected graph
    }
    
    // Dijkstra's algorithm to find the shortest path from the source to the destination
    public Map<String, String> dijkstra (String startNode) {
        // Priority queue to store cities based on the shortest known distance from startNode
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>( Comparator.comparingInt( n -> n.distance ) );
        Map<String, Integer> distances = new HashMap<>(); // Stores shortest distances to each city
        Map<String, String> previous = new HashMap<>();   // To reconstruct the shortest path
        Set<String> visited = new HashSet<>();            // To track visited cities
        
        // Initialize distances: 0 for startNode, infinity for others
        for ( String city : adjacencyList.keySet() ) {
            distances.put( city, Integer.MAX_VALUE );
        }
        distances.put( startNode, 0 );
        priorityQueue.add( new Node( startNode, 0 ) );
        
        // Dijkstra's main loop
        while ( !priorityQueue.isEmpty() ) {
            Node currentNode = priorityQueue.poll();
            String currentCity = currentNode.city;
            
            // Skip the processing if the city is already visited
            if ( visited.contains( currentCity ) ) continue;
            visited.add( currentCity );
            
            // Explore all adjacent roads (edges)
            for ( Edge edge : adjacencyList.getOrDefault( currentCity, new ArrayList<>() ) ) {
                String neighbor = edge.destination;
                int newDist = distances.get( currentCity ) + edge.weight;
                
                // Update the shortest distance to neighbor if found shorter
                if ( newDist < distances.get( neighbor ) ) {
                    distances.put( neighbor, newDist );
                    priorityQueue.add( new Node( neighbor, newDist ) ); // Push updated distance to priority queue
                    previous.put( neighbor, currentCity ); // Keep track of the path
                }
            }
        }
        
        return previous; // Return the map used to reconstruct the shortest path
    }
    
    // Helper class for priority queue to store cities with their current known shortest distances
    private static class Node {
        String city;
        int distance;
        
        public Node (String city, int distance) {
            this.city = city;
            this.distance = distance;
        }
    }
    
    // To get the shortest path from startNode to endNode
    public List<String> getShortestPath (Map<String, String> previous, String startNode, String endNode) {
        List<String> path = new LinkedList<>();
        for ( String at = endNode; at != null; at = previous.get( at ) ) {
            path.add( at );
        }
        Collections.reverse( path );
        
        // If the startNode is not the first node in the list, it means there's no valid path
        if ( !path.get( 0 ).equals( startNode ) ) {
            return List.of( "No path found" );
        }
        
        return path;
    }
    
    public static void main (String[] args) {
        WeightedGraph graph = new WeightedGraph();
        
        // Adding cities and roads (edges with distances)
        graph.addEdge( "A", "B", 4 );
        graph.addEdge( "A", "C", 2 );
        graph.addEdge( "B", "C", 1 );
        graph.addEdge( "B", "D", 5 );
        graph.addEdge( "C", "D", 8 );
        graph.addEdge( "C", "E", 10 );
        graph.addEdge( "D", "E", 2 );
        graph.addEdge( "D", "F", 6 );
        graph.addEdge( "E", "F", 3 );
        
        // Starting the Dijkstra algorithm from city 'A'
        String startNode = "A";
        String endNode = "F";
        Map<String, String> previous = graph.dijkstra( startNode );
        
        // Query the previous map to get the shortest path
        List<String> shortestPath = graph.getShortestPath( previous, startNode, endNode );
        
        // Print the shortest path from startNode to endNode
        System.out.println( "\nShortest path from " + startNode + " to " + endNode + ": " + shortestPath );
    }
}