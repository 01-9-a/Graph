package cpen221.mp2.graph;

import java.util.*;

/**
 * Represents a graph with vertices of type V.
 *
 * @param <V> represents a vertex type
 */
public class Graph<V extends Vertex, E extends Edge<V>> implements ImGraph<V, E>, MGraph<V, E> {
    Map<V, ArrayList<E>> al=new LinkedHashMap<>();

    @Override
    public E getEdge(V v1, V v2) {
        int length=0;
        MGraph mg=new ALGraph();
        Set<E> e_set =new HashSet<>(mg.allEdges());
        for(E e:e_set){
            if((e.v1()==v1&&e.v2()==v2)||(e.v2()==v1&&e.v1()==v2)){
                length=e.length();
            }else throw new NoSuchElementException("No Such edge existed");
        }
        Edge e_obj=new Edge<>(v1,v2,length);
        return (E) e_obj;
    }

    public ArrayList<V> get_neighbour_vertex(V v){
        MGraph mg=new ALGraph();
        Map<V,E> neighbour=new HashMap<>(mg.getNeighbours(v));
        Set<V> neighbour_v_set=new HashSet<>(neighbour.keySet());
        return new ArrayList<>(neighbour_v_set);
    }

    public ArrayList<ArrayList<V>> GetAllPath(V start, V end){
        MGraph mg=new ALGraph();
        Map<V, ArrayList<V>> neighbour_map=new HashMap<>();
        Set<V> all_vertex=new HashSet<>(mg.allVertices());
        ArrayList<ArrayList<V>> AllPath=new ArrayList<>();
        for(V v:all_vertex){
            ArrayList<V> m=new ArrayList<>(get_neighbour_vertex(v));
            neighbour_map.put(v,m);
        }
        Queue<ArrayList<V>> queue=new LinkedList<>();
        ArrayList<V> al= new ArrayList<>();
        al.add(start);
        queue.offer(al);
        while(!queue.isEmpty()){
            ArrayList<V> path;
            path=queue.poll();
            if(path.get(path.size()-1).equals(end)){
                AllPath.add(path);
            }
            //get the neighbour v list for the last vertex in path
            Vertex a =path.get(path.size()-1);
            ArrayList<V> m=new ArrayList<>(neighbour_map.get(a));
            for (V v : m) {
                if (!path.contains(v)) {
                    ArrayList<V> new_path = new ArrayList<>(path);
                    new_path.add(v);
                    queue.offer(new_path);
                }
            }
        }
        return AllPath;
    }

    @Override
    public List<V> shortestPath(V source, V sink) {
        ArrayList<ArrayList<V>> AllPath=new ArrayList<>(GetAllPath(source,sink));
        List<V> shortest_path=new ArrayList<>();
        int min_length=Integer.MAX_VALUE;
        for(ArrayList<V> al :AllPath){
            int length=0;
            for(int i=0;i<al.size();i++){
                MGraph obj=new ALGraph();
                length+= obj.edgeLength(al.get(i),al.get(i+1));
            }
            if(length<min_length){
                min_length=length;
                shortest_path=new ArrayList<>(al);
            }
        }
        return shortest_path;
    }

    @Override
    public int pathLength(List<V> path) {
        int path_length=0;
        Set<E> edge_set=new HashSet<>(allEdges());
        for(int i=0; i<path.size();i++ ){
            for(E e:edge_set){
                if(e.v1().equals(path.get(i))&&e.v2().equals(path.get(i+1))){
                    path_length+=e.length();
                }
            }
        }
        return path_length;
    }

    @Override
    public Map<V, E> getNeighbours(V v, int range) {
        return null;
    }

    @Override
    public Set<ImGraph<V, E>> minimumSpanningComponents(int k) {
        return null;
    }

    @Override
    public int diameter() {
        return 0;
    }

    @Override
    public V getCenter() {
        return null;
    }

    @Override
    public boolean addVertex(V v) {
        if(al.containsKey(v)){
            return false;
        }
        al.put(v,new ArrayList<E>());
        return true;
    }

    @Override
    public boolean vertex(V v) {
        if(al.containsKey(v)) {
            return true;
        }
        return false;
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
        if (edge_set.contains(e)) {
            return true;
        }
        return false;
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

    /**
     * This method removes some edges at random while preserving connectivity
     * <p>
     * DO NOT CHANGE THIS METHOD
     * </p>
     * <p>
     * You will need to implement allVertices() and allEdges(V v) for this
     * method to run correctly
     *</p>
     * <p><strong>requires:</strong> this graph is connected</p>
     *
     * @param rng random number generator to select edges at random
     */
    public void pruneRandomEdges(Random rng) {
        class VEPair {
            V v;
            E e;

            public VEPair(V v, E e) {
                this.v = v;
                this.e = e;
            }
        }
        /* Visited Nodes */
        Set<V> visited = new HashSet<>();
        /* Nodes to visit and the cpen221.mp2.graph.Edge used to reach them */
        Deque<VEPair> stack = new LinkedList<VEPair>();
        /* Edges that could be removed */
        ArrayList<E> candidates = new ArrayList<>();
        /* Edges that must be kept to maintain connectivity */
        Set<E> keep = new HashSet<>();

        V start = null;
        for (V v : this.allVertices()) {
            start = v;
            break;
        }
        if (start == null) {
            // nothing to do
            return;
        }
        stack.push(new VEPair(start, null));
        while (!stack.isEmpty()) {
            VEPair pair = stack.pop();
            if (visited.add(pair.v)) {
                keep.add(pair.e);
                for (E e : this.allEdges(pair.v)) {
                    stack.push(new VEPair(e.distinctVertex(pair.v), e));
                }
            } else if (!keep.contains(pair.e)) {
                candidates.add(pair.e);
            }
        }
        // randomly trim some candidate edges
        int iterations = rng.nextInt(candidates.size());
        for (int count = 0; count < iterations; ++count) {
            int end = candidates.size() - 1;
            int index = rng.nextInt(candidates.size());
            E trim = candidates.get(index);
            candidates.set(index, candidates.get(end));
            candidates.remove(end);
            remove(trim);
        }
    }
}

