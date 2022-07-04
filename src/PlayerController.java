import java.awt.event.KeyEvent;

public class PlayerController {

    private final Shape player;
    private final KeyEventListener keyListener;
    int speed = Constants.PADDLE_SPEED;

    public PlayerController(Shape player, KeyEventListener keyListener) {
        this.player = player;
        this.keyListener = keyListener;
    }

    public void update(double dt) {
        if (keyListener.isKeyPressed(KeyEvent.VK_UP) || keyListener.isKeyPressed(KeyEvent.VK_W)) {
            if ((player.y - speed * dt) > Constants.INSETES_TOP) {
                player.y -= speed * dt;
            }
        } else if (keyListener.isKeyPressed(KeyEvent.VK_DOWN) || keyListener.isKeyPressed(KeyEvent.VK_S)) {
            if ((player.y + speed * dt + player.h) < (Constants.WINDOW_HEIGHT - Constants.INSETES_BOTTOM)) {
                player.y += speed * dt;
            }
        }

    }
}
