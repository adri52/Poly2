
public class Polynomial implements PolyFunctions {

    //Fields
    private int degree;
    private Term head;


    class Term {
        private int coeff;
        private int power;
        private Term next;


        public Term(int coeff, int power){
            this.coeff = coeff;
            this.power = power;
        }

        public int getCoeff(){
            return coeff;
        }

        public int getPower(){
            return power;
        }
    }




    private void setDegree() {
        int maxPow = 0;
        Term curr = head;


        while (curr != null) {
            if (curr.power > maxPow)
                maxPow = curr.power;
            curr = curr.next;
        }

        degree = maxPow;
    }





    //Constructor, new polynomial of degree zero
    public Polynomial() {
        degree = 0;
    }


    //Chemge ot in such way that it adds a term in such way that is sorted
    // Method to insert a new node
    @Override
    public void insert( int coeff, int power)
    {
        // Create a new node with given data
        Term new_term = new Term(coeff, power);
        new_term.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (head == null) {
            head = new_term;
        }
        else {
            // Else traverse till the last node
            // and insert the new_node there
            Term last = head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new_term;
        }
        setDegree();
    }






    //not insertiing
    @Override
    public void setCoefficient(int coeff, int power) {
        Term curr = head;
        if (curr == null)
            insert(coeff, power);

        else {
            while (curr.next != null) {
                if (curr.power == power)
                    curr.coeff = coeff;

                if (curr.next == null)
                    insert(coeff, power);

                curr = curr.next;
            }
        }
    }


//*********************************************************************
    @Override
    public String toString() {
        Term curr = head;
        StringBuilder poly = new StringBuilder();
        //  Polynomial temp = curr;


        //assuming that the polynomial is not sorted. *****************
        while(curr != null) {
            if (curr.power == 0 && curr.next == null)
                poly.append(curr.coeff);
            if (curr.power == 0)
                poly.append(curr.coeff).append(" + ");
            if (curr.next == null)
                poly.append(curr.coeff).append("x^").append(curr.power);
            else
                poly.append(curr.coeff).append("x^").append(curr.power).append(" + ");
            curr = curr.next;
        }
        return poly.toString();
    }

    @Override
    public double evaluate(double x) {
        Term curr = head;
        double base = 1;
        double total = 0;
        while(curr != null){
            for(int i = 0; i< curr.power; i++)
                base *=x;
            total += curr.coeff * base;
            curr = curr.next;
        }
        return total;
    }


    @Override
    public Polynomial add(Polynomial other) {

        //declare what we are going to use
        Polynomial newPoly = new Polynomial();
        //my "pointers" that will go through the lists
        Term thisCurr = this.head.next;
        Term otherCurr = other.head.next;
        Term newPolyCurr;


        //we copy the first polynomial to the new polynomial link list
        newPoly.head = this.head;
        newPolyCurr = newPoly.head.next;

        while (thisCurr.next != null) {

            newPolyCurr = thisCurr;
            thisCurr = thisCurr.next;
            newPolyCurr = newPolyCurr.next;

        }

        //we assign the degree of the fist polynomial
        if (this.degree > other.degree)
            newPoly.degree = this.degree;
        else
            newPoly.degree = other.degree;

        //we return thisCurr to the head.
        thisCurr = this.head.next;


        //We copy the original polynomial to a new polynimial
        //then we check if a the "other" polynomial has same exponentials
        //if they do then they add, if not we go to the next one.
        for (int i = 0; i < other.degree; i++) {
            for (int n = 0; n < newPoly.degree; n++) {
                if (thisCurr.power == otherCurr.power) {
                    newPolyCurr.coeff = newPolyCurr.coeff + otherCurr.coeff;
                    break;
                }
                if (n == (other.degree - 1) && thisCurr.power != otherCurr.power) {
                    newPolyCurr.next.coeff = otherCurr.coeff;
                    newPolyCurr.next.power = otherCurr.power;
                } else
                    newPolyCurr = newPolyCurr.next;
            }
            otherCurr = otherCurr.next;
        }

        return newPoly;
    }

}
