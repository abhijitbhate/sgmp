package can.ab.thread.examples.cb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class MainClass {

    private List<String> result;
    private CyclicBarrier cyclicBarrier;
    private ThirdThread thirdThread;

    public MainClass() {
        this.result = Collections.synchronizedList(new ArrayList<>(0));
        this.thirdThread = new ThirdThread();
        this.cyclicBarrier = new CyclicBarrier(2, this.thirdThread);
    }

    public static void main(String args[]) throws Exception{

        MainClass instance = new MainClass();

        FirstThread firstThread = new FirstThread(instance.result, instance.cyclicBarrier);
        SecondThread secondThread = new SecondThread(instance.result, instance.cyclicBarrier);

        instance.thirdThread.setResult(instance.result);


        Thread t1 = new Thread(firstThread);
        Thread t2 = new Thread(secondThread);

        t1.start();

        t2.start();

        System.out.println("Main is Done");
    }
}
