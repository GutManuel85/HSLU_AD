package AD.SW14;

public class OptimierterSuchautomat {

    public static void main(String[] args) {

        System.out.println(stateSearch("RDGDADGGGGGGGGGGGGGGGGGANANASFDDDDGGGGGGGGGGGGGGGDDD"));

    }

    public static int stateSearch(final String a) {
        int index = 0; // index von String a
        String state = "-1"; // "-1" ist ein spezieller status und bedeutet, dass String nicht gefunden wurde
        final int notFound = -1; // Rückgabewert, wenn String nicht gefunden wurde
        do {
            switch (state) {

                case "-1": //entspricht Zustand Z0
                    if (a.charAt(index) == 'A') {
                        state = "A";
                    }
                    break;

                case "A": //entspricht Zustand Z1
                    if (a.charAt(index) == 'N') {
                        state = "AN";
                    } else if (a.charAt(index) == 'A') {
                        state = "A"; //entspricht Zustand 1
                    } else {
                        state = "-1"; //entspricht Zustand 0
                    }
                    break;

                case "AN": //entspricht Zustand Z2
                    if (a.charAt(index) == 'A') {
                        state = "ANA";
                    } else {
                        state = "-1";
                    }
                    break;

                case "ANA": //entspricht Zustand Z3
                    if (a.charAt(index) == 'N') {
                        state = "ANAN";
                    } else if (a.charAt(index) == 'A') {
                        state = "A";
                    } else {
                        state = "-1";
                    }
                    break;

                case "ANAN": //entspricht Zustand Z4
                    if (a.charAt(index) == 'A') {
                        state = "ANANA";
                    } else {
                        state = "-1";
                    }
                    break;

                case "ANANA": //entspricht Zustand Z5
                    char c = a.charAt(index); //Lokale Variabel, da mehrmals gebraucht
                    if (c == 'S') {
                        state = "ANANAS"; //gefunden => Zustand Z6
                    } else if (c == 'N') {
                        state = "ANAN"; //entspricht Zustand Z4
                    } else if (c == 'A') {
                        state = "A"; //entspricht Zustand Z1
                    } else {
                        state = "-1";
                    }
                    break;
            }
            index++;
        } while (!state.equals("ANANAS") && index < a.length());
        if (state.equals("ANANAS")) {
            return index - "ANANAS".length();
        } else return notFound;
    }
}
