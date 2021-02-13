package AD.SW02.Stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StackGenerisch<E> implements StackableGenerisch<E> {

    private static final Logger LOG = LogManager.getLogger(StackGenerisch.class);
    private int stackCounter;
    private E[] array;

    public StackGenerisch(int size){
        array = (E[]) new Object[size]; //Cast auf generisches Array
        stackCounter = -1;
    }

    @Override
    public void push(E element) {
        if (stackCounter <= array.length - 2) {
            stackCounter++;
            array[stackCounter] = element;
        } else {
            throw new ArrayIndexOutOfBoundsException("Stack ist voll");
        }
    }

    @Override
    public Object pop() {
        if (stackCounter >= 0) {
            Object object = array[stackCounter];
            stackCounter--;
            return object;
        } else {
            throw new ArrayIndexOutOfBoundsException("Stack ist leer");
        }
    }

    public int getStackCounter() {
        return stackCounter;
    }

    public Object[] getarray() {
        return array;
    }
}
