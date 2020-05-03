package renderer;

import Primitives.Color;
import Primitives.Point3D;
import Primitives.Ray;
import scene.Scene;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import geometries.*;
import elements.*;

public class Render {
    private ImageWriter _imageWriter;
    private Scene _scene;

    /**Constructor
     * @param _imageWriter
     * @param _scene
     */
    public Render(ImageWriter _imageWriter, Scene _scene) {
        this._imageWriter = _imageWriter;
        this._scene = _scene;
    }

// ***************** Getters ********************** //

    public ImageWriter get_imageWriter() {
        return _imageWriter;
    }

    public Scene get_scene() {
        return _scene;
    }

    /**
     *Creates rays through pixels and colors the pixel according to the intersection points.
     */
    public void renderImage() {
        Camera camera = _scene.get_camera();
        Intersectable geometries = _scene.get_geometries();
        java.awt.Color background = _scene.get_background().getColor();
        int nX = _imageWriter.getNx();
        int nY=_imageWriter.getNy();
        double distance=_scene.get_distance();
        double width=_imageWriter.getWidth();
        double height=_imageWriter.getHeight();
        Ray ray;
        List<Point3D> intersectionPoints=new ArrayList<Point3D>();
        for(int i=0;i<_imageWriter.getNx();i++) // i is pixel row number and j is pixel in the row number
            for(int j=0;j<_imageWriter.getNy();j++) {
                ray = camera.constructRayThroughPixel(nX, nY, j, i, distance, width, height);
                intersectionPoints = geometries.findIntersections(ray);
                if (intersectionPoints.size() == 0)
                    _imageWriter.writePixel(j, i, background);
                else {
                    Point3D closestPoint = getClosestPoint(intersectionPoints);
                    _imageWriter.writePixel(j, i, calcColor(closestPoint).getColor());
                }
            }
    }


    /**Calculates the closest intersection point to camera.
     * @param points
     * @return
     */
   public Point3D getClosestPoint(List<Point3D> points)
   {
     double distance=Double.MAX_VALUE;
     Point3D p0=_scene.get_camera().getPoint();
     Point3D minDistancePoint=null;
     for(Point3D point: points)
         if(p0.distance(point)<distance) {
             minDistancePoint = new Point3D(point);
             distance = p0.distance(point);
         }
     return minDistancePoint;
   }


    /**Calculates the color in given point.
     * @param point
     * @return
     */
    private Color calcColor(Point3D point) {
        return _scene.get_ambientLight().getIntensity();}

    /**Prints the grid
     * @param interval
     * @param color
     */
    public void printGrid(int interval, java.awt.Color color)
    {
        for(int i=0; i<_imageWriter.getWidth(); i++)
            for(int j=0; j<_imageWriter.getHeight(); j++) {
                if (i % interval == 0 || j % interval == 0)
                    _imageWriter.writePixel(i, j, color);
            }
    }
}
