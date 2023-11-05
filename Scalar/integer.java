package Scalar;
public class integer implements Scalar{
    private int number;

    public integer(int num){
        this.number=num;
    }
    public int getNumber() {
        return number;
    }

    public Scalar add(Scalar s){
        integer other = (integer) s;
        return new integer(this.number + other.number);
    }
    public String toString(){
        return ("" + number);
    }

    public Scalar mul(Scalar s){
        integer other = (integer) s;
        return new integer(this.number * other.getNumber());
    }
    public Scalar neg(){
        return new integer(-1 * number);
    }
    public Scalar power(int exponent){
        Scalar result = new integer(1);
        for (int i = 1; i <= exponent; i++) {
            result = result.mul(this);
        }
        return result;
    }
    public int sign(){
        if (number==0) return 0;
        else if (number>0) return 1;
        return -1;
    }
    public boolean equals(Object other) {
        integer temp = (integer) other;
        if (temp.toString().equals(this.toString())) return true;
        return false;
    }
}