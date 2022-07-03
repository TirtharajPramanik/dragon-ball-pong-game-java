import javax.swing.*;
import java.awt.*;

public class Window extends JFrame implements Runnable {

    Graphics2D g2;
    Shape bg, player, ai, ball;
    KeyEventListener keyListener = new KeyEventListener();
    PlayerController playerController;

    public Window() {
        this.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        this.setTitle(Constants.WINDOW_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        Constants.INSETES_TOP = this.getInsets().top;
        Constants.INSETES_BOTTOM = this.getInsets().bottom;

        g2 = (Graphics2D) this.getGraphics();
        bg = new Shape(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, Constants.WINDOW_COLOR);
        player = new Shape(Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Constants.PADDLE_COLOR);
        ai = new Shape(Constants.WINDOW_WIDTH - (Constants.PADDLE_WIDTH * 2), Constants.PADDLE_HEIGHT, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Constants.PADDLE_COLOR);
        ball = new Shape(Constants.WINDOW_WIDTH / 2, Constants.WINDOW_HEIGHT / 2, Constants.BALL_RADIUS, Constants.BALL_RADIUS, Constants.BALL_COLOR);
        playerController = new PlayerController(player, keyListener);
    }

    void update(double dt) {
        Image dbImage = createImage(getWidth(), getHeight());
        Graphics dbg = dbImage.getGraphics();
        this.draw(dbg);
        g2.drawImage(dbImage, 0, 0, this);

        playerController.update(dt);
    }

    void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        bg.drawRect(g2);
        player.drawRect(g2);
        ai.drawRect(g2);
        ball.drawEllipse(g2);
    }

    @Override
    public void run() {
        double lastFrameTime = 0.0;
        while (true) {
            double time = Time.getTime();
            double deltaTime = time - lastFrameTime;
            lastFrameTime = time;

            update(deltaTime);
        }
    }
}
