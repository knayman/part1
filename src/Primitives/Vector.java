package Primitives;

import java.io.PipedOutputStream;
import java.util.Objects;

public class Vector {
    Point3D _p;

    /**Constructor
     * @param _p point3D
     */
    public Vector(Point3D _p) {
    if(_p.equals(Point3D.ZERO))
    throw new IllegalArgumentException("Zero Vector");
        this._p = _p;
    }

    /**Constructor
     * @param _x Coordinate
     * @param _y Coordinate
     * @param _z Coordinate
     */
    public Vector(Coordinate _x,Coordinate _y,Coordinate _z) {

        if(_x._coord==0&&_y._coord==0&&_z._coord==0)
            throw new IllegalArgumentException("Zero Vector");
        this._p=new Point3D(_x,_y,_z);
    }

    /**Constructor
     * @param x double
     * @param y double
     * @param z double
     */
    public Vector( double x,double y,double z)
    {
        if(x==0&&y==0&&z==0)
            throw new IllegalArgumentException("Zero Vector");
        this._p=new Point3D(x,y,z);
    }

    /** Copy Constructor
     * @param _v Vector
     */
    public Vector(Vector _v) {

        _p =new Point3D(_v._p);
    }

    /**Get function
     * @return point3D
     */
    public Point3D get_p() {

        return _p;
    }

    /**Set function
     * @param _p point3D
     */
    public void set_p(Point3D _p) {
        this._p = _p;
    }

    /**Returns true if vectors are equal
     * @param o Vector
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return _p.equals(vector._p);
    }
    /**toString
     * @return string
     */
    @Override
    public String toString() {

        return "Vector{" +
                "_p=" + _p +
                '}';
    }

    /**Adds two vectors to create a new vector
     * @param vec Vector
     * @return Vector
     */
    public Vector add (Vector vec)
    {
        return new Vector(new Point3D(this._p.add(vec)));
    }

    /**Subtracts two vectors to create a new vector
     * @param vec Vector
     * @return Vector
     */
    public  Vector subtract(Vector vec)
    {
        return new Vector(new Point3D(this._p).subtract(vec._p));
    }

    /**Multiplies the vector by a scalar.
     * @param _s double
     * @return Vector
     */
    public Vector scale(double _s)
    {
        return new Vector(new Point3D(this._p.get_x()._coord*_s,this._p.get_y()._coord*_s,this._p.get_z()._coord*_s));
    }

    /**Returns dot product between two vectors
     * @param vec Vector
     *
     * @return double
     */
    public double dotProduct(Vector vec)
    {
        return this._p.get_x()._coord*vec._p.get_x()._coord+this._p.get_y()._coord*vec._p.get_y()._coord+this._p.get_z()._coord*vec._p.get_z()._coord;
    }

    /**Returns cross prodect between two vectors
     * @param vec Vector
     * @return Vector
     */
    public Vector crossProduct(Vector vec) {

        double _x = this._p.get_y()._coord * vec._p.get_z()._coord - vec._p.get_y()._coord * this._p.get_z()._coord;
        double _y = vec._p.get_x()._coord * this._p.get_z()._coord - this._p.get_x()._coord * vec._p.get_z()._coord;
        double _z = this._p.get_x()._coord * vec._p.get_y()._coord - vec._p.get_x()._coord * this._p.get_y()._coord;
        return new Vector(new Point3D(_x, _y, _z));
    }

    /**Returns the vector's length squared.
     * @return double
     */
    public double lengthSquared()
    {
        return this._p.distanceSquared(Point3D.ZERO);
    }

    /**Returns the vector's length.
     * @return double
     */
    public double length()
    {
        return Math.sqrt(this._p.distanceSquared(Point3D.ZERO));
    }

    /**Returns the vector normalized.
     * @return Vector
     */
    public Vector normalize()
    {
        double length=this.length();
        this._p.set_x(new Coordinate(this._p.get_x()._coord/length));
        this._p.set_y(new Coordinate(this._p.get_y()._coord/length));
        this._p.set_z(new Coordinate(this._p.get_z()._coord/length));
        return this;
    }

    /**Returns a normalized vector.
     * @return Vector
     */
    public Vector normalized()
    {
     return new Vector(new Coordinate(this._p.get_x()._coord/this.length()),new Coordinate(this._p.get_y()._coord/this.length()),new Coordinate(this._p.get_z()._coord/this.length()));
    }
}
