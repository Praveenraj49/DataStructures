package datastructures;

/**
 * Created by Praveen on 2/19/2018.
 */
public class DoublyLinkedList {
    LinkedNode head;
    LinkedNode tail;

    public DoublyLinkedList()
    {
        head = null;
        tail = null;
    }


    public void insertAtTail(int data)
    {
        LinkedNode node  = new LinkedNode(data);
        if(head==null && tail ==null)
        {
            head.next = node;
            node.prev= head;
            node.next = tail;
            tail.prev= node;
        }

        if(tail.prev !=null)
        {
            LinkedNode prev = tail.prev;
            prev.next = node;
            node.prev = prev;
            node.next = tail;
            tail.prev = node;
        }
    }

    public void InsertAt (int k , int data)
    {

    }
}
