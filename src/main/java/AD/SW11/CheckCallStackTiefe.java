package AD.SW11;

public class CheckCallStackTiefe {

    private static long depth = 0L;

    public static void main(String[] args) {
        deep();
    }

    private static void deep() {
        System.err.println(++depth);
        deep();
    }

}

