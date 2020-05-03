package unittests;

import org.junit.Test;

import static org.junit.Assert.*;
import Primitives.*;


public class VectorTest {

    /**
     * Test method for adding two vectors
     */
    @Test
    public void add() {
        // ============ Equivalence Partitions Tests ==============
        Vector v1 = new Vector(1, 1, 1);
        Vector v2 = new Vector(1, 1, 1);
        v1 = v1.add(v2);
        assertEquals("add() wrong result",(new Vector(2, 2, 2)),v1);

        Vector v3 = new Vector(-1, -1, -1);
        Vector v4 = new Vector(-1, -1, -1);
        v3 = v3.add(v4);
       assertEquals("add() wrong result",new Vector(-2, -2, -2),v3);

        Vector v5 = new Vector(2, 2, 2);
        Vector v6 = new Vector(-1, -1, -1);
        v5 = v5.add(v6);
        assertEquals("add() wrong result",new Vector(1, 1, 1),v5);

        Vector v7 = new Vector(-1, -1, -1);
        Vector v8 = new Vector(2, 2, 2);
        v7 = v7.add(v8);
        assertEquals("add() wrong result",new Vector(1, 1, 1),v7);

        // =============== Boundary Values Tests ==================
        try {
            Vector v9=new Vector(-1,-1,-1);
            Vector v10=new Vector(1,1,1);
            v9.add(v10);
            fail("Vector (0,0,0) not valid");
        }
        catch  (IllegalArgumentException e)
        {
            assertTrue(e.getMessage()!= null);
        }
    }

    /**
     *Test method for subtracting two vectors
     */
    @Test
    public void subtract()
    {
        // ============ Equivalence Partitions Tests ==============
        Vector v1 = new Vector(2, 2, 2);
        Vector v2 = new Vector(1, 1, 1);
        v1 = v1.subtract(v2);
        assertEquals("subtract() wrong result",(new Vector(1, 1, 1)),v1);

        Vector v3 = new Vector(-2, -2, -2);
        Vector v4 = new Vector(-1, -1, -1);
        v3 = v3.subtract(v4);
        assertEquals("subtract() wrong result",new Vector(-1, -1, -1),v3);

        Vector v5 = new Vector(2, 2, 2);
        Vector v6 = new Vector(-1, -1, -1);
        v5 = v5.subtract(v6);
        assertEquals("subtract() wrong result",new Vector(3, 3, 3),v5);

        Vector v7 = new Vector(-1, -1, -1);
        Vector v8 = new Vector(2, 2, 2);
        v7 = v7.subtract(v8);
        assertEquals("subtract() wrong result",new Vector(-3, -3, -3),v7);

        // =============== Boundary Values Tests ==================
        try {
            Vector v9=new Vector(1,1,1);
            Vector v10=new Vector(1,1,1);
            v9.subtract(v10);
            fail("Vector (0,0,0) not valid");
        }
        catch  (IllegalArgumentException e)
        {
            assertTrue(e.getMessage()!= null);
        }
    }

    /**
     * Test method for scale function
     */
    @Test
    public void scale()
    {
        // ============ Equivalence Partitions Tests ==============
        Vector v1=new Vector(1,1,1);
        v1=v1.scale(-1);
        assertEquals("scale() wrong result",new Vector(-1,-1,-1),v1);
        Vector v2=new Vector(1,1,1);
        v2=v2.scale(2);
        assertEquals("scale() wrong result",new Vector(2,2,2),v2);
        Vector v3=new Vector(-1,-1,-1);
        v3=v3.scale(2);
        assertEquals(new Vector(-2,-2,-2),v3);
        Vector v4=new Vector(-1,-1,-1);
        v4=v4.scale(-1);
        assertEquals("scale() wrong result",new Vector(1,1,1),v4);

        // =============== Boundary Values Tests ==================
        try {
            Vector v9=new Vector(-1,-1,-1);
            v9.scale(0);
            fail("Vector (0,0,0) not valid");
        }
        catch  (IllegalArgumentException e)
        {
            assertTrue(e.getMessage()!= null);
        }
    }


    /**
     * Test method for dot product between two vectors
     */
    @Test
    public void dotProduct()
    {
        // ============ Equivalence Partitions Tests ==============
        Vector v1 = new Vector(1, 1, 1);
        Vector v2 = new Vector(1, 1, 1);
        assertTrue("ERROR: dotProduct() wrong value",(Double.compare(v1.dotProduct(v2),(1+1+1))==0));

        Vector v3 = new Vector(-1, -1, -1);
        Vector v4 = new Vector(-1, -1, -1);
        assertTrue("ERROR: dotProduct() wrong value",(Double.compare(v3.dotProduct(v4),(1+1+1))==0));

        Vector v5 = new Vector(2, 2, 2);
        Vector v6 = new Vector(-1, -1, -1);
        assertTrue("ERROR: dotProduct() wrong value",(Double.compare(v5.dotProduct(v6),(-2+-2+-2))==0));

        Vector v7 = new Vector(-1, -1, -1);
        Vector v8 = new Vector(2, 2, 2);
        assertTrue("ERROR: dotProduct() wrong value",(Double.compare(v7.dotProduct(v8),(-2+-2+-2))==0));

        Vector v9=new Vector(1,0,1);
        Vector v10=new Vector(-1,0,1);
        assertTrue("ERROR: dotProduct() for orthogonal vectors is not zero",(Double.compare(v9.dotProduct(v10),0))==0);

        // =============== Boundary Values Tests ==================
        try {
            Vector v11=new Vector(-1,2,0);
            Vector v12=new Vector(2,1,0);
            v11.dotProduct((v12));
            fail("Vector (0,0,0) not valid");
        }
        catch  (IllegalArgumentException e)
        {
            assertTrue(e.getMessage()!= null);
        }
    }


