package unittests;

import Geometries.Sphere;
import Primitives.Point3D;
import Primitives.Vector;
import org.junit.Test;

import static org.junit.Assert.*;

public class SphereTest {

    @Test
    public void getNormal() {
        Sphere s = new Sphere(1, new Point3D(1, 0, 0));
        Vector check=new Vector(s.getNormal(new Point3D(2,0,0)));
        Vector check2=new Vector(1,0,0);
        assertEquals("Wrong normal to sphere",check,check2);
    }
}
//(new Vector(1,0,0)).equals(s.getNormal(new Point3D(2,0,0)))

