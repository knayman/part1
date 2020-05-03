package geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import Primitives.Util;
public class Cylinder extends Tube {

    private double _h;

    /**
     * Constructor
     *
     * @param radius double
     * @param height double
     */
    public Cylinder(Ray ray, double radius, double height) {
        super(radius,ray);
        _h = height;
    }



    /**
     * Returns normal to the point received.
     *
     * @return vector
     */
    public Vector getNormal(Point3D _p) {
        Point3D o = _r.get_point();
        Vector v = _r.get_vec();

        // projection of P-O on the ray:
        double t;
        try {
            t = Util.alignZero(_p.subtract(o).dotProduct(v));
        } catch (IllegalArgumentException e) { // P = O
            return v;
        }

        // if the point is at a base
        if (Util.isZero(t) || Util.isZero(_h - t)) // if it's close to 0, we'll get ZERO vector exception
            return v;

        o = o.add(v.scale(t));
        return _p.subtract(o).normalize();
    }
}