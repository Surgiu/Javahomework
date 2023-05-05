package assignment5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GraphicObjectCollection implements ObjectCollection {
    private List<GraphicObject> graphicObjects = new ArrayList<>();

    @Override
    public void addObject(ObjectColor objectColor, double... parameters) {
        if (parameters.length == 1) {
            this.graphicObjects.add(new Sphere(objectColor, parameters[0]));
        } else if (parameters.length == 2) {
            this.graphicObjects.add(new Cone(objectColor, parameters[0], parameters[1]));
        } else if (parameters.length == 3) {
            this.graphicObjects.add(new Cuboid(objectColor, parameters[0], parameters[1], parameters[2]));
        }
    }

    @Override
    public List<String> getObjectInfo() {
        List<String> info = new ArrayList<>();
        for (GraphicObject graphicObject : graphicObjects) {
            info.add(graphicObject.toString());
        }
        return info;
    }

    @Override
    public int getObjectCount() {
        return graphicObjects.size();
    }

    @Override
    public List<String> getCountsByColor() {
        int r = 0, y = 0, b = 0, g = 0, hei = 0, w = 0;
        for (GraphicObject graphicObject : graphicObjects) {
            switch (graphicObject.getColor()) {
                case RED -> r++;
                case BLUE -> b++;
                case BLACK -> hei++;
                case GREEN -> g++;
                case WHITE -> w++;
                case YELLOW -> y++;
            }
        }
        List<String> color = new ArrayList<>();
        if (r != 0) {
            color.add("RED " + r);
        }
        if (y != 0) {
            color.add("YELLOW " + y);
        }
        if (b != 0) {
            color.add("BLUE " + b);
        }
        if (g != 0) {
            color.add("GREEN " + g);
        }
        if (hei != 0) {
            color.add("BLACK " + hei);
        }
        if (w != 0) {
            color.add("WHITE " + w);
        }
        return color;
    }

    @Override
    public List<String> getObjectByVolume() {
        List<GraphicObject> o = new ArrayList<>();
        for (GraphicObject object : graphicObjects) {
            o.add(object);
        }
        o = sortByVolume(o);
        List<String> res = new ArrayList<>();
        for (GraphicObject graphicObject : o) {
            res.add(graphicObject.toString());
        }
        return res;
    }

    public static List<GraphicObject> sortByVolume(List<GraphicObject> l1) {
        l1.sort(new Comparator<GraphicObject>() {
            @Override
            public int compare(GraphicObject o1, GraphicObject o2) {
                if (o1.volume() > o2.volume()) {
                    return 1;
                } else if (o1.volume() < o2.volume()) {
                    return -1;
                } else {
                    return o1.getId() - o2.getId();
                }
            }
        });
        return l1;
    }

    @Override
    public List<String> getObjectsBySurface() {
        List<GraphicObject> o = new ArrayList<>();
        for (GraphicObject object : graphicObjects) {
            o.add(object);
        }
        o = sortByArea(o);
        List<String> res = new ArrayList<>();
        for (GraphicObject graphicObject : o) {
            res.add(graphicObject.toString());
        }
        return res;
    }

    public static List<GraphicObject> sortByArea(List<GraphicObject> l1) {
        l1.sort(new Comparator<GraphicObject>() {
            @Override
            public int compare(GraphicObject o1, GraphicObject o2) {
                if (o1.surfaceMeanSize() > o2.surfaceMeanSize()) {
                    return 1;
                } else if (o1.surfaceMeanSize() < o2.surfaceMeanSize()) {
                    return -1;
                } else {
                    return o1.getId() - o2.getId();
                }
            }
        });
        return l1;
    }

    @Override
    public double getWaterInjected(double area, double height) {
        double V = area * height;
        double vTotal = 0;
        for (GraphicObject graphicObject : graphicObjects) {
            vTotal += graphicObject.volume();
        }
        return V - vTotal;
    }
}
