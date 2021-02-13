package AD.SW07.Playground.Sleep;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlaySleepingTask implements Runnable {

    private static final Logger LOG = LogManager.getLogger(PlaySleepingTask.class);

    @Override
    public void run() {
        LOG.info(Thread.currentThread().getName() + "geht 1x schlafen");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOG.info(Thread.currentThread().getName() + "wurde aufgeweckt");
        }
        LOG.info(Thread.currentThread().getName() + "geht 2x schlafen");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOG.info(Thread.currentThread().getName() + "wurde aufgeweckt");
            Thread.currentThread().interrupt();
        }
        LOG.info(Thread.currentThread().getName() + "geht 3x schlafen");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOG.info(Thread.currentThread().getName() + "wurde aufgeweckt");
            Thread.currentThread().interrupt();
        }
        LOG.info(Thread.currentThread().getName() + "geht 3x schlafen");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOG.info(Thread.currentThread().getName() + "wurde aufgeweckt");
            Thread.currentThread().interrupt();
        }

    }
}
