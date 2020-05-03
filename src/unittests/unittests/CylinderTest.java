package unittests;

import geometries.Cylinder;
import org.junit.Test;
import Primitives.*;

import static org.junit.Assert.*;


public class CylinderTest {

    /**
     * Test method for normal to cylinder.
     */
    @Test
    public void getNormal()
    {
        Cylinder t = new Cylinder(new Ray(new Point3D(1,0,0), new Vector(0,1,0)),1, 1);
        assertEquals("Wrong normal to Cylinder", new Vector(0, 1, 0), t.getNormal(new Point3D(2, 0, 0)));
    }
}