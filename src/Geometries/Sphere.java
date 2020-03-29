package Geometries;

import Geometries.RadialGeometry;
import Primitives.Point3D;
import Primitives.Vector;


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
}
