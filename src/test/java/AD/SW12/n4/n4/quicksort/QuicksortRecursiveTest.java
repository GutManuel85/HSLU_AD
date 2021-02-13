package AD.SW12.n4.n4.quicksort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuicksortRecursiveTest {

    @Test
    void partition() {
        int[] array = {2,1,3,5,4,8,7,6};
        assertEquals(5,QuicksortRecursive.partition(array,0,array.length - 1));
        assertEquals(5,QuicksortRecursive.partition(array,0,array.length - 2));
        assertEquals(5,QuicksortRecursive.partition(array,0,array.length - 3));
        assertEquals(3,QuicksortRecursive.partition(array,0,array.length - 4));
    }
}