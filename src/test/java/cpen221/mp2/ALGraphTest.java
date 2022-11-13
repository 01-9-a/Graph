package cpen221.mp2;

import cpen221.mp2.graph.ALGraph;
import cpen221.mp2.graph.Edge;
import cpen221.mp2.graph.Vertex;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ALGraphTest {

    @Test
    public void test1() {
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");
        Vertex v4 = new Vertex(4, "D");
        Vertex v5 = new Vertex(2, "B");
        Vertex v6 = new Vertex(5, "E");

        Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
        Edge<Vertex> e2 = new Edge<>(v2, v3);
        Edge<Vertex> e3 = new Edge<>(v1, v4, 9);
        Edge<Vertex> e4 = new Edge<>(v1, v4, 9);
        Edge<Vertex> e5 = new Edge<>(v1, v6, 3);

        ALGraph<Vertex, Edge<Vertex>> g = new ALGraph<>();
        boolean addV1 = g.addVertex(v1);
        boolean addV2 = g.addVertex(v2);
        boolean addV3 = g.addVertex(v3);
        boolean addV4 = g.addVertex(v4);
        boolean addV5 = g.addVertex(v5);
        boolean addE1 = g.addEdge(e1);
        boolean addE2 = g.addEdge(e2);
        boolean addE3 = g.addEdge(e3);
        boolean addE4 = g.addEdge(e4);

        assertTrue(g.vertex(v1));
        assertTrue(g.vertex(v2));
        assertTrue(g.vertex(v3));
        assertTrue(g.vertex(v4));
        assertTrue(g.vertex(v5));
        assertFalse(g.vertex(v6));

        assertTrue(addV1);
        assertTrue(addV2);
        assertTrue(addV3);
        assertTrue(addV4);
        assertFalse(addV5);

        assertTrue(addE1);
        assertTrue(addE2);
        assertTrue(addE3);
        assertFalse(addE4);
    }

    @Test
    public void test2() {
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");
        Vertex v4 = new Vertex(4, "D");
        Vertex v5 = new Vertex(2, "B");
        Vertex v6 = new Vertex(5, "E");
        Vertex v7 = new Vertex(7, "F");

        Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
        Edge<Vertex> e2 = new Edge<>(v2, v3);
        Edge<Vertex> e3 = new Edge<>(v1, v4, 9);
        Edge<Vertex> e4 = new Edge<>(v1, v4, 9);
        Edge<Vertex> e5 = new Edge<>(v1, v6, 3);
        Edge<Vertex> e6 = new Edge<>(v1, v7, 3);

        ALGraph<Vertex, Edge<Vertex>> g = new ALGraph<>();
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

        assertEquals(1, g.edgeLength(v2, v3));
        assertEquals(9, g.edgeLength(v1, v4));

        assertTrue(g.edge(e2));
        assertTrue(g.edge(v2, v3));
        assertFalse(g.edge(v4, v6));
        assertFalse(g.addEdge(e6));


        assertEquals(-1, g.edgeLength(v4, v6));
        assertEquals(0, g.edgeLength(v4, v4));
        assertEquals(15, g.edgeLengthSum());
    }

    @Test
    public void test3() {
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");
        Vertex v4 = new Vertex(4, "D");
        Vertex v5 = new Vertex(2, "B");
        Vertex v6 = new Vertex(5, "E");

        Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
        Edge<Vertex> e2 = new Edge<>(v2, v3);
        Edge<Vertex> e3 = new Edge<>(v1, v4, 9);
        Edge<Vertex> e4 = new Edge<>(v1, v4, 9);
        Edge<Vertex> e5 = new Edge<>(v1, v6, 3);

        ALGraph<Vertex, Edge<Vertex>> g = new ALGraph<>();
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);

        boolean removeE4 = g.remove(e4);
        boolean removeE5 = g.remove(e5);

        assertTrue(removeE4);
        assertFalse(removeE5);
        assertFalse(g.edge(e3));

        boolean removeV1 = g.remove(v1);
        boolean removeV6 = g.remove(v6);
        assertTrue(removeV1);
        assertFalse(removeV6);
        assertEquals(1, g.edgeLengthSum());
    }

    @Test
    public void test4() {
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");
        Vertex v4 = new Vertex(4, "D");
        Vertex v5 = new Vertex(2, "B");
        Vertex v6 = new Vertex(5, "E");

        Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
        Edge<Vertex> e2 = new Edge<>(v2, v3);
        Edge<Vertex> e3 = new Edge<>(v1, v4, 9);
        Edge<Vertex> e4 = new Edge<>(v1, v4, 9);
        Edge<Vertex> e5 = new Edge<>(v1, v6, 3);

        ALGraph<Vertex, Edge<Vertex>> g = new ALGraph<>();
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);

        Set<Vertex> expectedV = new HashSet<>();
        expectedV.add(v1);
        expectedV.add(v2);
        expectedV.add(v3);
        expectedV.add(v4);
        assertEquals(expectedV, g.allVertices());

        Set<Edge<Vertex>> expectedE = new HashSet<>();
        expectedE.add(e1);
        expectedE.add(e2);
        expectedE.add(e3);
        assertEquals(expectedE, g.allEdges());
    }

    @Test
    public void test5() {
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");
        Vertex v4 = new Vertex(4, "D");
        Vertex v5 = new Vertex(2, "B");
        Vertex v6 = new Vertex(5, "E");

        Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
        Edge<Vertex> e2 = new Edge<>(v2, v3);
        Edge<Vertex> e3 = new Edge<>(v1, v4, 9);
        Edge<Vertex> e4 = new Edge<>(v1, v4, 9);
        Edge<Vertex> e5 = new Edge<>(v1, v6, 3);

        ALGraph<Vertex, Edge<Vertex>> g = new ALGraph<>();
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);

        Set<Edge<Vertex>> expectedEonV2 = new HashSet<>();
        expectedEonV2.add(e1);
        expectedEonV2.add(e2);
        assertEquals(expectedEonV2, g.allEdges(v2));

        Map<Vertex, Edge<Vertex>> expectedNeighbours = new HashMap<>();
        expectedNeighbours.put(v1, e1);
        expectedNeighbours.put(v3, e2);
        assertEquals(expectedNeighbours, g.getNeighbours(v2));
    }
}