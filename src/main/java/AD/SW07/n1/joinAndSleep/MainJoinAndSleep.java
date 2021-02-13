package AD.SW07.n1.joinAndSleep;

public class MainJoinAndSleep {

    public static void main(String[] args){

        Thread thread3 = new Thread(new Task3(),"Thread3");
        Thread thread2 = new Thread(new Task2(),"Thread2");
        Thread thread1 = new Thread(new Task1(),"Thread1");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
