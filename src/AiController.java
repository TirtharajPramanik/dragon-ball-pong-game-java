public class AiController {
    private final Shape ai;
    private final BallController ball;
    int speed = Constants.PADDLE_SPEED;

    public AiController(Shape ai, BallController ball) {
        this.ai = ai;
        this.ball = ball;
    }

    public void update(double dt) {
        if (ball.vx > 0) {
            if (ball.ball.y + ball.ball.h < ai.y + (ai.h / 2)) {
                moveUp(dt);
            } else if (ball.ball.y > ai.y + (ai.h / 2)) {
                moveDown(dt);
            }
        }
    }

    private void moveUp(double dt) {
        if ((ai.y - speed * dt) > Constants.INSETES_TOP) {
            ai.y -= speed * dt;
        }
    }

    private void moveDown(double dt) {
        if ((ai.y + speed * dt + ai.h) < (Constants.WINDOW_HEIGHT - Constants.INSETES_BOTTOM)) {
            ai.y += speed * dt;
        }
    }
}


