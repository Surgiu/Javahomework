package assignment5;

public class Test {
    public static void main(String[] args) {
        Cone cone = new Cone(ObjectColor.RED, 4.4, 5.6);
        Sphere sphere = new Sphere(ObjectColor.RED, 4.4);
        Cuboid cuboid = new Cuboid(ObjectColor.RED, 3.3, 4.4, 5.5);
        System.out.println(sphere.volume());
        System.out.println(sphere.surfaceMeanSize());
        System.out.println(cone.surfaceMeanSize());
        System.out.println(cone.volume());
        System.out.println(cuboid.volume());
        System.out.println(cuboid.surfaceMeanSize());
        GraphicObjectCollection graphicObjectCollection = new GraphicObjectCollection();
        graphicObjectCollection.addObject(ObjectColor.RED,3);
        System.out.println(graphicObjectCollection.getObjectInfo());
    }
}
