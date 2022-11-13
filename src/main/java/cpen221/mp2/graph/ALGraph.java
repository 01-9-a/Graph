package cpen221.mp2.graph;
import java.util.*;

public class ALGraph<V extends Vertex, E extends Edge<V>> implements MGraph<V, E> {
    int numV = 0;
    int numE = 0;
    Set<V> setV = new HashSet<>();
    Set<E> setE = new HashSet<>();
    List<List<V>> adjList = new ArrayList<>();

    /**
     * Add a vertex to the adjacency list graph
     *
     * @param v vertex to add
     * @return true if the vertex was added successfully and false if already existed
     */
    @Override
    public boolean addVertex(V v) {
        if(vertex(v)){
            return false;
        }
        else {
            numV++;
            setV.add(v);
            List<V> list = new LinkedList<>();
            list.add(v);
            adjList.add(list);
            return true;
        }
    }

    /**
     * Check if a vertex is part of the adjacency list graph
     *
     * @param v vertex to check in the graph
     * @return true of v is part of the graph and false otherwise
     */
    @Override
    public boolean vertex(V v) {
        if(setV.contains(v)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Add an edge of the adjacency list graph
     *
     * @param e the edge to add to the graph
     * @return true if the edge was successfully added and false if already existed
     */
    @Override
    public boolean addEdge(E e) {
        if(!edge(e)){
            if(vertex(e.v1()) && vertex(e.v2())) {
                numE++;
                setE.add(e);
                for (List<V> l : adjList) {
                    if (l.get(0).equals(e.v1())) {
                        l.add(e.v2());
                    }
                    if (l.get(0).equals(e.v2())) {
                        l.add(e.v1());
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Check if an edge is part of the adjacency list graph
     *
     * @param e the edge to check in the graph
     * @return true if e is an edge in the graph and false otherwise
     */
    @Override
    public boolean edge(E e) {
        if(setE.contains(e)){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Check if v1-v2/v2-v1 is an edge in the adjacency list graph
     *
     * @param v1 the first vertex of the edge
     * @param v2 the second vertex of the edge
     * @return true of the v1-v2 edge/v2-v1 edge is part of the graph and false otherwise
     */
    @Override
    public boolean edge(V v1, V v2) {
        for(E e: setE){
            if((e.v1()==v1 && e.v2()==v2) || e.v2()==v1 && e.v1()==v2){
                return true;
            }
        }
        return false;
    }

    /**
     * Determine the length on an edge in the adjacency list graph
     *
     * @param v1 the first vertex of the edge
     * @param v2 the second vertex of the edge
     * @return the length of the v1-v2/v2-v1 edge if this edge is part of the graph else return 0
     */
    @Override
    public int edgeLength(V v1, V v2) {
        if(edge(v1,v2)){
            for(E e: setE){
                if((e.v1()==v1 && e.v2()==v2) || e.v2()==v1 && e.v1()==v2){
                    return e.length();
                }
            }
        }
        else if(v1.equals(v2)){
            return 0;
        }
        return -1;
    }

    /**
     * Obtain the sum of the lengths of all edges in the adjacency list graph
     *
     * @return the sum of the lengths of all edges in the adjacency list graph
     */
    @Override
    public int edgeLengthSum() {
        int sum = 0;
        for(E e: setE){
            sum += e.length();
        }
        return sum;
    }

    /**
     * Remove an edge from the adjacency list graph
     *
     * @param e the edge to remove
     * @return true if e was successfully removed and false if not existed
     */
    @Override
    public boolean remove(E e) {
        if (edge(e)) {
            numE--;
            setE.remove(e);
            for(List<V> l: adjList){
                if(l.get(0)==e.v1()){
                    l.remove(e.v2());
                }
                if(l.get(0)==e.v2()){
                    l.remove(e.v1());
                }
            }
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * Remove a vertex from the adjacency list graph
     *
     * @param v the vertex to remove
     * @return true if v was successfully removed and false if not existed
     */
    @Override
    public boolean remove(V v) {
        if(vertex(v)){
            numV--;
            setV.remove(v);
            adjList.removeIf(l -> l.get(0) == v);
            setE.removeIf(e -> e.v1().equals(v) || e.v2().equals(v));
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Obtain a set of all vertices in the adjacency list graph.
     *
     * @return a set of all vertices in the graph
     */
    @Override
    public Set<V> allVertices() {
        return new HashSet<>(setV);
    }

    /**
     * Obtain a set of all edges incident on v.
     *
     * @param v the vertex of interest
     * @return all edges incident on v
     */
    @Override
    public Set<E> allEdges(V v) {
        Set<E> set = new HashSet<>();
        for(E e: setE){
            if(e.v1()==v || e.v2()==v){
                set.add(e);
            }
        }
        return set;
    }

    /**
     * Obtain a set of all edges in the adjacency list graph.
     *
     * @return a set of all edges in the graph
     */
    @Override
    public Set<E> allEdges() {
        return new HashSet<>(setE);
    }

    /**
     * Obtain all the neighbours of vertex v.
     *
     * @param v is the vertex whose neighbourhood we want.
     * @return a map containing each vertex w that neighbors v and the edge between v and w.
     */
    @Override
    public Map<V, E> getNeighbours(V v) {
        Map<V, E> map = new HashMap<>();{
            for(E e: setE){
                if(e.v1().equals(v) || e.v2().equals(v)){
                    if(e.v1().equals(v)){
                        map.put(e.v2(), e);
                    }
                    if(e.v2().equals(v)){
                        map.put(e.v1(), e);
                    }
                }
            }
        }
        return map;
    }
}
