package unittests;

import geometries.Sphere;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SphereTest {

    /**
     * Test method for normal to sphere.
     */
    @Test
    public void getNormal() {
        Sphere s = new Sphere(1, new Point3D(1, 0, 0));
        Vector check=new Vector(s.getNormal(new Point3D(2,0,0)));
        Vector check2=new Vector(1,0,0);
        assertEquals("Wrong normal to sphere",check,check2);
    }

    /**
     * Test method for sphere intersections
     */
    @Test
    public void findIntsersections() {

            Sphere sphere = new Sphere(1d, new Point3D(1, 0, 0));

            // ============ Equivalence Partitions Tests ==============

            // TC01: Ray's line is outside the sphere (0 points)
            assertEquals("Ray's line out of sphere", null, sphere.findIntersections(new Ray(new Point3D(-1, 0, 0), new Vector(1, 1, 0))));

            // TC02: Ray starts before and crosses the sphere (2 points)
            Point3D p1 = new Point3D(0.0651530771650466, 0.355051025721682, 0);
            Point3D p2 = new Point3D(1.53484692283495, 0.844948974278318, 0);
            List<Point3D> exp=List.of(p1,p2);
            List<Point3D> result = sphere.findIntersections(new Ray(new Point3D(-1, 0, 0), new Vector(3, 1, 0)));
            assertEquals("Wrong number of points", 2, result.size());
            if (result.get(0).get_x().get() > result.get(1).get_x().get())
                result = List.of(result.get(1), result.get(0));
            assertEquals("Ray crosses sphere", List.of(p1, p2), result);


        // TC03: Ray starts inside the sphere (1 point)
        List<Point3D> result03=sphere.findIntersections(new Ray(new Point3D(0.5, 0.5, 0), new Vector(3, 1, 0)));
        assertEquals(  "Ray from inside sphere",List.of(p2),result03);

        // TC04: Ray starts after the sphere (0 points)
        assertNull("Sphere behind Ray",sphere.findIntersections(new Ray(new Point3D(2, 1, 0), new Vector(3, 1, 0))));
            // =============== Boundary Values Tests ==================

        // =============== Boundary Values Tests ==================
        // **** Group: Ray's line crosses the sphere (but not the center)

        // TC05: Ray starts at sphere and goes inside (1 points)
        assertEquals(  "Ray from sphere inside",List.of(new Point3D(2, 0, 0)),
                sphere.findIntersections(new Ray(new Point3D(1, -1, 0), new Vector(1, 1, 0)))
               );

        // TC06: Ray starts at sphere and goes outside (0 points)
        assertNull( "Ray from sphere outside",sphere.findIntersections(new Ray(new Point3D(2, 0, 0), new Vector(1, 1, 0)))
               );

        // **** Group: Ray's line goes through the center
        // TC07: Ray starts before the sphere (2 points)
        result = sphere.findIntersections(new Ray(new Point3D(1, -2, 0), new Vector(0, 1, 0)));

        assertEquals( "Wrong number of points",2, result.size());
        if (result.get(0).get_y().get() > result.get(1).get_y().get()) {
            result = List.of(result.get(1), result.get(0));
        }
        assertEquals("Line through O, ray crosses sphere",List.of(new Point3D(1, -1, 0), new Point3D(1, 1, 0)), result);

        // TC08: Ray starts at sphere and goes inside (1 points)
        assertEquals( "Line through O, ray from and crosses sphere", List.of(new Point3D(1, 1, 0)),
                sphere.findIntersections(new Ray(new Point3D(1, -1, 0), new Vector(0, 1, 0))));

        // TC09: Ray starts inside (1 points)
        assertEquals( "Line through O, ray from inside sphere", List.of(new Point3D(1, 1, 0)),
                sphere.findIntersections(new Ray(new Point3D(1, 0.5, 0), new Vector(0, 1, 0))));

        // TC10: Ray starts at the center (1 points)
        assertEquals(  "Line through O, ray from O",List.of(new Point3D(1, 1, 0)),
                sphere.findIntersections(new Ray(new Point3D(1, 0, 0), new Vector(0, 1, 0))));

        // TC11: Ray starts at sphere and goes outside (0 points)
        assertNull("Line through O, ray from sphere outside",sphere.findIntersections(new Ray(new Point3D(1, 1, 0), new Vector(0, 1, 0)))
                );

        // TC12: Ray starts after sphere (0 points)
        assertNull("Line through O, ray outside sphere",sphere.findIntersections(new Ray(new Point3D(1, 2, 0), new Vector(0, 1, 0)))
                );

        // **** Group: Ray's line is tangent to the sphere (all tests 0 points)
        // TC13: Ray starts before the tangent point
        assertNull("Tangent line, ray before sphere",sphere.findIntersections(new Ray(new Point3D(0, 1, 0), new Vector(1, 0, 0)))
                );

        // TC14: Ray starts at the tangent point
        assertNull("Tangent line, ray at sphere",sphere.findIntersections(new Ray(new Point3D(1, 1, 0), new Vector(1, 0, 0)))
                );

        // TC15: Ray starts after the tangent point
        assertNull("Tangent line, ray after sphere",sphere.findIntersections(new Ray(new Point3D(2, 1, 0), new Vector(1, 0, 0))) );

        // **** Group: Special cases
        // TC16: Ray's line is outside, ray is orthogonal to ray start to sphere's
        // center line
        assertNull("Ray orthogonal to ray head -> O line",sphere.findIntersections(new Ray(new Point3D(-1, 0, 0), new Vector(0, 0, 1))));
        }


    }


