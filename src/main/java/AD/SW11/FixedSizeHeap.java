package AD.SW11;

import java.security.SecureRandom;
import java.util.NoSuchElementException;
import java.util.Random;

public class FixedSizeHeap implements InterHeapInterface {

    private int[] array;
    private int indexNextElement = 0;

    public FixedSizeHeap(int size) {
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            Random random = new SecureRandom();
            insert(random.nextInt(100_000_000));
        }
    }

    @Override
    public int getMax() {
        if (indexNextElement > 0) { //Wenn es ein Element im Array hat
            //Höchsten Wert speichern
            int max = array[0];
            //Blatt unten rechts zur Wurzel hoch verschieben
            array[0] = array[indexNextElement - 1];
            //SyncProzess, sodass Kind immer Kleiner als Vater ist. Ausgehend von root
            reorganizeRecursivly(array, array.length, 0);
            //Index um eins runter zählen
            indexNextElement--;
            //Höchsten Wert zurückgeben
            return max;
        } else {
            throw new NoSuchElementException("Array ist leer");
        }
    }

    @Override
    public void insert(int newInt) {
        if (indexNextElement < array.length) {
            array[indexNextElement] = newInt;
            reorganizeBackwards(indexNextElement);
            indexNextElement++;
        } else {
            System.out.println("Element kann nicht eingefügt werden, da Array voll ist.");
        }
    }

    @Override
    public int[] getArray() {
        return this.array;
    }

    private void reorganizeBackwards(int indexElement) {
        //solange Element grösser als Vater ist, dann tauschen
        int indexParent = getIndexParent(indexElement);
        while (array[indexElement] > array[indexParent]) {
            //Tauschen
            int temp = array[indexParent];
            array[indexParent] = array[indexElement];
            array[indexElement] = temp;
            //Index neu setzen
            indexElement = indexParent;
            indexParent = getIndexParent(indexElement);
        }
    }

    private void reorganizeForwards() { //Todo: hier gibt es noch ein Problem
        int indexElement = 0;
        int indexBiggerChild = 0;
        try {
            indexBiggerChild = getIndexBiggerChild(indexElement);
        } catch (NoSuchElementException nsee) {
            System.out.println(nsee.getMessage());
            return;
        }
        while (array[indexElement] < array[indexBiggerChild]) {
            try {
                indexBiggerChild = getIndexBiggerChild(indexElement);
            } catch (NoSuchElementException nsee) {
                System.out.println(nsee.getMessage());
                return;
            }
            //Werte tauschen
            int temp = array[indexElement];
            array[indexElement] = array[indexBiggerChild];
            array[indexBiggerChild] = temp;
            //Index neu setzen
            indexElement = indexBiggerChild;
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void reorganizeRecursivly(int[] arr, int n, int i) //Todo: funktioniert, aber fremder Code => verstehen!
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            reorganizeRecursivly(arr, n, largest);
        }
    }

    private int getIndexBiggerChild(int indexElement) {
        int indexBiggerChild;
        int indexLeftChild = getIndexLeftChild(indexElement);
        int indexRightChild = getIndexRightChild(indexElement);
        if (array[indexLeftChild] > array[indexRightChild]) {
            indexBiggerChild = indexLeftChild;
        } else {
            indexBiggerChild = indexRightChild;
        }
        return indexBiggerChild;
    }

    private int getIndexParent(int indexChild) {
        return (indexChild - 1) / 2;
    }

    private int getIndexLeftChild(int indexParent) {
        return (2 * indexParent) + 1;
    }

    private int getIndexRightChild(int indexParent) {
        return (indexParent + 1) * 2;
    }
}
