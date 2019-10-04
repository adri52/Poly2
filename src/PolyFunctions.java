public interface PolyFunctions {
    public void setCoefficient(int coef, int power);

    public Polynomial insert(Polynomial list, int coeff, int power);

    public String toString();

    public double evaluate(double x);

    public Polynomial add(Polynomial other);
}

