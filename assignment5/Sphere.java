package assignment5;

public class Sphere extends GraphicObject {
    private double radius;

    public Sphere(ObjectColor color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double surfaceMeanSize() {
        double d = Math.floor(100.0 * 4.0 * Math.PI * radius * radius);
        String s = String.format("%.2f", d / 100.0);
        return Double.parseDouble(s);
    }

    @Override
    public double volume() {
        double v = 4.0 / 3.0 * Math.PI * radius * radius * radius;
        return v;
    }

    @Override
    public String toString() {
        return "Sphere: r=" + String.format("%.2f", this.radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
