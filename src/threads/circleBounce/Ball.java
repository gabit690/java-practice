package threads.circleBounce;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Ball extends Ellipse2D.Double {

    private int size;

    private Point position;

    private Point differential;

    private Point maxPosition;

    private int lives;

    public Ball(int size, Point position, Point max, int lives) {

        this.size = size;

        this.position = position;

        Random random = new Random();

        this.differential = new Point(
                ( (random.nextInt(2) % 2) == 0 ) ? 1 : -1,
                ( (random.nextInt(2) % 2) == 0 ) ? 1 : -1);

        this.maxPosition = max;

        this.lives = lives;
    }

    public void move() {

        if (this.lives > 0) {
            this.position = new Point(
                    (int) (this.position.getX() + this.differential.getX()),
                    (int) (this.position.getY() + this.differential.getY())
            );
            boolean hShock = this.horizontalShock();
            boolean vShock = this.verticalShock();
            if ((hShock ^ vShock) ^ (hShock && vShock)) {
                this.lives--;
            }
        } else {
            System.out.println("QUIET");
        }
    }

    public boolean isActive() {
        return this.lives > 0;
    }

    public Ellipse2D getShape() {

        return new Ellipse2D.Double(this.position.getX(), this.position.getY(), this.size, this.size);
    }

    private boolean horizontalShock() {
        boolean isShock = this.position.getX() == 0  || this.position.getX() == this.maxPosition.getX();
        if (isShock) {
            this.differential = new Point(-(int) this.differential.getX(), (int) this.differential.getY());
        }
        return isShock;
    }

    private boolean verticalShock() {
        boolean isShock = this.position.getY() == 0 || this.position.getY() == this.maxPosition.getY();
        if (isShock) {
            this.differential = new Point((int) this.differential.getX(), -(int) this.differential.getY());
        }
        return isShock;
    }

}
