package Primitives;

import java.util.Objects;
import Primitives.Point3D;

public class Ray {
    Point3D _point;
    Vector _vec;

    /**Constructor
     * @param _point point3D
     * @param _vec Vector
     */
    public Ray(Point3D _point, Vector _vec) {

        this._point = _point;
        _vec=_vec.normalize();
        this._vec = _vec;
    }



    /**Copy Constructor
     * @param _ray Ray
     */
    public Ray(Ray _ray) {

       _point=new Point3D((_ray._point));
       _vec=new Vector((_ray._vec));
    }

    /**Get function for point3D
     * @return _point Point3D
     */
    public Point3D get_point() {
        return _point;
    }

    /**Set function for vector
     * @return _vec Vector
     */
    public Vector get_vec() {
        return _vec;
    }

    /**Returns true if rays are equal
     * @param o Ray
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return ray.equals( ray._point) && ray.equals( ray._vec);
    }

    /**toString
     * @return string
     */
    @Override
    public String toString() {
        return "Ray{" +
                "_point=" + _point +
                ", _vec=" + _vec +
                '}';
    }

    public Point3D getPoint(double t) {
        return Util.isZero(t ) ? _point : _point.add(_vec.scale(t));
    }
}
