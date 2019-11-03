package interviewcake;

import java.util.Map;

/**
 * Created by Praveen on 5/6/2018.
 */
//Insert Temperature
    // Get Max
    // Get Min
    // Get Median
    // Get Mode
public class TemperatureTracker {
    //Get Median
    private int numOfValues;
    private long sum;
    private double median;

    //Get Min and Max
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;

    //Get Mode
    private int maxOccurence;
    private int[] modes = new int[111]; // since that is the temperature;
    private int mode;

    public void Insert(int temp)
    {
        numOfValues++;
        sum += temp;

        median = temp/numOfValues;

        min = Math.min(min,temp);
        max=  Math.max(max,temp);

        modes[temp] ++;
        if(modes[temp] > maxOccurence)
        {
            mode = temp;
            maxOccurence = modes[temp];
        }

    }

    public int getMin()
    {
        return min;
    }

    public int getMax()
    {
        return max;
    }

    public int getMode()
    {
        return mode;
    }

    public double getMedian()
    {
        return median;
    }

}
