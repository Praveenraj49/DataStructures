package algorithms;

import java.util.Arrays;

/**
 * Created by Praveen on 10/13/2019.
 */
public class StableMatching {

    /**
     *
     * @param preferences is a 2D Matrix of Size (2*N)*N , 0-N-1 Men preference, N - 2N-1 Women preference
     *                    N is the number of Men/Women
     * @param n N is the number of men or women
     * @return a tuple of Women matched with men
     */
    public static int [] match (int[][] preferences , int n)
    {
        //Input Validation
        if(preferences == null  || preferences.length != 2*n || preferences[0].length != n)
            return null;

        int[] wPartner = new int[n];
        boolean[] mFree = new boolean[n];

        Arrays.fill(wPartner,-1);
        int freeCount = n;

        while(freeCount >0){

            int m;
            for(m =0;m<n;m++)
            {
                if(mFree[m] == false)
                {
                    break;
                }
            }

            for(int i=0;i<n && mFree[m]==false;i++)
            {
                int w = preferences[m][i];
                if(wPartner[w-n] ==-1)
                {
                    wPartner[w-n] = m;
                    mFree[w] = true;
                    freeCount--;
                }
                else
                {
                    int m1 = wPartner[w-n];
                    if(wPrefersm1Overm(preferences, w, m , m1, n) == false)
                    {
                        wPartner[w-n] = m;
                        mFree[m] = true;
                        mFree[m1] = false;
                    }
                }
            }


        }

        return wPartner;
    }



    private  static boolean wPrefersm1Overm(int[][] prefer,int w, int m , int m1 , int n)
    {
        //if m1 comes before m then w prefers m1
        for(int i=0;i <n ;i++)
        {
            if(prefer[w][i] ==m)
                return false;

            if(prefer[w][i] == m1)
                return true;
        }

        return false;
    }



}
