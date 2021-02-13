package AD.SW07.n1.balls;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BallTask implements Runnable {

    private static final Logger LOG = LogManager.getLogger(BallTask.class);

    private Circle circle;

    public BallTask(Circle circle) {
        this.circle = circle;
    }

    @Override
    public void run() {
        while (circle.getY() < 400 - circle.getDiameter()) {
            circle.moveDown();
        }
        try {
            Thread.sleep(1000);
            circle.makeInvisible();
        } catch (InterruptedException ie) {
            LOG.warn(ie.getMessage(), ie.getCause(), ie.getStackTrace());
        }
    }
}
