package geometries;

import Primitives.*;

import java.util.List;


public class Triangle extends Polygon
{
    /**Constructor
     * @param vertices
     */
    public Triangle(Point3D... vertices) {
        super(vertices);
    }

    public Vector getNormal( Point3D _p)
    {
       return super.getNormal(_p);
    }

    /**
     * @param ray
     * @return Triangle intersection point
     */
    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> intersections = _plane.findIntersections(ray);
        if (intersections == null) return null;

        Point3D p0 = ray.get_point();
        Vector v = ray.get_vec();

        Vector v1 = _vertices.get(0).subtract(p0);
        Vector v2 = _vertices.get(1).subtract(p0);
        Vector v3 = _vertices.get(2).subtract(p0);

        double s1 = v.dotProduct(v1.crossProduct(v2));
        if (Util.isZero(s1)) return null;
        double s2 = v.dotProduct(v2.crossProduct(v3));
        if (Util.isZero(s2)) return null;
        double s3 = v.dotProduct(v3.crossProduct(v1));
        if (Util.isZero(s3)) return null;

        return ((s1 > 0 && s2 > 0 && s3 > 0) || (s1 < 0 && s2 < 0 && s3 < 0)) ? intersections : null;
    }
}
