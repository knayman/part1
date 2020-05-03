/**
 *
 */
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.*;
import Primitives.*;

import java.util.List;

/**
 * Testing Polygons
 * @author Dan
 *
 */
public class PolygonTest {

    /**
     * Test method for polygon
     *
     */
    @Test
    public void testConstructor() {
        // ============ Equivalence Partitions Tests ==============

        // TC01: Correct concave quadrangular with vertices in correct order
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(-1, 1, 1));
        } catch (IllegalArgumentException e) {
            fail("Failed constructing a correct polygon");
        }

        // TC02: Wrong vertices order
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(0, 1, 0),
                    new Point3D(1, 0, 0), new Point3D(-1, 1, 1));
            fail("Constructed a polygon with wrong order of vertices");
        } catch (IllegalArgumentException e) {}

        // TC03: Not in the same plane
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 2, 2));
            fail("Constructed a polygon with vertices that are not in the same plane");
        } catch (IllegalArgumentException e) {}

        // TC04: Concave quadrangular
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0.5, 0.25, 0.5));
            fail("Constructed a concave polygon");
        } catch (IllegalArgumentException e) {}

        // =============== Boundary Values Tests ==================

        // TC10: Vertix on a side of a quadrangular
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 0.5, 0.5));
            fail("Constructed a polygon with vertix on a side");
        } catch (IllegalArgumentException e) {}

        // TC11: Last point = first point
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 0, 1));
            fail("Constructed a polygon with vertice on a side");
        } catch (IllegalArgumentException e) {}

        // TC12: Collocated points
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 1, 0));
            fail("Constructed a polygon with vertice on a side");
        } catch (IllegalArgumentException e) {}

    }

    /**
     * Test method for polygan m=normanl
     */
    @Test
    public void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Polygon pl = new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0),
                new Point3D(-1, 1, 1));
        double sqrt3 = Math.sqrt(1d / 3);
        assertEquals("Wrong normal to triangle", new Vector(sqrt3, sqrt3, sqrt3), pl.getNormal(new Point3D(0, 0, 1)));
    }

    /**
     *Test method for polygon intersection points
     */
    @Test
    public void findIntersections()
    {
        Polygon poly=new Polygon(new Point3D(1,1,0),new Point3D(1,4,0), new Point3D(4,1,0));
        // ============ Equivalence Partitions Tests ==============
        // TC01 Intersection point inside polygon
     Ray r1=new Ray(new Point3D(2,2,-1),new Vector(0,0,1));
     List<Point3D> result1=poly.findIntersections(r1);
     assertEquals("Wrong number of intersection points",1,result1.size());

        // TC02 Intersection point outside polygon against edge
        Ray r2=new Ray(new Point3D(4,3,-1),new Vector(0,0,1));
        List<Point3D> result2=poly.findIntersections(r2);
        assertEquals("Wrong number of intersection points",0,result2.size());

        // TC03 Intersection point outside polygon against vertex
        Ray r3=new Ray(new Point3D(0.5,0.5,-1),new Vector(0,0,1));
        List<Point3D> result3=poly.findIntersections(r3);
        assertEquals("Wrong number of intersection points",0,result3.size());

        // ============ Boundary Value Tests ==============
        // TC04 Intersection point on the edge of the polygon
        Ray r4=new Ray(new Point3D(2,1,-1),new Vector(0,0,1));
        List<Point3D> result4=poly.findIntersections(r4);
        assertEquals("Wrong number of intersection points",0,result4.size());

        // TC05 Intersection point in vertex
        Ray r5=new Ray(new Point3D(1,1,-1),new Vector(0,0,1));
        List<Point3D> result5=poly.findIntersections(r5);
        assertEquals("Wrong number of intersection points",0,result5.size());

        // TC06 Intersection point on edges continuation
        Ray r6=new Ray(new Point3D(1,8,0),new Vector(0,0,1));
        List<Point3D> result6=poly.findIntersections(r6);
        assertEquals("Wrong number of intersection points",0,result6.size());
    }
}
