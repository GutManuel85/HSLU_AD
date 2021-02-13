package ch.hslu.demo.EqualsHashcodeComparable;

import java.util.Comparator;
import java.util.Objects;

public class GrundstückComparator implements Comparator<Grundstück> {

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof GrundstückComparator) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getClass());
    }

    @Override
    public int compare(Grundstück g1, Grundstück g2) {
        int compare = Integer.compare(g1.getPreis(), g2.getPreis());
        if(compare != 0){
            return compare;
        }else{
            return Integer.compare(g1.getQuadratMeter(),g2.getQuadratMeter());
        }

    }
}
