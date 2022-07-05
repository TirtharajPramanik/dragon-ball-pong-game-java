import java.awt.*;

public class BallController {
    public final Shape ball, player, ai;
    private final TextHelper gameOverText = new TextHelper("Game Over!", (double) (Constants.WINDOW_WIDTH / 2) - (Constants.FONT_SIZE * 2), (Constants.WINDOW_HEIGHT - Constants.INSETES_TOP) / 2);
    public double vx = Constants.BALL_SPEED;
    public double vy = Constants.BALL_SPEED;
    public int playerScore = 0, aiScore = 0;
    public TextHelper playerScoreText = new TextHelper("" + playerScore, Constants.PADDLE_WIDTH / 2, Constants.INSETES_TOP + Constants.FONT_SIZE);
    public TextHelper aiScoreText = new TextHelper("" + aiScore, Constants.WINDOW_WIDTH - (Constants.PADDLE_WIDTH / 2) - Constants.FONT_SIZE, Constants.INSETES_TOP + Constants.FONT_SIZE);

    public BallController(Shape ball, Shape player, Shape ai) {
        this.ball = ball;
        this.player = player;
        this.ai = ai;
    }

    private double calculateShootAngle(Shape paddle) {
        double relativeIntersectY = (paddle.y + (paddle.h / 2.0)) - (ball.y + (ball.h / 2.0));
        double normalIntersectY = relativeIntersectY / (paddle.h / 2.0);
        double theta = normalIntersectY * Constants.MAX_ANGLE;
        return Math.toRadians(theta);
    }

    private void shoot(Shape paddle) {
        double theta = calculateShootAngle(paddle);
        double nvx = Math.abs(Math.cos(theta) * Constants.BALL_SPEED);
        double nvy = -Math.sin(theta) * Constants.BALL_SPEED;

        double oldSign = Math.signum(vx);
        vx = nvx * (oldSign * -1.0);
        vy = nvy;
    }


    public void update(double dt) {
        ball.x += dt * vx;
        ball.y += dt * vy;

        if (ball.x + ball.w >= Constants.WINDOW_WIDTH) {
            playerScore++;
            playerScoreText.text = "" + playerScore;
            ball.x = (double) Constants.WINDOW_WIDTH / 2;
        } else if (ball.x <= 0) {
            aiScore++;
            aiScoreText.text = "" + aiScore;
            ball.x = (double) Constants.WINDOW_WIDTH / 2;
        }

        if (ball.y <= Constants.INSETES_TOP || ball.y + ball.h >= Constants.WINDOW_HEIGHT - Constants.INSETES_BOTTOM) {
            vy *= -1;
        }

        if ((ball.x <= player.x + player.w && ball.x >= player.w) && (ball.y <= player.y + player.h && ball.y + ball.h >= player.y)) {
            shoot(player);
        } else if ((ball.x + ball.w >= ai.x && ball.x + ball.w <= ai.x + ai.w) && (ball.y <= ai.y + ai.h && ball.y + ball.h >= ai.y)) {
            shoot(ai);
        }

    }

    public void draw(Graphics2D g2) {
        this.playerScoreText.draw(g2, Color.CYAN);
        this.aiScoreText.draw(g2, Color.GREEN);
//        if (playerScore > 2 || aiScore > 2) {
//            gameOverText.draw(g2, Color.ORANGE);
//        }
    }
}


