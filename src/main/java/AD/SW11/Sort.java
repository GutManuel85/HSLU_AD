package AD.SW11;

import java.util.Random;

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

    public static final int[] quickSort(final int[] a, final int left, final int right) { //hier mit int[] anstelle von char[] wie in Input

        if(sortMethode != 5){
            sortMethode = 4;
        };

        int up = left; // linke Grenze
        int down = right - 1; // rechte Grenze (ohne Trennelement)
        int t = a[right]; // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++; // suche grösseres (>=) Element von links an
            }
            while ((a[down] >= t) && (down > up)) {
                down--; // suche echt kleineres (<) Element von rechts an
            }
            if (down > up) { // solange keine Überschneidung
                exchange(a, up, down);
                up++;
                down--; // linke und rechte Grenze verschieben
            } else {
                allChecked = true; // Austauschen beendet
            }
        } while (!allChecked);
        exchange(a, up, right); // Trennelement an endgültige Position (a[up])
        if (left < (up - 1)) quickSort(a, left, (up - 1)); // linke Hälfte
        if ((up + 1) < right) quickSort(a, (up + 1), right); // rechte Hälfte, ohne T’Elt.

        return a;
    }

    /**
     * Vertauscht zwei bestimmte Zeichen im Array.
     *
     * @param a           Zeichen-Array
     * @param firstIndex  Index des ersten Zeichens
     * @param secondIndex Index des zweiten Zeichens
     */
    private static final void exchange(final int[] a, //hier mit int[] anstelle von char[] wie in Input
                                       final int firstIndex,
                                       final int secondIndex) {
        int tmp;
        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }


    public static final int[] quickSort(final int[] a) { //hier mit int[] anstelle von char[] wie in Input

        if(sortMethode != 5){
            sortMethode = 4;
        }

        int left = 0;
        int right = a.length - 1;
        return quickSort(a, left, right);
    }

    public static final int[] quickSortMedianOfThree(final int[] a) { //hier mit int[] anstelle von char[] wie in Input

        sortMethode = 5;

        int medianIndex = (a.length - 1) / 2;
        int beginningIndex = a[0];
        int endIndex = a[a.length - 1];

        if (beginningIndex > medianIndex && beginningIndex < endIndex || beginningIndex < medianIndex && beginningIndex > endIndex) {
            exchange(a, medianIndex, beginningIndex);
        }
        if (endIndex > medianIndex && endIndex < beginningIndex || endIndex < medianIndex && endIndex > beginningIndex) {
            exchange(a, medianIndex, endIndex);
        }

            int left = 0;
            int right = a.length - 1;
            return quickSort(a, left, right);
        }

    public static final int getMedianOfThree(int beginning, int middle, int end) {

        int median = middle;

        if (beginning > middle && beginning < end || beginning < middle && beginning > end) {
            median = beginning;
        }
        if (end > middle && end < beginning || end < middle && end > beginning) {
            median = end;
        }
        return median;
    }

    public static final int[] randomIntsQuickSort(final int length) {

        sortMethode = 4;

        int[] a = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            a[i] = random.nextInt();
        }
        return quickSort(a);
    }
}


