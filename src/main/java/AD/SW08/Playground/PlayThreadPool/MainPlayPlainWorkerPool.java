package AD.SW08.Playground.PlayThreadPool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainPlayPlainWorkerPool {

    private static final Logger LOG = LogManager.getLogger(MainPlayPlainWorkerPool.class);

    public static void main(String[] args) {

        PlayPlainWorkerPool workerPool = new PlayPlainWorkerPool(100, 4);

        workerPool.execute(new MyTaskForWorkerPool());
        workerPool.execute(new MyTaskForWorkerPool());
        workerPool.execute(new MyTaskForWorkerPool());
        workerPool.execute(new MyTaskForWorkerPool());
        workerPool.execute(new MyTaskForWorkerPool());
        workerPool.execute(new MyTaskForWorkerPool());
        workerPool.execute(new MyTaskForWorkerPool());
        workerPool.execute(new MyTaskForWorkerPool());
        workerPool.execute(new MyTaskForWorkerPool());
        workerPool.execute(new MyTaskForWorkerPool());
        workerPool.execute(new MyTaskForWorkerPool());
        workerPool.execute(new MyTaskForWorkerPool());
        workerPool.execute(new MyTaskForWorkerPool());
        workerPool.execute(new MyTaskForWorkerPool());
        workerPool.execute(new MyTaskForWorkerPool());
        workerPool.execute(new MyTaskForWorkerPool());

        LOG.info("Main am Ende angelangt");

    }
}
