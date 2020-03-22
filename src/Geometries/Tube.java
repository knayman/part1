package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

public class Tube extends RadialGeometry{
    private Ray _r;

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
    public Vector getNormal(Point3D _p)
    {
        return null;
    }
}
