package AD.SW08.Playground.PlayThreadPool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyTaskForWorkerPool implements Runnable{

    private static final Logger LOG = LogManager.getLogger(MyTaskForWorkerPool.class);

    @Override
    public void run() {
        LOG.info("Hello from the MyTask");
    }
}
