package AD.SW08.Playground.PlayJavaThreadPoolExecutor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;

public class MainJavaThreadPollExecutor {

    /* Siehe Input N22 ab Folie 14*/

    ThreadFactory threadFactory;

    private static final Logger LOG = LogManager.getLogger(MainJavaThreadPollExecutor.class);

    public static void main(String[] args) {

        final ExecutorService executor = Executors.newFixedThreadPool(2); //Anzahl workers

        for (int nTask = 0; nTask < 4; nTask++) { //nTask: Anzahl Buchstaben im Alphabet
            final char ch = (char) (65 + nTask); //char 65 ist ein "A"
            executor.execute(() -> {
                LOG.info(Thread.currentThread().getName() + " starts " + ch);
                for(int i = 0; i<200; i++){ //i: wie oft ein Buchstabe gedruckt wird
                    System.out.print(ch);
                }
                LOG.info(Thread.currentThread().getName() + " finished " + ch);            });
        }
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException ie) {
            LOG.warn("sleep interrupted");
        }
        LOG.info("shutdown");
        executor.shutdown();
    }
}
