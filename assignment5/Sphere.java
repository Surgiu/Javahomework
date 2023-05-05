package assignment5;

public class Sphere extends GraphicObject {
    private double radius;

    public Sphere(ObjectColor color,double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double surfaceMeanSize() {
        String s = String.format("%.2f", 4.0 * Math.PI * radius * radius);
        return Double.parseDouble(s);
    }

    @Override
    public double volume() {
        double s = 4.0 * Math.PI * radius * radius * radius / 3.0;
        String ss = String.format("%.2f", s);
        return Double.parseDouble(ss);
    }

    @Override
    public String toString() {
        return "Sphere: r=[" + String.format("%.2f", this.radius) + "]";
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
