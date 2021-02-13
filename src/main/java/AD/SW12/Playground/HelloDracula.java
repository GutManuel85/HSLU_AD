package AD.SW12.Playground;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloDracula {

    private static final Logger LOGGER = LogManager.getLogger("HelloDracula");
    public static void main(String[] args) {

        System.out.println(getText(0,4));
    }

    public static String getText(int number, int anzahlKinder) {
        switch (number) {
            case 0:
                switch(anzahlKinder){
                    case 0:
                        return "Hello Dracula without children";
                    case 1:
                        return "Hello Dracula with one child";
                    default:
                        return "Fuck you and your unkown amount of children";
                }
            case 1:
                return "Hello Dracula1";
            default:
                return "Fuck your number";
        }

    }
}
