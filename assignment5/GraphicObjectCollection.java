package assignment5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GraphicObjectCollection implements ObjectCollection {
    private List<GraphicObject> graphicObjects = new ArrayList<>();

    @Override
    public void addObject(ObjectColor objectColor, double... parameters) {
        switch (parameters.length) {
            case 1:
                Sphere sphere = new Sphere(parameters[0]);
                graphicObjects.add(sphere);
            case 2:
                Cone cone = new Cone(parameters[0], parameters[1]);
                graphicObjects.add(cone);
            case 3:
                Cuboid cuboid = new Cuboid(parameters[0], parameters[1], parameters[2]);
                graphicObjects.add(cuboid);
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
    public List<String> getCountsByVolume() {
        List<Double> v = new ArrayList<>();
        for (GraphicObject graphicObject : graphicObjects) {
            v.add(graphicObject.volume());
        }
        v.sort(Comparator.naturalOrder());
        List<String> res = new ArrayList<>();
        for (Double aDouble : v) {
            res.add(aDouble.toString());
        }
        return res;
    }

    @Override
    public List<String> getObjectsBySurface() {
        List<Double> s = new ArrayList<>();
        for (GraphicObject graphicObject : graphicObjects) {
            s.add(graphicObject.surfaceMeanSize());
        }
        s.sort(Comparator.naturalOrder());
        List<String> res = new ArrayList<>();
        for (Double aDouble : s) {
            res.add(aDouble.toString());
        }
        return res;
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
