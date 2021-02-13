package AD.SW01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FibonacciZahlenTest {

    @Test
    public void testfiboRec1Eingabe0(){
        assertEquals(0, FibonacciZahlen.fiboRec1(0));
    }

    @Test
    public void testfiboRec1Eingabe7(){
        assertEquals(13, FibonacciZahlen.fiboRec1(7));
        assertThrows(NumberFormatException.class, () -> {
            FibonacciZahlen.fiboRec1(-1);
        });
    }

    @Test
    public void testfiboRec1EingabeNegativeZahl(){
        assertThrows(NumberFormatException.class, () -> {
            FibonacciZahlen.fiboRec1(-1);
        });
    }

    @Test
    public void testfiboIterEingabe0(){
        assertEquals(0, FibonacciZahlen.fiboIter(0));
    }

    @Test
    public void testfiboIterEingabe7(){
        assertEquals(13, FibonacciZahlen.fiboIter(7));
    }

    @Test
    public void testfiboIterEingabeNegativ(){
        assertThrows(NumberFormatException.class, ()->{
            FibonacciZahlen.fiboIter(-1);
        });
    }
}

