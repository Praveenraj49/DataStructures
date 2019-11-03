package algorithms;

import java.util.Queue;
import java.util.ArrayDeque;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by Praveen on 11/14/2018.
 */
public class ArrayProblems {


    public  static int myAtoi(String str) {
        boolean isNegative = false;
        if(str ==null || str.length()==0) return 0;
        String input = str.trim();
        int index=0;
        List<Integer> result = new ArrayList<>();

        if(input.length() ==0 || (input.charAt(index)!='-' && (input.charAt(index) -'0' > 9  && input.charAt(index) -'0' < 0 ))) return 0;
        if(input.charAt(index) == '-')
        {
            isNegative = true;
            index++;
        }

        for(;index<input.length();index++)
        {

            if(input.charAt(index)- '0' > 9 || input.charAt(index) -'0' < 0) break;
            result.add(input.charAt(index) - '0');
        }

        long value =0;
        int pow = 0;
        for(int i= result.size()-1; i >=0;i--)
        {
            value += result.get(i)* Math.pow(10,pow++);
        }

        if (isNegative)
        {
            value = - value;
        }

        if(value <Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        if(value > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return (int)value;

    }

    public static  int lengthOfLongestSubstring(String s) {


        if(s ==null || s.length() ==0) return 0;

        int[] map = new int[128];
     /*   for(char c : s.toCharArray())
        {
            map[c]++;
        }
        */
        int end =0, begin =0, d = Integer.MIN_VALUE , counter =0;

        while(end < s.length())
        {
            if(map[s.charAt(end++)]++ >0) counter++;
            while(counter >0)
            {
                if (map[s.charAt(begin++)]-- >1 ) counter--;
            }

            d = Math.max(d, end-begin);
        }

        return d;

    }

    public static int findMissingNum(int[] array)
    {
        if(array ==null || array.length ==0) return -1;

        int start =0;
        int end = array.length;
        while(start <end)
        {
            int mid = start+(end-start)/2;
            if(array[mid] != mid)
            {
                if(mid ==0 || array[mid-1] == mid-1)
                    return mid;
                else
                    end = mid-1;
            }
            else {
                start = mid + 1;
            }

        }

        return -1;
    }

    public static int[] partitionZero(int[] array) {
        if(array==null ||array.length ==0) return array;
        int zIdx =0;
        for(int i=0;i<array.length;i++)
        {
            if(array[i] ==0)
            {
                int k  = getIndex(array, i+1);
                if(k==-1)
                {
                    break;
                }
                else
                {
                    swapOpt(array, i , k);
                }
            }
        }

        return array;
    }

    private static void swap(int[] array , int i , int j)
    {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

    }

    private static void swapOpt(int[] array , int i , int j)
    {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

    private static int getIndex(int[] array , int start)
    {
        int index = -1;
        while(start <array.length)
        {
            if(array[start] !=0)
            {
                return start;
            }
            else
                ++start;

        }
        return index;
    }

    public static int leastInterval(char[] tasks, int n) {

        Queue<Character> jobs  = new ArrayDeque<>();
        for(char job : tasks)
        {
            jobs.add(job);
        }

        int idle = 0;
        Character previous = Character.MIN_VALUE;
        while(!jobs.isEmpty())
        {
            Character job   = jobs.poll();
            if(job.equals(previous))
            {
                idle +=n;
            }
            previous = job;
        }


        return idle;


    }


    //Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
    //Output: [3,3,5,5,6,7]

    public int[] maxSlidingWindow(int[] nums , int k) {
        if(nums ==null || nums.length < k) return new int[0];

        int[] output  = new int[nums.length -k +1];

        Deque<Integer> queue = new ArrayDeque<>();

        for(int i=0;i<k;i++)
        {
            queue.add(nums[i]);
        }

        int index=0;

        int[] temp = new int[k];


        for(int j=k;j<nums.length;j++)
        {
            output[index++] =  queue.peek();
            queue.removeFirst();
            queue.add(nums[j]);

        }


        return output;

    }


    private int getMax(Objects[] array )
    {
      return 0;
    }

}