    /**
     * Test method for cross product between two vectors
     */
    @Test
    public void crossProduct()
    {
        // ============ Equivalence Partitions Tests ==============
        Vector v1 = new Vector(1, 1, 1);
        Vector v2 = new Vector(1,2,3);
        Vector tmp1=new Vector(v1);
        v1 = v1.crossProduct(v2);
        assertEquals("ERROR: crossProduct() result is not orthogonal to its operands",(Double.compare(v1.dotProduct(v2),0))==0);
        assertEquals("ERROR: crossProduct() result is not orthogonal to its operands",(Double.compare(v1.dotProduct(tmp1),0))==0);
        assertEquals("ERROR: crossProduct() wrong result length",(new Vector(1, -2,1)),v1);

        Vector v3 = new Vector(-1, -1, -1);
        Vector v4 = new Vector(-1, -2, -3);
        Vector tmp2=new Vector(v3);
        v3= v3.crossProduct(v4);
        assertEquals("ERROR: crossProduct() result is not orthogonal to its operands",(Double.compare(v3.dotProduct(v4),0))==0);
        assertEquals("ERROR: crossProduct() result is not orthogonal to its operands",(Double.compare(v3.dotProduct(tmp2),0))==0);
        assertEquals("ERROR: crossProduct() wrong result length",new Vector(1,-2,1),v3);

        Vector v5 = new Vector(1, 1, 1);
        Vector v6 = new Vector(-1, -2, -3);
        Vector tmp3=new Vector(v5);
        v5 = v5.crossProduct(v6);
        assertEquals("ERROR: crossProduct() result is not orthogonal to its operands",(Double.compare(v5.dotProduct(v6),0))==0);
        assertEquals("ERROR: crossProduct() result is not orthogonal to its operands",(Double.compare(v5.dotProduct(tmp3),0))==0);
        assertEquals("ERROR: crossProduct() wrong result length",new Vector(-1,2,-1),v5);

        Vector v7 = new Vector(-1, -1, -1);
        Vector v8 = new Vector(1, 2, 3);
        Vector tmp4=new Vector(v7);
        v7 = v7.crossProduct(v8);
        assertEquals("ERROR: crossProduct() result is not orthogonal to its operands",(Double.compare(v7.dotProduct(v8),0))==0);
        assertEquals("ERROR: crossProduct() result is not orthogonal to its operands",(Double.compare(v7.dotProduct(tmp4),0))==0);
        assertEquals("ERROR: crossProduct() wrong result length",new Vector(-1, 2, -2),v7);

        // =============== Boundary Values Tests ==================
        try {
            Vector v9=new Vector(-1,-1,-1);
            Vector v10=new Vector(-2,-2,-2);
            Vector v11=v9.crossProduct(v10);
            fail("Vector (0,0,0) not valid");
        }
        catch  (IllegalArgumentException e)
        {
            assertTrue(e.getMessage()!= null);
        }
    }


    /**
     * Test method for vector length squared
     */
    @Test
    public void lengthSquared()
    {
        // ============ Equivalence Partitions Tests ==============
        Vector v1=new Vector(1,1,1);
        assertTrue("ERROR: lengthSquared() wrong value",Double.compare(v1.lengthSquared(),3)==0);
        Vector v2=new Vector(-1,-1,-1);
        assertTrue("ERROR: lengthSquared() wrong value",Double.compare(v2.lengthSquared(),3)==0);


    }

    /**
     * Test method for vector length
     */
    @Test
    public void length()
    {
        // ============ Equivalence Partitions Tests ==============
        Vector v1=new Vector(1,1,1);
        assertTrue("ERROR: crossProduct() wrong result length",Double.compare(v1.length(),Math.sqrt(3))==0);
        Vector v2=new Vector(-1,-1,-1);
        assertTrue("ERROR: crossProduct() wrong result length",Double.compare(v2.length(),Math.sqrt(3))==0);
    }

    /**
     * Test method for normalize function
     */
    @Test
    public void normalize()
    {
        // ============ Equivalence Partitions Tests ==============
        Vector v1=new Vector(2,0,0);
        v1.normalize();
        assertEquals("ERROR: normalize result is not a unit vector",1,v1.length(),1e-10);
        Vector v2=new Vector(-2,0,0);
        v2.normalize();
         assertEquals("ERROR: normalize() result is not a unit vector",1,v2.length(),1e-10);


    }

    /**
     * Test method for normalized function
     */
    @Test
    public void normalized()
    {
        // ============ Equivalence Partitions Tests ==============
        Vector v1=new Vector(2,0,0);
        Vector v2=v1.normalized();
        assertTrue("ERROR: normalizated() function does not create a new vector",!v2.equals(v1));
        assertEquals("ERROR: normalized() result is not a unit vector",1, v2.length(),1e-10);
        Vector v3=new Vector(-2,0,0);
        Vector v4=v3.normalized();
        assertTrue("ERROR: normalizated() function does not create a new vector",!v4.equals(v3));
        assertEquals("ERROR: normalized() result is not a unit vector",1,v4.length(),1e-10);
    }
}

