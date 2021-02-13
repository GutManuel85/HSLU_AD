package AD.SW07.n1.joinAndSleep;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task1 implements Runnable {


    private static final Logger LOG = LogManager.getLogger(Task2.class);

    public Task1(){
        LOG.info("Task1 erstellt");
    }

    @Override
    public void run(){
        LOG.info("Task1 gestartet");
        try {
            Thread.currentThread().join();
            Thread.currentThread().sleep(2000);
        }catch(InterruptedException ie){
            ie.getStackTrace();
        }
    }
}
