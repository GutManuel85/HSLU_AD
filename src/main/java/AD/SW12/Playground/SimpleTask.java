package AD.SW12.Playground;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.RecursiveAction;

public class SimpleTask extends RecursiveAction {

    public static final Object LOCK = new Object();
    private static final Logger LOGGER = LogManager.getLogger("SimpleTask");
    private static final int THRESHOLD = 100;
    private static volatile int n = 0;

    private String stringSeq = "Hello from the simple Task sequenziell";
    private String stringPara = "Hello from the simple Task parallel";

    public SimpleTask() {
    }

    @Override
    protected void compute() {
        synchronized (LOCK) {
            n++; //zählt Anzahl simpleTasks
        }
        if (n >= THRESHOLD) {
            LOGGER.info(stringSeq);
        } else {
            LOGGER.info(stringPara);//Ausführen der eigentlichen Aufgabe
            SimpleTask simpleTask1 = new SimpleTask();
            SimpleTask simpleTask2 = new SimpleTask();
            SimpleTask.invokeAll(simpleTask1, simpleTask2);
        }
    }
}
