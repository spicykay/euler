package smallestmultiple;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SmallestMultiple {

    public static int smallestCommonMultiple(int[] n) {
        final List<Integer> numList = Arrays.stream(n).boxed().collect(Collectors.toList());
        final Map<Integer, Integer> multiples = new HashMap<>();
        for(int i = 0; i<numList.size(); i++) {
            int num = numList.get(numList.size()-1-i);
            getPrimeFactors(num).forEach((key, val) -> {
                if(multiples.getOrDefault(key, 0) < val) {
                    multiples.put(key, val);
                }
            });
        }

        int res = 1;
        for(Map.Entry<Integer, Integer> entry : multiples.entrySet()) {
            res = (int)(res * Math.pow(entry.getKey(), entry.getValue()));
        }
        return res;
    }

    public static Map<Integer, Integer> getPrimeFactors(int n) {
        if (isPrime(n)) return Collections.singletonMap(n, 1);
        final Map<Integer, Integer> resMap = new HashMap<>();

        while (n%2 == 0) {
            resMap.put(2, resMap.getOrDefault(2, 0) +1);
            n/=2;
        }
        for(int i = 3; i<=Math.sqrt(n); i+=2) {
            while (n%i == 0) {
                resMap.put(i, resMap.getOrDefault(i, 0) +1);
                n/=i;
            }
        }
        if(isPrime(n)) {
            resMap.put(n, resMap.getOrDefault(n, 0) +1);
        }
        return resMap;
    }

    public static boolean isPrime(int n) {
        if(n < 2) return false;
        if(n <= 3) return true;
        return (n * n - 1) % 24 == 0 ? true : false;
    }

    public static void main(String[] args) {
        System.out.printf("Smallest Common Multiple Is: %d\n", smallestCommonMultiple(IntStream.range(1, 21).toArray()));
    }
}
