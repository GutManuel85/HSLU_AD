package AD.SW10.Triangle;

import java.util.Objects;

public class TriangleSpezielleOrdnung implements Comparable<TriangleSpezielleOrdnung> {

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x3;
    private int y3;

    public TriangleSpezielleOrdnung(int x1, int y1, int x2, int y2, int x3, int y3){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public double getUmfang(){
        double seite1 = Math.pow(Math.pow((x1-x2),2) + Math.pow((y1-y2),2), 0.5);
        double seite2 = Math.pow(Math.pow((x2-x3),2) + Math.pow((y2-y3),2), 0.5);
        double seite3 = Math.pow(Math.pow((x3-x1),2) + Math.pow((y3-y1),2), 0.5);
        return seite1 + seite2 + seite3;
    }

    public int getHighestPoint(){
        if(y1 >= y2) {
            return y1;
        }else if(y2 >= y3){
            return y2;
        }else{
            return y3;
        }
    }

    @Override
    public int compareTo(TriangleSpezielleOrdnung other) {
        TriangleComparator triangleComparator = new TriangleComparator();
        if(this == other){
            return 0;
        }
        return triangleComparator.compare(this,other);
    }

    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(!(object instanceof TriangleSpezielleOrdnung)){
            return false;
        }
        TriangleSpezielleOrdnung other = (TriangleSpezielleOrdnung) object;
        return this.getUmfang() == other.getUmfang() && this.getHighestPoint() == other.getHighestPoint();
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.getUmfang(), this.getHighestPoint());
    }

    @Override
    public String toString(){
        return "Der Umfang ist " + this.getUmfang() + " / Highest Point ist " + this.getHighestPoint();
    }
}
