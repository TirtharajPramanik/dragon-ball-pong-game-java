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
        if (keyListener.isKeyPressed(KeyEvent.VK_ESCAPE) || keyListener.isKeyPressed(KeyEvent.VK_SPACE)) {
            Main.changeState(0);
        } else if (keyListener.isKeyPressed(KeyEvent.VK_UP) || keyListener.isKeyPressed(KeyEvent.VK_W)) {
            moveUp(dt);
        } else if (keyListener.isKeyPressed(KeyEvent.VK_DOWN) || keyListener.isKeyPressed(KeyEvent.VK_S)) {
            moveDown(dt);
        }
    }

    private void moveUp(double dt) {
        if ((player.y - speed * dt) > Constants.INSETES_TOP) {
            player.y -= speed * dt;
        }
    }

    private void moveDown(double dt) {
        if ((player.y + speed * dt + player.h) < (Constants.WINDOW_HEIGHT - Constants.INSETES_BOTTOM)) {
            player.y += speed * dt;
        }
    }
}
