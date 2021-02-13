package AD.SW04;//package AD.SW04;
//
//import AD.SW02.VerketteteListe.Node;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//public class HashTableWithBuckets implements HashArrayInterface<Node> {
//
//    private static final Logger LOG = LogManager.getLogger(HashTableWithBuckets.class);
//
//    private Node[] nodeArray = new Node[10];
//
//    @Override
//    public void add(Node node){
//        if(!alreadyExisting(node)){
//
//
//        }
//
//
//    }
//
//    @Override
//    public void remove(Node element) {
//
//    }
//
//    @Override
//    public int search(Node element) {
//        return 0;
//    }
//
//    @Override
//    public int getSize() {
//        return 0;
//    }
//
//    protected boolean alreadyExisting(Node node) {
//        for (int i = 0; i < this.nodeArray.length; i++) {
//            if (this.nodeArray[i].equals(node)) {
//                LOG.info("Element bereits vorhanden.");
//                return true;
//            }
//        }
//        return false;
//    }
//
//    protected int getIndex(Node node){
//        if(no)
//        int index = node.hashCode()%nodeArray.length;
//    }
//}