package cpen221.mp2.graph;

import java.util.*;

public class ALGraph<V extends Vertex, E extends Edge<V>> implements MGraph<V, E> {

    public Map<V, ArrayList<E>> al=new LinkedHashMap<>();
    @Override
    public boolean addVertex(V v) {
        if(al.containsKey(v)){
            return false;
        }
        al.put(v, new ArrayList<>());
        return true;
    }

    @Override
    public boolean vertex(V v) {
        return al.containsKey(v);
    }

    @Override
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
    public boolean edge(E e) {
        Set<E> edge_set=new HashSet<>(allEdges());
        return edge_set.contains(e);
    }

    @Override
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
    public int edgeLength(V v1, V v2) {
        ArrayList<E> e_list=al.get(v1);
        for(E e: e_list) {
            if ((e.v1() == v1 && e.v2() == v2)) {
                return e.length();
            }
            if ((e.v1() == v2 && e.v2() == v1)) {
                return e.length();
            }
        }
        return 0;
    }

    @Override
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
    public boolean remove(E e) {
        if(edge(e)){
            for(V key:al.keySet()){
                ArrayList<E> e_list=al.get(key);
                e_list.removeIf(m -> m == e);
                al.put(key,e_list);
            }
            return false;
        }

        return true;
    }

    @Override
    public boolean remove(V v) {
        if(vertex(v)){
            al.remove(v);
            return false;
        }
        return true;
    }

    @Override
    public Set<V> allVertices() {
        return new HashSet<>(al.keySet());
    }

    @Override
    public Set<E> allEdges(V v) {
        return new HashSet<>(al.get(v));
    }

    @Override
    public Set<E> allEdges() {
        Set<E> e_set=new HashSet<>();
        Set<V> v_set=new HashSet<>(al.keySet());
        for(V v:v_set){
            e_set.addAll(allEdges(v));
        }
        return e_set;
    }

    @Override
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
