package Primitives;

import java.util.Objects;

public class Point3D {
   private Coordinate _x;
   private Coordinate _y;
   private Coordinate _z;

public static Point3D ZERO=new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0));
    /**Constructor
     * @param _x Coordinate
     * @param _y Coordinate
     * @param _z Coordinate
     */
    public Point3D(Coordinate _x, Coordinate _y, Coordinate _z)
    {
        this._x = _x;
        this._y = _y;
        this._z = _z;
    }

    /**Constructor
     * @param _x Coordinate
     * @param _y Coordinate
     * @param _z Coordinate
     */
    public Point3D(double _x, double _y, double _z)
    {
        this._x = new Coordinate(_x);
        this._y = new Coordinate(_y);
        this._z = new Coordinate(_z);
    }

    /**Copy Constructor
     * @param _p Point3D
     */
    public Point3D(Point3D _p)
    {
        this._x = _p._x;
        this._y = _p._y;
        this._z = _p._z;
    }

    /**Get function
     * @return _x Coordinate
     */
    public Coordinate get_x() {

        return _x;
    }

    /** Get function
     * @return _y Coordinate
     */
    public Coordinate get_y() {

        return _y;
    }

    /** Get function
     * @return _z Coordinate
     */
    public Coordinate get_z() {
        return _z;
    }

    /** Set function
     * @param _x Coordinate
     */
    public void set_x(Coordinate _x) {

        this._x = _x;
    }

    /** Set function
     * @param _y Coordinate
     */
    public void set_y(Coordinate _y) {
        this._y = _y;
    }

    /** Set function
     * @param _z Coordinate
     */
    public void set_z(Coordinate _z) {
        this._z = _z;
    }

    /**Returns true if points are equal
     * @param o point3D
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return _x.equals( point3D._x) &&
                _y.equals( point3D._y) &&
                _x.equals( point3D._z);
    }

    /**toString
     * @return string
     */
    @Override
    public String toString() {

        return "Point3D{" +
                "_x=" + _x +
                ", _y=" + _y +
                ", _z=" + _z +
                '}';
    }

    /**Subtracts points to create a vector
     * @param _p Point3D
     * @return vector
     */
    public Vector subtract(Point3D _p)
    {
        double x=this._x._coord-_p._x._coord;
        double y=this._y._coord-_p._y._coord;
        double z=this._z._coord-_p._z._coord;
        return new Vector(new Point3D(x,y,z));
    }

    /**Adds a point to a vector creating a new vector
     * @param  _v Vector
     * @return vector
     */
    public Point3D add(Vector _v)
    {
        double x=this._x._coord+_v._p._x._coord;
        double y=this._y._coord+_v._p._y._coord;
        double z=this._z._coord+_v._p._z._coord;
        return new Point3D(x,y,z);
    }

    /**Returns the distance between two points squared
     * @param _p
     * @return double
     */
    public double distanceSquared(Point3D _p)
    {
        return (this._x._coord-_p._x._coord)*(this._x._coord-_p._x._coord)+(this._y._coord-_p._y._coord)*(this._y._coord-_p._y._coord)+(this._z._coord-_p._z._coord)*(this._z._coord-_p._z._coord);
    }

    /**Returns the distance between two points
     * @param _p
     * @return double
     */
    public  double distance(Point3D _p)
    {
        return Math.sqrt(distanceSquared(_p));
    }
}
