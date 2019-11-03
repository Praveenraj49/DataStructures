package algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Praveen on 11/14/2018.
 */
public class ArrayProblemsTest {
    @Test
    public void leastInterval() throws Exception {

    }

    @Test
    public void getLongestSubArray() throws  Exception {
        String str = "abccabcbb";
        int t = '4'-'0';
        int result = ArrayProblems.lengthOfLongestSubstring(str);
        assertEquals(3, result);
    }

    @Test
    public void atoi() throws  Exception {
        String str = "4193 with words";
        int t = '4'-'0';
        int result = ArrayProblems.myAtoi(str);
        assertEquals(4193, result);
    }

    @Test
    public void partitionZero() throws Exception {

        int[] array = new int[] {6,0,2,3,0,1,2,0,0,0 ,-3};
        int[] result  = ArrayProblems.partitionZero(array);

        assertEquals(array.length , result.length);

    }

    @Test
    public void findMissingNumber() throws Exception {
        int[] array = new int[] {0,1,2,4,5,6};
        int[][] bombs2 = {{0, 0}, {0, 1}, {1, 2}};
        int num  = ArrayProblems.findMissingNum(array);
        assertEquals(3,num);
    }

}