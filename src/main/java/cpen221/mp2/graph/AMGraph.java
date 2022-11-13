package cpen221.mp2.graph;

import java.util.*;

/**
 * This class represents the adjacency matrix representation for graph
 */

public class AMGraph<V extends Vertex, E extends Edge<V>> implements MGraph<V, E> {
    // Representation Invariant:
    //   maximum number of vertices in the matrix
    // Abstraction Function:
    //   AF(r) = a matrix graph
    //   amGraph.size() = maxVertices

    /** The maximum number of vertices allowed in the matrix */
    private final int maxVertices;

    /** The adjacency matrix graph */
    private final int[][] amGraph;

    /** The list for all vertices */
    private final List<V> vertices;

    /** The list for all edges */
    private final List<E> edges;

    /**
     * Create an empty graph with an upper-bound on the number of vertices
     * If there is no edge between two vertices, the weight will be -1
     * If two vertices are the same, which means v1 equals v2, the weight will be 0
     */
    public AMGraph(int maxVertices) {
        // TODO: Implement this method
        this.maxVertices = maxVertices;
        amGraph = new int[maxVertices][maxVertices];
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
        for (int i=0; i<maxVertices; i++) {
            for (int j=0; j<maxVertices; j++) {
                if (i==j) {
                    amGraph[i][j]=0;
                }
                else {
                    amGraph[i][j]=-1;
                }
            }
        }
    }

    /**
     * Add a vertex to the graph
     *
     * @param v vertex to add
     * @return true if the vertex was added successfully and false otherwise
     */
    @Override
    public boolean addVertex(V v) {
        if (vertices.size()+1>maxVertices|| vertices.contains(v)) {
            return false;
        }
        vertices.add(v);
        return true;
    }

    /**
     * Check if a vertex is part of the graph
     *
     * @param v vertex to check in the graph
     * @return true of v is part of the graph and false otherwise
     */
    @Override
    public boolean vertex(V v) {
        return vertices.contains(v);
    }

    /**
     * Add an edge of the graph
     * The length of the edge has no directions so length will be added to both of
     * (v1,v2) and (v2,v1)
     *
     * @param e the edge to add to the graph
     * @return true if the edge was successfully added and false otherwise
     */
    @Override
    public boolean addEdge(E e) {
        if (edges.contains(e)) {
            return false;
        }
        if (!vertices.contains(e.v1())||!vertices.contains(e.v2())) {
            return false;
        }
        edges.add(e);
        amGraph[vertices.indexOf(e.v1())][vertices.indexOf(e.v2())]=e.length();
        amGraph[vertices.indexOf(e.v2())][vertices.indexOf(e.v1())]=e.length();
        return true;
    }

    /**
     * Check if an edge is part of the graph
     *
     * @param e the edge to check in the graph
     * @return true if e is an edge in the graph and false otherwise
     */
    @Override
    public boolean edge(E e) {
        return edges.contains(e);
    }

    /**
     * Check if v1-v2 is an edge in the graph
     *
     * @param v1 the first vertex of the edge
     * @param v2 the second vertex of the edge
     * @return true of the v1-v2 edge is part of the graph and false otherwise
     */
    @Override
    public boolean edge(V v1, V v2) {
        for (E e:edges) {
            if (v1.equals(e.v1())&&v2.equals(e.v2())) {
                return true;
            }
            if (v2.equals(e.v1())&&v1.equals(e.v2())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determine the length on an edge in the graph
     *
     * @param v1 the first vertex of the edge
     * @param v2 the second vertex of the edge
     * @return the length of the v1-v2 edge if this edge is part of the graph
     * 0 if v1 equals v2
     * -1 if there is no edge between two vertices
     */
    @Override
    public int edgeLength(V v1, V v2) {
        for (E e:edges) {
            if (v1.equals(e.v1())&&v2.equals(e.v2())) {
                return e.length();
            }
            if (v2.equals(e.v1())&&v1.equals(e.v2())) {
                return e.length();
            }
        }
        if (v1.equals(v2)) {
            return 0;
        }
        return -1;
    }

    /**
     * Obtain the sum of the lengths of all edges in the graph
     *
     * @return the sum of the lengths of all edges in the graph
     */
    @Override
    public int edgeLengthSum() {
        int sum = 0;
        for (E e:edges) {
            sum += e.length();
        }
        return sum;
    }

    /**
     * Remove an edge from the graph
     *
     * @param e the edge to remove
     * @return true if e was successfully removed and false otherwise
     */
    @Override
    public boolean remove(E e) {
        if (!vertices.contains(e.v1())||!vertices.contains(e.v1())) {
            return false;
        }
        if (!edges.contains(e)) {
            return false;
        }
        amGraph[vertices.indexOf(e.v1())][vertices.indexOf(e.v2())] = -1;
        amGraph[vertices.indexOf(e.v2())][vertices.indexOf(e.v1())] = -1;
        edges.remove(e);
        return true;
    }

    /**
     * Remove a vertex from the graph
     * Also remove the edges connected to the vertex
     *
     * @param v the vertex to remove
     * @return true if v was successfully removed and false otherwise
     */
    @Override
    public boolean remove(V v) {
        if (!vertices.contains(v)) {
            return false;
        }
        for (int i=0; i<maxVertices; i++) {
            amGraph[vertices.indexOf(v)][i] = -1;
            amGraph[i][vertices.indexOf(v)] = -1;
        }
        edges.removeIf(e -> v.equals(e.v1()) || v.equals(e.v2()));
        vertices.remove(v);
        return true;
    }

    /**
     * Obtain a set of all vertices in the graph.
     * Access to this set **should not** permit graph mutations.
     *
     * @return a set of all vertices in the graph
     */
    @Override
    public Set<V> allVertices() {
        return new HashSet<>(vertices);
    }

    /**
     * Obtain a set of all vertices incident on v.
     * Access to this set **should not** permit graph mutations.
     *
     * @param v the vertex of interest
     * @return all edges incident on v
     */
    @Override
    public Set<E> allEdges(V v) {
        Set<E> allEdgeV = new HashSet<>();
        for (E e:edges) {
            if (v.equals(e.v2())||v.equals(e.v1())) {
                allEdgeV.add(e);
            }
        }
        return allEdgeV;
    }

    /**
     * Obtain a set of all edges in the graph.
     * Access to this set **should not** permit graph mutations.
     *
     * @return all edges in the graph
     */
    @Override
    public Set<E> allEdges() {
        return new HashSet<>(edges);
    }

    /**
     * Obtain all the neighbours of vertex v.
     * Access to this map **should not** permit graph mutations.
     *
     * @param v is the vertex whose neighbourhood we want.
     * @return a map containing each vertex w that neighbors v and the edge between v and w.
     */
    @Override
    public Map<V, E> getNeighbours(V v) {
        Map<V,E> neighbours = new HashMap<>();
        for (E e:edges) {
            if (v.equals(e.v1())) {
                neighbours.put(e.v2(),e);
            }
            if (v.equals(e.v2())) {
                neighbours.put(e.v1(),e);
            }
        }
        return neighbours;
    }
}