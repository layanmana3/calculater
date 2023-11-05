package Scalar;
public class Rational implements Scalar{
    private int numerator;
    private int denominator;

    public Rational(int numerator,int denominator){
     if(denominator != 0) {
        this.numerator = numerator;
        this.denominator = denominator;
    }}
    public int getDenominator() {
        return denominator;
    }
    public int getNumerator() {
        return numerator;
    }

    public Scalar add(Scalar s){
        Rational other = (Rational) s;
        return new Rational((this.numerator * other.denominator) + (other.numerator * this.denominator), (this.denominator * other.denominator));
    }
    public Scalar mul(Scalar s){
        Rational other = (Rational) s;
        Scalar out = new Rational(this.numerator * other.numerator, this.denominator * other.denominator);
        return out;
    }
    public Scalar neg(){
        return new Rational(-1 * numerator,denominator);
    }
    public Scalar power(int exponent){
        int newNum=(int) Math.pow(numerator, exponent);
        int NewDen=(int) Math.pow(denominator, exponent);
        return new Rational(newNum, NewDen);
    }
    public int sign(){
        if (denominator < 0 & numerator > 0 | numerator < 0 & denominator > 0) return -1;
        else if ((numerator == 0)) return 0;
        else return 1;
    }
    public Rational reduce(){
        int gcd = findGCD(numerator, denominator);
        int reducedNumerator = numerator / gcd;
        int reducedDenominator = denominator / gcd;
        return new Rational(reducedNumerator, reducedDenominator);
    }
    private int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    public String toString(){
        if (numerator % denominator == 0) {
            return "" + numerator / denominator;
        }
        Rational reduced = this.reduce();
        if (reduced.sign() == -1 && numerator > 0) {
            return "-" + reduced.getNumerator() + "/" + reduced.getDenominator() * (-1);
        }
        return "" + reduced.getNumerator() + "/" + reduced.getDenominator();
    }
    public boolean equals(Object other){
        Rational temp = (Rational) other;
        return this.reduce().toString().equals(temp.reduce().toString());
    }
}