package algorithms;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Praveen on 12/23/2018.
 */
public class Backtracking {

    public static  List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> permutations  = new ArrayList<>();

        permuteUnique (nums,  permutations, 0);

        return permutations;

    }


    public static  List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> subsets  = new ArrayList<>();
        List<Integer> subset  = new ArrayList<>();

        subsetsHelper(nums , subset , subsets , 0);

        return subsets;
    }

    private  static void subsetsHelper(int[] nums , List<Integer> subSet , List<List<Integer>> subsets , int start)
    {
        subsets.add(new ArrayList(subSet));


            for (int i = start; i < nums.length; i++) {
                subSet.add(nums[i]);
                subsetsHelper(nums, subSet, subsets, i + 1);
                subSet.remove(subSet.size()-1);
            }

    }

    private static void permuteUnique(int[] nums, List<List<Integer>> permutations , int start )
    {
        if(start == nums.length-1)
        {
            permutations.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }

        Set<Integer> visited  = new HashSet<>();
        for(int i = start ;i<nums.length;i++)
        {
            if(!visited.contains(nums[i])) {
                swap(nums, i, start);
                permuteUnique(nums, permutations, start+ 1);
                swap(nums, i, start);
                visited.add(nums[i]);
            }
        }
    }

    public List<Integer> getPermutations()
    {
        return null;
    }

    private static void swap(int[] nums , int i , int j)
    {
        if(i != j)
        {
            int temp  = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}

