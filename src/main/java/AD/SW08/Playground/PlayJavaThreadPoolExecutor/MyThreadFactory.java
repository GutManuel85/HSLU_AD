package AD.SW08.Playground.PlayJavaThreadPoolExecutor;

import java.util.concurrent.ThreadFactory;

/* Input N22 Folie 23*/

public class MyThreadFactory implements ThreadFactory {

    int threadCounter = 0;

    @Override
    public Thread newThread(final Runnable r) { //erzeugt ein Thread mit Runnable r
        Thread thread = new Thread(r, "Thread " + threadCounter);
        threadCounter++;
        //thread.setDaemon(true);
        return thread;
    }
}
