package AD.SW09.Playground;

/*Probleme
   - self kann Null sein => Nullpointer
   - run-Methode kann während der Ausführung keine Exception zurück geben
 */

public class PlayRunnableWithReturn<T> implements Runnable {

    private T returnValue;
    private volatile Thread self;

    @Override
    public void run() {
        self = Thread.currentThread();
        System.out.println("Hello from the " + Thread.currentThread());
        //Berechnung und Speicherung des Resultats ins Rückgabe Attribut.
    }

    public T getReturnValue() throws InterruptedException{
        self.join();
        return returnValue;
    }
}
