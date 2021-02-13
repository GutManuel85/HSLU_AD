package AD.SW11;

import java.util.Random;

public class Main {

    private static boolean isRandom;
    private static boolean isSortiert;
    private static boolean isUmgekehrtSortiert;
    private static int anzahlElemente;

    public static void main(String[] args) {

        Random random = new Random();
        int anzahlFaecher = 500_000;

        int[] ints1 = erstelleRandomArray(anzahlFaecher);
        int[] ints2 = copyArray(ints1);
        int[] ints3 = copyArray(ints1);
        int[] ints4 = copyArray(ints1);

        printSetUp();

        long sortStartTime;
        long sortEndTime;

//        sortStartTime = System.currentTimeMillis();
//        Sort.(ints1);
//        sortEndTime = System.currentTimeMillis();
//
//        printTime(sortStartTime, sortEndTime);
//
//        sortStartTime = System.currentTimeMillis();
//        Sort.(ints2);
//        sortEndTime = System.currentTimeMillis();
//        printTime(sortStartTime, sortEndTime);

        sortStartTime = System.currentTimeMillis();
        Sort.quickSort(ints3);
        sortEndTime = System.currentTimeMillis();
        printTime(sortStartTime, sortEndTime);

        sortStartTime = System.currentTimeMillis();
        Sort.quickSortMedianOfThree(ints4);
        sortEndTime = System.currentTimeMillis();
        printTime(sortStartTime, sortEndTime);

//        printArray(ints3);
//        System.out.println("__________________");
//        printArray(ints4);

    }

    private static int[] copyArray(int[] array) {
        int[] arrayNew = new int[array.length];
        int counter = 0;
        for (int i : array) {
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
        if (Sort.sortMethode == 4) {
            System.out.print(" ...mit quickSort ");
        }
        if (Sort.sortMethode == 5) {
            System.out.print(" ...mit quickSortMedianOfThree ");
        }
        System.out.println("benötigte " + (endTime - startTime) + " Millisekunden");
    }
}

