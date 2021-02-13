package AD.SW08.Playground.PlaySemaphor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Semaphore;

public class MainPlaySemaphor {

    private static final Logger LOG = LogManager.getLogger(MainPlaySemaphor.class);

    public static volatile int counter = 0;

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2, true);

        Thread thread1 = new Thread(() -> {
            try {
                semaphore.acquire();
                counter++;
                LOG.info("Semaphor wurde passiert. Thread1 wird nun am Fabrikband " + counter + " erstellt");
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                LOG.warn("interrupted");
                return;
            }
            LOG.info("Thread 1 ist erstellt.");
            counter--;
            semaphore.release();
        });

        Thread thread2 = new Thread(() -> {
            try {
                semaphore.acquire();
                counter++;
                LOG.info("Semaphor wurde passiert. Der grosse Thread2 wird nun am Fabrikband " + counter +
                        " erstellt. Dies dauert etwas länger.");
                Thread.sleep(1500);
            } catch (InterruptedException ie) {
                LOG.warn("interrupted");
                return;
            }
            LOG.info("Thread 2 ist erstellt.");
            counter--;
            semaphore.release();
        });

        Thread thread3 = new Thread(() -> {
            try {
                semaphore.acquire();
                counter++;
                LOG.info("Semaphor wurde passiert. Thread3 wird nun am Fabrikband " + counter + " erstellt");
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                LOG.warn("interrupted");
                return;
            }
            LOG.info("Thread 3 ist erstellt.");
            counter--;
            semaphore.release();
        });

        Thread thread4 = new Thread(() -> {
            try {
                semaphore.acquire();
                counter++;
                LOG.info("Semaphor wurde passiert. Thread4 wird nun am Fabrikband " + counter + " erstellt");
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                LOG.warn("interrupted");
                return;
            }
            LOG.info("Thread 4 ist erstellt.");
            counter--;
            semaphore.release();
        });

        Thread thread5 = new Thread(() -> {
            try {
                semaphore.acquire();
                counter++;
                LOG.info("Semaphor wurde passiert. Thread5 wird nun am Fabrikband " + counter + " erstellt");
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                LOG.warn("interrupted");
                return;
            }
            LOG.info("Thread 5 ist erstellt.");
            counter--;
            semaphore.release();
        });

        thread1.start();
        thread2.start();
        thread3.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException ie) {
            LOG.info("Wartezeit zwischen thread3 und thread4 wurde unterbrochen");
        }
        thread4.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            LOG.info("Wartezeit zwischen thread4 und thread5 wurde unterbrochen");
        }
        thread5.start();
    }
}
