/**
 * Created by Praveen on 2/17/2018.
 */
public class MainClass {

    public static void main(String[] args) {

     String[] arr  = new String[4];
     arr[0] = "1112";
     arr[1] = "1912";
     arr[2] = "1892";
     arr[3] = "1234";

     String[] result = cavityMap(arr);

     for(int i=0;i<arr.length;i++)
     {
         System.out.println(result[i]);
     }

    }

    static String[] cavityMap(String[] arr) {

        int row = arr.length;
        int col = arr[0].length();
        String[]  result = new String[row];

        for(int i=0;i<row;i++)
        {
            char[] charArray = arr[i].toCharArray();
            for(int j=0;j<col;j++)
            {
                if(isCavity(arr,row ,col, i , j))
                {
                    charArray[j] = 'X';
                }
            }
            result[i] = String.valueOf(charArray);

        }

        return result;


    }

    static boolean isCavity(String[] arr , int row , int col , int i , int j)
    {
        //Check if the cell is within boundary
        if(!(i-1>=0 && i+1<row && j-1>=0 && j+1<col))
            return false;

        int cell = Character.getNumericValue(arr[i].charAt(j));

        for(int r= i-1;r<=i+1;r++)
        {
            for(int c = j-1;c<=j+1;c++)
            {
                if(Math.abs(r-c) ==1) {
                    int temp = Character.getNumericValue(arr[r].charAt(c));
                    if (cell <= temp) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


}
