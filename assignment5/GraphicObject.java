package assignment5;

public abstract class GraphicObject {
    private ObjectColor color;
    private int id;
    private static int count = 0;

    public GraphicObject(ObjectColor color) {
        this.color = color;
        this.id = count;
        count++;
    }

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

