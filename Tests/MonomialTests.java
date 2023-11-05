package Tests;
import Scalar.Rational;
import Scalar.integer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import plyNem.*;

public class MonomialTests {
    private Monomial obj1;
    private Monomial obj2;
    private Monomial obj3;
    private Monomial obj4;

    @Before
    public void beforeAny(){
        obj1 = new Monomial(2, new Rational(4,5));
        obj2 = new Monomial(1, new integer(-4));
        obj3 = new Monomial(1, new integer(-1));
        obj4=new Monomial(3,new integer(5));
    }

    @Test
    public void add() {
        Assert.assertEquals("-4x -x = -5x" , new Monomial(1,new integer(-5)), obj2.add(obj3));
    }
    @Test
    public void mul() {
       // Assert.assertEquals("4/5x^2 * -4x is -16/5x^3" , new Monomial(3, new Rational(-16,5)),obj1.mul(obj2));
//        Assert.assertEquals("the value should be 25x^6",new Monomial(25,1)),obj4.mul();
        Assert.assertEquals("the value should be 25x^6",obj4.mul(obj4).toString(),"25x^6");

    }
    @Test
    public void evaluate() {
        //Assert.assertEquals("evaluating 4/5x^2 when x is 5 is 20" , new integer(20).toString() , obj1.evaluate(new integer(5)).toString());
        Assert.assertEquals("the value should be 40",obj4.evaluate(new integer(2)).toString(),"40");
    }
    @Test
    public void derivative() {
        Assert.assertEquals("derivative of -4x is -4" , new Monomial(0,new integer(-4)), obj2.derivative() );
    }
    @Test
    public void sign() {
        Assert.assertEquals("sign of -4x is -1" , -1 , obj2.sign());
        Assert.assertEquals("sign of 4/5x^2 is 1" , 1 , obj1.sign());
    }
    @Test
    public void testToString() {
        Assert.assertEquals("4/5^2 -->" , "4/5x^2" , obj1.toString());
        Assert.assertEquals("-4x -->" , "-4x" , obj2.toString());
    }
}
