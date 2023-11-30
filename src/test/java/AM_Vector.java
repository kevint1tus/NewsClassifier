import org.junit.jupiter.api.*;
import uob.oop.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AM_Vector {
    private Vector myVector1 = new Vector(new double[]{1.123422145532, -1284723.120, 99.99999, 32.231, -185.0, -632.0});
    private Vector myVector2 = new Vector(new double[]{0.0, 112.2343578, 0.32133, -300.4, 89.215, 0.0});
    private Vector myVector3 = new Vector(new double[]{0.0, 0.0, 0.0});
    private Vector myVector4 = new Vector(new double[]{14.01, 22.2123, -3.34, 324.5, 5.5, 6.6, 7.7, 8.8, 9.9, 0.0});
    private Vector myVector5 = new Vector(new double[]{0.0});
    private Vector myVector6 = new Vector(new double[]{0.0, 0.0, 0.0, 0.0});
    private Vector myVector7 = new Vector(new double[]{14.01, 22.2123, -3.34, 324.5, 5.5, 6.6, 7.7, 8.8, 9.9, 0.0});
    private Vector myVector8 = new Vector(new double[]{0.0, 0.0, 1.0, 0.0});
    public static double doubMarks = 0;

    @Test
    @Order(1)
    void VectorConstructor() { //0.5
        assertEquals("1.12342,-1284723.12000,99.99999,32.23100,-185.00000,-632.00000", myVector1.toString());
        assertEquals("0.00000,112.23436,0.32133,-300.40000,89.21500,0.00000", myVector2.toString());
        assertEquals("0.00000,0.00000,0.00000", myVector3.toString());
        assertEquals("0.00000", myVector5.toString());
        doubMarks += 0.5;
    }

    @Test
    @Order(2)
    void getElementatIndex() { //2.0
        assertEquals(1.123422145532, myVector1.getElementatIndex(0));
        assertEquals(-300.4, myVector2.getElementatIndex(3));
        assertEquals(0.0, myVector3.getElementatIndex(2));
        assertEquals(-1, myVector3.getElementatIndex(3));
        doubMarks += 2.0;
    }

    @Test
    @Order(3)
    void setElementatIndex() { //2.0
        Vector myVector = new Vector(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0});
        myVector.setElementatIndex(7.0, -1);
        assertEquals(7.0, myVector.getElementatIndex(5));
        myVector.setElementatIndex(7.0, 0);
        assertEquals(7.0, myVector.getElementatIndex(0));
        myVector.setElementatIndex(-7.0, 5);
        assertEquals(-7.0, myVector.getElementatIndex(5));
        doubMarks += 2.0;
    }

    @Test
    @Order(4)
    void getAllElements() { //0.5
        assertEquals(0.0, myVector3.getAllElements()[0]);
        assertEquals(22.2123, myVector4.getAllElements()[1]);
        assertEquals(-3.34, myVector4.getAllElements()[2]);
        doubMarks += 0.5;
    }

    @Test
    @Order(5)
    void getVectorSize() { //0.5
        assertEquals(6.0, myVector1.getVectorSize());
        assertEquals(6.0, myVector2.getVectorSize());
        assertEquals(1.0, myVector5.getVectorSize());
        doubMarks += 0.5;
    }

    @Test
    @Order(6)
    void reSize() { //6.0
        assertEquals("1.12342,-1284723.12000", myVector1.reSize(2).toString());
        assertEquals("1.12342,-1284723.12000,99.99999,32.23100,-185.00000,-632.00000,-1.00000,-1.00000,-1.00000,-1.00000", myVector1.reSize(10).toString());
        assertEquals("1.12342,-1284723.12000,99.99999,32.23100,-185.00000,-632.00000", myVector1.reSize(6).toString());
        assertEquals("1.12342,-1284723.12000,99.99999,32.23100,-185.00000,-632.00000", myVector1.reSize(0).toString());
        assertEquals("1.12342,-1284723.12000,99.99999,32.23100,-185.00000,-632.00000", myVector1.reSize(-1).toString());
        doubMarks += 6.0;
    }

    @Test
    @Order(7)
    void add_SameSize() { //1.0
        assertEquals("1.12342,-1284610.88564,100.32132,-268.16900,-95.78500,-632.00000", myVector1.add(myVector2).toString());
        doubMarks += 1.0;
    }

    @Test
    @Order(8)
    void add_DifferentSize() { //1.0
        assertEquals("1.12342,-1284723.12000,99.99999,31.23100,-186.00000,-633.00000", myVector1.add(myVector3).toString());
        assertEquals("14.01000,134.44666,-3.01867,24.10000,94.71500,6.60000,6.70000,7.80000,8.90000,-1.00000", myVector2.add(myVector4).toString());
        doubMarks += 1.0;
    }

    @Test
    @Order(9)
    void subtraction_SameSize() { //1.0
        assertEquals("1.12342,-1284835.35436,99.67866,332.63100,-274.21500,-632.00000", myVector1.subtraction(myVector2).toString());
        doubMarks += 1.0;
    }

    @Test
    @Order(10)
    void subtraction_DifferentSize() { //1.0
        assertEquals("1.12342,-1284723.12000,99.99999,33.23100,-184.00000,-631.00000", myVector1.subtraction(myVector3).toString());
        assertEquals("-14.01000,90.02206,3.66133,-624.90000,83.71500,-6.60000,-8.70000,-9.80000,-10.90000,-1.00000", myVector2.subtraction(myVector4).toString());
        doubMarks += 1.0;
    }

    @Test
    @Order(11)
    void dotProduct_SameSize() { //1.0
        assertEquals("-144216229.15842", String.format("%.5f", myVector1.dotProduct(myVector2)));
        doubMarks += 1.0;
    }

    @Test
    @Order(12)
    void dotProduct_DifferentSize() { //1.0
        assertEquals("784.76900", String.format("%.5f", myVector1.dotProduct(myVector3)));
        assertEquals("-94523.60752", String.format("%.5f", myVector2.dotProduct(myVector4)));
        doubMarks += 1.0;
    }

    @Test
    @Order(13)
    void cosineSimilarity_SameSize() { //3.0
        assertEquals("-0.33724", String.format("%.5f", myVector1.cosineSimilarity(myVector2)));
        doubMarks += 3.0;
    }

    @Test
    @Order(14)
    void cosineSimilarity_DifferentSize() { //3.5
        assertEquals("0.00035", String.format("%.5f", myVector1.cosineSimilarity(myVector3)));
        assertEquals("-0.87093", String.format("%.5f", myVector2.cosineSimilarity(myVector4)));
        doubMarks += 3.5;
    }


    @Test
    @Order(15)
    void Marks() {
        System.out.println("===============================");
        System.out.println("Task 3 Marks: " + doubMarks + "/24.0");
        System.out.println("===============================");
    }
}