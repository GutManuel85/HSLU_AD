package AD.SW01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AckermannFunktion {

    private static final Logger LOG = LogManager.getLogger(AckermannFunktion.class);
    private static long methodenaufrufCounter = 0;

    public static void main(String[] args){
        printAckermannFunktion(2,2);
    }

    public static long ackermann(long n, long m) {
        methodenaufrufCounter++;
        LOG.info("die Methode wurde " + methodenaufrufCounter + " mal aufgerufen");
        if(n<0 || m<0){
            throw new NumberFormatException();
        }
        if (n == 0) {
            return m+1;
        }
        if (n > 0 && m == 0) {
            return ackermann(n-1, 1);
        }
        if (n > 0 && m > 0) {
            return ackermann(n-1, ackermann(n, m-1));
        }
        // Something went wrong
        LOG.error("Invalid inputs");
        return -1;
    }

    public static void printAckermannFunktion(long n, long m){
        LOG.info(ackermann(n,m));
    }
}
