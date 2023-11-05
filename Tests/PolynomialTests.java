package Tests;
import Scalar.integer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import plyNem.Polynomial;

import java.lang.management.PlatformLoggingMXBean;


public class PolynomialTests {
    private Polynomial obj1;
    private Polynomial obj2;
    private Polynomial obj3;
    private Polynomial obj4;
    private Polynomial obj5;
    private Polynomial obj6;
    private Polynomial obj7;
    private Polynomial obj8;
      @Before
    public void beforeAny(){
        obj1 = Polynomial.build("3 2 3");
        obj2 = Polynomial.build("2 2 2 2");
        obj3=Polynomial.build("2");
        obj4=Polynomial.build("0 0 2");
        obj5 = Polynomial.build("0 0 4 2");
        obj6 = Polynomial.build("1 -2 3");
        obj7 = Polynomial.build("0 1/2 3 -5/3");
        obj8 = Polynomial.build("0 0 0 0 0 0 7");
    }

    @Test
    public void build() {
        Assert.assertEquals("1 2 3 is 1+2x+3x^2" ,"1+2x+3x^2", Polynomial.build("1 2 3").toString());
        Assert.assertEquals("3 3 3 is 3+x+x^2" ,"1/2x+3x^2-5/3x^3", Polynomial.build("0 1/2 3 -5/3").toString());
        Assert.assertEquals("0 0 2 is 2x^2" ,"2x^2", Polynomial.build("0 0 2").toString());
       // Assert.assertEquals("1 0 1 is 1+1x^2" ,"1+x^2", Polynomial.build("1 0 1").toString());

    }

    @Test
    public void add() {
    Assert.assertEquals("2+2x+2x^2+2x^3 + 3+2x+3x^2 is 5+4x+5x^2+2x^3",Polynomial.build("5 4 5 2") ,obj1.add(obj2));
    }
//
    @Test
    public void mul() {
        Assert.assertEquals("3+2x+3x^2 * 4x^2+2x^3 is 12x^2+14x^3+16x^4+6x^5" , Polynomial.build("6 10 16 16 10 6") , obj1.mul(obj2));
        Assert.assertEquals("3+2x+3x^2 * 2x^2+2x^3 is 12x^2+14x^3+16x^4+6x^5", Polynomial.build("4 4 4 4"), obj2.mul(obj3));
    }
//    @Test
    public void evaluate() {
        Assert.assertEquals("3+2x+3x^2 evaluating x = 2 is 19" , new integer(19) , obj1.evaluate(new integer(2) {
        }));
    }
//
   @Test
    public void testToString() {
        Assert.assertEquals("obj is 3+2x+3x^2",obj1.toString() ,"3+2x+3x^2" );
       Assert.assertEquals("obj is 2+2x+2x^2",obj2.toString() ,"2+2x+2x^2+2x^3");
       Assert.assertEquals("obj is 2x^2",obj4.toString() ,"2x^2");
       Assert.assertEquals("obj is 1-2x+3x^2",obj6.toString() ,"1-2x+3x^2");
       Assert.assertEquals("obj is 1/2x+3x^2-5/3x^3",obj7.toString(),"1/2x+3x^2-5/3x^3");
       Assert.assertEquals("obj is 7x^6",obj8.toString(),"7x^6");
    }

    @Test
    public void derivative() {
          Assert.assertEquals("derivative for 3+2x+3x^2 is 2+6x" , Polynomial.build("2 6") , obj1.derivative());
        Assert.assertEquals("derivative for 4x^2+2x^3 is 8x+6x^2" , Polynomial.build("0 8 6") , obj5.derivative());
   }
}
