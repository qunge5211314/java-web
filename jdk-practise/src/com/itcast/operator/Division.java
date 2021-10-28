package com.itcast.operator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Division {
    public static void main(String[] args) {
        BigDecimal bigDecimal = BigDecimal.valueOf(123L).divide(BigDecimal.valueOf(234L), 4, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal);
    }
}
