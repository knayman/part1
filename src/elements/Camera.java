package elements;
import Primitives.*;


public class Camera {

    Point3D P0;
    Vector Vto;
    Vector Vup;
    Vector Vright;

    /**Get function for point
     * @return Point3D
     */
    public Point3D getPoint() {
        return P0;
    }

    /**Get function for Vto
     * @return Vector
     */
    public Vector getVto() {
        return Vto;
    }

    /**get function for Vup
     * @return Vector
     */
    public Vector getVup() {
        return Vup;
    }

    /**Get function for Vright
     * @return Vector
     */
    public Vector getVright() {
        return Vright;
    }

    /**Constructor
     * @param point
     * @param vto
     * @param vup
     */
    public Camera(Point3D point, Vector vto, Vector vup) {
        P0 = point;
        if(Util.isZero(vto.dotProduct(vup))){
            Vto = vto.normalize();
            Vup = vup.normalize();
            Vright=Vto.crossProduct(Vup);
        }
        else
            throw new IllegalArgumentException("Vectors are not orthogonal");
    }

    /**Construct ray through pixel of the plane in given point.
     * @param nX
     * @param nY
     * @param j
     * @param i
     * @param screenDistance
     * @param screenWidth
     * @param screenHeight
     * @return
     */
    public Ray constructRayThroughPixel (int nX, int nY, int j, int i, double screenDistance, double screenWidth, double screenHeight)
    {
        Point3D PC=new Point3D(P0.add(Vto.scale(screenDistance)));
        double Rx=screenWidth/nX;
        double Ry=screenHeight/nY;
        double yi=(i-(nY-1)/2d)*Ry;
        double xj=(j-(nX-1)/2d)*Rx;
        Point3D Pij=PC;
        if(!Util.isZero(xj)) Pij=Pij.add(Vright.scale(xj));
        if (!Util.isZero(yi)) Pij=Pij.add(Vup.scale(-yi));

        return new Ray (P0,Pij.subtract(P0));
    }

}
