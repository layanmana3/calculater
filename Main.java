import Scalar.*;
import Scalar.integer;


public class Main {
    public static void main(String[] args) {
        integer a=new integer(3);
        integer b=new integer(-2);
        Rational r1=new Rational(2,4);
        Rational r2=new Rational(-4,12);
        System.out.println("a ="+a);
        System.out.println("b ="+b);
        System.out.println("r1 ="+r1);
        System.out.println("r2 ="+r2);
        System.out.println("a+b ="+a.add(b));
        System.out.println("a+r1 ="+a.add(r1));
        System.out.println("a+r2 ="+a.add(r2));
        System.out.println("r1+r2 ="+r1.add(r2));
        System.out.println("a*b ="+a.mul(b));
        System.out.println("a*r1 ="+a.mul(r1));
        System.out.println("a*r2 ="+a.mul(r2));
        System.out.println("r1*r2 ="+r1.mul(r2));
        System.out.println("-a ="+a.neg());
        System.out.println("-r1="+r1.neg());
        System.out.println("a^4 ="+a.power(4));
        System.out.println("r2^5 ="+r2.power(5));
        System.out.println("a.sign ="+a.sign());
        System.out.println("r2.sign ="+r2.sign());
        System.out.println("((-a+b)*r2)^2 ="+(a.neg().add(b)).mul(r2).power(2));
    }
}
