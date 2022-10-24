package cpen221.mp2.graph;

import java.util.*;

public class ALGraph<V extends Vertex, E extends Edge<V>> implements MGraph<V, E> {

    private int numOfVexs;
    private int maxNumOfVexs;
    private Map<V,List<E>> alGraph;

    public ALGraph () {
        this.maxNumOfVexs = maxNumOfVexs;
        alGraph = new HashMap<>();
    }

    @Override
    public boolean addVertex(V v) {
        if (numOfVexs>maxNumOfVexs||alGraph.containsKey(v)) {
            return false;
        }
        List<E> vexs = new ArrayList<>();
        alGraph.put(v,vexs);
        return true;
    }

    @Override
    public boolean vertex(V v) {
        if (alGraph.containsKey(v)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addEdge(E e) {
        if (!alGraph.containsKey(e.v1())||!alGraph.containsKey(e.v2())) {
            return false;
        }
        List<E> vexs = new ArrayList<>();
        vexs.add(e);
        alGraph.put(e.v1(),vexs);
        alGraph.put(e.v2(),vexs);
        return true;
    }

    @Override
    public boolean edge(E e) {
        if (alGraph.get(e.v1()).contains(e)&&alGraph.get(e.v2()).contains(e)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean edge(V v1, V v2) {
        List<E> vexs;
        vexs = alGraph.get(v1);
        for (E e:vexs) {
            if (e.v1()==v1&&e.v2()==v2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int edgeLength(V v1, V v2) {
        int length = 0;
        List<E> vexs;
        vexs = alGraph.get(v1);
        for (E e:vexs) {
            if (e.v2()==v2) {
                length=e.length();
            }
        }
        return length;
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
    // TODO: Implement this type using an adjacency list representation

}
