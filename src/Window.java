import javax.swing.*;
import java.awt.*;

public class Window extends JFrame implements Runnable {

    private final Graphics2D g2;
    private final Shape bg, player, ai, ball;
    private final PlayerController playerController;
    private final AiController aiController;
    private final BallController ballController;

    public Window() {
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setTitle(Constants.WINDOW_TITLE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        final KeyEventListener keyListener = new KeyEventListener();
        addKeyListener(keyListener);
        Constants.INSETES_TOP = getInsets().top;
        Constants.INSETES_BOTTOM = getInsets().bottom;

        this.g2 = (Graphics2D) getGraphics();
        this.bg = new Shape(0.0, 0.0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, Constants.WINDOW_COLOR);
        this.player = new Shape(Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Constants.PADDLE_COLOR);
        this.ai = new Shape(Constants.WINDOW_WIDTH - (Constants.PADDLE_WIDTH * 2), Constants.PADDLE_HEIGHT, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Constants.PADDLE_COLOR);
        this.ball = new Shape((double) Constants.WINDOW_WIDTH / 2, (double) Constants.WINDOW_HEIGHT / 2, Constants.BALL_RADIUS, Constants.BALL_RADIUS, Constants.BALL_COLOR);
        this.playerController = new PlayerController(this.player, keyListener);
        this.ballController = new BallController(this.ball, player, ai);
        this.aiController = new AiController(this.ai, ballController);
    }

    void update(final double dt) {
        final Image dbImage = this.createImage(this.getWidth(), this.getHeight());
        final Graphics dbg = dbImage.getGraphics();
        draw(dbg);
        this.g2.drawImage(dbImage, 0, 0, this);

        this.playerController.update(dt);
        this.aiController.update(dt);
        this.ballController.update(dt);
    }

    void draw(final Graphics g) {
        final Graphics2D g2 = (Graphics2D) g;

        this.bg.drawRect(g2);
        this.player.drawRect(g2);
        this.ai.drawRect(g2);
        this.ball.drawEllipse(g2);
        this.ballController.draw(g2);
    }

    @Override
    public void run() {
        double lastFrameTime = 0.0;
        //noinspection InfiniteLoopStatement
        while (true) {
            final double time = Time.getTime();
            final double deltaTime = time - lastFrameTime;
            lastFrameTime = time;

            this.update(deltaTime);
        }
    }
}
