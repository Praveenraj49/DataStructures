/**
 * Created by Praveen on 2/17/2018.
 */

import java.util.*;
import java.util.stream.Collectors;

public class FindAndAddTrie
{

    public static  void main (String[] args)
    {
        Trie trie = new Trie();
        trie.Insert("hack");
        trie.Insert("hackerrank");
        trie.Insert("xyz");
        System.out.println(trie.find("hac"));
        System.out.println(trie.find("xy"));
    }


    private static class TrieNode
    {
        private char value;
        private Map<Character , TrieNode> children;
        private boolean end;
        private int size=0;

        TrieNode (char val)
        {
            value = val;
            children = new HashMap<>();
            end = false;
        }

        public char getValue()
        {
            return value;
        }

        public List<TrieNode> getChildrenAsList()
        {
            return children.values().stream().collect(Collectors.toList());
        }

        public Map<Character, TrieNode> getChildren()
        {
            return children;
        }

        public boolean isEnd()
        {
            return  end;
        }

        public void setEnd(boolean val)
        {
            end = val;
        }
    }

    private static class Trie
    {
        private TrieNode root;

        Trie ()
        {
            root  = new TrieNode((char)0);
        }

        public void Insert(String str)
        {
            TrieNode node  = root;

            for(int i=0;i<str.length();i++)
            {

                Map<Character ,TrieNode> children  = node.getChildren();
                if(children.containsKey(str.charAt(i)))
                {
                    node = children.get(str.charAt(i));
                }
                else
                {
                    TrieNode newNode  = new TrieNode(str.charAt(i));
                    children.put(str.charAt(i) , newNode);
                    node = newNode;
                }
            }
            node.setEnd(true);
        }

        public int find (String prefix)
        {
            TrieNode node = root;
            for(int i=0;i<prefix.length();i++) {
                Map<Character, TrieNode> children = node.getChildren();
                if(children.containsKey(prefix.charAt(i)))
                {
                    node =  children.get(prefix.charAt(i));
                }
                else
                {
                    return 0;
                }
            }
            int match =0;

            /*Deque<TrieNode> stack = new ArrayDeque<>();
             stack.addFirst(node);
             while(!stack.isEmpty())
             {
                 TrieNode tmp = stack.pop();
                 if(tmp.end)
                 {
                     match++;
                 }
                 Map<Character ,TrieNode> childNodes  = tmp.getChildren();
                 for(Map.Entry<Character,TrieNode> entry : childNodes.entrySet())
                 {
                     stack.push(entry.getValue());
                 }

             } */

            match = find(node , prefix);
            return match;
        }

        public int  find(TrieNode root , String prefix)
        {
            if(root.getChildren().size() ==0)
            {
                return 1;
            }
            else
            {
                int match =0;
                for(TrieNode node : root.getChildrenAsList())
                {
                    match +=find(node , prefix+node.getValue());
                }
                return match;
            }

        }

        public List<String> getAllWords(String str)
        {
            List<String> words = new ArrayList<>();
            Deque<TrieNode> stack = new ArrayDeque<>();
            stack.push(root);

            Map<Character,Integer> map = new HashMap<>();

            for(int i=0;i<str.length();i++)
            {
                int count =1;
                char ch = str.charAt(i);
                if(map.containsKey(ch))
                {
                    count += map.get(ch);

                }
                map.put(ch,count);
            }

            while(!stack.isEmpty())
            {
                TrieNode node = stack.pop();
                StringBuilder builder = new StringBuilder();
                if(node.getValue() !=(char)0) {
                    builder.append(node.getValue());
                }
                if(node.isEnd())
                {
                    words.add(builder.toString());
                    builder = new StringBuilder();
                }

                for(Map.Entry<Character,TrieNode> entry : node.getChildren().entrySet())
                {
                    stack.push(entry.getValue());
                }
            }

            return words;

        }
    }

}

/*if ((expression.length() & 1) == 1) return false;
        else {
        char[] brackets = expression.toCharArray();
        Stack<Character> s = new Stack<>();
        for (char bracket : brackets)
        switch (bracket) {
        case '{': s.push('}'); break;
        case '(': s.push(')'); break;
        case '[': s.push(']'); break;
default :
        if (s.empty() || bracket != s.peek())
        return false;
        s.pop();
        }
        return s.empty(); */
