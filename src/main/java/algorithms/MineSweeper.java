package algorithms;

/**
 * Created by Praveen on 11/15/2018.
 */
public class MineSweeper {

        public static void main(String[] args) {
            // NOTE: The following input values will be used for testing your solution.
            int[][] bombs1 = {{0, 2}, {2, 0}};
            int[][] result1 =  mineSweeper(bombs1, 3, 3);// should return:
            // [[0, 1, -1],
            //  [1, 2, 1],
            //  [-1, 1, 0]]

            int[][] bombs2 = {{0, 0}, {0, 1}, {1, 2}};
            int[][] result2 =   mineSweeper(bombs2, 3, 4);// should return:
            // [[-1, -1, 2, 1],
            //  [2, 3, -1, 1],
            //  [0, 1, 1, 1]]

            int[][] bombs3 = {{1, 1}, {1, 2}, {2, 2}, {4, 3}};
            int[][] result3 =   mineSweeper(bombs3, 5, 5);// should return:
            // [[1, 2, 2, 1, 0],
            //  [1, -1, -1, 2, 0],
            //  [1, 3, -1, 2, 0],
            //  [0, 1, 2, 2, 1],
            //  [0, 0, 1, -1, 1]]

            System.out.println("Done");
        }


        public static int[] dx = new int [] {-1,-1,-1,0,0,1,1,1};
        public static int[] dy = new int [] {-1,0,1,-1,1,-1,0,1};

        // Implement your solution below.
        public static int[][] mineSweeper(int[][] bombs, int numRows, int numCols) {
            int[][] field = new int[numRows][numCols];

            for(int[] bomb : bombs)
            {
                int row = bomb[0];
                int col = bomb[1];
                field[row][col] = -1;

                for(int i = row-1;i<=row+1;i++)
                {
                    for(int j = col-1;j<=col+1;j++)
                    {
                        if(0<=i && i <numRows && 0<=j && j < numCols && field[i][j] !=-1)
                        {
                            field[i][j] += 1;
                        }
                    }
                }
            }

          /*  for(int row =0;row<bombs.length;row++)
            {
                for(int col =0;col<bombs[0].length;col++)
                {
                    if(row <field.length && col <field[0].length)
                        field[row][col] = -1;
                }
            }

            for(int row=0;row<numRows;row++)
            {
                for(int col=0;col<numCols;col++)
                {
                    if(field[row][col] ==0)
                    {
                        field[row][col] = getValue(field , numRows, numCols , row, col);
                    }

                }
            }
            */

            return field;
        }

        private static int getValue(int[][] field , int numRows , int numCols, int row , int col)
        {
            int count =0;
            for(int i=0;i<dx.length;i++)
            {

                if(isValid(dx[i]+row , dy[i]+col , numRows , numCols))
                {
                    if(field[dx[i]+row][dy[i]+col ] ==-1)
                        ++count;
                }
            }

            return count;
        }

        private static boolean isValid(int row , int col , int numRows , int numCols)
        {
            return !(row <0 || row >= numRows || col <0 || col>= numCols);
        }


}
