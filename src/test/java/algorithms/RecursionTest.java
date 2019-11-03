package algorithms;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Praveen on 9/25/2019.
 */
public class RecursionTest {
    @Test
    public void wordMatch() throws Exception {

    }

    @Test
    public void phoneMnemonics() throws Exception {
       String phNum = "8945672389";
       for(String str : Recursion.phoneMnemonics(phNum))
       {
           System.out.println(str);
       }


    }

}