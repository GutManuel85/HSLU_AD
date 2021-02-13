package AD.SW04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.NoSuchElementException;
import java.util.Objects;

public class HashArrayImplementation implements HashArrayInterface<Integer> {

    private static final Logger LOG = LogManager.getLogger(HashArrayImplementation.class);

    private Integer[] hashArray = new Integer[10];

    /**
     * Default Konsturktor.
     */
    public HashArrayImplementation() {
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Prüfung auf Identität (Entity).
     *
     * @param obj
     * @return boolean
     */

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override
    public String toString() {
        for (int i = 0; i < hashArray.length; i++) {
            if (hashArray[i] == null) {
                LOG.info("Fach " + i + " :  null");
            } else {
                LOG.info("Fach " + i + " : " + hashArray[i].toString());
            }
        }
        return "siehe LOG";
    }

    @Override
    public void add(Integer element) {
        int index = this.getIndex(element);
        int counter = 0;
        if (!this.alreadyExisting(element)) {
            if (!this.isEmpty(index)) {
                while (!this.isEmpty(index) && counter < hashArray.length) {
                    if (index < this.hashArray.length - 1) {
                        index++;
                        counter++;
                    } else //hier geschiet der Uebergang von Fach 9 auf Fach 0
                        index = 0;
                }
            }
            if (this.isEmpty(index)) {
                LOG.info("Das Element " + element.toString() + " wurde ins Fach " + index + " aufgenommen");
                this.hashArray[index] = element;
                counter++;
            }
        }else{
            LOG.warn("Element existiert bereits und wurde nicht aufgenommen.");
        }
    }


        @Override
        public void remove (Integer element){
            int index;
            try {
                index = search(element);
                this.hashArray[index] = null;
            } catch (NoSuchElementException nsee) {
                LOG.error(nsee.getMessage(), nsee.getCause(), nsee.getStackTrace());
            }
        }

        @Override
        public int search (Integer element){
            for (int i = 0; i < this.hashArray.length; i++) {
                if (this.hashArray[i] != null && this.hashArray[i].equals(element)) {
                    LOG.info("Element gefunden");
                    return i;
                }
            }
            throw new NoSuchElementException("Element nicht gefunden");
        }

        /**
         * Zaehlt die Anzahl Elemente im Array.
         *
         * @return int
         */
        @Override
        public int getSize () {
            int counter = 0;
            for (Integer i : this.hashArray) {
                if (i != null) {
                    counter++;
                }
            }
            return counter;
        }

        public boolean isFullArray () {
            return getSize() >= this.hashArray.length;
        }


        public Integer[] getHashArray () {
            return hashArray;
        }

        protected int getIndex (Integer element){
            int index = 0;
            if (element < 0) {
                element = this.makePositiv(element);
            }
            LOG.info("Der Hash des Elements ist: " + Objects.hash(element));
            index = element.hashCode() % hashArray.length;
            LOG.info("Der Index ist: " + index);
            return index;
            // Integer.hashCode() rechnet zum Integerwert + 31.
        }

        protected boolean alreadyExisting (Integer element){
            for (int i = 0; i < this.hashArray.length; i++) {
                if (this.hashArray[i] != null && this.hashArray[i].equals(element)) {
                    LOG.info("Element existiert bereits");
                    return true;
                }
            }
            return false;
        }

        protected boolean isEmpty ( int index){
            return (this.hashArray[index] == null);
        }

        protected int makePositiv ( int element){
            while (element < 0) {
                element = element + 10;
            }
            return element;
        }
    /* da in java -1mod10 -1 ergibt, muss negativer Index zuerst positiv gemacht werden.
    Siehe hier: https://www.youtube.com/watch?v=dhMYdAvUrko
     */
    }