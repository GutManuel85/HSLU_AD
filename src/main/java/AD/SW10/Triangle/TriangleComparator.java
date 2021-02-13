package AD.SW10.Triangle;

import java.util.Comparator;

public class TriangleComparator implements Comparator<TriangleSpezielleOrdnung> {

    @Override
    public int compare(TriangleSpezielleOrdnung t1, TriangleSpezielleOrdnung t2) {
        int compare = Double.compare(t1.getUmfang(),t2.getUmfang());
        if(compare == 0){
            return Integer.compare(t1.getHighestPoint(),t2.getHighestPoint());
        }
        return compare;
    }


}
