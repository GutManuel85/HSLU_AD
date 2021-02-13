package AD.SW07.n1.balls;

public enum Farben {

    BLUE("blue"), RED("red"), GREEN("green");

    private String string;

    private Farben(String string){
        this.string = string;
    }

    public String toString(){
        return  this.string;
    }
}
