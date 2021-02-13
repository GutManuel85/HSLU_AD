/*
 * Copyright 2020 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package AD.SW12.n4.n4.quicksort;

/**
 * Codevorlage zu RecursiveAction für die Sortierung eines int-Arrays.
 */
public class QuicksortRecursive {

    /**
     * public method exposed to client, sorts given array using QuickSort
     * Algorithm in Java.
     *
     * @param array input array.
     */
    public static void quicksort(int[] array) {
        QuicksortRecursive.quicksort(array, 0, array.length - 1);
    }

    /**
     * Recursive quicksort logic.
     *
     * @param array      input array.
     * @param indexLeft  start index of the array.
     * @param indexRight end index of the array.
     */
    public static void quicksort(int[] array, int indexLeft, int indexRight) {

        int indexUp = indexLeft; //pointer aufwärts
        int indexDown = indexRight - 1; //pointer abwärts
        int trennelement = array[indexRight]; //Wert des Trennelements
        boolean allChecked = false;
        do {
            while (array[indexUp] < trennelement) { //geht aufwärts, solange Element kleiner ist
                indexUp++;
            }
            while (array[indexDown] > trennelement) { //geht abwärts, solange Elemment grösser ist. Optimierung: gleich grosse Elemente wie Trennelement werden auch getauscht.
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
        }
        if (indexUp + 1 < indexRight) {
            quicksort(array, indexUp + 1, indexRight);
        }
    }


    private static void exchange(int[] array, int indexZahl1, int indexZahl2) {
        int temp = array[indexZahl1];
        array[indexZahl1] = array[indexZahl2];
        array[indexZahl2] = temp;
    }

    /**
     * Divides array from pivot, left side contains elements less than Pivot
     * while right side contains elements greater than pivot.
     *
     * @param array array to partitioned.
     * @param indexLeft  lower bound of the array.
     * @param indexRight upper bound of the array.
     * @return the partition index.
     */
    public static int partition(int[] array, int indexLeft, int indexRight) {
        int anzahlKleinerAlsTrennelement = 0;
        for(int i = indexLeft; i < indexRight; i ++){
            if(array[i] < array[indexRight]){
                anzahlKleinerAlsTrennelement++;
            }
        }
        return anzahlKleinerAlsTrennelement;
    }
}
