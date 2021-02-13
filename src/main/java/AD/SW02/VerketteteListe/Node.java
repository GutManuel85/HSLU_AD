package AD.SW02.VerketteteListe;

import java.util.Iterator;
import java.util.Objects;

public class Node<T> implements Iterator<Node> {

    private T object;
    private Node nextNode;

    public Node(T object) {
        this.object = object; //Element selbst
        nextNode = null; //Referenz auf nächstes Element
    }

    @Override
    public boolean hasNext() {
        return this.nextNode != null;
    }

    @Override
    public Node next() {
        return this.getNextNode();
    }

    @Override
    public String toString() {
        return object.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Node)) {
            return false;
        }
        Node other = (Node) object;
        return (this.getObject() == other.getObject());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.object);
    }

    public Object getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node node) {
        this.nextNode = node;
    }
}
