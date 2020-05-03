package unittests;

import org.junit.Test;
import renderer.ImageWriter;
import Primitives.*;

import java.awt.*;
import java.awt.Color;

import static org.junit.Assert.*;

public class ImageWriterTest {

    @Test
    public void writePixel() {
        ImageWriter image=new ImageWriter("backgroundGrid2",1600,1000,800,500);
        for(int i=0;i<800;i++)
            for (int j=0;j<500;j++)
               if(i%50==0||j%50==0)
                  image.writePixel(i,j, new java.awt.Color(255,255,255));
               else
                   image.writePixel(i,j,new Color(255,0,0));

    image.writeToImage();
    }
}