package AD.SW01;

public class TowersOfHanoi {

    public static void main(String[] args) {
        moveDisks("A", "B", "C", 4);
    }

    public static void moveDisks(final String from, final String via,
                                 final String to, final int n) {
        if (n == 1) {
            System.out.println("move disk from " + from + " to " + to);
        } else {
            moveDisks(from, to, via, n - 1);
            System.out.println("move disk from " + from + " to " + to);
            moveDisks(via, from, to, n - 1);
        }
    }
}
