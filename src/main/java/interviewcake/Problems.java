package interviewcake;


import java.util.*;

import datastructures.BinaryNode;

import javax.xml.soap.Node;

/**
 * Created by Praveen on 5/3/2018.
 */
public class Problems {

    public static int getMaxProfit(int[] prices){
        if(prices.length < 2) throw new IllegalArgumentException();

        int maxProfit = prices[1] - prices[0];
        int minPrice = prices[0];

        for(int i=1;i<prices.length;i++){
            int currentPrice  = prices[i];
            int potential_profit  = currentPrice - minPrice;

            maxProfit = Math.max(maxProfit, potential_profit);

            minPrice = Math.min(minPrice , currentPrice);

        }
        return maxProfit;

    }

    public static  long[] getProductExIndex(int[] array)
    {
        long[] result = new long[array.length];

        long productSoFar =1;
        for(int i=0;i<array.length;i++)
        {
            result[i] = productSoFar;
            productSoFar *= array[i];
        }

        productSoFar =1;
        for(int i = array.length-1 ; i>=0;i--){
            result[i] *= productSoFar;
            productSoFar *= array[i];
        }

        return result;
    }

    public static long getMaxProduct(int[] array)
    {
        if(array.length <3) throw new IllegalArgumentException("The array must consists of at least three elements");
        long maxProduct = array[0] * array[1] * array[2];
        long highest2   = array[0] * array[1];
        int  highest = Math.max(array[0] , array[1]);

        long lowest2 = array[0] * array[1];
        int lowest = Math.min(array[0], array[1]);

        for(int i=2 ; i < array.length;i++) {
            int current = array[1];
            maxProduct  = Math.max( maxProduct , Math.max( highest2 * current , lowest2 * current ) );

            highest2 = Math.max( highest2 , Math.max (current * highest , current * lowest));

            lowest2 = Math.min(lowest2 , Math.min (current * highest , current * lowest));

            highest  = Math.max(highest , current);

            lowest  = Math.min(lowest , current);

        }

        return maxProduct;


    }

    public static List<Meeting> mergeMeetings(List<Meeting> meetings)
    {
        // First Sort the List by startime
        Collections.sort(meetings);

        List<Meeting> merged = new ArrayList<>();
        merged.add(meetings.get(0));


        for(Meeting currentMeeting : meetings)
        {
            Meeting previousMeeting = merged.get(merged.size() - 1);

            if(previousMeeting.getEndTime() >= currentMeeting.getStartTime())
            {
                previousMeeting.setEndTime(Math.max(previousMeeting.getEndTime() , currentMeeting.getEndTime()));
            }
            else
            {
                merged.add(currentMeeting);
            }
        }

        return merged;

    }


    public static int getNumOfWaysCoins(int[] coins , int amount)
    {
        int[] ways = new int[amount+1];

        ways[0] =1;

        for(int coin : coins)
        {
            for(int higherAmount = coin ; higherAmount <= amount;higherAmount++)
            {
                int remainder = higherAmount -coin;

                ways[higherAmount] += ways[remainder];
            }
        }

        return ways[amount];

    }

    private static class RectangleOverlap
    {
        private int startPoint;
        private int length;

        public  RectangleOverlap(int startPoint , int length)
        {
            this.startPoint = startPoint;
            this.length = length;
        }

        public int getStartPoint()
        {
            return startPoint;
        }

        public int getLength()
        {
            return length;
        }

    }

    private static RectangleOverlap findRangeOverlap (int point1 , int length1 , int point2 , int length2)
    {
        int highestStartPoint = Math.max(point1, point2);
        int lowestEndPoint = Math.max(point1+length1 , point2+length2);

        if(highestStartPoint >= lowestEndPoint)
        {
            return new RectangleOverlap(0,0);
        }

        int overlap = lowestEndPoint - highestStartPoint;

        return new RectangleOverlap(highestStartPoint,overlap);
    }

    public static Rectangle findOverlap(Rectangle rect1 , Rectangle rect2)
    {
        RectangleOverlap xOverlap =  findRangeOverlap(rect1.getxLeft(), rect2.getxLeft(),
                                                        rect1.getWidth() , rect2.getWidth());
        RectangleOverlap yOverlap = findRangeOverlap(rect1.getyBottom() , rect2.getyBottom(),
                                                    rect1.getHeight(), rect2.getHeight());


        return new Rectangle(xOverlap.getStartPoint() , yOverlap.getStartPoint(),
                             xOverlap.getLength() , yOverlap.getLength());
    }


    private static class NodeDepthPair
    {
        private BinaryNode node;
        private int depth;

        public NodeDepthPair(BinaryNode node , int depth)
        {
            this.node = node;
            this.depth = depth;
        }

        public BinaryNode getNode ()
        {
            return node;
        }

        public int getDepth()
        {
            return depth;
        }
    }

    public static boolean isBTreeBalanced(BinaryNode tree)
    {
       if(tree ==null) return true;

        Deque<NodeDepthPair> stack  = new ArrayDeque<>();
        stack.push(new NodeDepthPair(tree,0));

        List<Integer> depths = new ArrayList<>(3);



        while(!stack.isEmpty())
        {

            NodeDepthPair pair = stack.pop();
            BinaryNode node = pair.getNode();
            int depth = pair.getDepth();

            if(node.left == null && node.right ==null)
            {
                if(!depths.contains(depth))
                {
                    depths.add(depth);
                }

                if(depths.size()>2 || depths.size() ==2
                        && Math.abs(depths.get(0) - depths.get(1)) >1 ) return false;

            }

            else
            {
                if(node.left !=null)
                {
                    stack.push(new NodeDepthPair(node.left , depth+1));
                }

                if(node.right !=null)
                {
                    stack.push(new NodeDepthPair(node.right , depth+1));
                }
            }


        }
        return true;

    }

    public static int findRotation(int[] numbers)
    {
        int start = 0;
        int end = numbers.length-1;

        int mid = start+(end-start)/2;

        while(start < end)
        {
            if(numbers[mid] >= numbers[start]) // Go right
            {
                start = mid;
            }
            else
            {
                end = mid;
            }
            if(start+1 == end) // converged
            {
                break;
            }
        }

        return end;

    }

    public static boolean findSum(int[] array , int sum)
    {
        Set<Integer> hash = new HashSet<>();

        for(int first : array)
        {
            int remaining = sum -first;

            if(hash.contains(remaining))
            {
                return true;
            }
            hash.add(first);
        }
        return false;
    }



}