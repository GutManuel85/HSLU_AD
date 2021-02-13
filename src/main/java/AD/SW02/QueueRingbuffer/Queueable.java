package AD.SW02.QueueRingbuffer;

public interface Queueable {

    /**Methode zum Zeichen zu Queue hinzufügen*/
    boolean enqueue(char zeichen);

    /**Methode zum Zeichen aus Queue lesen*/
    char deque();
}
