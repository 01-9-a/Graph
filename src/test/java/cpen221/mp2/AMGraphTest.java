package cpen221.mp2;

import cpen221.mp2.graph.AMGraph;
import cpen221.mp2.graph.Edge;
import cpen221.mp2.graph.Vertex;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class AMGraphTest {
    Vertex v1 = new Vertex(1, "A");
    Vertex v2 = new Vertex(2, "B");
    Vertex v3 = new Vertex(3, "C");
    Vertex v4 = new Vertex(4, "D");
    Vertex v5 = new Vertex(5, "E");

    Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
    Edge<Vertex> e2 = new Edge<>(v2, v3, 7);
    Edge<Vertex> e3 = new Edge<>(v1, v4, 9);
    Edge<Vertex> e4 = new Edge<>(v3, v4, 0);
    Edge<Vertex> e5 = new Edge<>(v2, v5, 11);
    int max = 4;
    AMGraph<Vertex, Edge<Vertex>> g = new AMGraph<>(max);

    @Test
    public void task1Test1() {
        assertTrue(g.addVertex(v1));
        assertTrue(g.addVertex(v2));
        assertTrue(g.addVertex(v3));
        assertTrue(g.addVertex(v4));
        assertFalse(g.addVertex(v5));
        assertFalse(g.addVertex(v1));

        assertTrue(g.addEdge(e1));
        assertTrue(g.addEdge(e2));
        assertTrue(g.addEdge(e3));
        assertTrue(g.addEdge(e4));
        assertFalse(g.addEdge(e5));
        assertFalse(g.addEdge(e1));

        assertTrue(g.vertex(v2));
        assertFalse(g.vertex(v5));

        assertTrue(g.edge(e4));
        assertFalse(g.edge(e5));
        assertTrue(g.edge(e2));

        assertTrue(g.edge(v1, v2));
        assertTrue(g.edge(v2, v3));
        assertTrue(g.edge(v1, v4));
        assertTrue(g.edge(v2, v1));
        assertFalse(g.edge(v1, v3));
        assertFalse(g.edge(v2, v5));
        assertFalse(g.edge(v3, v5));

        assertEquals(7, g.edgeLength(v2,v3));
        assertEquals(0, g.edgeLength(v3, v4));
        assertEquals(5, g.edgeLength(v2, v1));
        assertEquals(0, g.edgeLength(v3, v3));
        assertEquals(-1, g.edgeLength(v1, v3));
    }

    @Test
    public void task2Test1() {
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);

        assertEquals(21, g.edgeLengthSum());

        assertTrue(g.remove(v1));
        assertFalse(g.remove(v1));
        assertFalse(g.remove(e1));
        assertTrue(g.remove(e2));
        assertFalse(g.remove(e2));
        assertTrue(g.addVertex(v1));
        assertTrue(g.addEdge(e1));
        assertTrue(g.addEdge(e2));
        assertTrue(g.addEdge(e3));
        assertFalse(g.remove(e5));

        Set<Vertex> expectedVex = new HashSet<>();
        expectedVex.add(v1);
        expectedVex.add(v2);
        expectedVex.add(v3);
        expectedVex.add(v4);
        assertEquals(expectedVex, g.allVertices());

        Set<Edge<Vertex>> expectedEdge = new HashSet<>();
        expectedEdge.add(e1);
        expectedEdge.add(e2);
        expectedEdge.add(e3);
        expectedEdge.add(e4);
        assertEquals(expectedEdge, g.allEdges());

        Set<Edge<Vertex>> expectedEdge2 = new HashSet<>();
        expectedEdge2.add(e1);
        expectedEdge2.add(e3);
        assertEquals(expectedEdge2, g.allEdges(v1));

        Map<Vertex, Edge<Vertex>> expectedNeighbours = new HashMap<>();
        expectedNeighbours.put(v2, e1);
        expectedNeighbours.put(v4, e3);
        assertEquals(expectedNeighbours, g.getNeighbours(v1));
        Map<Vertex, Edge<Vertex>> expectedNeighbours1 = new HashMap<>();
        expectedNeighbours1.put(v1, e3);
        expectedNeighbours1.put(v3, e4);
        assertEquals(expectedNeighbours1, g.getNeighbours(v4));
    }
}
