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
        String r = String.format("%.2f", this.radius);
        return "Cone: " + "r=" + r + ", l=" + String.format("%.2f", this.length);
    }

    @Override
    public double surfaceMeanSize() {
        double temp = Math.floor(100 * Math.PI * radius * (radius + length));
        String s = String.format("%.2f", temp / 100.0);
        double d = Double.parseDouble(s);
        return d;
    }

    @Override
    public double volume() {
        double h = Math.sqrt(length * length - radius * radius);
//        return Math.PI * radius * radius * h / 3.0;
        double t2 = Math.floor(100 * Math.PI * radius * radius * h / 3.0);
        String s = String.format("%.2f", t2 / 100.0);
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
