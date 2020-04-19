package geometries;

import Primitives.Point3D;
import Primitives.Ray;

import java.util.ArrayList;
import java.util.List;

public class Geometries implements Intersectable{

    List<Intersectable> lst;

    /**Constructor
     * We chose an array list because it is easier for iteration.
     */
    public Geometries(Intersectable...geometries)
    {
        if(lst==null)
            this.lst = new ArrayList<Intersectable>();
        else
            for (Intersectable g:geometries) {
                lst.add(g);

            }
    }

    /**adds geometries to list
     * @param geometries
     */
    public void add(Intersectable... geometries) {
        for (Intersectable g : geometries) {
            lst.add(g);
        }
    }

    /**Finds intersection points with geometries.
     * @param ray
     * @return
     */
    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Primitives.Point3D> intersections=new ArrayList<Primitives.Point3D>();
        List<Point3D> tmp=new ArrayList<Point3D>();
        for (Intersectable g: lst) {
            tmp=g.findIntersections(ray);
               if(tmp!=null)
                   intersections.addAll(g.findIntersections(ray));
        }
        return intersections;
    }
}
