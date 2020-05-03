package unittests;

import Primitives.*;
import geometries.Geometries;
import org.junit.Test;
import geometries.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GeometriesTest {

    /**
     * Test method for finding intersections in geomtries.
     */
    @Test
    public void findIntersections() {
        // ============ Boundary Value Tests ==============
        //T01 Empty collection
        Geometries g=new Geometries();
        Ray r=new Ray(new Point3D(1,1,1),new Vector(0,3,4));
        List<Point3D> result=g.findIntersections(r);
        int size;
        if(result==null)
            size=0;
        else
            size=result.size();
        assertEquals("Expected empty list",0,size);

        Sphere s=new Sphere(1,new Point3D(1,0,0));
        Plane p=new Plane(new Point3D(5,1,0),new Point3D(5,0,1),new Point3D(5,0,0));
        Triangle t=new Triangle(new Point3D(8,0.5,0),new Point3D(8,-3,-5),new Point3D(8,-3,2));
        g.add(s,p,t);
        //T02 No intersection points
        Ray r1=new Ray(new Point3D(-1,0,0),new Vector(0,1,0));
        List<Point3D> result1=g.findIntersections(r1);
        int size1;
        if(result1==null)
            size1=0;
        else
            size1=result1.size();
        assertEquals("No intersection points expected",0,size1);
        //T03 Ray intersects one geometry
        Ray r2=new Ray(new Point3D(0,0,10),new Vector(1,0,0));
        List<Point3D> result2=g.findIntersections(r2);
        int size2;
        if(result2==null)
            size2=0;
        else
            size2=result2.size();
        assertEquals("Only one intersection point expected",1,size2);
        //T04 Ray intersects some of the geometries but not all
        Ray r3=new Ray(new Point3D(1,0.7,0),new Vector(1,0,0));
        List<Point3D> result3=g.findIntersections(r3);
        int size3;
        if(result3==null)
            size3=0;
        else
            size3=result3.size();
        assertEquals("Wrong number of intersection points",2,size3);
        //T05 Ray intersects with all of the geometries
        Ray r4=new Ray(new Point3D(-1,0,0),new Vector(1,0,0));
        List<Point3D> result4=g.findIntersections(r4);
        int size4;
        if(result4==null)
            size4=0;
        else
            size4=result4.size();
        assertEquals("Wrong number of intersection points",4,size4);
    }
}