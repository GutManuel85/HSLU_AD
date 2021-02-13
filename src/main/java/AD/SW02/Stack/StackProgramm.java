package AD.SW02.Stack;

public class StackProgramm {

    public static void main(String[] args){

        Stack stack = new Stack(3);
        stack.push("toll");
        stack.push("sind");
        stack.push("Datenstrukturen");
        for(int i = 2; i >= 0; i--) {
            System.out.println(stack.pop());
        }
    }
}
