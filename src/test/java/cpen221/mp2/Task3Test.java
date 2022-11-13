package cpen221.mp2;

import cpen221.mp2.graph.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class Task3Test {

    @Test
    public void test1() {
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");
        Vertex v4 = new Vertex(4, "D");
        Vertex v5 = new Vertex(5, "E");
        Vertex v6 = new Vertex(6, "F");
        Vertex v7 = new Vertex(7, "G");

        Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
        Edge<Vertex> e2 = new Edge<>(v2, v3, 7);
        Edge<Vertex> e3 = new Edge<>(v1, v4, 9);
        Edge<Vertex> e4 = new Edge<>(v3, v5, 3);
        Edge<Vertex> e5 = new Edge<>(v2, v5, 11);
        Edge<Vertex> e6 = new Edge<>(v3, v6, 2);
        Edge<Vertex> e7 = new Edge<>(v5, v6, 8);
        Edge<Vertex> e_not_exist1 = new Edge<>(v6, v7, 2);
        Edge<Vertex> e_not_exist2 = new Edge<>(v7, v6, 2);
        Edge<Vertex> e_not_added = new Edge<>(v1, v6, 1);

        Graph<Vertex, Edge<Vertex>> g = new Graph<>();
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);
        assertFalse(g.addVertex(v6));
        g.addVertex(v7);
        assertFalse(g.remove(v7));
        assertTrue(g.remove(v7));

        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);
        g.addEdge(e5);
        g.addEdge(e6);
        g.addEdge(e7);
        assertTrue(g.addEdge(e_not_exist1));
        assertTrue(g.addEdge(e_not_exist2));
        g.addEdge(e_not_added);
        assertTrue(g.remove(e_not_added));
        assertFalse(g.remove(e_not_added));


        assertEquals(e2, g.getEdge(v2, v3));
        assertEquals(e5, g.getEdge(v5, v2));
        NoSuchElementException l1 = assertThrows(
                NoSuchElementException.class, () -> {
                    g.getEdge(v3, v4);
                });
        NoSuchElementException l2 = assertThrows(
                NoSuchElementException.class, () -> {
                    g.getEdge(v6, v2);
                });


        assertEquals(21, g.pathLength(g.shortestPath(v3, v4)));
        assertEquals(3, g.pathLength(g.shortestPath(v3, v5)));
        assertEquals(14, g.pathLength(g.shortestPath(v6, v1)));

        //test mggraph
        assertEquals(0, g.edgeLength(v1,v1));
        assertFalse(g.edge(v3, v4));
        assertTrue(g.edge(e2));
        assertTrue(g.edge(v2, v3));
        assertTrue(g.edge(v2, v1));
        assertEquals(45, g.edgeLengthSum());
        Map<Vertex, Edge> neighbours_expected = Map.of(v2, e1, v4, e3);
        Map<Vertex, Edge> neighbours_actual = Map.copyOf(g.getNeighbours(v1));
        assertTrue(g.vertex(v2));
        assertEquals(9, g.edgeLength(v1, v4));
        assertTrue(neighbours_expected.equals(neighbours_actual));
        NoSuchElementException l3 = assertThrows(
                NoSuchElementException.class, () -> {
                    g.edgeLength(v3, v4);
                });

        //test get neighbours
        Map<Vertex, Edge> map1=new HashMap<>();
        map1.put(v2, e1);
        map1.put(v3, e2);
        map1.put(v4, e3);
        assertEquals(map1, g.getNeighbours(v1,12));
        assertTrue(g.getNeighbours(v2,3).isEmpty());
    }

}