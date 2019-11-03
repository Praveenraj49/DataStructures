import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Praveen on 2/19/2018.
 */
public class UtilitiesTest {
    @Test
    public void numberNeeded() throws Exception {

    }

    @Test
    public void isMaxContigiousSubArrayExists() throws Exception {

        int[] array = new int[] {1,3,-1,8,9,0};
        int k = 16;
        assertTrue(Utilities.isMaxContigiousSubArrayExists(array,k));

    }

    @Test
    public void getMaximumSumSubArray() throws Exception
    {
        int [] array = new int[] {100,200,300,400};
        int k =2;
        long expected = 700;
        long result  = Utilities.getMaximumSumSubArray(array,k);
        assertEquals(expected,result);

    }

    @Test
    public void getMaximumSumSubArray1() throws Exception
    {
        int [] array = new int[] {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k =6;
        long expected = 57;
        long result  = Utilities.getMaximumSumSubArray(array,k);
        System.out.println(result);
        assertEquals(expected,result);
    }

    @Test
    public void getSortedWords() throws Exception{
        String str = "bob alice 89 teddy 43 2 4 sugi";
        String result  = Utilities.getSorted(str);
        System.out.println(result);
        assertTrue(true);
    }


    @Test
    public void merge() throws Exception{
        String str = "bob alice 89 teddy 43 2 4 sugi";
        String a= "ab";
        String b = "zsd";
        String result  = Utilities.mergeStrings(a,b);
        System.out.println(result);
        assertTrue(true);
    }

    @Test
    public void testPartition() throws Exception{

        int[] array  = new int[] {1,4,0, -6, 0,0, 4,3,6};
        Utilities.partition(array);

    }




}