package AD.SW02.VerketteteListe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EinfachVerketteteListeTest {

    @Test
    void testAddFirstListElement() {
        EinfachVerketteteListe liste = new EinfachVerketteteListe();
        Node node = new Node("testNode1");
        liste.addListElement(node);
        assertEquals("testNode1", node.getObject().toString());
    }

    @Test
    void testAddSecondListElement() {
        EinfachVerketteteListe liste = new EinfachVerketteteListe();
        liste.addListElement(new Node("testNode1"));
        Node node = new Node("testNode2");
        liste.addListElement(node);
        assertEquals("testNode2", node.getObject().toString());
    }

    @Test
    void testRemoveListElement() throws NoSuchFieldException{
        EinfachVerketteteListe liste = new EinfachVerketteteListe();
        Node nodeLastInList = new Node("nodeLastInList");
        liste.addListElement(nodeLastInList);
        Node nodeToBeRemoved = new Node("nodeToBeRemoved");
        liste.addListElement(nodeToBeRemoved);
        Node nodeFirstInList =  new Node("nodeFirstInList");
        liste.addListElement(nodeFirstInList);
        liste.removeListElement(nodeToBeRemoved);
        assertEquals("nodeLastInList", nodeFirstInList.getNextNode().getObject().toString());
    }

    @Test
        // hier wird auf testNode2 getestet, ob er einen Nachfolge-Node hat, was richtig ist. Dies ist testNode1, der davor eingefügt wurde.
    void testHasNextTrue() {
        EinfachVerketteteListe liste = new EinfachVerketteteListe();
        liste.addListElement(new Node("testNode1"));
        Node node = new Node("testNode2");
        liste.addListElement(node);
        assertTrue(node.hasNext());
    }

    @Test
        // hier wird auf testNode1 getestet, ob er einen Nachfolge-Node hat. Dies ist nicht der Fall, da zuvor noch kein Node eingefügt wurde.
    void testHasNextFalse() {
        EinfachVerketteteListe liste = new EinfachVerketteteListe();
        Node node = new Node("testNode1");
        liste.addListElement(node);
        assertFalse(node.hasNext());
    }

    @Test
    void testFind() {
        EinfachVerketteteListe liste = new EinfachVerketteteListe();
        liste.addListElement(new Node("testNode1"));
        Node nodeToBeFound = new Node("testNode2");
        liste.addListElement(nodeToBeFound);
        liste.addListElement(new Node("testNode3"));
        assertDoesNotThrow(() -> {
            liste.find(nodeToBeFound);
        });
    }

    @Test
    void testFindReferenz() throws NoSuchFieldException{
        EinfachVerketteteListe liste = new EinfachVerketteteListe();
        liste.addListElement(new Node("testNode1"));
        liste.addListElement(new Node("testNode2"));
        liste.addListElement(new Node("testNode3"));
        Node node = new Node("testNode4");
        liste.addListElement(node);
        Node result = liste.findReferenz(node);
        assertEquals("testNode3", result.getObject().toString());
    }

    @Test
    void size() {
        EinfachVerketteteListe liste = new EinfachVerketteteListe();
        liste.addListElement(new Node("testNode1"));
        liste.addListElement(new Node("testNode2"));
        liste.addListElement(new Node("testNode3"));
        assertEquals(3, liste.size());
    }
}