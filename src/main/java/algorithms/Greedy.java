package algorithms;

import java.util.Comparator;
import java.util.Iterator;
import java.util.*;

/**
 * Created by Praveen on 12/9/2018.
 */
public class Greedy {

    private static class Interval
    {
        int start;
        int end;

        public Interval(int s , int e)
        {
            start = s;
            end = e;
        }

    }

    private static  class IntervalComparator implements Comparator<Interval>
    {
        @Override
        public int compare(Interval i1 , Interval i2)
        {
            return Integer.compare(i1.start , i2.start);
        }
    }

    public static int getMinimum(int[] start , int[] end) {
        if(start.length != end.length)  return -1;
        /* List<Interval> intervalList = new ArrayList<>();
        for(int i=0;i<start.length;i++){
            intervalList.add(new Interval(start[i] , end[i]));
        }
        Collections.sort(intervalList , new IntervalComparator());

        int  count =0;

        for(Interval interval : intervalList)
        {

        } */
        int result =1 , rooms =0;
        Arrays.sort(start);
        Arrays.sort(end);

        int n = start.length;
        int i =0 , j =0;

        while(i< n && j < n)
        {
            if(start[i] <= end[j])
            {
                rooms++;
                i++;
                //result = Math.min(result , rooms);
            }

            else
            {
                rooms--;
                j++;
            }


        }
        return rooms;
    }

}
