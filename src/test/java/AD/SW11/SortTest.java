package AD.SW11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    @Test
    void testQuickSort() {

        int[] a = {4,1,9,2}; //arrange
        Sort.quickSort(a, 0, 3); //act
        assertTrue(a[0] == 1 && a[1] == 2 && a[2] == 4 && a[3] == 9); //assert = dt. behaupten
    }

    @Test
    void testGetMedianOfThree(){
        assertEquals(2, Sort.getMedianOfThree(1, 2, 3));
        assertEquals(2, Sort.getMedianOfThree(1, 3, 2));
        assertEquals(2, Sort.getMedianOfThree(2, 1, 3));
        assertEquals(2, Sort.getMedianOfThree(2, 3, 1));
        assertEquals(2, Sort.getMedianOfThree(3, 1, 2));
        assertEquals(2, Sort.getMedianOfThree(3, 2, 1));
    }
}