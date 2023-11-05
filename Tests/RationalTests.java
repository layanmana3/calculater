package Tests;
import Scalar.Rational;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RationalTests {
    private Rational obj1;
    private Rational obj2;
    private Rational obj3;
@Before
public void beforeAny(){
    obj1 = new Rational(5 , 4);
    obj2 = new Rational(6,9);
    obj3 = new Rational(-4,18);

}
    @Test
    public void add() {
        Assert.assertEquals("5/4 + 6/9 is 23/12" , new Rational(23,12), obj1.add(obj2));
        Assert.assertEquals("5/4 + (-4/18) is 37/36", new Rational(37,36), obj1.add(obj3));

    }
    @Test
    public void mul() {
        Assert.assertEquals("5/4 * 6/9 is 30/36", new Rational(30,36), obj1.mul(obj2));
        Assert.assertEquals("6/9 * -4/18 is -4/27", new Rational(-4,27), obj2.mul(obj3));
    }

    @Test
    public void neg() {
        Assert.assertEquals("neg of 5/4 is -5/4" , new Rational(-5,4), obj1.neg());
        Assert.assertEquals("neg of 6/9 is -6/9", new Rational(-6,9) , obj2.neg());
        Assert.assertEquals("neg of -4/18", new Rational(4,18), obj3.neg());
    }

    @Test
    public void power() {
      Assert.assertEquals("6/9 to the power of 2 is 36/81" , new Rational(36,81), obj2.power(2));
      Assert.assertEquals("5/4 to the power of 3 is 125/64" , new Rational(125,64), obj1.power(3));
      Assert.assertEquals("-4/18 to the power of 0 is 1/1" , new Rational(1,1), obj3.power(0));
    }

    @Test
    public void sign() {
        Assert.assertEquals("sign of 5/4 is 1"  , 1 , obj1.sign());
        Assert.assertEquals("sign of -4/18 is -1",-1, obj3.sign());
        Assert.assertEquals("sign of 0 is 0 ", 0, obj1.add(obj1.neg()).sign());
    }

    @Test
    public void reduce() {
        Assert.assertEquals("5/4 reduced is 5/4", obj1,obj1.reduce());
        Assert.assertEquals("-4/18 reduced is -2/9" , new Rational(-2,9), obj3.reduce());
        Assert.assertEquals("6/9 reduced is 2/3" , new Rational(2,3), obj2.reduce());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("5/4","5/4", obj1.toString());
        Assert.assertEquals("-4/18","-2/9", obj3.toString());
    }
}
