package geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Util;
import Primitives.Vector;

import java.util.List;


public class Sphere extends RadialGeometry
{
    private Point3D _p;

    /**Constructor
     * @param radius
     * @param _p
     */
    public Sphere(double radius, Point3D _p) {
        super(radius);
        this._p = _p;
    }

    /**Returns normal to the point received.
     * @return vector
     */
    public Vector getNormal(Point3D point)
    {
        Vector orthogonal = new Vector(point.subtract(_p));
        return orthogonal.normalized();
    }

    /**
     * @param ray
     * @return Sphere intersection points
     */
    @Override
    public List<Point3D> findIntersections(Ray ray) {

        Point3D p0 = ray.get_point();
        Vector v = ray.get_vec();
        Vector u;
        try {
            u = _p.subtract(p0);   // p0 == _center
        } catch (IllegalArgumentException e) {
            return List.of(ray.getPoint(getRadius()));
        }
        double tm = Util.alignZero(v.dotProduct(u));
        double dSquared = (tm == 0) ? u.lengthSquared() : u.lengthSquared() - tm * tm;
        double thSquared = Util.alignZero(getRadius()* getRadius()- dSquared);

        if (thSquared <= 0) return null;

        double th = Util.alignZero(Math.sqrt(thSquared));
        if (th == 0) return null;

        double t1 = Util.alignZero(tm - th);
        double t2 = Util.alignZero(tm + th);
        if (t1 <= 0 && t2 <= 0) return null;
        if (t1 > 0 && t2 > 0) return List.of(ray.getPoint(t1), ray.getPoint(t2)); //P1 , P2
        if (t1 > 0)
            return List.of(ray.getPoint(t1));
        else
            return List.of(ray.getPoint(t2));
    }
    }

