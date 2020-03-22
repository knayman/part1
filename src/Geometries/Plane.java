package Geometries;

import Primitives.Point3D;
import Primitives.Vector;

public class Plane {
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
        this._normal=null;
    }

    /**Returns the normal at a point
     * @param _p Point3D
     * @return Vector
     */
public Vector getNormal(Point3D _p)
{
    return null;
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
}
