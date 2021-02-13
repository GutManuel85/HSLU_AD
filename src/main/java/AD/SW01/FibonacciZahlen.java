package AD.SW01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class FibonacciZahlen {

    private static final Logger LOG = LogManager.getLogger(FibonacciZahlen.class);

    public static void main(String[] args) {

        messenZeitRekursiv(40);
        fiboIter(40);

    }

    public static long fiboRec1(int number) { //number ist das n-te Glied. Also bei 0 ist es das Glied f0 und somit die erste Zahl.
        if (number < 0) {
            throw new NumberFormatException();
        }
        if (number == 0) {
            return 0; //Rekursionsbasis
        }
        if (number == 1) {
            return 1; //Rekursionsbasis
        }
        return fiboRec1(number - 1) + fiboRec1(number - 2); //Rekursionsvorschrift
    }

    public static void messenZeitRekursiv(int number){
        long timeEnd = System.currentTimeMillis();
        fiboRec1(number);
        long timeStart = System.currentTimeMillis();
        LOG.info("Die rekursive Methode benötige " + (timeEnd - timeStart) + "Millisekunden für das " + number + ". Glied");
    }

    public static long fiboIter(int number) { //number ist das n-te Glied. Also bei 0 ist es das Glied f0 und somit die erste Zahl.
        final long timeStart = System.currentTimeMillis();
        if (number < 0) {
            throw new NumberFormatException();
        } else if (number == 0) {
            return 0;
        }
        long fNMinus2 = 0;
        long fNMinus1 = 1;
        long fn = 0;
        for (int i = 1; i < number; i++) {
            /* On each iteration, we are assigning second number
             * to the first number and assigning the sum of last two
             * numbers to the second number
             */
            fn = fNMinus1 + fNMinus2;
            fNMinus2 = fNMinus1;
            fNMinus1 = fn;
        }
        final long timeEnd = System.currentTimeMillis();
        LOG.info("Die itterative Methode benötige " + (timeEnd - timeStart) + "Millisekunden für das " + number + ". Glied");
        return fn;
    }
}



