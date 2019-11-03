package algorithms;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Praveen on 9/25/2019.
 */
public class BacktrackingTest {
    @Test
    public void permuteUnique() throws Exception {

    }

    @Test
    public void subsets() throws Exception {

        int[] num = new int[]{1,2};
        for(List<Integer> val : Backtracking.subsets(num))
        {
            StringBuilder builder = new StringBuilder();
            builder.append("(");
            for(Integer v : val)
            {
                builder.append(v+",");
            }
            //builder.setLength(builder.length()-1);
            builder.append(")");
            System.out.println(builder.toString());
        }

    }

    @Test
    public void getPermutations() throws Exception {

        int[] num = new int[]{1,2,3};
        for(List<Integer> val : Backtracking.permuteUnique(num))
        {
            StringBuilder builder = new StringBuilder();
            builder.append("(");
            for(Integer v : val)
            {
                builder.append(v+",");
            }
            //builder.setLength(builder.length()-1);
            builder.append(")");
            System.out.println(builder.toString());
        }

    }

}