package algorithms.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Graph Example
 */
public class Graph {

    private final HashMap<Integer, Vertex> verticies = new HashMap<>();

    static class Vertex {
        private final int id;
        LinkedList<Vertex> adjacent = new LinkedList<>();

        public Vertex(int id) {
            this.id = id;
        }
    }

    /**
     * this method adds an edge to the graph between two specified verticies
     *
     * @param source      the data of the vertex the edge is from
     * @param destination to the data of the vertex the edge is going to
     */
    public void addEdge(int source, int destination) {
        verticies.computeIfAbsent(destination, k -> new Vertex(destination));
        verticies.computeIfAbsent(source, k -> new Vertex(source));
        Vertex sourceVertex = getNode(source);
        Vertex destinationVertex = getNode(destination);
        sourceVertex.adjacent.add(destinationVertex);
    }

    public boolean hasPathDFS(int source, int destination) {
        Vertex sourceVertex = getNode(source);
        Vertex destinationVertex = getNode(destination);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(sourceVertex, destinationVertex, visited);
    }

    public boolean hasPathBFS(int source, int destination) {
        return hasPathBFS(getNode(source), getNode(destination));
    }

    private Vertex getNode(int source) {
        return verticies.get(source);
    }

    /**
     * DFS search
     *
     * @param source      Source
     * @param destination Destination
     * @return return true if the source and the destination are linked
     */
    private boolean hasPathDFS(Vertex source, Vertex destination, HashSet<Integer> visited) {
        if (visited.contains(source.id)) {
            return false;
        }
        visited.add(source.id);
        if (source == destination) {
            return true;
        }
        for (Vertex child : source.adjacent) {
            if (hasPathDFS(child, destination, visited)) {
                return true;
            }
        }
        return false;
    }

    /**
     * BFS search
     *
     * @param source      Source
     * @param destination Destination
     * @return return true if the source and the destination are linked
     */
    private boolean hasPathBFS(Vertex source, Vertex destination) {
        LinkedList<Vertex> nextToVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        nextToVisit.add(source);
        while (!nextToVisit.isEmpty()) {
            Vertex node = nextToVisit.remove();
            if (node == destination) {
                return true;
            }
            if (visited.contains(node.id)) {
                continue;
            }
            visited.add(node.id);
            nextToVisit.addAll(node.adjacent);
        }
        return false;
    }


}
