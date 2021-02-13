package AD.SW09.Playground;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class PlayWithFutureTask {

    private static final Logger LOG = LogManager.getLogger(PlayWithFutureTask.class);

    public static void main(String[] args) {

        final Callable<Integer> callable = () -> {
            int sum = 0;
            for(int i = 0; i < 1000; i++){
                sum +=1;
            }
            return sum;
        };

        final FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask, "FutureTaskThread").start();

        try {
            LOG.info("Summe" + futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
