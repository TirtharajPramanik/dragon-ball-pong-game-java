import java.awt.*;

public class TextHelper {
    private final Font font;
    private final double x;
    private final double y;
    public String text;

    public TextHelper(String text, double x, double y) {
        this.text = text;
        this.font = new Font("sans-serif", Font.PLAIN, Constants.FONT_SIZE);
        this.x = x;
        this.y = y;
    }

    public TextHelper(String text, int size, double x, double y) {
        this.text = text;
        this.font = new Font("sans-serif", Font.PLAIN, size);
        this.x = x;
        this.y = y;
    }

    public TextHelper(String text, String font, int size, double x, double y) {
        this.text = text;
        this.font = new Font(font, Font.PLAIN, size);
        this.x = x;
        this.y = y;
    }

    public double[] getRect() {
        double rectx = x + font.getSize() * 2;
        double recty = y - font.getSize();
        return new double[]{x, rectx, y, recty};
    }

    public void draw(Graphics2D g2, Color color) {
        g2.setColor(color);
        g2.setFont(font);
        g2.drawString(text, (float) x, (float) y);
    }

}
