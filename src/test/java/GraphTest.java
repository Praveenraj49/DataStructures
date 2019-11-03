import static org.junit.Assert.*;




/**
 * Created by Praveen on 2/18/2018.
 */
import java.util.List;
import  org.junit.Test;
import java.util.*;

public class GraphTest {

    public static Graph graph;

    @org.junit.Before
    public void setUp() throws Exception {

        graph =  new Graph(6);
        graph.addEdge(1,5);
        graph.addEdge(2,3);
        graph.addEdge(1,4);
        graph.addEdge(0,1);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(1,0);
    }

    @Test
    public void topologicalSort() throws Exception {

        List<Integer> list  = graph.topologicalSort();
        list.stream().forEach(System.out::print);
        assert(true);
    }

    @Test
    public void isCycle() throws Exception {
        //boolean expected = false;
        boolean result = graph.isCycle();
        assertFalse(!result);
    }

    @Test
    public void getMaxRegion() throws Exception {
        int expected = 5;
        graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        int result = graph.getMaxRegion();
        assertEquals(expected,result);
    }

    @Test
    public  void getAllEmployees() throws Exception{
        graph  = new Graph(11);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);

        graph.addEdge(3,5);
        graph.addEdge(3,6);
        graph.addEdge(3,7);

        graph.addEdge(5,8);
        graph.addEdge(5,9);
        graph.addEdge(5,10);

        List<Integer> employeeIds = graph.getEmployeeId(5);

        employeeIds.stream().forEach(System.out::println);


    }

    @Test
    public void getFlightPath() throws Exception
    {
        List<List<String>> boardingPass  = new ArrayList<>();
        List<String> bp1 = new ArrayList<>();
        bp1.add("LAX");
        bp1.add("SEA");

        List<String> bp2 = new ArrayList<>();
        bp2.add("SEA");
        bp2.add("PHX");

        List<String> bp3 = new ArrayList<>();
        bp3.add("PHX");
        bp3.add("NYC");

        List<String> bp4 = new ArrayList<>();
        bp4.add("NYC");
        bp4.add("DEN");

        boardingPass.add(bp1);
        boardingPass.add(bp2);
        boardingPass.add(bp3);
        boardingPass.add(bp4);

        String itinerary  = Graph.getItineary(boardingPass);

        System.out.println(itinerary);

        assertTrue(true);



    }

}