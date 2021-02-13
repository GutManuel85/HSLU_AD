package AD.SW08.Playground.PlayThreadPool;

import AD.SW08.n21.buffer.BoundedBuffer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Executor;

public class PlayPlainWorkerPool implements Executor {

    private static final Logger LOG = LogManager.getLogger(PlayPlainWorkerPool.class);

    private final BoundedBuffer<Runnable> workQueue;
    private final int nWorkers; //Anzahl Workers

    public PlayPlainWorkerPool(final int capacityOfQueue, final int anzahlWorkersThreads) {
        this.workQueue = new BoundedBuffer<>(capacityOfQueue);
        this.nWorkers = anzahlWorkersThreads;
        for (int i = 0; i < nWorkers; i++) {
            activate();
        }
    }

    private void activate() {
        final Runnable runLoop = () -> {
            try {
                while (true) { //gewollt ein Endlosloop. Beendet kann der Loop werden, indem die Mainmehtode zum Ende kommt, da ausführender Thread ein Deamon-Thread ist. Siehe weiter unten.
                    final Runnable r = workQueue.take(); //Task aus Queue holen
                    r.run(); //Task ausführen.
                }
            } catch (InterruptedException ie) {
                LOG.warn("workerThread wurde unterbrochen");
            }
        };
        final Thread thread = new Thread(runLoop);
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public void execute(Runnable task) {
        try {
            workQueue.put(task);
        }catch(InterruptedException ie){
            LOG.warn("Task kann nicht in Queue gespeichert werden.");
            Thread.currentThread().interrupt();
        }
    }
}
