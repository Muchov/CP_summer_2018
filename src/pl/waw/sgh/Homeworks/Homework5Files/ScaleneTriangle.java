package pl.waw.sgh.Homeworks.Homework5Files;

/*
This class extends abstract class of Triangle. In the abstract we defined what Triangle is,
now we specify the type (Equilateral/Isosceles/Scalene)
*/

public class ScaleneTriangle extends AbstractTriangle {

    public ScaleneTriangle(double a, double b, double c) {
        super(a, b, c);
    }

    @Override
    public String toString() {
        return "My " + this.getClass().getSimpleName() + " [parA=" + parA + ", parB=" + parB + ", parC=" + parC + "]";
    }
}