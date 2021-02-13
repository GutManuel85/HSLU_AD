package AD.SW01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RessourcenBedarfAhaBsp {

    public static final Logger LOG = LogManager.getLogger(RessourcenBedarfAhaBsp.class);


    public static void main(String[] args) {
        task(2);
        task(4);
        task(8);
        task(100);
        task(200);
    }

    public static void task(final int n) {
        long timeStart = System.currentTimeMillis();
        int task1counter = 0;
        int task2counter = 0;
        int task3counter = 0;
        int taskInsgesamt = 0;
        task1();
        task1();
        task1();
        task1(); // T ~ 4
        task1counter += 4;
        for (int i = 0; i < n; i++) { // äussere Schleife: n-mal
            task2();
            task2();
            task2(); // T ~ n · 3
            task2counter += 3;
            for (int j = 0; j < n; j++) { // innerer Schleife: n-mal
                task3();
                task3(); // T ~ n · n· 2
                task3counter += 2;
            }
        }
        long timeEnd = System.currentTimeMillis();
        taskInsgesamt = task1counter + task2counter + task3counter;
        LOG.info("Task 1 wurde " + task1counter + " mal ausgeführt");
        LOG.info("Task 2 wurde " + task2counter + " mal ausgeführt");
        LOG.info("Task 3 wurde " + task3counter + " mal ausgeführt");
        LOG.info("Insgesamt wurden " + taskInsgesamt + " Tasks ausgeführt");
        LOG.info("Bei n = " + n + " wurden " + (timeEnd - timeStart) + " Millisekunden benötigt");
        LOG.info("----------------------------------------------------------------");

    }

    public static void task1() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            LOG.info("Es ist ein Fehler aufgetreten.");
        }
    }


    public static void task2() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            LOG.info("Es ist ein Fehler aufgetreten.");
        }
    }


    public static void task3() {
    }
}

    
