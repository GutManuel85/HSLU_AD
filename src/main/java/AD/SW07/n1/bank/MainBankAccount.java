package AD.SW07.n1.bank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class MainBankAccount {

    private static final Logger LOG = LogManager.getLogger(MainBankAccount.class);

    private synchronized static void waitForCompletion(final Thread[] threads) {
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException ie) {
                LOG.error(ie.getMessage(), ie.getCause(), ie.getStackTrace());
                System.exit(-1);
            }
        }
    }

    public static void main(String[] ars) {

        final ArrayList<BankAccount> quellKonti = new ArrayList<>();
        final ArrayList<BankAccount> zielKonti = new ArrayList<>();
        final int transferBetrag = 10000;
        final int startSaldo = 100000;
        final int anzahlKonti = 5;
        final Thread[] threads = new Thread[anzahlKonti * 2];

        for (int i = 0; i < anzahlKonti; i++) {
            quellKonti.add(new BankAccount(startSaldo));
            zielKonti.add(new BankAccount());
        }

        for (int i = 0; i < anzahlKonti; i++) {
            threads[i] = new Thread(new AccountTask(quellKonti.get(i), zielKonti.get(i), transferBetrag)); //Überweisung
            threads[i + anzahlKonti] = new Thread(new AccountTask(zielKonti.get(i), quellKonti.get(i), transferBetrag)); //Rücküberweisung
        }

        for (Thread t : threads) {
            t.start();
        }

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException ie) {
//            LOG.error(ie.getMessage(), ie.getCause(), ie.getStackTrace());
//            System.exit(-1);
//       }

        waitForCompletion(threads);
        LOG.info("Bank accounts after transfers");
        for (int i = 0; i < anzahlKonti; i++) {
            LOG.info("source({}) = {}; target({}) = {};",
                    i, quellKonti.get(i).getBalance(), i, zielKonti.get(i).getBalance());
        }
    }
}

