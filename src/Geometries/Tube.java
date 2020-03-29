package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Util;
import Primitives.Vector;

public class Tube extends RadialGeometry{
    protected Ray _r;

    /**Constructor
     * @param radius
     * @param _r
     */
    public Tube(double radius, Ray _r) {
        super(radius);
        this._r = _r;
    }

    /**Returns normal to the point received.
     * @return vector
     */
    @Override
        public Vector getNormal(Point3D point)
        {
        //The vector from the point of the cylinder to the given point
        Point3D o = _r.get_point();
        Vector v = _r.get_vec();

        Vector vector1 = point.subtract(o);

        //We need the projection to multiply the _direction unit vector
        double projection = vector1.dotProduct(v);
        if(!Util.isZero(projection))
        {
            // projection of P-O on the ray:
            o.add(v.scale(projection));
        }

        //This vector is orthogonal to the _direction vector.
        Vector check = point.subtract(o);
        return check.normalize();
    }
}
