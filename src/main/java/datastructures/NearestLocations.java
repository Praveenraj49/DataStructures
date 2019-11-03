package datastructures;

import java.util.*;

/**
 * Created by Praveen on 11/13/2018.
 */
public class NearestLocations {

    private static class Location
    {
        List<Integer> loc;
        double distance;

        public  Location(List<Integer> loc , double distanceFromOrigin)
        {
            this.loc = loc;
            distance = distanceFromOrigin;
        }

        public  List<Integer> getLocation()
        {
            return loc;
        }
    }

    private static class LocationComparator implements Comparator<Location> {

        @Override
        public int compare(Location l1 , Location l2) {
            return Double.compare(l2.distance , l1.distance);
        }


    }

    public List<List<Integer>> getNearestLocation(List<List<Integer>> locations , int numofLocations , int totalNumberofLoc)
    {

        PriorityQueue<Location> maxHeap = new PriorityQueue<Location>(numofLocations, new LocationComparator());
        List<List<Integer>> result  = new ArrayList<List<Integer>>();

        for(int i =0;i<locations.size();i++)
        {
            int  x  = locations.get(i).get(0);
            int  y = locations.get(i).get(1);
            double distance = Math.sqrt(x*x +y*y);
            maxHeap.add(new Location(locations.get(i) , distance));
            if(maxHeap.size() > numofLocations)
            {
                maxHeap.poll();
            }
        }

        while(!maxHeap.isEmpty())
        {
            result.add(maxHeap.poll().getLocation());

        }

        return result;
    }

}
