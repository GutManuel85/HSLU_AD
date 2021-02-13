package AD.SW07.n1.joinAndSleep;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task2 implements Runnable {


    private static final Logger LOG = LogManager.getLogger(Task2.class);

    public Task2(){
        LOG.info("Task2 erstellt");
    }

    @Override
    public void run(){
        LOG.info("Task2 gestartet");
        try {
            Thread.currentThread().join();
            Thread.currentThread().sleep(3000);
        }catch(InterruptedException ie){
            ie.getStackTrace();
        }
    }
}
