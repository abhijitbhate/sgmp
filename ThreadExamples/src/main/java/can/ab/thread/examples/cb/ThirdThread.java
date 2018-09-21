package can.ab.thread.examples.cb;

import java.util.List;

public class ThirdThread implements Runnable{

    private List<String> result;

    public ThirdThread() {
    }

    public void setResult(List<String> result) {
        this.result = result;
    }

    public void run() {
        result.forEach(System.out::println);
    }
}
