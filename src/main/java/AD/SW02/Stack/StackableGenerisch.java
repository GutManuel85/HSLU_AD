package AD.SW02.Stack;

/**Interface für Stacks*/
public interface StackableGenerisch<E> {

    /**String auf Stack legen*/
    void push(E e);

    /**String vom Stack nehmen*/
    Object pop();
}
