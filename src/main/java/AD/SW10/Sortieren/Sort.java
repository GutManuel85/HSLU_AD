package AD.SW10.Sortieren;

public class Sort {

    public static int sortMethode = 0; //1=insertion / 2=selcetion / 3=bubble

    /**
     * Sortiert das int-Array aufsteigend, aber erst ab Feld a[1]!
     *
     * @param a Zu sortierendes Array.
     */
    public static void insertionSort2(final int[] a) {

        sortMethode = 1;

        int elt;
        int j;
        for (int i = 1; i < a.length; i++) {
            elt = a[i]; // next elt for insert
            a[0] = elt; // dummy-element
            j = i; // a[1]..a[j-1] already sorted
            while (a[j - 1] > elt) {
                a[j] = a[j - 1]; // shift right
                j--; // go further left
            }
            a[j] = elt; // insert elt
        } // a[1]...a[j] sorted
    }

    public static void selectionSort(final int[] a) {

        sortMethode = 2;

        for (int e = 0; e < a.length - 1; e++) { //e ist die Einfügestelle
            int f = e; //f ist die Fundstelle
            for (int i = e + 1; i < a.length; i++) { //i ist die aktuelle Stelle
                if (a[i] < a[f]) {
                    f = i; //Zuweisung des Index des kleinsten Wert zu Fundstelle
                }
            }
            int smallest = a[f]; //Zwischenspeicher für Tausch
            a[f] = a[e];
            a[e] = smallest;
        }
    }

    public static void bubbleSort(final int[] a) {

        sortMethode = 3;

        int p = 0; //pointer
        for (int i = 0; i < a.length; i++) { //i ist die Anzahl äussere Durchläufe
            p = 0;
            while (p < a.length - 1) { //p ist der aktuelle pointer
                if (a[p] > a[p + 1]) { //Vergleich der benachbarten Werte
                    int temp = a[p + 1]; //Zwischenspeicher
                    a[p + 1] = a[p]; //Tausch
                    a[p] = temp; //Tausch
                    p++; //pointer eins hoch
                } else {
                    p++;
                }
            }
        }
    }
}

/*
@startuml

interface carable{

{static} int zahl;
}

@enduml
 */

