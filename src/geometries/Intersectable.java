package geometries;
import Primitives.*;

import java.util.List;

public interface Intersectable
{
    List<Point3D> findIntersections(Ray ray);
}
