public class PolyMain {

    public static void main(String[] args ){

        Polynomial poly = new Polynomial();


        poly.insert(4,6);
        poly.insert(7,2);
        poly.insert(6,3);
        System.out.println(poly.toString());

        System.out.println("Change coeff:");
        poly.setCoefficient(4,5);
        poly.setCoefficient(4,2);
        poly.setCoefficient(6,4);
        poly.setCoefficient(9,1);
        poly.setCoefficient(5,0);

        System.out.println(poly.toString());

        System.out.println("Evaluete at 2:");
        System.out.println(poly.evaluate(2));



        System.out.println("Second Polynomial");
        Polynomial poly2 = new Polynomial();

        poly2.insert(6,1);
        poly2.insert(2,7);
        System.out.println(poly2.toString());

        poly2.setCoefficient(1,3);
        poly2.setCoefficient(6,7);
        poly2.setCoefficient(2,1);
        poly2.setCoefficient(9,5);
        poly2.setCoefficient(12,4);

        System.out.println("Change coeff:");
        System.out.println(poly2.toString());

       /* System.out.println("Add polynomials: ");
        Polynomial newPoly =poly.add(poly2);
        System.out.println(poly.toString());

        */









    }
}
