package datastructures;
import java.util.*;
/**
 * Created by Praveen on 9/29/2019.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode (int x) {val =x;}


    public static class NodeValue
    {
        ListNode node;
        int index;

        NodeValue(ListNode node , int index)
        {
            this.node = node;
            this.index = index;
        }
    }

    public ListNode  mergeSorted(ListNode[] lists)
    {

        Comparator<ListNode> listNodeComparator = (ListNode l1 , ListNode l2)->l1.val - l2.val;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(listNodeComparator);

        ListNode sorted = null;
        ListNode tail = null;


        for(int i =0;i<lists.length;i++)
        {
            if(lists[i] !=null)
               minHeap.add(lists[i]);
        }

        while(!minHeap.isEmpty()){

            ListNode top = minHeap.peek();
            minHeap.remove();

            if(top.next !=null)
                minHeap.add(top.next);

            if(sorted ==null)
            {
                sorted = top;
                tail = top;
            }
            else
            {
                tail.next = top;
                tail = top;

            }

        }

        return sorted;

    }

}
