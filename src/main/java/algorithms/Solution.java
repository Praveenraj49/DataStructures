package algorithms;

import java.util.*;
import java.io.*;


/**
 * Created by Praveen on 11/21/2018.
 */
class Solution {

    private static class  Flight implements  Comparable<Flight>
    {
        int flightId;
        int startTime;
        int endTime;

        public  Flight (int fid , int sTime , int eTime) {
            flightId = fid;
            startTime = sTime;
            endTime = eTime;
        }

        @Override
        public int compareTo(Flight o) {
            Flight that  = (Flight)o;
            return (this.startTime - that.startTime);
        }

        @Override
        public String toString() {
            return "Flight ID :" + flightId + "StartTime :" + startTime + "End Time :" + endTime;
        }


    }

    public static void main(String[] args) {


        List<Flight>  flights  = new ArrayList<>();
        flights.add(new Flight(1, 10 ,20));
        flights.add(new Flight(3, 6,18));
        flights.add(new Flight(6 , 15, 20));

        Collections.sort(flights);

        for(Flight flight : flights)
        {
            System.out.println(flight.toString());
        }




    }
}

