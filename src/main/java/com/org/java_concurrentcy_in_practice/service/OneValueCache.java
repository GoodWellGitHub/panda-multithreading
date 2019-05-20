package com.org.java_concurrentcy_in_practice.service;

import java.math.BigInteger;
import java.util.Arrays;

public class OneValueCache {
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger i, BigInteger[] lastFactors) {
        this.lastFactors = lastFactors;
        this.lastNumber = i;
    }

    public BigInteger[] getLastFactors(BigInteger i) {
        if (lastNumber == null || !lastNumber.equals(i)) {
            return null;
        } else {
            return Arrays.copyOf(lastFactors, lastFactors.length);
        }
    }
}
