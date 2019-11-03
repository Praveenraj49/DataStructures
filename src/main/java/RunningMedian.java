import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Praveen on 2/19/2018.
 */
public class RunningMedian {

    private Queue<Integer> maxHeap = new PriorityQueue<>();
    private Queue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());


    public RunningMedian()
    {

    }

    public void  add (int a)
    {
        Queue<Integer> target = minHeap.size()<= maxHeap.size()?minHeap:maxHeap;
        target.add(a);
        balance();
    }

    private void balance()
    {
        if(!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() > maxHeap.peek())
        {
            Integer low = minHeap.poll();
            Integer high = maxHeap.poll();

            minHeap.add(high);
            maxHeap.add(low);
        }
    }

    public double getMedian() throws Exception
    {
        if(minHeap.isEmpty() && maxHeap.isEmpty()) throw new IllegalStateException("Heap is Empty");

        return (minHeap.size() == maxHeap.size() ? (minHeap.peek() + maxHeap.peek())/2.0 : minHeap.peek());
    }



}
