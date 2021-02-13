package AD.SW07.Playground;

public class SimpleThread implements Runnable {

    public static void main(String arg[]){
        Thread thread = new Thread(new SimpleThread());
        thread.start();
        try {
            thread.sleep(1000); // hier wird thread 1 sek schlafen gelegt
            Thread.sleep(1000); // hier wird mainThread 1 sek schlafen gelegt.
        }catch(InterruptedException ie){
            System.out.println(ie.getStackTrace());
        }
        System.out.println("1. Hallo von main"); //kann vor oder nach dem Hochzählen von run()-Methode abgearbeitet werden
        System.out.println("2. Hallo von main"); //kann vor oder nach dem Hochzählen von run()-Methode abgearbeitet werden

        try{
            thread.join();
        }catch(InterruptedException ie){
            System.out.println(ie.getStackTrace());
        }
        System.out.println("3. Hallo von main"); //wird aufgrund von thread.join() immer nach dem Hochzählen von run()-Methode abgearbeitet, da auf den Thread thread = new Thread(new SimpleThread()) gewartet wird.
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
