import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by Praveen on 2/18/2018.
 */
public class HeapTest {


    public static Heap minheap;

    @Before
    public void setUp() throws Exception
    {
        minheap = new Heap(10);
        minheap.add(5);
        minheap.add(6);
        minheap.add(3);
        minheap.add(2);
        minheap.add(10);

    }


    @Test
    public void peek() throws Exception {

        int expected  = 2;
        int result  = minheap.peek();
        assertEquals(expected,result);

    }

    @Test
    public void poll() throws Exception {

         int expected  = 2;
         int result = minheap.poll();
         assertEquals(expected,result);

         expected = 3;
         result = minheap.poll();
         assertEquals(expected,result);
    }

    @Test
    public void add() throws Exception {

    }

}