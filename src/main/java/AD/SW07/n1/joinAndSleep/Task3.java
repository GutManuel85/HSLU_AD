package AD.SW07.n1.joinAndSleep;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task3 implements Runnable {

    private static final Logger LOG = LogManager.getLogger(Task3.class);

    public Task3(){
        LOG.info("Task3 erstellt");
    }

    @Override
    public void run(){
        LOG.info("Task3 gestartet");
        try {
            Thread.sleep(4000);
        }catch(InterruptedException ie){
            ie.getStackTrace();
        }
    }
}
