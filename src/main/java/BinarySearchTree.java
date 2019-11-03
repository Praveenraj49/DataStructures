/**
 * Created by Praveen on 2/19/2018.
 */

import datastructures.BinaryNode;

import java.util.List;
import java.util.ArrayList;
public class BinarySearchTree {
    BinaryNode root;

    public BinarySearchTree(BinaryNode node)
    {
        root = node;
    }

    public BinarySearchTree()
    {

    }

    public void printLevelOrder(BinaryNode root)
    {

        if(root!=null)
        {
           System.out.print(root.data+" ");
           printLevelOrder(root.left);
           printLevelOrder(root.right);
        }
    }

    public List<BinaryNode> createAllBST(int n)
    {
        return createAllBST(1 ,n);

    }

    private List<BinaryNode>  createAllBST(int start , int end)
    {
        List<BinaryNode> bstLists  = new ArrayList<>();
        if(start > end)
        {
           bstLists.add(null);
            return  bstLists;
        }

        for (int i = start ;i<=end;i++)
        {
            List<BinaryNode> leftBSTLists  = createAllBST(start,i-1);
            List<BinaryNode> rightBSTLists  = createAllBST(i+1 , end);

            for(int j =0;i<leftBSTLists.size();j++)
            {
                BinaryNode left  = leftBSTLists.get(j);
                for(int k=0;k<rightBSTLists.size();k++)
                {
                    BinaryNode right = rightBSTLists.get(k);
                    BinaryNode root  = new BinaryNode(i);
                    root.left = left;
                    root.right = right;
                }
                bstLists.add(root);
            }
        }
        return  bstLists;
    }

    public  static boolean isBST(BinaryNode tree)
    {
        return isBST(tree, Integer.MAX_VALUE,Integer.MIN_VALUE);
    }

    private static boolean isBST(BinaryNode tree , int max , int min)
    {
        if(tree == null) return true;

        if (tree.data >= max || tree.data <= min) return false;
        return ( isBST(tree.left , tree.data , min) && isBST(tree.right , max , tree.data));
    }

    public static int findSecondLargest(BinaryNode tree) throws Exception
    {
        if(tree == null || (tree.left ==null && tree.right == null))
            throw new IllegalArgumentException("Tree must at least contain two nodes");

        BinaryNode current = tree;

        while(true)
        {
            if(current.left !=null && current.right == null)
            {
                return getLargest(current.left);
            }


            if(current.right !=null && current.right.left == null
                    && current.right.right ==null)
            {
                return current.data;
            }
            current = current.right;
        }




    }

    public static int getLargest(BinaryNode tree) throws Exception
    {
        if(tree ==null) throw new IllegalArgumentException("Tree Must contains at least one Node ");
        BinaryNode current = tree;
        while(current.right!=null)
        {
            current = current.right;
        }

        return current.data;
    }

    public static boolean isBalanced(BinaryNode tree)
    {
        if(tree == null) return true;

        int lh = getHeight(tree.left);
        int rh = getHeight(tree.right);

         if(Math.abs(lh- rh ) <=1
                && isBalanced(tree.left)
                && isBalanced(tree.right))
             return true;

         return false;
    }

    private static class Height
    {
        int height=0;
    }

    public static boolean isBalancedOpt(BinaryNode node)
    {
        return isBalancedOpt(node , new Height());
    }

    private static boolean isBalancedOpt(BinaryNode node , Height height)
    {
     if(node ==null)
     {
         height.height =0;
         return true;
     }

     Height lHeight = new Height();
     Height rHeight = new Height();
     boolean left = isBalancedOpt(node.left , lHeight);
     boolean right = isBalancedOpt(node.right , rHeight);

     int lh = lHeight.height;
     int rh = rHeight.height;

     height.height = 1+Math.max(lh,rh);

     if(Math.abs(lh-rh)  >1) return false;

     return left && right;
    }
    private static int getHeight(BinaryNode tree)
    {
        if(tree == null) return 0;

        return 1+Math.max(getHeight(tree.left) , getHeight(tree.right));
    }

}
