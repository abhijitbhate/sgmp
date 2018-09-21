package can.ab.thread.examples.cb;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Stream;

public class SecondThread implements Runnable{

    private List<String> result;
    private CyclicBarrier cyclicBarrier;

    public SecondThread(List<String> result, CyclicBarrier cyclicBarrier) {
        this.result = result;
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run() {
        try (Stream<String> lines = Files.lines(Paths.get(FirstThread.class.getResource("/sample.txt").toURI()))) {
            result.add(lines.skip(2).findFirst().get());

            this.cyclicBarrier.await();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
