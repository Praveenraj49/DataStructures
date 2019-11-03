/**
 * Created by Praveen on 2/19/2018.
 */

import java.util.*;

import interviewcake.Cake;

public class DynamicProgramming {

    public static long numOfWaysCoins(int amount , int[] coins)
    {
        long[] combinations  = new long[amount+1];
        combinations[0] = 1;
        for(int coin:coins)
        {
            for(int i=1;i<combinations.length;i++)
            {
                if(i >=coin)
                {
                    combinations[i] += combinations[i-coin];
                }
            }
        }

        return combinations[amount];
    }


    // Use a bottom up aproach
    public static long getMaximumValue(List<Cake> cakes , int weight)
    {
        long[] dp = new long[weight+1];
        dp[0]  = 0; // Zero Weight has zero value;

        for(int currentCapacity=1;currentCapacity<=weight;currentCapacity++){
            long maxValue =0L;
            for(Cake cake :cakes)
            {
                if(currentCapacity <= cake.getWeight())
                {
                    long maxValueUsingCake = cake.getValue() + dp[currentCapacity - cake.getWeight()];
                    maxValue = Math.max(maxValueUsingCake,maxValue);
                }
            }
            dp[currentCapacity] = maxValue;
            String str = "";


        }
        return dp[weight];



    }

    private static class ListComp implements Comparator<List<String>>
    {

        public int compare (List<String> t1, List<String> t2)
        {
            return 0;
        }

    }

}
