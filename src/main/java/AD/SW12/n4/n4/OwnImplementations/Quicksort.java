package AD.SW12.n4.n4.OwnImplementations;

public class Quicksort {

    public static void quicksort(int[] array, int indexLeft, int indexRight) {

        int indexUp = indexLeft; //pointer aufwärts
        int indexDown = indexRight - 1; //pointer abwärts
        int trennelement = array[indexRight]; //Wert des Trennelements
        boolean allChecked = false;
        do {
            while (array[indexUp] < trennelement) { //geht aufwärts, solange Element kleiner ist
                indexUp++;
            }
            while (array[indexDown] > trennelement) { //geht aufwärts, solange Elemment grösser ist. Optimierung: gleich grosse Elemente wie Trennelement werden auch getauscht.
                indexDown--;
            }
            if (indexDown > indexUp) { //solange pointer nicht auf diesselbe Stelle zeigen oder indexDown um eins kleiner ist als indexUp -> tauschen
                exchange(array, indexUp, indexDown);
            } else {
                allChecked = true;
            }
        }
        while (!allChecked);
        exchange(array, indexUp, indexRight); /*Trennelement an die endgültige Stelle verschieben,
        indem die Inhalte der folgenden Fächer getauscht werden: indexUp und indexRight*/
        if (indexLeft < indexUp) {
            quicksort(array, indexLeft, indexUp - 1);
            if (indexUp + 1 < indexRight) {
                quicksort(array, indexUp + 1, indexRight);
            }
        }
    }

    private static void exchange(int[] array, int indexZahl1, int indexZahl2) {
        int temp = array[indexZahl1];
        array[indexZahl1] = array[indexZahl2];
        array[indexZahl2] = array[temp];
    }
}
