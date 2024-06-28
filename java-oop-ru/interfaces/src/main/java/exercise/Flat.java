package exercise;

// BEGIN
public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return this.area + this.balconyArea;
    }

    @Override
    public String toString() {
        return "Квартира площадью " +
                this.getArea() +
                " метров на " + floor +
                " этаже";
    }

    @Override
    public int compareTo(Home another) {
        if (this.getArea() > another.getArea()) {
            return 1;
        }
        if (this.getArea() < another.getArea()) {
            return -1;
        }
        return 0;
    }
}
// END
