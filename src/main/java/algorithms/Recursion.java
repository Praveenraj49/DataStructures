package algorithms;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Praveen on 3/9/2018.
 */
public class Recursion {

    public static boolean wordMatch(String str , Set dict)
    {
        if(str==null || str.length()==0) return false;

        for(int i=0;i<str.length();i++)
        {
            if(dict.contains(str.substring(0,i+1)))
            {
               if(!wordMatch(str.substring(i,str.length()),dict))
               {
                   return(wordMatch(str.substring(i,str.length()),dict));
               }

            }
        }
        return false;
    }

    private static String[] mapping =  new String[]{"0","1","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};

    public static List<String> phoneMnemonics(String phoneNumber)
    {
        char[] partial = new char[phoneNumber.length()];
        List<String> mnemonics = new ArrayList<>();

        phoneMnemonicsHelper(phoneNumber, partial,0, mnemonics);

        return mnemonics;

    }


    private static void  phoneMnemonicsHelper(String phoneNumber ,char[] partialMnemonics , int digit , List<String> mnemonics)
    {
        if(digit == phoneNumber.length())
        {
            mnemonics.add(new String(partialMnemonics));

        }

        else
        {
            for(int i=0;i<mapping[phoneNumber.charAt(digit) -'0'].length();i++)
            {
                char c = mapping[phoneNumber.charAt(digit)-'0'].charAt(i);
                partialMnemonics[digit] =c;
                phoneMnemonicsHelper(phoneNumber, partialMnemonics, digit+1,mnemonics);
            }
        }

    }



}
