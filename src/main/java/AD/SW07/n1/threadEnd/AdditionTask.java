package AD.SW07.n1.threadEnd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdditionTask implements Runnable {

    private static final Logger LOG = LogManager.getLogger(AdditionTask.class);

    private Thread runThread;
    private int rangeBegin;
    private int rangeEnd;
    private boolean isStopped = false;

    public AdditionTask(int rangeBegin, int rangeEnd) {
        this.rangeBegin = rangeBegin;
        this.rangeEnd = rangeEnd;
    }

    @Override
    public void run() {

        // Initialisierungsphase
        this.runThread = Thread.currentThread();
        long sum = 0;

        //Arbeitsphase
        while (!isStopped()) {
            for (int i = this.rangeBegin; i <= this.rangeEnd; i++) {
                try {
                    Thread.sleep(15);
                } catch (InterruptedException ie) {
                    LOG.warn(runThread.getName() + " / Exception aus Runmethode während dem sleep nach " + i + ". Increment", ie.getStackTrace());
                    isStopped = true; //Wichtig: Da Interrupt-Exception das Interrupt-Flag wieder auf false setzt, muss dieses true referenziert werden.
                }
                sum += i;
            }

            //Aufräumphase
            if (!isStopped) {
                LOG.info(runThread.getName() + ": SUM ->" + sum);
            } else {
                LOG.info(runThread.getName() + ": interrupted.");
            }
            stopRequest();
        }
    }

    public void stopRequest() {
        isStopped = true;
        if (runThread != null) { //um Nullpointer zu verhindern
            runThread.interrupt();
        }
    }

    private boolean isStopped() {
        return isStopped;
    }
}
