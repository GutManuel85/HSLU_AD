package AD.SW07.n1.balls;

import java.util.ArrayList;

public class FarbSammlung {

    private static int colorCounter = 0;
    private int anzahlFarben = 3;
    private ArrayList<Farben> farbArray = new ArrayList<>();

    public FarbSammlung() {
        farbArray.add(Farben.GREEN);
        farbArray.add(Farben.BLUE);
        farbArray.add(Farben.RED);
    }

    public Farben getColorFromSammlung() {
        colorCounter++;
        return farbArray.get(getColorCounter());
    }

    private int getColorCounter() {
        return colorCounter % anzahlFarben;
    }
}
