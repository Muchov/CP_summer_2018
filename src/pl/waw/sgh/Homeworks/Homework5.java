package pl.waw.sgh.Homeworks;

/*
This class allows us to print info about our triangles.
We can define their parameters here.
*/

import pl.waw.sgh.Homeworks.Homework5Files.AbstractTriangle;
import pl.waw.sgh.Homeworks.Homework5Files.EquilateralTriangle;
import pl.waw.sgh.Homeworks.Homework5Files.IsoscelesTriangle;
import pl.waw.sgh.Homeworks.Homework5Files.ScaleneTriangle;

public class Homework5 {

    public static void main(String[] args) {

        AbstractTriangle[] myTriangles = new AbstractTriangle[3];

        myTriangles[0] = new ScaleneTriangle(3, 4, 5);

        myTriangles[1] = new IsoscelesTriangle(3, 4, 4);

        myTriangles[2] = new EquilateralTriangle(3, 3, 3);

        for (AbstractTriangle t : myTriangles) {

            System.out.println(t.toString());
            System.out.println("Surface: " + t.calcSurface());

        }
    }
}