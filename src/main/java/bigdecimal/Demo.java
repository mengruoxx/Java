package bigdecimal;

import java.math.BigInteger;
import java.util.Random;

/**
 * @author mengruo
 * @date 2022/6/23 19:28
 */
public class Demo {
    public static void main(String[] args) {
        BigInteger bigInteger = BigInteger.probablePrime(3, new Random());
        System.out.println(bigInteger);
    }
}
