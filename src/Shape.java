import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

public class Shape {
    public final double w, h, arcw, arch;
    public final Color color;
    public double x, y;

    public Shape(double x, double y, double w, double h, Color color) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.arcw = 0;
        this.arch = 0;
        this.color = color;
    }

    public Shape(double x, double y, double w, double h, double arcw, double arch, Color color) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.arcw = arcw;
        this.arch = arch;
        this.color = color;
    }

    public void drawRect(Graphics2D g2) {
        g2.setColor(color);
        g2.fill(new RoundRectangle2D.Double(x, y, w, h, arcw, arch));
    }

    public void drawEllipse(Graphics2D g2) {
        g2.setColor(color);
        g2.fill(new Ellipse2D.Double(x, y, w, h));
    }

}
