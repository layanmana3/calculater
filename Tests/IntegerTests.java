package Tests;
import Scalar.integer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class IntegerTests {
    private integer obj1;
    private integer obj2;

        @Before
        public void Beforeany(){
            obj1 = new integer(4);
            obj2 = new integer(8);
        }
        @Test
        public void add() {
            Assert.assertEquals("4 + 5 should be 9", obj1.add(new integer(5)), new integer(9));
            Assert.assertEquals("4 + 4 + 4 + 4 should be 16" , obj1.add(obj1).add(obj1).add(obj1) , new integer(16));
            Assert.assertEquals("4 + 8 should be 12", obj1.add(obj2), new integer(12));
        }
    
        @Test
        public void mul() {
            Assert.assertEquals("4*8 is 32" , obj2.mul(obj1), new integer(32));
            Assert.assertEquals("4*12 is 48", obj1.mul(new integer(12)), new integer(48));
            Assert.assertEquals("8*2 is 16", obj2.mul(new integer(2)), new integer(16));
        }
    
        @Test
        public void neg() {
            Assert.assertEquals("the value should be -4" , obj1.neg().toString(), new integer(-4).toString());
            Assert.assertEquals("the value should be -8" , obj2.neg().toString(), new integer(-8).toString());
        }
        @Test
        public void testpower() {
           Assert.assertEquals("4 to the power of 5 is 1024", obj1.power(5), new integer(1024));
           Assert.assertEquals("8 to the power of 2 is 64" , obj2.power(2) , new integer(64));
        }
    
        @Test
        public void testsign() {
            Assert.assertEquals("sign of 4 is 1" , obj1.sign() , 1);
            Assert.assertEquals("sign of -8 is -1", obj2.neg().sign() , -1);
            Assert.assertEquals("sign of 0 is 0" , obj2.add(new integer(-8)).sign(), 0);
        }
    
        @Test
        public void testToString() {
            Assert.assertEquals("the string should be 4" , obj1.toString(), "4");
            Assert.assertEquals("the string should be 8" , obj2.toString(), "8");
        }
    
}
