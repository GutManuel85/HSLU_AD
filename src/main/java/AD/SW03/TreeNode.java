package AD.SW03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;


public class TreeNode implements Comparable<TreeNode> {

    private static final Logger LOG = LogManager.getLogger(TreeNode.class);

    private TreeNode leftTreeNode;
    private TreeNode rightTreeNode;
    private int zahl;

    public TreeNode(int zahl) {
        this.zahl = zahl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(zahl);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TreeNode)) {
            return false;
        }
        final TreeNode other = (TreeNode) obj;
        return this.zahl == other.zahl;
    }

    @Override
    public String toString() {
        return Integer.toString(zahl);
    }

    @Override
    public int compareTo(TreeNode other) {
        if (this.zahl > other.zahl) {
            return 1;
        }
        ;
        if (this.zahl == other.zahl) {
            return 0;
        }
        if (this.zahl < other.zahl) {
            return -1;
        }
        RuntimeException re = new RuntimeException("Vergleich konnte nicht gemacht werden");
        LOG.error(re.getMessage());
        throw re;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public TreeNode getLeftTreeNode() {
        return leftTreeNode;
    }

    public void setLeftTreeNode(TreeNode leftTreeNode) {
        if (leftTreeNode.compareTo(this) < 0 && this.leftTreeNode == null) {
            this.leftTreeNode = leftTreeNode;
        }
    }

    public TreeNode getRightTreeNode(){
        return rightTreeNode;
    }

    public void setRightTreeNode(TreeNode rightTreeNode) {
        if (rightTreeNode.compareTo(this) > 0 && this.rightTreeNode == null) {
            this.rightTreeNode = rightTreeNode;
        }
    }

    public int getZahl() {
        return zahl;
    }

    public void setZahl(int zahl) {
        this.zahl = zahl;
    }
}
