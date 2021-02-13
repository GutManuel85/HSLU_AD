package AD.SW04;

import AD.SW02.Stack.StackGenerisch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StackImplementationVergleich {

    public static String[] stringArray;
    public static Stack<String> stackFromCollection;
    public static StackGenerisch<String> stackOwnImplementation;
    public static Deque<String> deque;

    private static final Logger LOG = LogManager.getLogger(StackImplementationVergleich.class);

    public static void main(String[] args){

        stringArray = createArray(100000);
        stackFromCollection = createStackfromCollection(stringArray);
        stackOwnImplementation = createStackOwnImplementation(stringArray);
        deque = createDeque(stringArray);
    }

    public static String[] createArray(int AnzahlObjekte){
        long startTime = System.currentTimeMillis();
        String[] stringArray = new String[AnzahlObjekte];
        for(int i = 0; i < stringArray.length; i++){
            stringArray[i] = "hallo";
        }
        long endTime = System.currentTimeMillis();
        long usedTime = endTime - startTime;
        LOG.info("Es wurden " + usedTime + " Millisekunden benötigt, um Objekte zu Initialisieren" +
                "und um in Array zu speichern.");
        return stringArray;
    }

    public static Stack<String> createStackfromCollection(String[] stringArray){
        stackFromCollection = new Stack<>();
        stackFromCollection.ensureCapacity(stringArray.length); //legt die minimale Groesse fest.
        long startTime = System.currentTimeMillis();
        for(String s : stringArray){
            stackFromCollection.push(s);
        }
        long endTime = System.currentTimeMillis();
        long usedTime = endTime - startTime;
        LOG.info("StackCollection benötigte " + usedTime + " Millisekunden.");
        return stackFromCollection;
    }

    public static StackGenerisch<String> createStackOwnImplementation(String[] stringArray){
        stackOwnImplementation = new StackGenerisch<>(stringArray.length);
        long startTime = System.currentTimeMillis();
        for(String s: stringArray){
            stackOwnImplementation.push(s);
        }
        long endTime = System.currentTimeMillis();
        long usedTime = endTime - startTime;
        LOG.info("StackOwnImplementation benötigete " + usedTime + " Millisekunden.");
        return stackOwnImplementation;
    }

    public static Deque<String> createDeque(String[] stringArray){
        deque = new ArrayDeque<>();
        long startTime = System.currentTimeMillis();
        for(String s: stringArray){
            deque.add(s);
        }
        long endTime = System.currentTimeMillis();
        long usedTime = endTime - startTime;
        LOG.info("Deque benötigte " + usedTime + " Millisekunden.");
        return deque;
    }
}
