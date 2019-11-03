package Concurreny;


/**
 * Created by Praveen on 10/20/2019.
 */
public class PrintOdd extends Thread {

    private int value;

    public PrintOdd(int value)
    {
        this.value = value;
    }

    public void print(int value)
    {
        this.value=value;
        run();
    }

    public void run()
    {
        System.out.println("I am in the Print odd thread");
        int index = value;
        while(index>0) {
            if (value % 2 != 0)
                System.out.println(value);
            index--;
        }
    }



}
