package unittests;

import Geometries.Plane;
import Primitives.Point3D;
import Primitives.Vector;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void getNormal() {
        Vector v = new Vector(1, 1, 1);
        Point3D p = new Point3D(2, 2, 2);
        Plane plane = new Plane(p, v);
        Vector normal = new Vector(plane.getNormal(p));
        assertEquals(v.scale(-1), normal);
    }
    }


