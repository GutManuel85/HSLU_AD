package AD.SW10.Triangle;

import java.util.Objects;

public class Triangle implements Comparable<Triangle> {

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x3;
    private int y3;

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3){
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

    @Override
    public int compareTo(Triangle other) {
        if(this == other){
            return 0;
        }
        return Double.compare(this.getUmfang(),other.getUmfang());
    }

    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(!(object instanceof Triangle)){
            return false;
        }
        Triangle other = (Triangle) object;
        return this.getUmfang() == other.getUmfang();
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.getUmfang());
    }
}
