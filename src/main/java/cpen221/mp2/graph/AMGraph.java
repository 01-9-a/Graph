package cpen221.mp2.graph;

import java.util.*;

public class AMGraph<V extends Vertex, E extends Edge<V>> implements MGraph<V, E> {

    private int maxVertices;
    private int[][] amGraph;
    private List<V> vexs;
    private List<E> edges;
    private Set<V> allVex;
    private Set<E> allEdge;
    private Set<E> allEdgeV;

    /**
     * Create an empty graph with an upper-bound on the number of vertices
     */
    public AMGraph(int maxVertices) {
        this.maxVertices = maxVertices;
        amGraph = new int[maxVertices][maxVertices];
        vexs = new ArrayList<>();
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
        allVex = new HashSet<V>();
        allEdge = new HashSet<E>();
    }

    @Override
    public boolean addVertex(V v) {
        if (vexs.size()+1>maxVertices||vexs.contains(v)) {
            return false;
        }
        vexs.add(v);
        return true;
    }

    @Override
    public boolean vertex(V v) {
        return vexs.contains(v);
    }

    @Override
    public boolean addEdge(E e) {
        if (edges.contains(e)) {
            return false;
        }
        edges.add(e);
        amGraph[vexs.indexOf(e.v1())][vexs.indexOf(e.v2())]=e.length();
        amGraph[vexs.indexOf(e.v2())][vexs.indexOf(e.v1())]=e.length();
        return true;
    }

    @Override
    public boolean edge(E e) {
        return edges.contains(e);
    }

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

    @Override
    public int edgeLengthSum() {
        int sum = 0;
        for (E e:edges) {
            sum += e.length();
        }
        return sum;
    }

    @Override
    public boolean remove(E e) {
        if (!edges.contains(e)) {
            return false;
        }
        edges.remove(e);
        amGraph[vexs.indexOf(e.v1())][vexs.indexOf(e.v2())] = -1;
        amGraph[vexs.indexOf(e.v2())][vexs.indexOf(e.v1())] = -1;
        return true;
    }

    @Override
    public boolean remove(V v) {
        if (!vexs.contains(v)) {
            return false;
        }
        vexs.remove(v);
        for (int i=0; i<maxVertices; i++) {
            amGraph[vexs.indexOf(v)][i] = -1;
            amGraph[i][vexs.indexOf(v)] = -1;
        }
        return true;
    }

    @Override
    public Set<V> allVertices() {
        allVex.addAll(vexs);
        Set<V> allVexs;
        allVexs = allVex;
        return allVexs;
    }

    @Override
    public Set<E> allEdges(V v) {
        for (E e:edges) {
            if (v.equals(e.v2())||v.equals(e.v1())) {
                allEdgeV.add(e);
            }
        }
        return allEdgeV;
    }

    @Override
    public Set<E> allEdges() {
        allEdge.addAll(edges);
        Set<E> allEdges;
        allEdges = allEdge;
        return allEdges;
    }

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