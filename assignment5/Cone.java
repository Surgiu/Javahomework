package assignment5;

public class Cone extends GraphicObject {
    private double radius;
    private double length;

    public Cone(ObjectColor objectColor, double radius, double length) {
        this.radius = radius;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Cone: " + "r=[" + String.format("%.2f", this.radius) + "], l=[" + String.format("%.2f", this.length) + "]";
    }

    @Override
    public double surfaceMeanSize() {
        String s = String.format("%.2f", Math.PI * radius * (radius + length));
        return Double.parseDouble(s);
    }

    @Override
    public double volume() {
        double h = Math.sqrt(length * length - radius * radius);
        String s = String.format("%.2f", Math.PI * radius * radius * h / 3.0);
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
