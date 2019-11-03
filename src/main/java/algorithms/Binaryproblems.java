package algorithms;

import datastructures.BinaryNode;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Praveen on 11/17/2018.
 */
public class Binaryproblems {

    public static boolean isBST(BinaryNode root) {
        return isBST(root , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }

    private static boolean isBST(BinaryNode root , int min , int max) {
        if(root ==null) return true;
        if(root.data < min || root.data >max) return false;

       // boolean isLeft = isBST(root.left , min , root.data);
       // boolean isRight = isBST(root.right, root.data , max);

        return (isBST(root.left , min , root.data) && isBST(root.right, root.data+1 , max));
    }


    public static BinaryNode lcaBST(BinaryNode root ,BinaryNode node1, BinaryNode node2) {
        if(root ==null) return root;
        if(root.data > node1.data && root.data > node2.data)
            return lcaBST(root.left, node1, node2);

        if(root.data <node1.data && root.data < node2.data)
            return lcaBST (root.right , node1 , node2);

        return root;

    }

    public static BinaryNode lca(BinaryNode root ,BinaryNode node1, BinaryNode node2) {

        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();

        if (getpath(root, node1.data , path1) && getpath(root, node2.data , path2))
        {
            int i =0;
            for(;i<path1.size() && i <path2.size();i++)
            {
                if(path1.get(i) != path2.get(i))
                {
                    break;
                }
            }

            return new BinaryNode(path1.get(i-1));

        }

        else
            return null;



    }

    private static boolean getpath(BinaryNode root, int n , List<Integer> path) {
        if(root ==null) return false;

        path.add(root.data);

        if(root.data ==n)
            return true;

        if(root.left !=null && getpath(root.left , n , path))
            return true;

        if(root.right !=null && getpath(root.right , n , path));

        return false;
    }

    public static BinaryNode lcaOpt(BinaryNode root , int n1 , int n2)
    {

        boolean v1 = false;
        boolean v2 = false;
        BinaryNode lca = lcaUtil(root, n1, n2, v1,v2);
        if(v1 && v2)
        {
            return lca;
        }

        return null;

    }

    private static BinaryNode  lcaUtil(BinaryNode root , int n1 , int n2 , boolean v1, boolean v2)
    {
        if(root ==null) return null;

        BinaryNode temp = null;

        if(root.data ==n1)
        {
            v1 = true;
            temp = root;
        }

        if(root.data == n2)
        {
            v2 = true;
            temp = root;
        }

        if(temp !=null)
        {
            return temp;

        }
        BinaryNode left_lca = lcaUtil(root.left , n1, n2 , v1, v2);
        BinaryNode righ_lca = lcaUtil(root.right , n1, n2, v1,v2);

        return left_lca !=null ?left_lca :righ_lca;
    }
}
