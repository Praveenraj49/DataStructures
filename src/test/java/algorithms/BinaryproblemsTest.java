package algorithms;

import datastructures.BinaryNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Praveen on 11/17/2018.
 */
public class BinaryproblemsTest {
    @Test
    public void isBST() throws Exception {
        BinaryNode root = new BinaryNode(10);
        BinaryNode left = new BinaryNode(9);
        BinaryNode right = new BinaryNode(15);
        root.left = left;
        root.right = right;


        left.setLeftNode(new BinaryNode(5));
        left.setRightNode(new BinaryNode(8));

        right.setLeftNode(new BinaryNode(12));
        right.setRightNode(new BinaryNode(20));

        assertTrue(Binaryproblems.isBST(root));


    }

}