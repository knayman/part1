package geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Util;
import Primitives.Vector;

import java.util.List;

public class Plane implements Geometry {
   private Point3D _p;
   private Vector _normal;

    /**Constructor
     * @param _p Point3D
     * @param _v Vector
     */
    public Plane(Point3D _p, Vector _v) {
        this._p = _p;
        this._normal = _v;
    }

    /**Constructor
     * @param _p1
     * @param _p2
     * @param _p3
     */
    public  Plane(Point3D _p1,Point3D _p2,Point3D _p3)
    {
        this._p=_p1;
        Vector tmp1=_p1.subtract(_p2);
        Vector u=new Vector(tmp1);
        Vector tmp2=_p1.subtract(_p3);
        Vector V=new Vector(tmp2);
        Vector n=u.crossProduct(V);
        n.normalize();
       n.scale(-1);
        this._normal=n;
    }

    /**Returns the normal at a point
     * @param _p Point3D
     * @return Vector
     */
public Vector getNormal(Point3D _p)
{
    return _normal.scale(-1);
}

    /**Get function
     * @return Point3D
     */
    public Point3D get_p() {
        return _p;
    }

    /**Get function
     * @return Vector
     */
    public Vector get_normal() {
        return _normal;
    }

    /**Set function
     * @param _p Point3D
     */
    public void set_p(Point3D _p) {
        this._p = _p;
    }

    /**Set function
     * @param _normal
     */
    public void set_normal(Vector _normal) {
        this._normal = _normal;
    }

    /**
     * @param ray
     * @return Plane intersection points.
     */
    @Override
    public List<Point3D> findIntersections(Ray ray) {
        Vector p0Q;
        try {
            p0Q = _p.subtract(ray.get_point());
        } catch (IllegalArgumentException e) {
            return null; // ray starts from point Q - no intersections
        }

        double nv = _normal.dotProduct(ray.get_vec());
        if (Util.isZero(nv)) // ray is parallel to the plane - no intersections
            return null;

        double t = Util.alignZero(_normal.dotProduct(p0Q) / nv);

        return t <= 0 ? null : List.of(ray.getPoint(t));
    }
    }
