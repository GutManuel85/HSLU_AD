package AD.SW08.Playground.PlayCreateThreads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlayAdditionTask implements Runnable {

    private static final Logger LOG = LogManager.getLogger(PlayAdditionTask.class);
    private static final Object LOCK = new Object();

    public static long gesamtSumme = 0;

    private long summe;
    private int zahl;

    public PlayAdditionTask(int zahl) {
        this.summe = 0;
        this.zahl = zahl;
    }

    @Override
    public void run() {
        for (int i = 0; i <= zahl; i++) {
            summe += i;
            synchronized (LOCK) {
                gesamtSumme += i;
            }
        }
    }
}
