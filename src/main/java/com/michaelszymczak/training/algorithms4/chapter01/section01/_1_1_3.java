package com.michaelszymczak.training.algorithms4.chapter01.section01;

public class _1_1_3 {

    public static void main(String[] args) {
        System.out.println(check(args[0], args[1], args[2]));
    }

    public static String check(String a, String b, String c) {
        try {
            Integer intA = Integer.parseInt(a);
            Integer intB = Integer.parseInt(b);
            Integer intC = Integer.parseInt(c);
            if (intA.equals(intB) && intB.equals(intC)) {
                return "equal";
            }
        } catch (NumberFormatException e) {}

        return "not equal";
    }
}
