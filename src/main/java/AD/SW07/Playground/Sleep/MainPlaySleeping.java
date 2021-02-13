package AD.SW07.Playground.Sleep;

public class MainPlaySleeping {

    public static void main(String[] args) {

        Thread thread = new Thread(new PlaySleepingTask(), "sleepingTask");
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

}
