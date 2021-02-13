package AD.SW12.Playground;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ForkJoinPool;

public class PlaygroundApp {

    private static final Logger LOGGER = LogManager.getLogger("PlaygroundApp");


    public static void main(String[] args) {

        //Aufruf über forkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long startTime = System.currentTimeMillis();
        SimpleTask rootTask1 = new SimpleTask();
        forkJoinPool.invoke(rootTask1);
        long endTime = System.currentTimeMillis();

        LOGGER.info("Die Aufgabe dauerte insgesamt " + (endTime - startTime) + " Millisekunden");

        /*Aufruf über commonPool. Wird automatisch dann verwendet,
        wenn nicht explizit ein Pool erstellt wird*/
//        SimpleTask rootTask2 = new SimpleTask();
//        rootTask2.invoke();
    }
}
