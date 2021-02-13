package AD.SW03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.NoSuchElementException;

public class BinaryTree<Node> implements TreeInterface<Integer> {

    private Logger LOG = LogManager.getLogger(BinaryTree.class);

    private TreeNode root;
    private int size;


//    private TreeNode addRekursiv(TreeNode current, int zahl) {
//        if (size == 0) {
//            this.root = new TreeNode(zahl);
//            current = this.root;
//            return current;
//        } else if (current != null) {
//            if (current.getZahl() > zahl) {
//                addRekursiv(current.getLeftTreeNode(), zahl);
//            } else if (current.getZahl() < zahl) {
//                addRekursiv(current.getRightTreeNode(), zahl);
//            } else {
//                LOG.warn("Zahl existiert bereits");
//            }
//        } else {
//        }
//    }

//    public void add(int zahl) {
//        addRekursiv(root, zahl);
//    }

    public void add(int zahl) { //itterativ
        if (size == 0) {
            this.root = new TreeNode(zahl);
        }
        TreeNode current = this.root;
        TreeNode next;
        if (this.root.getZahl() >= zahl) {
            next = this.root.getLeftTreeNode();
        } else if (this.root.getZahl() <= zahl) {
            next = this.root.getRightTreeNode();
        } else {
            LOG.warn("Zahl existiert bereits und wurde deshalb nicht aufgenommen.");
            return;
        }
        while (next != null) {
            current = next;
            if (current.getZahl() >= zahl) {
                next = current.getLeftTreeNode();
            } else if (current.getZahl() <= zahl) {
                next = current.getRightTreeNode();
            } else {
                LOG.warn("Zahl existiert bereits und wurde deshalb nicht aufgenommen.");
                return;
            }
        }
        if (current.getZahl() >= zahl) {
            current.setLeftTreeNode(new TreeNode(zahl));
        } else {
            current.setRightTreeNode(new TreeNode(zahl));
        }
        size++;
    }


    @Override
    public void remove(int zahl) {
    }

    @Override
    public int searchInorder(int zahl) {
        return 0;
    }
//        if (size != 0)
//            return searchRecInorder(root, zahl).getZahl();
//        else {
//            throw new NoSuchElementException("Tree ist leer");
//        }
//    }


//    private TreeNode searchRecInorder(TreeNode treeNode, int zahl) {
//        TreeNode nodePointer = root;
//        if (nodePointer.getZahl() == zahl) {
//            return nodePointer;
//        } else {
//            nodePointer = searchRecInorder(root.getLeftTreeNode(), zahl);
//
//
//        }
//    }


    public TreeNode getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }
}
