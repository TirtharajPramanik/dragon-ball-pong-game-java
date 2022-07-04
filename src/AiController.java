public class AiController extends ObjController {
    private final Shape ai, ball;
    int speed = Constants.PADDLE_SPEED;

    public AiController(Shape ai, Shape ball) {
        this.ai = ai;
        this.ball = ball;
    }

    @Override
    public void update(double dt) {
        if (ball.y + ball.h < ai.y) {
            moveUp(dt);
        } else if (ball.y > ai.y + ai.h) {
            moveDown(dt);
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


