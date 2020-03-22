package Geometries;

import Primitives.Point3D;
import Primitives.Vector;

public class Cylinder extends RadialGeometry {

    private double _h;

    /**
     * Constructor
     *
     * @param radius double
     * @param height double
     */
    public Cylinder(double radius, double height) {
        super(radius);
        _h = height;
    }


    /**
     * Returns normal to the point received.
     *
     * @return vector
     */
    public Vector getNormal(Point3D _p) {
        return null;
    }
}