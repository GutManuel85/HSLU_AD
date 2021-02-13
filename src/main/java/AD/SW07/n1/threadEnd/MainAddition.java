package AD.SW07.n1.threadEnd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainAddition {

    private static final Logger LOG = LogManager.getLogger(MainAddition.class);

    public static void main(String args[]) {

        final Thread thread0 = new Thread(new AdditionTask(0, 10), "threadKurz");
        final Thread thread1 = new Thread(new AdditionTask(0, 20), "threadMittel");
        final Thread thread2 = new Thread(new AdditionTask(0, 30), "threadLang");
        final Thread thread3 = new Thread(new AdditionTask(0, 40), "threadSehrLang");
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            Thread.sleep(800); // wenn hier die Sleep-Time reduziert wird, werden die Threads threas0 - 4 unterbrochen.
        } catch (InterruptedException ie) {
            LOG.warn(ie.getStackTrace());
        }
        thread0.interrupt();
        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();
    }

}
