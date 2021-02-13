package AD.SW08.Playground.PlayJavaThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainJavaThreadPoolWithMyThreadFactory {

    public static void main(String[] args) {

        int anzahlProzessoren = Runtime.getRuntime().availableProcessors();
        System.out.println("Die Anzahl Prozessoren ist " + anzahlProzessoren);

        final ExecutorService executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors() + 1, new MyThreadFactory());
        for (int nTask = 5; nTask > 0; nTask--) {
            executorService.execute(() -> {
                for (int i = 200; i > 0; i--) {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        executorService.shutdown(); /*Nach dem shutdown werden die zugewiesenen Arbeiten noch abgearbeitet.
        Neue werden aber mit einer RejectedExcecutionException abgewiesen. shutdown ist kein blockierender Aufruf.*/
    }
}