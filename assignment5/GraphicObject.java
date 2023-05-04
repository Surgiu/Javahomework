package assignment5;

public abstract class GraphicObject {
    private ObjectColor color;
    private int id;

    public abstract double surfaceMeanSize();

    public abstract double volume();

    public ObjectColor getColor() {
        return color;
    }

    public void setColor(ObjectColor color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class Cone extends GraphicObject {
    private double radius;
    private double length;

    public Cone(double radius, double length) {
        this.radius = radius;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Cone: " + "r=[" + String.format("%2f", this.radius) + "], l=[" + String.format("%2f", this.length) + "]";
    }

    @Override
    public double surfaceMeanSize() {
        String s = String.format("%2f", Math.PI * radius * (radius + length));
        return Double.parseDouble(s);
    }

    @Override
    public double volume() {
        double h = Math.sqrt(length * length - radius * radius);
        String s = String.format("%2f", Math.PI * radius * radius * h / 3.0);
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

class Cuboid extends GraphicObject {
    private double x;
    private double y;
    private double z;

    public Cuboid(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public double surfaceMeanSize() {
        String s = String.format("%2f", (x * y + y * z + x * z) * 2.0);
        return Double.parseDouble(s);
    }

    @Override
    public double volume() {
        String s = String.format("%2f", x * y * z);
        return Double.parseDouble(s);
    }

    @Override
    public String toString() {
        return "Cuboid: x=[" + String.format("%2f", this.x) + "], y=[" + String.format("%2f", this.y) + "], z=[" + String.format("%2f", this.z) + "]";
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}

class Sphere extends GraphicObject {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double surfaceMeanSize() {
        String s = String.format("%2f", 4.0 * Math.PI * radius * radius);
        return Double.parseDouble(s);
    }

    @Override
    public double volume() {
        double s = 4.0 * Math.PI * radius * radius * radius / 3.0;
        String ss = String.format("%2f", s);
        return Double.parseDouble(ss);
    }

    @Override
    public String toString() {
        return "Sphere: r=[" + String.format("%2f", this.radius) + "]";
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}