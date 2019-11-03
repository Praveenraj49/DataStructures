import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Praveen on 2/20/2018.
 */
public class TrieTest {
    @Test
    public void printAllWords() throws Exception {

        Trie trie = new Trie();

        // Let the given dictionary be following
        String Dict[] = {"go", "bat", "me", "eat",
                "goal", "boy", "run"} ;

        // insert all words of dictionary into trie
        int n = Dict.length;
        for (int i=0; i<n; i++)
        {
            trie.insertWord(Dict[i]);
        }

        char arr[] = {'e', 'o', 'b', 'a', 'm', 'g', 'l'} ;

        trie.printAllWords(String.valueOf(arr));


    }

}