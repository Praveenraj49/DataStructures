package algorithms;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by Praveen on 12/9/2018.
 */
public class IntervalTest {

    @Test
    public void testGetMinimum() throws Exception
    {
        int[] start = new int[] {30,0,60};
        int[] end = new int[] {75, 50 , 150};

        int result = Greedy.getMinimum(start, end);

        assertEquals(2, result);
    }

}