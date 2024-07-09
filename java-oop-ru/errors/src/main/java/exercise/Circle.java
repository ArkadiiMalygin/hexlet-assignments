package exercise;

// BEGIN
public class Circle {
    private Point centre;
    private int rad;

    public Circle(Point centre, int rad) {
        this.centre = centre;
        this.rad = rad;
    }

    public int getRadius() {
        return this.rad;
    }

    public double getSquare() throws NegativeRadiusException {
        if (getRadius() < 0) {
            throw new NegativeRadiusException("");
        }
        return Math.PI * getRadius() * getRadius();
    }
}
// END
