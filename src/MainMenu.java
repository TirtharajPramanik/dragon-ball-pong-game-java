import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MainMenu extends JFrame implements Runnable {
    public static boolean isRunning = true;
    public static boolean scores = false;
    private final MouseEventListener mouseListener;
    private final KeyEventListener keyListener;
    private final Graphics2D g2;
    private final Shape bg;
    private final TextHelper gameOverText = new TextHelper("Game Over!", Constants.FONT_SIZE * 2, (Constants.WINDOW_WIDTH / 2.0) - (Constants.FONT_SIZE * 6), ((Constants.WINDOW_HEIGHT - Constants.INSETES_TOP) / 2.0) - 100);
    private final TextHelper mainLogo = new TextHelper("Dragon Ball", Constants.FONT_SIZE * 2, (Constants.WINDOW_WIDTH / 2.0) - (Constants.FONT_SIZE * 6), ((Constants.WINDOW_HEIGHT - Constants.INSETES_TOP) / 2.0) - 100);
    private final TextHelper mainPlay = new TextHelper("Play", Constants.FONT_SIZE * 2, (Constants.WINDOW_WIDTH / 2.0) - (Constants.FONT_SIZE * 2), ((Constants.WINDOW_HEIGHT - Constants.INSETES_TOP) / 2.0));
    private final TextHelper mainQuit = new TextHelper("Quit", Constants.FONT_SIZE * 2, (Constants.WINDOW_WIDTH / 2.0) - (Constants.FONT_SIZE * 2), ((Constants.WINDOW_HEIGHT - Constants.INSETES_TOP) / 2.0) + 100);

    public MainMenu() {
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setTitle(Constants.WINDOW_TITLE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        keyListener = new KeyEventListener();
        mouseListener = new MouseEventListener();
        addKeyListener(keyListener);
        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);
        Constants.INSETES_TOP = getInsets().top;
        Constants.INSETES_BOTTOM = getInsets().bottom;

        this.g2 = (Graphics2D) getGraphics();
        this.bg = new Shape(0.0, 0.0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, Constants.WINDOW_COLOR);
    }

    void update(final double dt) {
        if (keyListener.isKeyPressed(KeyEvent.VK_ESCAPE) || keyListener.isKeyPressed(KeyEvent.VK_Q)) {
            isRunning = false;
        }

        final Image dbImage = this.createImage(this.getWidth(), this.getHeight());
        final Graphics dbg = dbImage.getGraphics();
        draw(dbg);

        this.g2.drawImage(dbImage, 0, 0, this);
    }

    void draw(final Graphics g) {
        final Graphics2D g2 = (Graphics2D) g;

        this.bg.drawRect(g2);
        if (scores) {
            this.gameOverText.draw(g2, Color.ORANGE);
        } else {
            this.mainLogo.draw(g2, Color.ORANGE);
        }

        if (keyListener.isKeyPressed(KeyEvent.VK_Q) || keyListener.isKeyPressed(KeyEvent.VK_W)) {
            isRunning = false;
        }

        double[] mainQuitRect = mainQuit.getRect();
        if (mouseListener.x >= mainQuitRect[0] && mouseListener.x <= mainQuitRect[1] && mouseListener.y <= mainQuitRect[2] && mouseListener.y >= mainQuitRect[3]) {
            this.mainPlay.draw(g2, Color.GRAY);
            this.mainQuit.draw(g2, Color.LIGHT_GRAY);
            if (mouseListener.isPressed || keyListener.isKeyPressed(KeyEvent.VK_ENTER) || keyListener.isKeyPressed(KeyEvent.VK_SPACE)) {
                isRunning = false;
            }
        } else {
            this.mainPlay.draw(g2, Color.LIGHT_GRAY);
            this.mainQuit.draw(g2, Color.GRAY);
            if (mouseListener.isPressed || keyListener.isKeyPressed(KeyEvent.VK_ENTER) || keyListener.isKeyPressed(KeyEvent.VK_SPACE)) {
                Main.changeState(1);
            }
        }
    }

    @Override
    public void run() {
        double lastFrameTime = 0.0;
        while (isRunning) {
            final double time = Time.getTime();
            final double deltaTime = time - lastFrameTime;
            lastFrameTime = time;

            this.update(deltaTime);
        }
        this.dispose();
    }
}
