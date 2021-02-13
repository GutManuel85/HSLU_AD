package AD.SW02.Stack;

/**Interface für Stacks*/
public interface Stackable<T> {

    /**String auf Stack legen*/
    void push(String string);

    /**String vom Stack nehmen*/
    String pop();
}
