package cpen221.mp2.graph;

import java.util.*;

public class ALGraph<V extends Vertex, E extends Edge<V>> implements MGraph<V, E> {

    public Map<V, ArrayList<E>> al=new LinkedHashMap<>();
    @Override
    /**
     * Add a vertex to the graph
     *
     * @param v vertex to add
     * @return true if the vertex was added successfully and false otherwise
     */
    public boolean addVertex(V v) {
        if(al.containsKey(v)){
            return false;
        }
        al.put(v,new ArrayList<E>());
        return true;
    }

    @Override
    /**
     * Check if a vertex is part of the graph
     *
     * @param v vertex to check in the graph
     * @return true of v is part of the graph and false otherwise
     */
    public boolean vertex(V v) {
        if(al.containsKey(v)) {
            return true;
        }
        return false;
    }

    @Override
    /**
     * Add an edge of the graph
     *
     * @param e the edge to add to the graph
     * @return true if the edge was successfully added and false otherwise
     */
    public boolean addEdge(E e) {
        boolean v1=al.containsKey(e.v1());
        boolean v2=al.containsKey(e.v2());
        if(!v1||!v2){
            return false;
        }
        al.get(e.v1()).add(e);
        al.get(e.v2()).add(e);
        return true;
    }

    @Override
    /**
     * Check if an edge is part of the graph
     *
     * @param e the edge to check in the graph
     * @return true if e is an edge in the graph and false otherwise
     */
    public boolean edge(E e) {
        Set<E> edge_set=new HashSet<>(allEdges());
        if (edge_set.contains(e)) {
            return true;
        }
        return false;
    }

    @Override
    /**
     * Check if v1-v2 is an edge in the graph
     *
     * @param v1 the first vertex of the edge
     * @param v2 the second vertex of the edge
     * @return true of the v1-v2 edge is part of the graph and false otherwise
     */
    public boolean edge(V v1, V v2) {
        ArrayList<E> v_list=al.get(v1);
        for(E e:v_list){
            if(e.v1()==v1){
                if(e.v2()==v2){
                    return true;
                }
            }
            if(e.v2()==v1){
                if(e.v1()==v2){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    /**
     * Determine the length on an edge in the graph
     *
     * @param v1 the first vertex of the edge
     * @param v2 the second vertex of the edge
     * @return the length of the v1-v2 edge if this edge is part of the graph
     */
    public int edgeLength(V v1, V v2) {
        int length=0;
        ArrayList<E> e_list=al.get(v1);
        for(E e: e_list){
            if((e.v1()==v1 && e.v2()==v2)) {
                return e.length();
            }
        }
        return 0;
    }

    @Override
    /**
     * Obtain the sum of the lengths of all edges in the graph
     *
     * @return the sum of the lengths of all edges in the graph
     */
    public int edgeLengthSum() {
        int sum=0;
        for(V key:al.keySet()){
            ArrayList<E> e_list=al.get(key);
            for(E e:e_list){
                sum+=e.length();
            }
        }
        return sum;
    }

    @Override
    /**
     * Remove an edge from the graph
     *
     * @param e the edge to remove
     * @return true if e was successfully removed and false otherwise
     */
    public boolean remove(E e) {
        if(edge(e)){
            for(V key:al.keySet()){
                ArrayList<E> e_list=al.get(key);
                for(E m:e_list){
                    if(m==e){
                        e_list.remove(m);
                    }
                }
                al.put(key,e_list);
            }
            return false;
        }

        return true;
    }

    @Override
    /**
     * Remove a vertex from the graph
     *
     * @param v the vertex to remove
     * @return true if v was successfully removed and false otherwise
     */
    public boolean remove(V v) {
        if(vertex(v)){
            al.remove(v);
            return false;
        }
        return true;
    }

    @Override
    /**
     * Obtain a set of all vertices in the graph.
     * Access to this set **should not** permit graph mutations.
     *
     * @return a set of all vertices in the graph
     */
    public Set<V> allVertices() {
        Set<V> v_set=new HashSet<>(al.keySet());
        return v_set;
    }

    @Override
    /**
     * Obtain a set of all vertices incident on v.
     * Access to this set **should not** permit graph mutations.
     *
     * @param v the vertex of interest
     * @return all edges incident on v
     */
    public Set<E> allEdges(V v) {
        Set<E> e_set=new HashSet<>(al.get(v));
        return e_set;
    }

    @Override
    /**
     * Obtain a set of all edges in the graph.
     * Access to this set **should not** permit graph mutations.
     *
     * @return all edges in the graph
     */
    public Set<E> allEdges() {
        Set<E> e_set=new HashSet<>();
        Set<V> v_set=new HashSet<>(al.keySet());
        for(V v:v_set){
            e_set.addAll(allEdges(v));
        }
        return e_set;
    }

    @Override
    /**
     * Obtain all the neighbours of vertex v.
     * Access to this map **should not** permit graph mutations.
     *
     * @param v is the vertex whose neighbourhood we want.
     * @return a map containing each vertex w that neighbors v and the edge between v and w.
     */
    public Map<V, E> getNeighbours(V v) {
        Map<V,E> neighbour=new HashMap<>();
        Set<E> edge_set=allEdges();
        for(E e:edge_set){
            if(e.v1()==v){
                neighbour.put(e.v2(),e);
            }
            else if(e.v2()==v){
                neighbour.put(e.v1(),e);
            }
        }
        return neighbour;
    }
}
