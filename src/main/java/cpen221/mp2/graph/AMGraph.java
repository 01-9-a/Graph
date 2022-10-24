package cpen221.mp2.graph;

import java.util.Map;
import java.util.Set;

public class AMGraph<V extends Vertex, E extends Edge<V>> implements MGraph<V, E> {

    private int maxVertices;
    private int[][] amGraph;
    private V v1;
    private V v2;

    /**
     * Create an empty graph with an upper-bound on the number of vertices
     * @param maxVertices is greater than 1
     */
    public AMGraph(int maxVertices) {
        // TODO: Implement this method
        this.maxVertices = maxVertices;
        amGraph = new int[maxVertices][maxVertices];
    }

    @Override
    public boolean addVertex(V v) {
        return false;
    }

    @Override
    public boolean vertex(V v) {
        return false;
    }

    @Override
    public boolean addEdge(E e) {
        return false;
    }

    @Override
    public boolean edge(E e) {
        return false;
    }

    @Override
    public boolean edge(V v1, V v2) {
        return false;
    }

    @Override
    public int edgeLength(V v1, V v2) {
        return 0;
    }

    @Override
    public int edgeLengthSum() {
        return 0;
    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public boolean remove(V v) {
        return false;
    }

    @Override
    public Set<V> allVertices() {
        return null;
    }

    @Override
    public Set<E> allEdges(V v) {
        return null;
    }

    @Override
    public Set<E> allEdges() {
        return null;
    }

    @Override
    public Map<V, E> getNeighbours(V v) {
        return null;
    }
}
