package AD.SW03;

public interface TreeInterface<Integer> {

    /**Hinzufügen von Elementen*/
    void add(int zahl);

    /**Entfernen von Elementen*/
    void remove(int zahl);

    /**Suchen von Elementen*/
    int searchInorder(int zahl);
}
