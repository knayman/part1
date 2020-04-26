package unittests;

import Primitives.*;
import elements.Camera;
import geometries.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CameraIntegrationTest {

    /**
     *Integration test of camera ray construction with ray sphere intersection.
     */
    @Test
    public void constructRayThroughSphere() {
        int count;
        Sphere s;
        List<Point3D> intersections;
        Camera camera;
        //T01 Two intersection points- small sphere.
        s=new Sphere(1, new Point3D(0,0,3));
        camera=new Camera(Point3D.ZERO,new Vector(0,0,1),new Vector(0,-1,0));
       count=0;
       for(int i=0;i<3;i++)
           for(int j=0;j<3;j++)
           {
               intersections=s.findIntersections(camera.constructRayThroughPixel(3,3,j,i,1,3,3));
               if(intersections!=null)
                   count+=intersections.size();
           }

       assertEquals("Wrong number of intersection points",2,count);

           //T02 Eighteen Intersection points-big sphere.
        s=new Sphere(2.5,new Point3D(0,0,2.5));
        camera=new Camera(new Point3D(0,0,-0.5),new Vector(0,0,1),new Vector(0,-1,0));
        count=0;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                intersections=s.findIntersections(camera.constructRayThroughPixel(3,3,j,i,1,3,3));
                if(intersections!=null)
                    count+=intersections.size();
            }
        assertEquals("Wrong number of intersection points",18,count);

            //Test 03 Ten intersection points.
        s=new Sphere(2,new Point3D(0,0,2));
        camera=new Camera(new Point3D(0,0,-0.5),new Vector(0,0,1),new Vector(0,-1,0));
        count=0;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                intersections=s.findIntersections(camera.constructRayThroughPixel(3,3,j,i,1,3,3));
                if(intersections!=null)
                    count+=intersections.size();
            }
        assertEquals("Wrong number of intersection points",10,count);

        //Test 04 Nine intersection points- camera inside sphere
        s=new Sphere(4,new Point3D(0,0,0.5));
        camera=new Camera(new Point3D(0,0,-0.5),new Vector(0,0,1),new Vector(0,-1,0));
        count=0;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                intersections=s.findIntersections(camera.constructRayThroughPixel(3,3,j,i,1,3,3));
                if(intersections!=null)
                    count+=intersections.size();
            }
        assertEquals("Wrong number of intersection points",9,count);

        //Test 05 Zero intersection points-camera behind sphere.
        s=new Sphere(0.5,new Point3D(0,0,-1));
        camera=new Camera(Point3D.ZERO,new Vector(0,0,1),new Vector(0,-1,0));
        count=0;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                intersections=s.findIntersections(camera.constructRayThroughPixel(3,3,j,i,1,3,3));
                if(intersections!=null)
                    count+=intersections.size();
            }
        assertEquals("Wrong number of intersection points",0,count);
    }

    /**
     *Integration test of camera ray construction with ray plane intersection.
     */
    @Test
    public void constructRayThroughPlane() {
        int count;
        Plane p;
        List<Point3D> intersections;
        Camera camera=new Camera(Point3D.ZERO,new Vector(0,0,1),new Vector(0,-1,0));

        //T01 Nine intersection points-plane against camera.
        p=new Plane(new Point3D(0,0,3),new Vector(0,0,1));
        count=0;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                intersections=p.findIntersections(camera.constructRayThroughPixel(3,3,j,i,1,3,3));
                if(intersections!=null)
                    count+=intersections.size();
            }
        assertEquals("Wrong number of intersection points",9,count);

        //T02 Nine intersection points-plane with small angle.
        p=new Plane(new Point3D(0,0,5),new Vector(0,-1,2));
        count=0;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                intersections=p.findIntersections(camera.constructRayThroughPixel(3,3,j,i,1,3,3));
                if(intersections!=null)
                    count+=intersections.size();
            }
        assertEquals("Wrong number of intersection points",9,count);

        //T03 Six intersection points.
        p=new Plane(new Point3D(0,0,5),new Vector(0,1,1));
        count=0;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                intersections=p.findIntersections(camera.constructRayThroughPixel(3,3,j,i,1,3,3));
                if(intersections!=null)
                    count+=intersections.size();
            }
        assertEquals("Wrong number of intersection points",6,count);

        //T04 Zer0 intersection points.
        p=new Plane(new Point3D(0,0,-1),new Vector(0,0,1));
        count=0;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                intersections=p.findIntersections(camera.constructRayThroughPixel(3,3,j,i,1,3,3));
                if(intersections!=null)
                    count+=intersections.size();
            }
        assertEquals("Wrong number of intersection points",0,count);





    }

    /**
     *Integration test of camera ray construction with ray triangle intersection.
     */
    @Test
    public void constructRayThroughTriangle() {
        int count;
        Triangle t;
        List<Point3D> intersections;
        Camera camera=new Camera(Point3D.ZERO,new Vector(0,0,1),new Vector(0,-1,0));

        //T01 One intersection point.
        t=new Triangle((new Point3D(0,-1,2)),new Point3D(1,1,2),new Point3D(-1,1,2));
        count=0;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                intersections=t.findIntersections(camera.constructRayThroughPixel(3,3,j,i,1,3,3));
                if(intersections!=null)
                    count+=intersections.size();
            }
        assertEquals("Wrong number of intersection points",1,count);

            //T02 Two intersection points.
        t=new Triangle((new Point3D(0,-20,2)),new Point3D(1,1,2),new Point3D(-1,1,2));
        count=0;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                intersections=t.findIntersections(camera.constructRayThroughPixel(3,3,j,i,1,3,3));
                if(intersections!=null)
                    count+=intersections.size();
            }
        assertEquals("Wrong number of intersection points",2,count);

            //T03 Zero intersections points.
        t=new Triangle((new Point3D(0,-1,-2)),new Point3D(1,1,-2),new Point3D(-1,1,-2));
        count=0;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                intersections=t.findIntersections(camera.constructRayThroughPixel(3,3,j,i,1,3,3));
                if(intersections!=null)
                    count+=intersections.size();
            }
        assertEquals("Wrong number of intersection points",0,count);
        }


}