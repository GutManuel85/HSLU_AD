package AD.SW02.VerketteteListe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EinfacheListeProgramm {

    private static final Logger LOG = LogManager.getLogger(EinfacheListeProgramm.class);

    public static void main(String[] args) {

        EinfachVerketteteListe einfachVerketteteListe = new EinfachVerketteteListe();
        einfachVerketteteListe.addListElement(new Node("1. Element"));
        Node nodeToBeFound = new Node("2. Element");
        einfachVerketteteListe.addListElement(nodeToBeFound);
        einfachVerketteteListe.addListElement(new Node("3. Element"));
        try {
            System.out.println(einfachVerketteteListe.find(nodeToBeFound).toString());
        } catch (NoSuchFieldException nsfe) {
            LOG.error(nsfe.getMessage());
        }
    }
}
