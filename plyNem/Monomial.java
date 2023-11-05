package plyNem;
import Scalar.integer;
import Scalar.Scalar;

public class Monomial {
    private int exponent;
    private Scalar coefficient;
    public Monomial(int exponent, Scalar coefficient) {
        this.exponent = exponent;
        this.coefficient = coefficient;
    }
    public int getExponent() {
        return exponent;
    }
    public Scalar getCoefficient() {
        return coefficient;
    }


    public Monomial add(Monomial m){
        if (exponent == m.getExponent()) {
            return new Monomial(exponent, coefficient.add(m.getCoefficient()));
        }
        return null;
    }

    public Monomial mul(Monomial m) {return (new Monomial(exponent + m.exponent,coefficient.mul(m.coefficient)));}
    public Scalar evaluate(Scalar s){
//        return coefficient.mul(s.power(exponent));
        return (s.power(exponent).mul(coefficient));

    }
    public  Monomial derivative(){
        if (exponent == 0) {
            return new Monomial(0, new integer(0));
        }
        return new Monomial(exponent - 1, new integer(exponent).mul(coefficient));
    }
    public int sign(){return coefficient.sign();
    }
    public String toString(){
        if (coefficient.sign()==0)
            return coefficient.toString();
        if (exponent == 0) {
            return coefficient.toString();
        } else if (exponent == 1) {
            return coefficient.toString() + "x";
        } else {
            return coefficient.toString() + "x^" + exponent;
        }
    }
    public boolean equals(Object other){
        Monomial temp = (Monomial) other;
        if(temp.getExponent() == this.exponent && temp.getCoefficient().toString().equals(this.coefficient.toString())) return true;
        return false;
    }
    
}
