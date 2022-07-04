public class BallController {
    private final Shape ball, player, ai;
    int xSpeed = -150;
    int ySpeed = 100;

    public BallController(Shape ball, Shape player, Shape ai) {
        this.ball = ball;
        this.player = player;
        this.ai = ai;
    }

    public void update(double dt) {
        ball.x += dt * xSpeed;
        ball.y += dt * ySpeed;

        if (ball.x <= 0 || ball.x + ball.w >= Constants.WINDOW_WIDTH) {
            System.out.println("Game Over!");
            System.exit(0);
        }

        if (ball.y <= Constants.INSETES_TOP || ball.y + ball.h >= Constants.WINDOW_HEIGHT - Constants.INSETES_BOTTOM) {
            ySpeed *= -1;
        }

        if (((ball.x <= player.x + player.w && ball.x >= player.w) && (ball.y <= player.y + player.h && ball.y + ball.h >= player.y)) || ((ball.x + ball.w >= ai.x && ball.x + ball.w <= ai.x + ai.w) && (ball.y <= ai.y + ai.h && ball.y + ball.h >= ai.y))) {
            xSpeed *= -1;
        }

    }
}


