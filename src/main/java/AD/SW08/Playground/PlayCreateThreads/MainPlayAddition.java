package AD.SW08.Playground.PlayCreateThreads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainPlayAddition {

    private static final Logger LOG = LogManager.getLogger(PlayAdditionTask.class);

    public static void main(String[] args) {

        LOG.info(Thread.currentThread().getName());

        Thread thread0 = new Thread(new PlayAdditionTask(10_000)); //Underline in Integer gibt hat keinen Effekt und dient der verbesserten Visualisierung (entspricht 1000er-Trennzeichen)
        thread0.setName("thread0");

        Thread thread1 = new Thread(new PlayAdditionTask(10_000), "thread1");

        Thread thread2 = new Thread(new PlayAdditionTask(10_000), "thread2");

        thread0.start();
        thread1.start();
        thread2.start();

        try {
            //Thread.sleep(5000);
            thread0.join();
            thread1.join();
            thread2.join();
            LOG.info(thread0.getState());
            LOG.info(thread1.getState());
            LOG.info(thread2.getState());

        } catch (InterruptedException ie) {
            LOG.warn("Main wurde unterbrochen.");
        }

        LOG.info("Meldung von " + Thread.currentThread().getName() + " Einzelne Resultate sind alle berechnet." +
                "\n Die Gesamtsumme ist " + PlayAdditionTask.gesamtSumme);
    }
}
