package assignment5;
import java.util.List;

public interface ObjectCollection {
    void addObject(ObjectColor objectColor,double...parameters);
    List<String> getObjectInfo();
    int getObjectCount();
    List<String> getCountsByColor();
    List<String> getObjectByVolume();
    List<String> getObjectsBySurface();
    double getWaterInjected(double area, double height);
}
