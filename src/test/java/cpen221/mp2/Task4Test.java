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


        Set<ImGraph<Vertex, Edge<Vertex>>> set1 = new HashSet<>();
        set1.add(g1);
        Set<ImGraph<Vertex, Edge<Vertex>>> set_result = new HashSet<>(g.minimumSpanningComponents(1));

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

        Set<Graph<Vertex, Edge<Vertex>>> set = new HashSet<>();
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

        Set<Graph<Vertex, Edge<Vertex>>> set = new HashSet<>();
        set.add(g1);
        set.add(g2);
        set.add(g3);
        assertEquals(set, g.minimumSpanningComponents(3));
    }

    @Test
    public void test_wrong() {
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
        g1.addEdge(e2);

        g2.addVertex(v1);
        g2.addVertex(v2);
        g2.addEdge(e1);

        g3.addVertex(v4);

        Set<Graph<Vertex, Edge<Vertex>>> set = new HashSet<>();
        set.add(g1);
        set.add(g2);
        set.add(g3);
        assertFalse(set.equals( g.minimumSpanningComponents(3)));
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
        g2.addVertex(v2);
        g3.addVertex(v3);
        g4.addVertex(v4);
        g5.addVertex(v5);
        g6.addVertex(v6);

        Set<Graph<Vertex, Edge<Vertex>>> set_expected = new HashSet<>();
        set_expected.add(g1);
        set_expected.add(g2);
        set_expected.add(g3);
        set_expected.add(g4);
        set_expected.add(g5);
        set_expected.add(g6);

        Set<Graph<Vertex, Edge<Vertex>>> set= new HashSet<>();
        set.add(g1);
        set.add(g2);
        set.add(g3);
        set.add(g4);
        set.add(g5);
        Set<ImGraph<Vertex, Edge<Vertex>>> set_result = new HashSet<>(g.minimumSpanningComponents(6));
        assertEquals(set_expected, set_result);
        assertFalse(set_result.equals(set));
    }

    @Test
    public void test_d1() {
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
        assertEquals(24, g.diameter());
    }

    @Test
    public void test_d2() {
        Edge<Vertex> e8 = new Edge<>(v1, v2, 5);
        Edge<Vertex> e9=new Edge<>(v2,v3,2);
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);

        g.addEdge(e8);
        g.addEdge(e9);

        int d = g.diameter();
        assertEquals(7, g.diameter());
        assertEquals(v2, g.getCenter());
    }
    @Test
    public void test_d3() {
        Edge<Vertex> e8 = new Edge<>(v1, v2, 5);
        Edge<Vertex> e9=new Edge<>(v2,v3,2);
        Edge<Vertex> e10=new Edge<>(v4,v5,6);
        Edge<Vertex> e11=new Edge<>(v1,v3,3);
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex((v4));
        g.addVertex(v5);

        g.addEdge(e8);
        g.addEdge(e9);
        g.addEdge(e10);
        g.addEdge(e11);
        assertEquals(5, g.diameter());
        assertEquals(v3, g.getCenter());
    }
    @Test
    public void test_d4() {
        Vertex v7 = new Vertex(7, "H");
        Vertex v8 = new Vertex(8, "S");
        Vertex v9 = new Vertex(9, "W");
        Vertex v10 = new Vertex(10, "Z");
        Edge<Vertex> e8 = new Edge<>(v1, v2, 5);
        Edge<Vertex> e9=new Edge<>(v2,v3,2);
        Edge<Vertex> e10=new Edge<>(v4,v5,6);
        Edge<Vertex> e11=new Edge<>(v7,v9,7);
        Edge<Vertex> e12=new Edge<>(v7,v8,11);
        Edge<Vertex> e13=new Edge<>(v7,v10,13);
        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addEdge(e9);
        g.addEdge(e8);
        g.addEdge(e10);

        assertEquals(v2, g.getCenter());
        g.equals(null);
        g.equals(1);
    }
}