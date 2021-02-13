package AD.SW08.Playground;

import AD.SW08.exercise.n2.waitpool.MyTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PlayTask implements Runnable {

    private static final Logger LOG = LogManager.getLogger(MyTask.class);
    private final Object lock;

    public PlayTask(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        LOG.info("running");
    }

    public Object getLock() {
        return lock;
    }
}

