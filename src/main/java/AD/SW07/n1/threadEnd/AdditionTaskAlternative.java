package AD.SW07.n1.threadEnd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdditionTaskAlternative implements Runnable {

    private static final Logger LOG = LogManager.getLogger(AdditionTaskAlternative.class);

    private Thread runThread;
    private int rangeBegin;
    private int rangeEnd;

    public AdditionTaskAlternative(int rangeBegin, int rangeEnd) {
        this.rangeBegin = rangeBegin;
        this.rangeEnd = rangeEnd;
    }

    @Override
    public void run() {

        // Initialisierungsphase
        this.runThread = Thread.currentThread();
        long sum = 0;

        //Arbeitsphase
        while (!runThread.isInterrupted()) {
            for (int i = this.rangeBegin; i <= this.rangeEnd; i++) {
                try {
                    Thread.sleep(15);
                } catch (InterruptedException ie) {
                    LOG.warn(runThread.getName() + " / Exception aus Runmethode während dem sleep nach " + i + ". Increment");
                    runThread.interrupt();
                    break;
                }
                sum += i;
            }

            //Aufräumphase
            if (!runThread.isInterrupted()) {
                LOG.info(runThread.getName() + ": SUM ->" + sum);
            } else {
                LOG.info(runThread.getName() + ": interrupted.");
            }
        }
    }
}
