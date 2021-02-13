package AD.SW03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeTest {
    BinaryTree binaryTree;


    @BeforeEach
    void init(){
        binaryTree = new BinaryTree();
    }

    @Test
    void testaddItterativZahlGleicheZahl() {
        binaryTree.add(5);
        binaryTree.add(5);
        assertEquals(null, binaryTree.getRoot().getLeftTreeNode());
        assertEquals(null, binaryTree.getRoot().getRightTreeNode());
    }

    @Test
    void testaddItterativZahl(){ //kompleter (vollständiger) Binärbaum bis Niveau 2
        binaryTree.add(4);
        binaryTree.add(2);
        binaryTree.add(6);
        binaryTree.add(1);
        binaryTree.add(3);
        binaryTree.add(5);
        binaryTree.add(7);
        assertEquals(4, binaryTree.getRoot().getZahl());
        assertEquals(2, binaryTree.getRoot().getLeftTreeNode().getZahl());
        assertEquals(6, binaryTree.getRoot().getRightTreeNode().getZahl());
        assertEquals(1, binaryTree.getRoot().getLeftTreeNode().getLeftTreeNode().getZahl());
        assertEquals(3, binaryTree.getRoot().getLeftTreeNode().getRightTreeNode().getZahl());
        assertEquals(5, binaryTree.getRoot().getRightTreeNode().getLeftTreeNode().getZahl());
        assertEquals(7, binaryTree.getRoot().getRightTreeNode().getRightTreeNode().getZahl());
    }
}