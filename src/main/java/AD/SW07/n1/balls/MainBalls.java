package AD.SW07.n1.balls;

import java.util.ArrayList;
import java.util.Random;

public class MainBalls {

    public static void main(String[] args) {

        Canvas canvas = Canvas.getCanvas();
        Random random = new Random();
        FarbSammlung farbSammlung = new FarbSammlung();
        ArrayList<Circle> ballSammlung = new ArrayList<>();
        ArrayList<Thread> threadSammlung = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Circle circle = new Circle(random.nextInt(80), random.nextInt(500),
                    random.nextInt(200), farbSammlung.getColorFromSammlung().toString());
            circle.makeVisible();
            ballSammlung.add(circle);
            threadSammlung.add(new Thread(new BallTask(circle)));
            threadSammlung.get(i).start();
        }


    }
}
