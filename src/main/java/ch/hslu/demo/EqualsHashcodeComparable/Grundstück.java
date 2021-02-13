package ch.hslu.demo.EqualsHashcodeComparable;

import java.util.Objects;

public class Grundstück {

    private int preis;
    private int quadratMeter;

    public Grundstück(int preis, int quadratMeter){
        this.preis = preis;
        this.quadratMeter = quadratMeter;
    }

    @Override
    public String toString(){
        return String.valueOf(preis) + " / " + String.valueOf(quadratMeter);
    }

    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(!(object instanceof Grundstück)){
            return false;
        }
        Grundstück other = (Grundstück) object;
        return (this.preis == other.preis && this.quadratMeter == other.quadratMeter);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.preis, this.quadratMeter);
    }

    public int getPreis() {
        return preis;
    }

    public int getQuadratMeter() {
        return quadratMeter;
    }
}
