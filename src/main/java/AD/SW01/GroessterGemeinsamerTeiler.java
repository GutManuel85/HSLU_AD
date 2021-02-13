package AD.SW01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GroessterGemeinsamerTeiler {

    public static final Logger LOG = LogManager.getLogger(GroessterGemeinsamerTeiler.class);

    public static void main(String[] args) {

        ggtIterativ1(28, 68); //ergibt 6 Schleifendurchgänge
        ggtIterativ2(28, 68); //ergibt 3 Schliefendurchgänge
        ggtRekursiv(28, 68); // ergibt 6 Rekursionen
    }

    public static int ggtIterativ1(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        LOG.info(a);
        return a;
    }

    public static int ggtIterativ2(int a, int b) {
        while ((a != 0) && (b != 0)) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        LOG.info(a);
        return (a + b);
    }

    public static int ggtRekursiv(int a, int b) {
        if (a > b) {
            return ggtRekursiv(a - b, b);
        } else if (a < b) {
            return ggtRekursiv(a, b - a);
        }else {
            return a;
        }
    }
}
