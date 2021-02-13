package AD.SW04;

/**
 * Interface mit Methoden zur Bearbeitung von Hashtabellen
 **/

public interface HashArrayInterface<T> {

    /**
     * Fuegt Elemente in HashArray ein.
     *
     * @param element
     */
    void add(T element);

    /**
     * Entfernt Elemente aus HashArray.
     *
     * @param element
     */
    void remove(T element);

    /**
     *Sucht ein Element im HashArray.
     *
     * @param element
     * @return boolean
     */
    int search(T element);


    /**
     * Gibt die Groesse des HashArrays zurueck.
     *
     * @return int
     */
    int getSize();
}
