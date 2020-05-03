package unittests;

import geometries.Plane;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PlaneTest {

    /**
     * Test method for normal to a plane
     */
    @Test
    public void getNormal() {
        Vector v = new Vector(1, 1, 1);
        Point3D p = new Point3D(2, 2, 2);
        Plane plane = new Plane(p, v);
        Vector normal = new Vector(plane.getNormal(p));
        assertEquals(v, normal.scale(-1));
    }


    /**
     * Test method for plane intersection points
     */
    @Test
    public void findIntersections() {
        Plane p = new Plane(new Point3D(5,0,0), new Vector(1, 0, 0));
        // ============ Equivalence Partitions Tests ==============

        //TC01 Ray intersects the plane
        Ray r1 = new Ray(new Point3D(-1, 0, 0), new Vector(1.5, 0, 0));
        List<Point3D> result1 = p.findIntersections(r1);
        assertEquals("Wrong number of intersection points", 1, result1.size());

        //TC02 Ray doesn't intersect the plane
        Ray r2 = new Ray(new Point3D(-1, 0, 0), new Vector(-1.5, 0, 0));
        List<Point3D> result2 = p.findIntersections(r2);
        int size;
        if(result2==null)
            size=0;
        else
            size=result2.size();
        assertEquals("Wrong number of intersection points", 0,size );
        // =============== Boundary Values Tests ==================

        //****Group :Parallel to plane.
        //TC03 Ray included in the plane
        Ray r3 = new Ray(new Point3D(5, 0, 0), new Vector(0, 1, 0));
        List<Point3D> result3 = p.findIntersections(r3);
        if(result3==null)
            size=0;
        else
            size=result3.size();
        assertEquals("Wrong number of intersection points", 0, size);

        //TC04 Ray not included in the plane
        Ray r4 = new Ray(new Point3D(-1, 0, 0), new Vector(0, 1, 0));
        List<Point3D> result4 = p.findIntersections(r4);
        if(result4==null)
            size=0;
        else
            size=result4.size();
        assertEquals("Wrong number of intersection points", 0, size);

        //***Group :Orthogonal to plane

        //TC05 Ray begins before plane
        Ray r5 = new Ray(new Point3D(-1, 0, 0), new Vector(1, 0, 0));
        List<Point3D> result5 = p.findIntersections(r5);
        assertEquals("Wrong number of intersection points", 1, result5.size());

        //TC06 Ray begins in the plane
        Ray r6 = new Ray(new Point3D(5, 1, 0), new Vector(1, 0, 0));
        List<Point3D> result6 = p.findIntersections(r6);
        if(result6==null)
            size=0;
        else
            size=result2.size();
        assertEquals("Wrong number of intersection points", 0, size);

        //TC07 Ray begins after plane
        Ray r7 = new Ray(new Point3D(6, 0, 0), new Vector(1, 0, 0));
        List<Point3D> result7 = p.findIntersections(r7);
        if(result7==null)
            size=0;
        else
            size=result7.size();
        assertEquals("Wrong number of intersection points", 0,size);

        //****Group: Special cases
        //TC08 Ray begins on the point that defines the plane but is not parallel or orthogonal
        Ray r8 = new Ray(new Point3D(5, 0, 0), new Vector(3, 5, 6));
        List<Point3D> result8 = p.findIntersections(r8);
        if(result8==null)
            size=0;
        else
            size=result8.size();
        assertEquals("Wrong number of intersection points", 0, size);

        //TC09 Ray begins on the plane but is not parallel or orthogonal
        Ray r9 = new Ray(new Point3D(5, 1, 3), new Vector(3, 5, 6));
        List<Point3D> result9 = p.findIntersections(r9);
        if(result9==null)
            size=0;
        else
            size=result9.size();
        assertEquals("Wrong number of intersection points", 0, size);
    }
}
