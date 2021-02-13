package AD.SW11;

/** Interface zur Implementierung eines Heaps.*/

public interface InterHeapInterface {

    /** Gibt das groesste Element des Heaps aus.
     *
     * @return int
     */
    int getMax();

    /** Fuegt eine neue Zahl in Heap ein.
     *
     */
    void insert(int newInt);

    /** Gibt den Heap als Array aus.
     *
     * @return intArray
     */
    int[] getArray();

}
