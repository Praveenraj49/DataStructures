package algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Praveen on 11/19/2018.
 */
public class StringProblemsTest {
    @Test
    public void findMinWindow() throws Exception {
        String str = "ABODECBDEFGBANC";
        String pattern  = "ABC";

        String result = StringProblems.findMinWindow(str,pattern);

        assertEquals(result , "BANC");

    }

    @Test
    public void longestNonRepeatingString () throws Exception {
        String str = "abcccab";
        int result  = StringProblems.lengthOfLongestSubstring(str);

        long tmp = (long)10e+9;
        tmp +=7;


        assertEquals(3,result);
    }

}