package Concurreny;

/**
 * Created by Praveen on 10/20/2019.
 */
public class ThreadTest {

    public static void main (String[] args) throws Exception
    {
        Thread t1  = new PrintOdd(10);
        t1.start();
    }
}
