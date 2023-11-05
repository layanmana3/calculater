package plyNem;
import Scalar.Rational;
import Scalar.Scalar;
import Scalar.integer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
public class Polynomial {
    private Collection monomials;
    public static Polynomial build(String input) {
        Polynomial output = new Polynomial();
        output.monomials = new LinkedList();
        int expCount = 0;
        String[] coffs = input.split("\\s+");
        for (String ind : coffs) {
            String[] each = ind.split("/");
            if (each.length == 1) {
                output.monomials.add(new Monomial(expCount, new integer(java.lang.Integer.parseInt(each[0]))));
                expCount += 1;
            } else {
                output.monomials.add(new Monomial(expCount, new Rational(java.lang.Integer.parseInt(each[0]), java.lang.Integer.parseInt(each[1]))));
                expCount += 1;
            }
        }
        return output;
    }

    public Polynomial add(Polynomial p) {
        Polynomial result = new Polynomial();
        result.monomials = new LinkedList();
        Iterator<Monomial> myiter = this.monomials.iterator();
        Iterator<Monomial> otheriter = p.monomials.iterator();
        while (myiter.hasNext()) {
            Monomial temp1 = myiter.next();
            if (otheriter.hasNext()) {
                Monomial temp2 = otheriter.next();
                result.monomials.add(new Monomial(temp1.getExponent(), temp1.getCoefficient().add(temp2.getCoefficient())));
            } else result.monomials.add(temp1);
        }
        while (otheriter.hasNext()) {
            result.monomials.add(otheriter.next());
        }
        return result;
    }

    public Polynomial mul(Polynomial p) {
        Polynomial output = new Polynomial();
        output.monomials = new LinkedList<Monomial>();
        Iterator<Monomial> myiter = monomials.iterator();
        int firstCounter = 0;
        while (myiter.hasNext()) {
            Monomial m = myiter.next();
            Iterator<Monomial> otheriter = p.monomials.iterator();
            Polynomial toAdd = new Polynomial();
            toAdd.monomials = new LinkedList<Monomial>();
            for (int i = 0; i < firstCounter; i++)
                toAdd.monomials.add(new Monomial(i, new integer(0)));
            while (otheriter.hasNext()) {
                toAdd.monomials.add(m.mul(otheriter.next()));
            }
            output = output.add(toAdd);
            firstCounter++;
        }
        return output;
    }
    public Scalar evaluate(Scalar s) {
        Scalar output = new integer(0);
        Iterator<Monomial> myiter = monomials.iterator();
        while (myiter.hasNext()) {
            output = output.add(myiter.next().evaluate(s));
        }
        return output;
    }
    public String toString() {
        String output = "";
        boolean flag = true;
        Iterator it = monomials.iterator();
        if (it.hasNext()) {
            String first = it.next().toString();
            if (!first.equals("0")) {
                if (first.charAt(0) == '-') {
                    output = output + first;
                    flag = false;
                } else output = output + "+" + first;
            }
        }
        while (it.hasNext()) {
            String curr = it.next().toString();
            if (!curr.equals("0")) {
                if (curr.charAt(0) == '-') output = output + curr;
                else output = output + "+" + curr;
            }
        }
        if (!flag) return output;
        if (output.length() == 0) return "0";
        if (output.charAt(0) == '+') return output.substring(1);
        return output;
    }

   public Polynomial derivative() {
       Polynomial output = new Polynomial();
       output.monomials = new LinkedList<Monomial>();
       Iterator<Monomial> myiter = monomials.iterator();
       while (myiter.hasNext()) {
           Monomial mynext = myiter.next();
           if (mynext.sign() != 0) {
               mynext = mynext.derivative();
               if (mynext.sign()!=0)
                   output.monomials.add(mynext);
           }
       }
       return output;
  }
    public boolean equals(Object other) {
        Polynomial temp = (Polynomial) other;
        if (temp.toString().equals(this.toString())) return true;
        return false;
    }
}
