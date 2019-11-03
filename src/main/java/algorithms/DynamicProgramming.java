package algorithms;

import java.util.Arrays;

/**
 * Created by Praveen on 2/21/2018.
 */
public class DynamicProgramming {

    public static int lcs(String str1 , String str2)
    {
        return lcs(str1,str2,str1.length(),str2.length());
    }

    private static int lcs(String x ,String y , int m , int n)
    {
        if(m==0 || n==0)
        {
            return 0;
        }
        if(x.charAt(m-1) == y.charAt(n-1))
            return 1+lcs(x, y , m-1,n-1);
        else
        {
            return Math.max(lcs(x,y,m-1,n), lcs(x,y ,m,n-1));
        }
    }

    private static int lcsOpt(String x , String y , int m , int n)
    {
        int[][] lcs = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0|| j==0) {
                    lcs[i][j] = 0;
                }
                if(x.charAt(m-1) == y.charAt(n-1))
                {
                    lcs[i][j] = 1+lcs[i-1][j-1];
                }
                else
                {
                    lcs[i][j] = Math.max(lcs[i][j-1] , lcs[i-1][j]);
                }
            }
        }

        int index  = lcs[m][n];

        char[] lcsStr = new char[index+1];
        lcsStr[index]  = '\0';

        int i=m , j=n;
        while(i >0 && j>0)
        {
            if(x.charAt(i) == y.charAt(j))
            {
                lcsStr[index-1]  = x.charAt(i);
                i--;
                j--;
                index--;
            }
            else if( lcs[i-1][j] > lcs[i][j-1])
            {
                i--;
            }
            else
            {
                j--;
            }
        }
        System.out.println(String.valueOf(lcsStr));


        return lcs[m][n];

    }

    public static int lis(int[] array)
    {
        int len = array.length;
        if(len==0) return len;

        int dp[] = new int[len];
        Arrays.fill(dp,1);
        for(int i=0;i<len;i++)
        {
            for(int j=1;j<i;j++)
            {
                if(array[j] > array[i] && dp[i] < dp[j]+1)
                {
                    dp[i] = dp[j]+1;
                }

            }
        }

       return Arrays.stream(dp).max().getAsInt();
    }


    public static int minimumEditDistance(String str1 , String str2)
    {
        int m = str1.length();
        int n = str2.length();

        if(m==0) return n;
        if(n==0) return m;

        int dp[][] = new int[m+1][n+1];

        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0)
                {
                    dp[i][j] =j;
                }
                if(j==0)
                {
                    dp[i][j] =i;
                }
                if(str1.charAt(i-1)== str2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = 1 + min(dp[i-1][j],dp[i-1][j] , dp[i-1][j-1]);
                }
            }
        }

        return dp[m][n];

    }

    public static int minAsciiDeleteDistance(String str1 , String str2)
    {
        int m  = str1.length();
        int n = str2.length();

        int dp [][]  = new  int [m+1][n+1];

        for(int i=0;i<=m ;i++)
        {
            for(int j =0;j<=n;j++)
            {
                if(i==0 && j ==0)
                    dp[i][j] = 0;

                else if (i ==0)
                {
                    dp[i][j] = dp[i][j-1] + (int)str2.charAt(j-1);
                }

                else if(j==0)
                {
                    dp[i][j] = dp[i-1][j] + (int)str1.charAt(i-1);
                }
                else
                {
                    int last = dp[i-1][j-1];
                    if(str1.charAt(i-1) != str2.charAt(j-1))
                    {
                        last +=  (int)str1.charAt(i-1)+(int)str2.charAt(j-1);

                    }
                    dp[i][j] = min(last , dp[i-1][j]+(int)str1.charAt(i-1) ,
                            dp[i][j-1]+(int)str2.charAt(j-1));
                }
            }
        }

        return dp[m][n];

    }

    private static int min (int x, int y, int z)
    {
        return Math.min(Math.min(x,y),z);
    }

}
