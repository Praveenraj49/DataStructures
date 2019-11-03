/**
 * Created by Praveen on 2/17/2018.
 */

import java.io.CharArrayReader;
import  java.util.*;
public class Utilities {

    public double getRunningMedian(int a)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap  = new PriorityQueue<>(Comparator.reverseOrder());

        return 0;


    }

    public static int numberNeeded(String first, String second) {
        Map<Character,Integer> map  =  new HashMap<>(26);
        char[]  charArray  = first.toCharArray();
        int len  = charArray.length;
        int minDeletions =0;
        for(int  i=0;i<len;i++)
        {
            char ch = charArray[i];
            int count =1;
            if(map.containsKey(ch))
            {
                count += map.get(ch);
            }
            else
                map.put(ch,count);
        }
        char[] charArraySec  = second.toCharArray();
        int lenSec  =  charArraySec.length;
        for(int j=0;j<lenSec;j++)
        {
            char ch = charArraySec[j];
            int count =1;
            if(map.containsKey(ch))
            {
                count -= map.get(ch);
            }
                map.put(ch,count);
        }

        for(Map.Entry<Character,Integer> entry : map.entrySet())
        {
            minDeletions += entry.getValue();
        }

        return minDeletions;


    }

    public static  boolean isExists (String[] words , String[] find)
    {
        HashMap<String , Integer> dict  = new HashMap<>();
        for(String word : words)
        {
            int count =1;
            if(dict.containsKey(word))
            {
                count  += dict.get(word);
            }
            dict.put(word,count);
        }

        for (String str : find)
        {
            if(dict.containsKey(str))
            {

            }

        }

        return true;
    }

    /**
     * Input array will contain duplicates , negative and zero value
     * int = [1,3,-,1,8,9] Sum = 16
     * @param sum
     * @return
     */
    public static boolean isMaxContigiousSubArrayExists(int[] array , int k)
    {
        int i =0,j =0;
        int sum =0;
        while(i<array.length)
        {
            if(sum ==k)
            {
                return true;
            }
            if(sum < k)
            {
                sum += array[i];
                i++;
            }
            else if(sum >k)
            {
                sum -= array[j];
                j++;
            }
        }

        while(j<i && sum >=k)
        {
            if(sum ==k)
                return true;
            else
            {
                sum -=array[j];
                j++;
            }
        }
        return false;

    }

    public  static long getMaximumSumSubArray(int[] array , int k)
    {
        if(k > array.length) return 0;
        long maxSum =0;
        long sumSofar=0;

        List<Integer> subArray  = new ArrayList<>(k);


        int i=0;
        while(i<k)
        {
            maxSum +=array[i];
            subArray.add(array[i]);
            i++;
        }
        sumSofar = maxSum;

        for(;i<array.length;i++)
        {

            sumSofar -= array[i-k]; // Remove the first element
            sumSofar += array[i]; // Add next element
            if(sumSofar > maxSum)
            {
                subArray.remove(0);
                subArray.add(array[i]);
            }
            maxSum = Math.max(maxSum, sumSofar);

        }

        //subArray.stream().forEach(System.out::println);

        return maxSum;

    }

    private static boolean isNumeric(String str)
    {
        for(int i=0;i<str.length();i++)
        {
            if(!Character.isDigit(str.charAt(i)))
                return false;

        }
        return true;
    }

    public static String getSorted(String str)
    {
         if(str ==null || str.length() ==0) return str;

         String[] strArray  = str.split(" ");
         List<Integer> numbers  = new ArrayList<>();
         List<String> words = new ArrayList<>();

         boolean[] wordsMap = new boolean[strArray.length];


         for(int i=0;i<strArray.length;i++)
         {
             String tmp = strArray[i];
             if(isNumeric(tmp))
             {
                 wordsMap[i] = true;
                 numbers.add(Integer.valueOf(tmp));
             }
             else
             {
                 words.add(tmp);
             }

         }
         Collections.sort(numbers);
         Collections.sort(words);

         StringBuilder builder = new StringBuilder();

         int k=0;
         int j =0;

         for(int i=0;i<wordsMap.length;i++)
         {
             if(wordsMap[i])
             {
                 builder.append(numbers.get(k));
                 k++;
             }
             else
             {
                 builder.append(words.get(j));
                 j++;
             }
             builder.append(" ");
         }

         return builder.toString().trim();


    }

    static String mergeStrings(String a, String b) {

        if(a==null || a.length() ==0) return b;
        if(b==null || b.length()==0) return a;

        int strlen1 = a.length();
        int strlen2 = b.length();
        char[] merged = new char[strlen1+strlen2];

        int i=0;
        int j=0;
        int k =0;
        while(i<strlen1 && j<strlen2)
        {
            merged[k++] = a.charAt(i);
            merged[k++] = b.charAt(j);
            i++;
            j++;
        }


        // Copy the remaining elements
        if(i<strlen1)
        {
            while(i<strlen1)
            {
                merged[k] = a.charAt(i);
                k++;
                i++;
            }
        }
        if(j<strlen2)
        {
            while(j<strlen2)
            {
                merged[k] = b.charAt(j);
                k++;
                i++;
            }
        }

        return String.valueOf(merged);


    }


    public static void partition(int[] array)
    {
        int count = 0;


        for(int i=0;i<array.length;i++)
        {
            if(array[i]!=0 )
            {
                array[count] = array[i];
                count++;
            }
        }

        System.out.println(count);

        while(count <array.length)
        {
            array[count++] =0;
        }

        Arrays.stream(array).forEach(System.out::print);
    }




}
