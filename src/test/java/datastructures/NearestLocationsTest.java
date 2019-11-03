package datastructures;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Praveen on 11/14/2018.
 */
public class NearestLocationsTest {
    @Test
    public void getNearestLocation() throws Exception {

        NearestLocations sol = new NearestLocations();
        List<List<Integer>> locations  = new ArrayList<List<Integer>>();
        List<List<Integer>> result ;
        List<Integer> list  = new ArrayList<>();
        list.add(1);
        list.add(-1);
        locations.add(list);

        list  = new ArrayList<>();
        list.add(2);
        list.add(4);
        locations.add(list);

        list  = new ArrayList<>();
        list.add(3);
        list.add(2);
        locations.add(list);

        list  = new ArrayList<>();
        list.add(1);
        list.add(1);
        locations.add(list);



        result  = sol.getNearestLocation(locations,4,4);

        assertEquals(result.size(),4);






    }

}