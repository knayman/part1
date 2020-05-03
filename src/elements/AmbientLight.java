package elements;
import Primitives.*;
import Primitives.Color;

public class AmbientLight {
    Primitives.Color Ia;
    Double Ka;
    Primitives.Color Ip;

    /**Constructor
     * @param ia
     * @param ka
     */
    public AmbientLight(Color ia, Double ka) {
        Ia = ia;
        Ka = ka;
        Ip=Ia.scale(ka);
    }

    /**Returns the ambient light intensity
     * @return Ia
     */
    public Color getIntensity()
    {
        return Ia;
    }
}
