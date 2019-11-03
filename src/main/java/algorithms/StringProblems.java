package algorithms;

/**
 * Created by Praveen on 11/19/2018.
 */

import java.lang.Math;
public class StringProblems {

    public static final int CHARACTERS = 256;
    public static String findMinWindow(String str, String pattern)
    {
        int[] map = new int[CHARACTERS];
        int counter =pattern.length(), begin =0, end =0, head =0, minLen = Integer.MAX_VALUE;
        for(char c : pattern.toCharArray()) {
            map[c]++;
        }
        while(end < str.length())
        {
            if (map[str.charAt(end++)] -- >0 ) counter--;
            while(counter ==0) //valid String
            {
                if(end -begin <  minLen)
                {
                    minLen  = end -begin;
                    head = begin;
                }
                if ( map[str.charAt(begin++)]++ ==0) counter++;
            }
        }


        return  minLen == Integer.MAX_VALUE? "" : str.substring(head , minLen+head);
    }

    public  static int lengthOfLongestSubstring(String s) {


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

}
