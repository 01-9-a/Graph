package cpen221.mp2;

import cpen221.mp2.graph.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class Task4Test {
    Vertex v1 = new Vertex(1, "A");
    Vertex v2 = new Vertex(2, "B");
    Vertex v3 = new Vertex(3, "C");
    Vertex v4 = new Vertex(4, "D");
    Vertex v5 = new Vertex(5, "E");
    Vertex v6 = new Vertex(6, "F");

    Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
    Edge<Vertex> e2 = new Edge<>(v2, v3, 7);
    Edge<Vertex> e3 = new Edge<>(v1, v4, 9);
    Edge<Vertex> e4 = new Edge<>(v3, v5, 3);
    Edge<Vertex> e5 = new Edge<>(v2, v5, 11);
    Edge<Vertex> e6 = new Edge<>(v3, v6, 2);
    Edge<Vertex> e7 = new Edge<>(v5, v6, 8);



    @Test
    public void test1() {
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);

        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);
        g.addEdge(e5);
        g.addEdge(e6);
        g.addEdge(e7);

        Graph<Vertex, Edge<Vertex>> g1 = new Graph<>();
        g1.addVertex(v1);
        g1.addVertex(v2);
        g1.addVertex(v3);
        g1.addVertex(v4);
        g1.addVertex(v5);
        g1.addVertex(v6);

        g1.addEdge(e1);
        g1.addEdge(e2);
        g1.addEdge(e3);
        g1.addEdge(e4);
        g1.addEdge(e6);


        Set<ImGraph<Vertex, Edge<Vertex>> >set1=new HashSet<>();
        set1.add(g1);
        Set<ImGraph<Vertex, Edge<Vertex>>> set_result =new HashSet<>(g.minimumSpanningComponents(1));

        assertEquals(set1, set_result);

    }

    @Test
    public void test2() {
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);

        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);
        g.addEdge(e5);
        g.addEdge(e6);
        g.addEdge(e7);

        Graph<Vertex, Edge<Vertex>> g1 = new Graph<>();
        Graph<Vertex, Edge<Vertex>> g2 = new Graph<>();
        g1.addVertex(v1);
        g1.addVertex(v2);
        g1.addVertex(v3);
        g1.addVertex(v5);
        g1.addVertex(v6);

        g1.addEdge(e1);
        g1.addEdge(e2);
        g1.addEdge(e4);
        g1.addEdge(e6);

        g2.addVertex(v4);

        Set<Graph<Vertex, Edge<Vertex>> >set=new HashSet<>();
        set.add(g1);
        set.add(g2);
        assertEquals(set, g.minimumSpanningComponents(2));
    }

    @Test
    public void test3() {
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);

        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);
        g.addEdge(e5);
        g.addEdge(e6);
        g.addEdge(e7);

        Graph<Vertex, Edge<Vertex>> g1 = new Graph<>();
        Graph<Vertex, Edge<Vertex>> g2 = new Graph<>();
        Graph<Vertex, Edge<Vertex>> g3 = new Graph<>();
        g1.addVertex(v3);
        g1.addVertex(v5);
        g1.addVertex(v6);
        g1.addEdge(e4);
        g1.addEdge(e6);

        g2.addVertex(v1);
        g2.addVertex(v2);
        g2.addEdge(e1);

        g3.addVertex(v4);

        Set<Graph<Vertex, Edge<Vertex>> >set=new HashSet<>();
        set.add(g1);
        set.add(g2);
        set.add(g3);
        assertEquals(set, g.minimumSpanningComponents(3));
    }
    @Test//k=6
    public void test4() {
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);

        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);
        g.addEdge(e5);
        g.addEdge(e6);
        g.addEdge(e7);

        Graph<Vertex, Edge<Vertex>> g1 = new Graph<>();
        Graph<Vertex, Edge<Vertex>> g2 = new Graph<>();
        Graph<Vertex, Edge<Vertex>> g3 = new Graph<>();
        Graph<Vertex, Edge<Vertex>> g4 = new Graph<>();
        Graph<Vertex, Edge<Vertex>> g5 = new Graph<>();
        Graph<Vertex, Edge<Vertex>> g6 = new Graph<>();
        g1.addVertex(v1);
        g1.addVertex(v2);
        g1.addVertex(v3);
        g1.addVertex(v4);
        g1.addVertex(v5);
        g1.addVertex(v6);

        Set<Graph<Vertex, Edge<Vertex>> >set=new HashSet<>();
        set.add(g1);
        set.add(g2);
        set.add(g3);
        set.add(g4);
        set.add(g5);
        set.add(g6);
        assertEquals(set, g.minimumSpanningComponents(6));
    }

    @Test
    public void test_d(){
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);

        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);
        g.addEdge(e5);
        g.addEdge(e6);
        g.addEdge(e7);
        int d= g.diameter();
        assertEquals(15,g.diameter());

    }

}