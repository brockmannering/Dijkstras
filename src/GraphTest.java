// --== CS400 File Header Information ==--
// Name: Brock Mannering
// Email: bmannering@wisc.edu
// Team: FE Red
// TA: Daniel Finer
// Lecturer: Gary Dahl
// Notes to Grader:
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest {

    private CS400Graph<String> graph;
    
    /**
     * Instantiate graph from last week's shortest path activity.
     */
    @BeforeEach
    public void createGraph() {
        graph = new CS400Graph<>();
        // insert vertices A-E
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        // insert edges from Week 09. Dijkstra's Activity
        graph.insertEdge("A","B",2);
        graph.insertEdge("A","D",4);
        graph.insertEdge("A","E",1);
        graph.insertEdge("B","C",5);
        graph.insertEdge("C","A",3);
        graph.insertEdge("D","B",3);
        graph.insertEdge("D","C",7);
        graph.insertEdge("D","E",1);
        graph.insertEdge("E","C",8);
    }

    /**
     * Checks the distance/total weight cost from the vertex labelled C to E
     * (should be 4), and from the vertex labelled A to C (should be 7).
     */
    @Test
    public void providedTestToCheckPathCosts() {
        assertTrue(graph.getPathCost("C", "E") == 4);    
        assertTrue(graph.getPathCost("A", "C") == 7);
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * labelled C to E, and from the vertex labelled A to C.
     */
    @Test
    public void providedTestToCheckPathContents() {
        assertTrue(graph.shortestPath("C", "E").toString().equals(
            "[C, A, E]"
        ));
        assertTrue(graph.shortestPath("A", "C").toString().equals(
            "[A, B, C]"
        ));
    }
    /**
     * Checks the distance/total weight cost from paths from our last assignment
     */
    @Test
    public void personalTestToCheckPathCost() {
        assertTrue(graph.getPathCost("D", "E") == 1);    
        assertTrue(graph.getPathCost("D", "B") == 3);
        assertTrue(graph.getPathCost("D", "A") == 10);    
        assertTrue(graph.getPathCost("D", "C") == 7);
    }
    /**
     * Checks the ordered sequence of data within vertices from the path below
     * from our last assignment. D->E
     */
    @Test
    public void personalTestToCheckContents() {
        assertTrue(graph.shortestPath("D", "A").toString().equals(
            "[D, C, A]"
        ));
    }
    //Testing vertex count, just to make sure other methods work.
    @Test
    public void testVertexCount() {
        assertTrue(graph.getVertexCount() == 5);
    }
    //Same as above, testing edge count to make sure all methods work in the 
    //program. (not many other things to test)
    @Test
    public void testEdgeCount() {
        assertTrue(graph.getEdgeCount() == 9);
    }

}