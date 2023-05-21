package assignment5;

public class Cuboid extends GraphicObject {
    private double x;
    private double y;
    private double z;

    public Cuboid(ObjectColor objectColor, double x, double y, double z) {
        super(objectColor);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public double surfaceMeanSize() {
        double g = Math.floor((x * y + y * z + x * z) * 2.0 * 100.0) / 100.0;
        String s = String.format("%.2f", g);
        return Double.parseDouble(s);
    }

    @Override
    public double volume() {
        double res = Math.floor(100.0 * x * y * z) / 100.0;
        String S = String.format("%.2f", res);
        return Double.parseDouble(S);
    }

    @Override
    public String toString() {
        return "Cuboid: x=" + String.format("%.2f", this.x) + ", y=" + String.format("%.2f", this.y) + ", z=" + String.format("%.2f", this.z);
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
