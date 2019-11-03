package datastructures;

/**
 * Created by Praveen on 2/19/2018.
 */
public class BinaryNode {
    public int data;
    public BinaryNode left , right;

    public BinaryNode(int value)
    {
        data = value;
        left = null;
        right =null;
    }

    public void setLeftNode(BinaryNode node)
    {
        left = node;
    }

    public void setRightNode(BinaryNode node)
    {
        right = node;
    }
}
