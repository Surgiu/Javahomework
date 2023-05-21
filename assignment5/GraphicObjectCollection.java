package assignment5;

import java.util.*;

public class GraphicObjectCollection implements ObjectCollection {
    private List<GraphicObject> graphicObjects = new ArrayList<>();

    @Override
    public void addObject(ObjectColor objectColor, double... parameters) {
        if (parameters.length == 1) {
            this.graphicObjects.add(new Sphere(objectColor, parameters[0]));
        } else if (parameters.length == 3) {
            this.graphicObjects.add(new Cuboid(objectColor, parameters[0], parameters[1], parameters[2]));
        } else if (parameters.length == 2) {
            this.graphicObjects.add(new Cone(objectColor, parameters[0], parameters[1]));
        }
    }

    @Override
    public List<String> getObjectInfo() {
        List<String> s = new ArrayList<>();
        for (GraphicObject graphicObject : graphicObjects) {
            s.add(graphicObject.toString());
        }
        return s;
    }


    public int getObjectCount() {
        return graphicObjects.size();
    }


    public List<String> getCountsByColor() {
        int red = 0;
        int blue = 0;
        int black = 0;
        int green = 0;
        int white = 0;
        int yellow = 0;
        for (GraphicObject graphicObject : graphicObjects) {
            //改成if-else
            switch (graphicObject.getColor()) {
                case RED -> red++;
                case BLUE -> blue++;
                case BLACK -> black++;
                case GREEN -> green++;
                case WHITE -> white++;
                case YELLOW -> yellow++;
            }
        }
        List<String> color = new ArrayList<>();
        if (red != 0) {
            color.add("RED " + red);
        }
        if (yellow != 0) {
            color.add("YELLOW " + yellow);
        }
        if (blue != 0) {
            color.add("BLUE " + blue);
        }
        if (green != 0) {
            color.add("GREEN " + green);
        }
        if (black != 0) {
            color.add("BLACK " + black);
        }
        if (white != 0) {
            color.add("WHITE " + white);
        }
        return color;
    }

    @Override
    public List<String> getObjectByVolume() {
        List<GraphicObject> o = new ArrayList<>(graphicObjects);
        o = sortByVolume(o);
        List<String> res = new ArrayList<>();
        for (GraphicObject graphicObject : o) {
            res.add(graphicObject.toString());
        }
        return res;
    }

    public static List<GraphicObject> sortByVolume(List<GraphicObject> l1) {
        GraphicObject[] a = (GraphicObject[]) l1.toArray();
        Arrays.sort(a, ((o1, o2) -> {
            return (int) (o1.volume() - o2.volume());
        }));
        ArrayList<GraphicObject> graphicObjects1 = new ArrayList<>();
        Collections.addAll(graphicObjects1, a);
        return graphicObjects1;
    }

    @Override
    public List<String> getObjectsBySurface() {
        List<GraphicObject> o = new ArrayList<>(graphicObjects);
        sortByArea(o);
        List<String> res = new ArrayList<>();
        for (GraphicObject graphicObject : o) {
            res.add(graphicObject.toString());
        }
        return res;
    }

    public static List<GraphicObject> sortByArea(List<GraphicObject> l1) {
        GraphicObject[] a = (GraphicObject[]) l1.toArray();
        Arrays.sort(a, ((o1, o2) -> {
            return (int) (o1.surfaceMeanSize() - o2.surfaceMeanSize());
        }));
        ArrayList<GraphicObject> graphicObjects1 = new ArrayList<>();
        Collections.addAll(graphicObjects1, a);
        return graphicObjects1;
    }

    @Override
    public double getWaterInjected(double area, double height) {
        double V = area * height, v2 = 0;
        for (int i = 0; i < graphicObjects.size(); i++) {
            v2 += graphicObjects.get(i).volume();
        }
        double rest = V - v2;
        return rest;
    }
}
