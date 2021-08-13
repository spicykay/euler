package powerdigitsum;

import java.math.BigInteger;

public class PowerDigitSum {

    public static BigInteger powerDigitSum(int power) {
        BigInteger sum = BigInteger.ZERO;
        BigInteger result = BigInteger.valueOf(2).pow(power);
        while(result.compareTo(BigInteger.ZERO) == 1) {
            sum = sum.add(result.mod(BigInteger.TEN));
            result = result.divide(BigInteger.TEN);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(powerDigitSum(1000).toString());
    }
}