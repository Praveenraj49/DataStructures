package interviewcake;

import java.util.Comparator;

/**
 * Created by Praveen on 5/4/2018.
 */
public class Meeting implements Comparable<Meeting> {
    private int startTime ;
    private int endTime;

    public Meeting(int startTime , int endTime)
    {
        this.setStartTime(startTime);
        this.setEndTime(endTime);
    }


    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Meeting o) {

         return Integer.compare(this.startTime , o.startTime);

        //return (this.startTime < o.startTime) ? -1 : (this.startTime > o.startTime) ? 1 : 0;

    }
}
