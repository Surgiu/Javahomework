package assignment5;

import java.util.ArrayList;
import java.util.List;

public interface ObjectCollection {
    void addObject(ObjectColor objectColor,double...parameters);
    List<String> getObjectInfo();
    int getObjectCount();
    List<String> getCountsByColor();
    List<String> getCountsByVolume();
    List<String> getObjectsBySurface();
    double getWaterInjected(double area, double height);
}
