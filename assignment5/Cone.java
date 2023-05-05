package assignment5;

public class Cone extends GraphicObject {
    private double radius;
    private double length;

    public Cone(ObjectColor objectColor, double radius, double length) {
        super(objectColor);
        this.radius = radius;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Cone: " + "r=" + String.format("%.2f", this.radius) + ", l=" + String.format("%.2f", this.length);
    }

    @Override
    public double surfaceMeanSize() {
        String s = String.format("%.2f", 0.01 * Math.floor(100 * Math.PI * radius * (radius + length)));
        return Double.parseDouble(s);
    }

    @Override
    public double volume() {
        double h = Math.sqrt(length * length - radius * radius);
        int d = (int) Math.floor(100 * Math.PI * radius * radius * h / 3.0);
        String s = String.format("%.2f", 0.01 * d);
        return Double.parseDouble(s);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
