package Geometries;

import Primitives.*;


public class Triangle extends Polygon
{
    /**Constructor
     * @param vertices
     */
    public Triangle(Point3D... vertices) {
        super(vertices);
    }

    public Vector getNormal( Point3D _p)
    {
       return super.getNormal(_p);
    }
}
