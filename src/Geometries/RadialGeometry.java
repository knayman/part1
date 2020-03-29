package Geometries;

abstract public class RadialGeometry implements Geometry {
   private double radius;

    /**Constructor
     * @param radius Double
     */
    public RadialGeometry(double radius) {

        this.radius = radius;
    }

    /**Get function
     * @return radius
     */
    public double getRadius() {
        return radius;
    }

    /**toString
     * @return string
     */
    @Override
    public String toString() {
        return "RadialGeometry{" +
                "radius=" + radius +
                '}';
    }


}
