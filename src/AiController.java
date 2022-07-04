import java.awt.event.KeyEvent;

public class AiController {
    private final Shape ai;
    private final KeyEventListener keyListener;
    int speed = Constants.PADDLE_SPEED;

    public AiController(Shape ai, KeyEventListener keyListener) {
        this.ai = ai;
        this.keyListener = keyListener;
    }

    public void update(double dt) {
        if (keyListener.isKeyPressed(KeyEvent.VK_LEFT) || keyListener.isKeyPressed(KeyEvent.VK_I)) {
            if ((ai.y - speed * dt) > Constants.INSETES_TOP) {
                ai.y -= speed * dt;
            }
        } else if (keyListener.isKeyPressed(KeyEvent.VK_RIGHT) || keyListener.isKeyPressed(KeyEvent.VK_J)) {
            if ((ai.y + speed * dt + ai.h) < (Constants.WINDOW_HEIGHT - Constants.INSETES_BOTTOM)) {
                ai.y += speed * dt;
            }
        }

    }
}


