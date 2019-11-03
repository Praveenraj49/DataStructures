package interviewcake;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Praveen on 5/3/2018.
 */
public class ProblemsTest {
    @Test
    public void getMaxProfit_positive() throws Exception {
        int prices[]  = new int[] {4, 8, 3, 9, 14,6};
        int expected = 11;
        int result = Problems.getMaxProfit(prices);

        assertEquals(expected,result);

    }

    @Test
    public void getMaxProfit_negative() throws Exception {
        int prices[]  = new int[] {10,9,8,7,5};
        int expected = -1;
        int result = Problems.getMaxProfit(prices);

        assertEquals(expected,result);

    }

    @Test
    public void getProductExceptIndex() throws Exception {
        int[] array = new int[] {1,3,5,6};
        long[] result = Problems.getProductExIndex(array);

        assertEquals(array.length , result.length);
        for(long val : result)
        {
            System.out.println(val);
        }
    }

    @Test
    public void getNumOfWaysCoins() throws Exception {
        int[] coins  = new int[] {1,3,5};
        int amount =5 ;
        int expected = 3;

        int result = Problems.getNumOfWaysCoins(coins, amount);
        assertEquals(expected,result);
    }

    @Test
    public void getNumOfWaysCoins2() throws Exception {
        int[] coins  = new int[] {1,3,5};
        int amount =6 ;
        int expected = 4;

        int result = Problems.getNumOfWaysCoins(coins, amount);
        assertEquals(expected,result);
    }



}