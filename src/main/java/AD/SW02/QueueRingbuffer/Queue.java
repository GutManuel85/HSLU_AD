package AD.SW02.QueueRingbuffer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Queue implements Queueable {

    public static final Logger LOG = LogManager.getLogger(Queue.class);

    private int size;
    private int kopfPointer;
    private int endePointer;
    private int anzahlElemente;
    private char[] array;

    public Queue() {
        size = 8;
        kopfPointer = 0;
        endePointer = 0;
        array = new char[size];
        anzahlElemente = 0;
    }

    @Override
    public boolean enqueue(char zeichen) {
        if (anzahlElemente < size) {
            array[kopfPointer % size] = zeichen;
            kopfPointer++;
            anzahlElemente = kopfPointer - endePointer;
            return true;
        } else {
            LOG.warn("Queue ist voll. Das Zeichen konnte nicht aufgenommen werden.");
            return false;
        }
    }

    @Override
    public char deque() {
        if (anzahlElemente > 0) {
            char c = array[endePointer % size];
            endePointer++;
            anzahlElemente = kopfPointer - endePointer;
            return c;
        } else {
            LOG.warn("Queue ist leer");
            throw new NullPointerException("Queue ist leer");
        }
    }

    @Override
    public String toString() {
        int ausgabePointer = kopfPointer; //Lokale Variable, damit der Kopfpointer nicht verändert wird.
        StringBuilder sb = new StringBuilder();
        for (int i = anzahlElemente; i > 0; i--) {
            sb.append(array[ausgabePointer % size]); //hier könnte man auch folgendes machen: wenn if(ausgabePointer >= array.size()){kopfpointer = 0;}
            ausgabePointer++; //Hochzählen, damit man im Uhrzeigersinn (Richtung, wie Elemente eingefügt wurden), um den Ringbuffer rumgeht.
        }
        String string = sb.toString();
        return "Die Queue hat " + anzahlElemente + " Elemente. Dies sind die folgenden: " + string;
    }

    public int getSize() {
        return size;
    }

    public int getKopfPointer() {
        return kopfPointer;
    }

    public int getEndePointer() {
        return endePointer;
    }

    public int getAnzahlElemente() {
        return anzahlElemente;
    }

    public char[] getArray() {
        return array;
    }
}
