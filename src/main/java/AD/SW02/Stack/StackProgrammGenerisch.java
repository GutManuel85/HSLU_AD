package AD.SW02.Stack;

public class StackProgrammGenerisch {

    public static void main(String[] args){

        StackGenerisch stack = new StackGenerisch(3);
        stack.push("toll");
        stack.push("sind");
        stack.push("Datenstrukturen");
        for(int i = 2; i >= 0; i--) {
            System.out.println(stack.pop());
        }
    }
}
