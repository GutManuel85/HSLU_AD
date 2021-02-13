package AD.SW10.Sortieren;

import java.util.Random;

public class Main {

    private static boolean isRandom;
    private static boolean isSortiert;
    private static boolean isUmgekehrtSortiert;
    private static int anzahlElemente;

    public static void main(String[] args) {

        Random random = new Random();

        int[] ints1 = erstelleRandomArray(100_000);
        int[] ints2 = copyArray(ints1);
        int[] ints3 = copyArray(ints1);

        printSetUp();

        long sortStartTime = System.currentTimeMillis();
        Sort.selectionSort(ints1);
        long sortEndTime = System.currentTimeMillis();

        printTime(sortStartTime, sortEndTime);

        sortStartTime = System.currentTimeMillis();
        Sort.insertionSort2(ints2);
        sortEndTime = System.currentTimeMillis();
        printTime(sortStartTime, sortEndTime);

        sortStartTime = System.currentTimeMillis();
        Sort.bubbleSort(ints3);
        sortEndTime = System.currentTimeMillis();
        printTime(sortStartTime, sortEndTime);
    }

    private static int[] copyArray(int[] array){
        int[] arrayNew = new int[array.length];
        int counter = 0;
        for(int i : array){
            arrayNew[counter] = i;
            counter++;
        }
        return arrayNew;
    }

    private static int[] erstelleRandomArray(int anzahlFaecher) {
        anzahlElemente = anzahlFaecher;
        Random random = new Random();
        int[] array = new int[anzahlFaecher];
        for (int i = 0; i < anzahlFaecher; i++) {
            array[i] = random.nextInt(anzahlFaecher);
        }
        isRandom = true;
        return array;
    }

    private static int[] erstelleVorSortiertesArray(int anzahlFaecher) {
        anzahlElemente = anzahlFaecher;
        Random random = new Random();
        int[] array = new int[anzahlFaecher];
        for (int i = 0; i < anzahlFaecher; i++) {
            array[i] = i;
        }
        isSortiert = true;
        return array;
    }

    private static int[] erstelleUmgekehrtVorSortiertesArray(int anzahlFaecher) {
        anzahlElemente = anzahlFaecher;
        Random random = new Random();
        int[] array = new int[anzahlFaecher];
        for (int i = 0; i < anzahlFaecher; i++) {
            array[i] = anzahlFaecher - i;
        }
        isUmgekehrtSortiert = true;
        return array;
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }

    private static void printSetUp() {
        System.out.print("Sortierung für " + anzahlElemente + " Elemente");
        if (isRandom) {
            System.out.print(" in random Array");
        }
        if (isSortiert) {
            System.out.print(" in vorsortiertem Array");
        }
        if (isUmgekehrtSortiert) {
            System.out.print(" in umgekehrt vorsortiertem Array");
        }
    }

    private static void printTime(long startTime, long endTime) {
        System.out.println();
        if (Sort.sortMethode == 1) {
            System.out.print(" ...mit insertionSort ");
        }
        if (Sort.sortMethode == 2) {
            System.out.print(" ...mit selectionSort ");
        }
        if (Sort.sortMethode == 3) {
            System.out.print(" ...mit bubbleSort ");
        }
            System.out.println(" benötigte " + (endTime - startTime) + " Millisekunden");
        }
    }
