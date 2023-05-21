package assignment5;

public abstract class GraphicObject {
    private ObjectColor color;

    public GraphicObject(ObjectColor color) {
        this.color = color;
    }

    public abstract double surfaceMeanSize();

    public abstract double volume();

    public ObjectColor getColor() {
        return color;
    }

    public void setColor(ObjectColor color) {
        this.color = color;
    }

}

