package AD.SW02.Stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Stack implements Stackable {

    private static final Logger LOG = LogManager.getLogger(Stack.class);
    private int stackCounter;
    private String[] stringArray;

    public Stack(int size){
        stringArray = new String[size];
        stackCounter = -1;
    }

    @Override
    public void push(String string) {
        if (stackCounter <= stringArray.length - 2) {
            stackCounter++;
            stringArray[stackCounter] = string;
        } else {
            throw new ArrayIndexOutOfBoundsException("Stack ist voll");
        }
    }

    @Override
    public String pop() {
        if (stackCounter >= 0) {
            String popString = stringArray[stackCounter];
            stringArray[stackCounter] = null; //damit String in Array von GarbageCollector abgeräumt wird.
            stackCounter--;
            return popString;
        } else {
            throw new ArrayIndexOutOfBoundsException("Stack ist leer");
        }
    }

    public int getStackCounter() {
        return stackCounter;
    }

    public String[] getStringArray() {
        return stringArray;
    }
}
