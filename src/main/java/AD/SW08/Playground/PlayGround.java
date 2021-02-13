package AD.SW08.Playground;

public class PlayGround {

    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        System.out.println(LOCK.toString());
        PlayTask playTask = new PlayTask(LOCK);
        System.out.println(playTask.getLock().toString());
    }

}
