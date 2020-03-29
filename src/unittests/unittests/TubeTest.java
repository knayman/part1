package unittests;

import Geometries.Cylinder;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import Geometries.Tube;
import org.junit.Test;

import static org.junit.Assert.*;

public class TubeTest {
    /**
     * Test method for normal to tube.
     */
    @Test
    public void getNormal()
    {
        Tube t = new Tube(1,new Ray(new Point3D(1.0,0.0,0.0), new Vector(0,1,0)));
        assertEquals("Wrong normal to Cylinder", new Vector(1.0, 0.0, 0.0), t.getNormal(new Point3D(2, 0, 0)));
    }

}