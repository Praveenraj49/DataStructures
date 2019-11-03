/**
 * Created by Praveen on 2/20/2018.
 */
public class Trie {

    int SIZE =26;

    private static class TrieNode {
        char data;
        TrieNode[] children;
        boolean isEnd;

        TrieNode (char val)
        {
            data = val;
            children = new TrieNode[26];
            isEnd = false;
        }

        public void setEnd(boolean val)
        {
            isEnd= val;
        }
    }

    TrieNode root;

    public Trie()
    {
        root = new TrieNode((char)0);
    }

    public void insertWord(String str)
    {
        TrieNode node = root;

        for(int i=0;i<str.length();i++)
        {
            char ch  =  str.charAt(i);
            int index = ch-'a';
            if (node.children[index] ==null)
            {
                node.children[index] = new TrieNode(ch);
            }
            node = node.children[index];
        }

        node.setEnd(true);
    }

    public void search(TrieNode node , boolean[] hash , String word)
    {
        if(node.isEnd)
        {
            System.out.println(word);
        }

        for(int i=0;i<SIZE;i++)
        {
            if(hash[i] && node.children[i]!=null)
            {
                char ch  = (char)(i+'a');
                search(node.children[i] , hash, word+ch);
            }
        }


    }

    public  void  printAllWords(String str)
    {

        boolean[]  hash = new boolean[26];
        for(int i=0;i<str.length();i++)
        {
            hash[str.charAt(i)-'a'] = true;
        }

        String word="";
        TrieNode node = root;

        for(int i=0;i<SIZE;i++)
        {
            if(hash[i] && node.children[i] !=null)
            {
                word = word+ (char)(i+'a');
                search(node.children[i] , hash, word);
                word ="";

            }
        }

    }
}
