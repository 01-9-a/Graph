package cpen221.mp2.graph;

import java.util.*;

/**
 * Represents a graph with vertices of type V.
 *
 * @param <V> represents a vertex type
 */
public class Graph<V extends Vertex, E extends Edge<V>> implements ImGraph<V, E>, MGraph<V, E> {
    Map<V, ArrayList<E>> al=new LinkedHashMap<>();
    /**
     * Find the edge that connects two vertices if such an edge exists.
     * This method should not permit graph mutations.
     *
     * @param v1 one end of the edge
     * @param v2 the other end of the edge
     * @return the edge connecting v1 and v2
     * throw NoSuchElementException if no such edge found
     */
    @Override
    public E getEdge(V v1, V v2) {
        int length=0;
        int b=0;
        //MGraph mg=new ALGraph();
        Set<E> e_set =new HashSet<>(allEdges());
        for(E e:e_set){
            if((e.v1()==v1&&e.v2()==v2)||(e.v2()==v1&&e.v1()==v2)){
                length=e.length();
                b=1;
            }
        }
        if(b==0){
            throw new NoSuchElementException();
        }
        Edge<V> e_obj=new Edge<>(v1,v2,length);
        return (E) e_obj;
    }

    /**
     * obtain all the neighbours of vertex v.
     *
     * @param v is the vertex whose neighbourhood we want.
     * @return an arraylist containing each vertex w that neighbors v
     */
    public ArrayList<V> get_neighbour_vertex(V v){
        Map<V,E> neighbour=new HashMap<>(getNeighbours(v));
        Set<V> neighbour_v_set=new HashSet<>(neighbour.keySet());
        return new ArrayList<>(neighbour_v_set);
    }

    /**
     * obtain all paths from vertex start to vertex end
     * @param start the start vertex
     * @param end the end vertex
     * @return an arraylist that contains all paths from start to end
     */
    public ArrayList<ArrayList<V>> GetAllPath(V start, V end){
        Map<V, ArrayList<V>> neighbour_map=new HashMap<>();
        Set<V> all_vertex=new HashSet<>(allVertices());
        ArrayList<ArrayList<V>> AllPath=new ArrayList<>();
        for(V v:all_vertex){
            ArrayList<V> m=new ArrayList<>(get_neighbour_vertex(v));
            neighbour_map.put(v,m);
        }
        Queue<ArrayList<V>> queue=new LinkedList<>();
        ArrayList<V> arr= new ArrayList<>();
        arr.add(start);
        queue.offer(arr);
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
    /**
     * Compute the shortest path from source to sink
     *
     * @param source the start vertex
     * @param sink   the end vertex
     * @return the vertices, in order, on the shortest path from source to sink (both end points are part of the list)
     */
    @Override
    public List<V> shortestPath(V source, V sink) {
        ArrayList<ArrayList<V>> AllPath=new ArrayList<>(GetAllPath(source,sink));
        List<V> shortest_path=new ArrayList<>();
        int min_length=Integer.MAX_VALUE;
        for(ArrayList<V> al :AllPath){
            int length=0;
            for(int i=0;i<al.size()-1;i++){
                //MGraph obj=new ALGraph();
                length+= edgeLength(al.get(i),al.get(i+1));
            }
            if(length<min_length){
                min_length=length;
                shortest_path=new ArrayList<>(al);
            }
        }
        return shortest_path;
    }

    /**
     * Compute the length of a given path
     *
     * @param path indicates the vertices on the given path
     * @return the length of path
     */
    @Override
    public int pathLength(List<V> path) {
        int length=0;
        for(int i=0; i<path.size()-1;i++ ){
            length+= edgeLength(path.get(i),path.get(i+1));
        }
        return length;
    }
    /**
     * Obtain all vertices w that are no more than a <em>path distance</em> of range from v.
     *
     * @param v     the vertex to start the search from.
     * @param range the radius of the search.
     * @return a map where the keys are the vertices in the neighbourhood of v,
     *          and the value for key w is the last edge on the shortest path
     *          from v to w.
     */
    @Override
    public Map<V, E> getNeighbours(V v, int range) {
        Map<V,E> map=new HashMap<>();
        Set<V> all_v= new HashSet<>(allVertices());
        all_v.remove(v);
        for(V a:all_v){
            List<V> list=new ArrayList<>(shortestPath(v,a));
            int shortest_length=pathLength(list);
            if(list.size()>=2&&shortest_length<=range){
               map.put(a,getEdge(list.get(list.size()-2),a));
            }
        }
        return map;
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
    /**
     * Add a vertex to the graph
     *
     * @param v vertex to add
     * @return true if the vertex was added successfully and false otherwise
     */
    @Override
    public boolean addVertex(V v) {
        if(al.containsKey(v)){
            return false;
        }
        al.put(v, new ArrayList<>());
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
        return al.containsKey(v);
    }
    /**
     * Add an edge of the graph
     *
     * @param e the edge to add to the graph
     * @return true if the edge was successfully added and false otherwise
     */
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
    /**
     * Check if an edge is part of the graph
     *
     * @param e the edge to check in the graph
     * @return true if e is an edge in the graoh and false otherwise
     */
    @Override
    public boolean edge(E e) {
        Set<E> edge_set=new HashSet<>(allEdges());
        return edge_set.contains(e);
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
    /**
     * Determine the length on an edge in the graph
     *
     * @param v1 the first vertex of the edge
     * @param v2 the second vertex of the edge
     * @return the length of the v1-v2 edge if this edge is part of the graph
     * throw NoSuchElementException if v1,v2 edge is not part of the graph
     */
    @Override
    public int edgeLength(V v1, V v2) {
        ArrayList<E> e_list=al.get(v1);
        if(edge(v1,v2)) {
            for (E e : e_list) {
                if ((e.v1() == v1 && e.v2() == v2) || (e.v1() == v2 && e.v2() == v1)) {
                    return e.length();
                }
            }

        }
        throw new NoSuchElementException();
    }
    /**
     * Obtain the sum of the lengths of all edges in the graph
     *
     * @return the sum of the lengths of all edges in the graph
     */
    @Override
    public int edgeLengthSum() {
        int sum=0;
        Set<E> set=new HashSet<>();
        for(V key:al.keySet()){
            ArrayList<E> e_list=al.get(key);
            set.addAll(e_list);
        }
        for(E e:set){
            sum+=e.length();
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
        if(edge(e)){
            al.forEach((a,b) -> b.removeIf(c->c.equals(e)));
            return false;
        }

        return true;
    }
    /**
     * Remove a vertex from the graph
     *
     * @param v the vertex to remove
     * @return true if v was successfully removed and false otherwise
     */
    @Override
    public boolean remove(V v) {
        if(vertex(v)){
            al.remove(v);
            return false;
        }
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
        return new HashSet<>(al.keySet());
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
        return new HashSet<>(al.get(v));
    }
    /**
     * Obtain a set of all edges in the graph.
     * Access to this set **should not** permit graph mutations.
     *
     * @return all edges in the graph
     */
    @Override
    public Set<E> allEdges() {
        Set<E> e_set=new HashSet<>();
        Set<V> v_set=new HashSet<>(al.keySet());
        for(V v:v_set){
            e_set.addAll(allEdges(v));
        }
        return e_set;
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

    @Override
    public E getEdge(V v1, V v2) {
        return null;
    }

    @Override
    public List<V> shortestPath(V source, V sink) {
        return null;
    }

    @Override
    public int pathLength(List<V> path) {
        return 0;
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

