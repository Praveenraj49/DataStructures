package datastructures;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Praveen on 11/28/2018.
 */
public class Tree {


    public static boolean isunival(TreeNode root) {
        if (root == null) return true;
        return isunival(root, root.value);
    }

    public static boolean isunival(TreeNode root, int value) {
        if (root == null) return true;

        if (root.value!= value)
            return false;

        for (TreeNode node : root.getChildren()) {
            if (!isunival(node, value)) {
                return false;
            }
        }

        return true;

    }


    private static class Count {
        int count = 0;
    }


    public static int getUnivalSubTreeCount(TreeNode root) {
        Count count = new Count();
        univalHelper(root, count);
        return count.count;
    }


    public static boolean univalHelper(TreeNode root, Count count) {

        if (root == null) return true;


       /* boolean is_left = false;
        boolean is_right = false;

        is_left = univalHelper(root.left, count);
        is_right = univalHelper(root.right, count);

        if (is_left == false || is_right == false) {
            return false;
        }

        if (root.left != null && root.value != root.left.value) {
            return false;
        }

        if (root.right != null && root.value != root.right.value) {
            return false;
        }
       */

        List<TreeNode> children = root.getChildren();
        boolean[] uniValFlag = new boolean[children.size()];
        for (int i = 0; i < children.size(); i++) {
            //TreeNode node  = children.get(i);
            //if(node.value !=root.value){
            // uniValFlag[i]= false;
            //}
            uniValFlag[i] = univalHelper(children.get(i), count);

        }

        if (!uniValFlagCheck(uniValFlag)) {
            return false;
        }


        for (TreeNode node : root.getChildren()) {
            if (node != null && node.value != root.value) {
                return false;
            }
        }

        ++count.count;
        return true;


    }


    private static boolean uniValFlagCheck (boolean[] flags) {
        for (boolean flag: flags)
        {
            if(!flag)
                return false;
        }
        return true;
    }


}
