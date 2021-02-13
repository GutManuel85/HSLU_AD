package AD.SW11;

public class MainHeap {
    private static FixedSizeHeap fixedSizeHeap;

    public static void main(String[] args) {
         fixedSizeHeap = new FixedSizeHeap(10_000);
        heapSort(fixedSizeHeap.getArray());
    }

    public static void heapSort(final int[] a) {
        final int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = fixedSizeHeap.getMax();
            System.out.println(b[i]);
        }
    }
}

