import datastructures.BinaryNode;
import org.junit.Test;

/**
 * Created by Praveen on 2/19/2018.
 */
import java.util.List;
public class BinarySearchTreeTest {
    @Test
    public void createAllBST() throws Exception {
        BinarySearchTree tree  = new BinarySearchTree();
        int n =3;
        List<BinaryNode> result  = tree.createAllBST(n);

        for(BinaryNode node : result)
        {
            tree.printLevelOrder(node);
            System.out.println();
        }

    }

}