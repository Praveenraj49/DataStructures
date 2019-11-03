/**
 * Created by Praveen on 2/18/2018.
 */
import java.util.Arrays;

public class Heap {
    private int capacity =10;
    private int[] items = new int[capacity];
    int size = 0;

    public Heap()
    {

    }

    public Heap(int capacity)
    {
        this.capacity = capacity;
        items  = new int[capacity];
    }


    private int getParentIndex(int index)
    {
      return (index-1)/2;
    }

    private int getLeftChildIndex(int parentIndex)
    {
        return (parentIndex*2+1);
    }

    private int getRightChildIndex(int parentIndex)
    {
        return (2*(parentIndex+1));
    }

    private boolean hasLeftChild(int parentIndex)
    {
        return (getLeftChildIndex(parentIndex)<size);
    }

    private boolean hasRightChild(int parentIndex)
    {
        return (getRightChildIndex(parentIndex) <size);
    }

    private boolean hasParent(int index)
    {
        return (getParentIndex(index) >=0);
    }

    private int letfChild(int index)
    {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index)
    {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index)
    {
        return items[getParentIndex(index)];
    }

    private void ensureCapacity()
    {
     if(size == capacity)
     {
         items = Arrays.copyOf(items , capacity*2);
         capacity = capacity*2;
     }
    }

    private void swap(int i , int j)
    {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    private void heapifyDown()
    {
        int index =0;
        while(hasLeftChild(index))
        {
            int smallestChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) < letfChild(index))
            {
                smallestChildIndex = getRightChildIndex(index);
            }
            if(items[index] < items[smallestChildIndex])
            {
                break;
            }
            else {
                swap(index, smallestChildIndex);

            }
            index = smallestChildIndex;

        }

    }

    private void heapifyUp()
    {
        int index = size-1;
        while(hasParent(index) && parent(index) > items[index])
        {
            swap(getParentIndex(index) , index);
            index = getParentIndex(index);
        }

    }

    public int peek() throws Exception
    {
        if(size ==0) throw new IllegalStateException();
        return items[0];
    }

    public int poll() throws Exception
    {
        if(size ==0) throw new IllegalStateException();
        int item = items[0];
        size = size-1;
        items[0]  = items[size];
        heapifyDown();
        return item;
    }

    public void add(int item)
    {
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

}
